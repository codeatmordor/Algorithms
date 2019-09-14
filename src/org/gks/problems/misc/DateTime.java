
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.misc;

import java.util.Calendar;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING. The function accepts
     * following parameters: 1. INTEGER month 2. INTEGER day 3. INTEGER year
     */

    static String[] days = new String[] { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };

    public static String findDay(int month, int day, int year) {

        // String s = String.valueOf(i);
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(year, month - 1, day);
        // c.setTime(yourDate);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);
        return days[dayOfWeek - 1];
    }

}

public class DateTime {

    public static void main(String[] args) {
        System.out.println(Result.findDay(8, 26, 2019));
    }

}
