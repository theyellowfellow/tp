package team.baymax.logic.parser.appointment;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static team.baymax.testutil.patient.PatientUtil.NAME_DESC_AMY;

import org.junit.jupiter.api.Test;

import team.baymax.logic.commands.appointment.MarkAppointmentDoneCommand;
import team.baymax.logic.parser.exceptions.ParseException;

public class MarkAppointmentDoneCommandParserTest {
    @Test
    void parse_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MarkAppointmentDoneCommandParser().parse(null));
    }

    @Test
    void parse_emptyInput_throwsParseException() {
        assertThrows(ParseException.class, () -> new MarkAppointmentDoneCommandParser().parse(""));
    }

    @Test
    void parse_validInput_returnsFindAppointmentCommand() throws ParseException {
        assertSame(new MarkAppointmentDoneCommandParser().parse("1").getClass(),
                MarkAppointmentDoneCommand.class);
    }
}
