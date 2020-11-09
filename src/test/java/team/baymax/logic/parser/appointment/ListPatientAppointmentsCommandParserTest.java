package team.baymax.logic.parser.appointment;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static team.baymax.testutil.patient.PatientUtil.NAME_DESC_AMY;

import org.junit.jupiter.api.Test;

import team.baymax.logic.commands.appointment.ListPatientAppointmentsCommand;
import team.baymax.logic.parser.exceptions.ParseException;

public class ListPatientAppointmentsCommandParserTest {
    @Test
    void parse_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ListPatientAppointmentsCommandParser().parse(null));
    }

    @Test
    void parse_emptyInput_throwsParseException() {
        assertThrows(ParseException.class, () -> new FindAppointmentByKeywordCommandParser().parse(""));
    }

    @Test
    void parse_validInput_returnsFindAppointmentCommand() throws ParseException {
        assertSame(new ListPatientAppointmentsCommandParser().parse("1").getClass(),
                ListPatientAppointmentsCommand.class);
        assertSame(new ListPatientAppointmentsCommandParser().parse("1" + NAME_DESC_AMY).getClass(),
                ListPatientAppointmentsCommand.class);
    }
}
