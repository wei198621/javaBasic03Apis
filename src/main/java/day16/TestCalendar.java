package day16;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author leowei
 * @date 2020/12/29  - 13:40
 */
public class TestCalendar {
    public static void main(String[] args) {

        // *******
        long timeNowLong = System.currentTimeMillis();       // 距离 1970 年 的毫秒数
        System.out.println("timeNow = " + timeNowLong);

        // *******
       // Calendar c = Calendar.getInstance();
        Calendar c = Calendar.getInstance(Locale.FRANCE);  //
        Date timeNow = c.getTime();
        System.out.println("timeNow = " + timeNow);

        // *******
        c.setTimeInMillis(timeNowLong);
        int year = c.get(Calendar.YEAR);
        int dayM = c.get(Calendar.DAY_OF_MONTH);
        int dayY = c.get(Calendar.DAY_OF_YEAR);
        int dayW = c.get(Calendar.DAY_OF_WEEK);
        int daySpe =c.getFirstDayOfWeek();
        System.out.println("dayW: " + dayW+ " ;  dayMonth:"+ dayM + "; dayYear:"+ dayY + " ; year: "+ year +"; firstDayofWeek:"+ daySpe);
        //dayW: 3 ;  dayMonth:29; dayYear:364 ; year: 2020; firstDayofWeek:1
        // *******
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatTime = sdf.format(timeNow);
        System.out.println("formatTime = " + formatTime);



    }
}
