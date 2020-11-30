package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

   public static Long dateDiff(String startTime, String endTime, String format, String str) {
       SimpleDateFormat sd = new SimpleDateFormat(format);
       long nd = 1000 * 24 * 60 * 60;
       long nh = 1000 * 60 * 60;
       long nm = 1000 * 60;
       long ns = 1000;
       long diff;
       long day = 0;
       long hour = 0;
       long min = 0;
       long sec = 0;
       String result = "0";

       try {
           diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
           day = Math.abs(diff / nd);
           hour = Math.abs(diff % nd / nh + day * 24);
           min = Math.abs(diff % nd % nh / nm + day * 24 * 60);
           sec = Math.abs(diff % nd % nh % nm / ns);
       } catch (ParseException e) {
           e.printStackTrace();
       }
       System.out.println("Time difference：" + day + "days" + (hour - day * 24) + "hours"
               + (min - day * 24 * 60) + "minutes" + sec + "seconds");
       if ("d".equalsIgnoreCase(str)){
           return day;
       } else if ("h".equalsIgnoreCase(str)) {
           return hour;
       } else if ("m".equalsIgnoreCase(str)){
           return min;
       } else {
           return 0L;
       }
   }

}
