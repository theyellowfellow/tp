package team.baymax.logic.parser.patient;

import static java.util.Objects.requireNonNull;
import static team.baymax.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import team.baymax.commons.core.index.Index;
import team.baymax.logic.commands.patient.DeletePatientCommand;
import team.baymax.logic.parser.ArgumentMultimap;
import team.baymax.logic.parser.ArgumentTokenizer;
import team.baymax.logic.parser.Parser;
import team.baymax.logic.parser.ParserUtil;
import team.baymax.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeletePatientCommandParser implements Parser<DeletePatientCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeletePatientCommand
     * and returns a DeletePatientCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeletePatientCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);
        if (argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DeletePatientCommand.MESSAGE_USAGE));
        }

        Index index = ParserUtil.parseIndex(args);
        return new DeletePatientCommand(index);
    }

}
