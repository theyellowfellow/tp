package team.baymax.logic;

import static team.baymax.commons.util.CollectionUtil.requireAllNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import team.baymax.commons.core.GuiSettings;
import team.baymax.commons.core.LogsCenter;
import team.baymax.logic.commands.Command;
import team.baymax.logic.commands.CommandResult;
import team.baymax.logic.commands.exceptions.CommandException;
import team.baymax.logic.parser.AppointmentBookParser;
import team.baymax.logic.parser.exceptions.ParseException;
import team.baymax.model.Model;
import team.baymax.model.appointment.Appointment;
import team.baymax.model.calendar.AppointmentCalendar;
import team.baymax.model.modelmanagers.ReadOnlyListManager;
import team.baymax.model.patient.Patient;
import team.baymax.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final AppointmentBookParser appointmentBookParser;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        requireAllNonNull(model, storage);
        this.model = model;
        this.storage = storage;
        appointmentBookParser = new AppointmentBookParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = appointmentBookParser.parseCommand(commandText);
        commandResult = command.execute(model);

        try {
            storage.savePatients(model.getPatientManager());
            storage.saveAppointments(model.getAppointmentManager());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public ReadOnlyListManager<Patient> getPatientManager() {
        return model.getPatientManager();
    }

    @Override
    public ReadOnlyListManager<Appointment> getAppointmentManager() {
        return model.getAppointmentManager();
    }

    @Override
    public ObservableList<Patient> getFilteredPatientList() {
        return model.getFilteredPatientList();
    }

    @Override
    public ObservableList<Appointment> getFilteredAppointmentList() {
        return model.getFilteredAppointmentList();
    }

    @Override
    public AppointmentCalendar getAppointmentCalendar() {
        return model.getAppointmentCalendar();
    }

    @Override
    public Path getPatientStorageFilePath() {
        return model.getPatientStorageFilePath();
    }

    @Override
    public Path getAppointmentStorageFilePath() {
        return model.getAppointmentStorageFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}
