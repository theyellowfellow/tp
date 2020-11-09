package team.baymax.logic.parser.appointment;

import static java.util.Objects.requireNonNull;
import static team.baymax.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static team.baymax.logic.parser.CliSyntax.PREFIX_DATETIME;
import static team.baymax.logic.parser.CliSyntax.PREFIX_NAME;
import static team.baymax.logic.parser.ParserUtil.arePrefixesPresent;

import team.baymax.commons.core.index.Index;
import team.baymax.logic.commands.appointment.MarkAppointmentDoneCommand;
import team.baymax.logic.parser.ArgumentMultimap;
import team.baymax.logic.parser.ArgumentTokenizer;
import team.baymax.logic.parser.Parser;
import team.baymax.logic.parser.ParserUtil;
import team.baymax.logic.parser.exceptions.ParseException;
import team.baymax.model.patient.Name;
import team.baymax.model.util.datetime.DateTime;

public class MarkAppointmentDoneCommandParser implements Parser<MarkAppointmentDoneCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the MarkAppointmentDoneCommand
     * and returns a MarkAppointmentDoneCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public MarkAppointmentDoneCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DATETIME, PREFIX_NAME);

        if (arePrefixesPresent(argMultimap, PREFIX_DATETIME, PREFIX_NAME)) {
            Name name;
            DateTime dateTime;
            try {
                name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
                dateTime = ParserUtil.parseDateTime(argMultimap.getValue(PREFIX_DATETIME).get());
            } catch (ParseException pe) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkAppointmentDoneCommand.MESSAGE_USAGE), pe);
            }
            return new MarkAppointmentDoneCommand(dateTime, name);
        } else {
            Index index;
            try {
                index = ParserUtil.parseIndex(args);
            } catch (ParseException pe) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkAppointmentDoneCommand.MESSAGE_USAGE), pe);
            }
            return new MarkAppointmentDoneCommand(index);
        }
    }
}
