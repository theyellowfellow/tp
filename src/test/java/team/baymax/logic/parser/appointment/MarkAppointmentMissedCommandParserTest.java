package team.baymax.logic.parser.appointment;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static team.baymax.testutil.patient.PatientUtil.NAME_DESC_AMY;

import org.junit.jupiter.api.Test;

import team.baymax.logic.commands.appointment.MarkAppointmentMissedCommand;
import team.baymax.logic.parser.exceptions.ParseException;

public class MarkAppointmentMissedCommandParserTest {
    @Test
    void parse_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MarkAppointmentMissedCommandParser().parse(null));
    }

    @Test
    void parse_emptyInput_throwsParseException() {
        assertThrows(ParseException.class, () -> new MarkAppointmentMissedCommandParser().parse(""));
    }

    @Test
    void parse_validInput_returnsFindAppointmentCommand() throws ParseException {
        assertSame(new MarkAppointmentMissedCommandParser().parse("1").getClass(),
                MarkAppointmentMissedCommand.class);
    }
}
