package 算法.dateApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Acui
 * @date 2022年05月25日 15:04
 */
public class DateTimeApiTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        String weekday = new Solution().getWeekday(sdf.parse("2022-07-25"));
        System.out.println(weekday);
    }
}

class Solution {
    public String getWeekday(Date date) {
        String[] dayOfWeek = {"日", "一", "二", "三", "四", "五", "六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek[i];
    }
}
