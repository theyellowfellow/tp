package team.baymax.logic.commands.patient;

import static team.baymax.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;

import team.baymax.commons.core.Messages;
import team.baymax.commons.core.index.Index;
import team.baymax.logic.commands.Command;
import team.baymax.logic.commands.CommandResult;
import team.baymax.logic.commands.exceptions.CommandException;
import team.baymax.model.Model;
import team.baymax.model.patient.Patient;
import team.baymax.model.patient.PatientIdenticalPredicate;
import team.baymax.model.patient.Remark;
import team.baymax.model.util.TabId;

/**
 * Changes the remark of an existing patient.
 */
public class RemarkPatientCommand extends Command {

    public static final String COMMAND_WORD = "remark";

    public static final String MESSAGE_ADD_REMARK_SUCCESS = "Added remark to Patient: \n%1$s";
    public static final String MESSAGE_DELETE_REMARK_SUCCESS = "Removed remark from Patient: %1$s";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the remark of the patient identified "
            + "by the index number used in the last patient listing. "
            + "Existing remark will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "r/[REMARK]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "r/Likes to swim.";

    public static final TabId TAB_ID = TabId.PATIENT;

    private final Index index;
    private final Remark remark;

    /**
     * @param index of the patient in the filtered patient list to edit the remark
     * @param remark of the patient to be updated to
     */
    public RemarkPatientCommand(Index index, Remark remark) {
        requireAllNonNull(index, remark);

        this.index = index;
        this.remark = remark;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Patient> lastShownList = model.getFilteredPatientList();

        assert index != null;

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PATIENT_DISPLAYED_INDEX);
        }

        Patient patientToEdit = lastShownList.get(index.getZeroBased());
        Patient editedPatient = new Patient(patientToEdit.getNric(), patientToEdit.getName(), patientToEdit.getPhone(),
                patientToEdit.getGender(), patientToEdit.getTags(), remark);

        model.setPatient(patientToEdit, editedPatient);
        model.updateFilteredPatientList(new PatientIdenticalPredicate(editedPatient));

        return new CommandResult(generateSuccessMessage(editedPatient), getTabId());
    }

    @Override
    public TabId getTabId() {
        return TAB_ID;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code patientToEdit}.
     */
    private String generateSuccessMessage(Patient patientToEdit) {
        String message = !remark.getValue().isEmpty() ? MESSAGE_ADD_REMARK_SUCCESS : MESSAGE_DELETE_REMARK_SUCCESS;
        return String.format(message, patientToEdit);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RemarkPatientCommand)) {
            return false;
        }

        // state check
        RemarkPatientCommand e = (RemarkPatientCommand) other;
        return index.equals(e.index)
                && remark.equals(e.remark);
    }
}
