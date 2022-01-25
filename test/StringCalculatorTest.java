import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    private StringCalculator cal;

    @Before
    public void setUp() throws Exception {
        cal = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    public void add_숫자하나() {
        assertEquals(1, cal.add("1"));
    }

    @Test
    public void add_쉼표구분자() {
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() {
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    public void add_custom_구분자() {
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @Test(expected = RuntimeException.class)
    public void add_negative() {
        cal.add("-1,2,3");
    }
}