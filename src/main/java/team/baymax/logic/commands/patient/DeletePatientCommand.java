package team.baymax.logic.commands.patient;

import static java.util.Objects.requireNonNull;

import java.util.List;

import team.baymax.commons.core.Messages;
import team.baymax.commons.core.index.Index;
import team.baymax.logic.commands.Command;
import team.baymax.logic.commands.CommandResult;
import team.baymax.logic.commands.exceptions.CommandException;
import team.baymax.model.Model;
import team.baymax.model.patient.Patient;
import team.baymax.model.util.TabId;

/**
 * Deletes a patient identified using it's displayed index from the appointment book.
 */
public class DeletePatientCommand extends Command {

    public static final String COMMAND_WORD = "deletepatient";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the patient identified by the index number used in the displayed patient list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_PATIENT_SUCCESS = "The following patient is deleted:\n %1$s";
    public static final TabId TAB_ID = TabId.PATIENT;

    private final Index targetIndex;

    /**
     * Creates a DeletePatientCommand to delete the specified {@code Patient} at the {@code targetIndex}
     * @param targetIndex  index of the Patient to delete in the current filtered list of patients
     */
    public DeletePatientCommand(Index targetIndex) {
        requireNonNull(targetIndex);
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Patient> lastShownList = model.getFilteredPatientList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PATIENT_DISPLAYED_INDEX);
        }

        Patient patientToDelete = lastShownList.get(targetIndex.getZeroBased());

        model.deletePatient(patientToDelete);
        model.clearAllAppointmentsOfPatient(patientToDelete);

        return new CommandResult(String.format(MESSAGE_DELETE_PATIENT_SUCCESS, patientToDelete), getTabId());
    }

    @Override
    public TabId getTabId() {
        return TAB_ID;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeletePatientCommand // instanceof handles nulls
                && targetIndex.equals(((DeletePatientCommand) other).targetIndex)); // state check
    }
}
