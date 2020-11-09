package team.baymax.logic.parser.appointment;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import team.baymax.logic.commands.appointment.FindAppointmentCommand;
import team.baymax.logic.parser.exceptions.ParseException;

public class FindAppointmentByKeywordCommandParserTest {
    @Test
    void parse_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new FindAppointmentByKeywordCommandParser().parse(null));
    }

    @Test
    void parse_emptyInput_throwsParseException() {
        assertThrows(ParseException.class, () -> new FindAppointmentByKeywordCommandParser().parse(""));
    }

    @Test
    void parse_validInput_returnsFindAppointmentCommand() throws ParseException {
        assertSame(new FindAppointmentByKeywordCommandParser().parse("Bob").getClass(),
                FindAppointmentCommand.class);
    }
}
