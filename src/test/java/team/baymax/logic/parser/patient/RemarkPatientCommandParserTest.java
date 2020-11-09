package team.baymax.logic.parser.patient;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static team.baymax.testutil.patient.PatientUtil.REMARK_DESC_AMY;

import org.junit.jupiter.api.Test;

import team.baymax.logic.commands.patient.RemarkPatientCommand;
import team.baymax.logic.parser.exceptions.ParseException;

public class RemarkPatientCommandParserTest {
    @Test
    void parse_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RemarkPatientCommandParser().parse(null));
    }

    @Test
    void parse_invalidInput_throwsParseException() {
        assertThrows(ParseException.class, () -> new RemarkPatientCommandParser().parse(""));
        assertThrows(ParseException.class, () -> new RemarkPatientCommandParser().parse("heehee"));
    }

    @Test
    void parse_validInput_returnsRemarkPatientCommand() throws ParseException {
        assertSame(new RemarkPatientCommandParser().parse("1" + REMARK_DESC_AMY).getClass(),
                RemarkPatientCommand.class);
    }
}
