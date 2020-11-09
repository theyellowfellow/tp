package team.baymax.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static team.baymax.testutil.Assert.assertThrows;
import static team.baymax.testutil.patient.TypicalPatients.AMY;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import team.baymax.commons.core.Messages;
import team.baymax.logic.commands.CommandResult;
import team.baymax.logic.commands.exceptions.CommandException;
import team.baymax.logic.commands.patient.AddPatientCommand;
import team.baymax.logic.commands.patient.ListPatientCommand;
import team.baymax.logic.parser.exceptions.ParseException;
import team.baymax.model.Model;
import team.baymax.model.ModelManager;
import team.baymax.model.appointment.Appointment;
import team.baymax.model.modelmanagers.ReadOnlyListManager;
import team.baymax.model.patient.Patient;
import team.baymax.model.userprefs.UserPrefs;
import team.baymax.storage.Storage;
import team.baymax.storage.StorageManager;
import team.baymax.storage.appointment.JsonAppointmentManagerStorage;
import team.baymax.storage.patient.JsonPatientManagerStorage;
import team.baymax.storage.userprefs.JsonUserPrefsStorage;
import team.baymax.testutil.patient.PatientBuilder;
import team.baymax.testutil.patient.PatientUtil;

public class LogicManagerTest {
    private static final IOException DUMMY_IO_EXCEPTION = new IOException("dummy exception");

    @TempDir
    public Path temporaryFolder;

    private Model model = new ModelManager();
    private Logic logic;
    private Storage storage;

    @BeforeEach
    public void setUp() {
        JsonPatientManagerStorage patientManagerStorage =
                new JsonPatientManagerStorage(temporaryFolder.resolve("patients.json"));
        JsonAppointmentManagerStorage appointmentManagerStorage =
                new JsonAppointmentManagerStorage(temporaryFolder.resolve("appointments.json"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(temporaryFolder.resolve("userPrefs.json"));
        StorageManager storage = new StorageManager(patientManagerStorage, appointmentManagerStorage, userPrefsStorage);
        this.storage = storage;
        logic = new LogicManager(model, storage);
    }

    @Test
    public void constructor_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new LogicManager(null, null));
        assertThrows(NullPointerException.class, () -> new LogicManager(model, null));
        assertThrows(NullPointerException.class, () -> new LogicManager(null, storage));
    }

    @Test
    public void execute_invalidCommandFormat_throwsParseException() {
        String invalidCommand = "uicfhmowqewca";
        assertParseException(invalidCommand, Messages.MESSAGE_UNKNOWN_COMMAND);
    }

    @Test
    public void execute_commandExecutionError_throwsCommandException() {
        String deleteCommand = "deletepatient 9";
        assertCommandException(deleteCommand, Messages.MESSAGE_INVALID_PATIENT_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validCommand_success() throws Exception {
        String listCommand = ListPatientCommand.COMMAND_WORD;
        assertCommandSuccess(listCommand, ListPatientCommand.MESSAGE_SUCCESS, model);
    }

    @Test
    public void execute_storageThrowsIoException_throwsCommandException() {
        // Setup LogicManager with JsonPatientManagerIoExceptionThrowingStub
        JsonPatientManagerStorage patientManagerStorage =
                new JsonPatientManagerIoExceptionThrowingStub(temporaryFolder
                        .resolve("ioExceptionPatientManager.json"));
        JsonAppointmentManagerStorage appointmentManagerStorage =
                new JsonAppointmentManagerIoExceptionThrowingStub(temporaryFolder
                        .resolve("ioExceptionAppointmentManager.json"));
        JsonUserPrefsStorage userPrefsStorage =
                new JsonUserPrefsStorage(temporaryFolder.resolve("ioExceptionUserPrefs.json"));
        StorageManager storage = new StorageManager(patientManagerStorage,
                appointmentManagerStorage, userPrefsStorage);
        logic = new LogicManager(model, storage);

        // Execute add command
        String addCommand = AddPatientCommand.COMMAND_WORD + PatientUtil.NRIC_DESC_AMY
                + PatientUtil.NAME_DESC_AMY + PatientUtil.PHONE_DESC_AMY
                + PatientUtil.GENDER_DESC_AMY + PatientUtil.REMARK_DESC_AMY;
        Patient expectedPatient = new PatientBuilder(AMY).withTags().build();
        ModelManager expectedModel = new ModelManager();
        expectedModel.addPatient(expectedPatient);
        String expectedMessage = LogicManager.FILE_OPS_ERROR_MESSAGE + DUMMY_IO_EXCEPTION;
        assertCommandFailure(addCommand, CommandException.class, expectedMessage, expectedModel);
    }

    @Test
    public void getFilteredPatientList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> logic.getFilteredPatientList().remove(0));
    }

    /**
     * Executes the command and confirms that
     * - no exceptions are thrown <br>
     * - the feedback message is equal to {@code expectedMessage} <br>
     * - the internal model manager state is the same as that in {@code expectedModel} <br>
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    private void assertCommandSuccess(String inputCommand, String expectedMessage,
            Model expectedModel) throws CommandException, ParseException {
        CommandResult result = logic.execute(inputCommand);
        assertEquals(expectedMessage, result.getFeedbackToUser());
        assertEquals(expectedModel, model);
    }

    /**
     * Executes the command, confirms that a ParseException is thrown and that the result message is correct.
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    private void assertParseException(String inputCommand, String expectedMessage) {
        assertCommandFailure(inputCommand, ParseException.class, expectedMessage);
    }

    /**
     * Executes the command, confirms that a CommandException is thrown and that the result message is correct.
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    private void assertCommandException(String inputCommand, String expectedMessage) {
        assertCommandFailure(inputCommand, CommandException.class, expectedMessage);
    }

    /**
     * Executes the command, confirms that the exception is thrown and that the result message is correct.
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    private void assertCommandFailure(String inputCommand, Class<? extends Throwable> expectedException,
            String expectedMessage) {
        Model expectedModel = new ModelManager(model.getPatientManager(),
                model.getAppointmentManager(), new UserPrefs(), model.getCalendarManager());
        assertCommandFailure(inputCommand, expectedException, expectedMessage, expectedModel);
    }

    /**
     * Executes the command and confirms that
     * - the {@code expectedException} is thrown <br>
     * - the resulting error message is equal to {@code expectedMessage} <br>
     * - the internal model manager state is the same as that in {@code expectedModel} <br>
     * @see #assertCommandSuccess(String, String, Model)
     */
    private void assertCommandFailure(String inputCommand, Class<? extends Throwable> expectedException,
            String expectedMessage, Model expectedModel) {
        assertThrows(expectedException, expectedMessage, () -> logic.execute(inputCommand));
        assertEquals(expectedModel, model);
    }

    /**
     * A stub class to throw an {@code IOException} when the save method is called on patientManagerStorage.
     */
    private static class JsonPatientManagerIoExceptionThrowingStub extends JsonPatientManagerStorage {
        private JsonPatientManagerIoExceptionThrowingStub(Path filePath) {
            super(filePath);
        }

        @Override
        public void savePatients(ReadOnlyListManager<Patient> patientManager, Path filePath) throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }
    }

    /**
     * A stub class to throw an {@code IOException} when the save method is called on AppointmentManagerStorage.
     */
    private static class JsonAppointmentManagerIoExceptionThrowingStub extends JsonAppointmentManagerStorage {
        private JsonAppointmentManagerIoExceptionThrowingStub(Path filePath) {
            super(filePath);
        }

        @Override
        public void saveAppointments(ReadOnlyListManager<Appointment> appointmentManager, Path filePath)
                throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }
    }
}
