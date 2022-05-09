package testApi;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Acui
 * @date 2022年04月03日 21:01
 */
public class DateTimeTest {
    @Test
    public void test() {
        LocalDate date = LocalDate.now();
        System.out.println(String.format("date format : %s", date));

        LocalTime localTime = LocalTime.now().withNano(0);
        System.out.println(String.format("time format : %s", localTime));
    }
}
