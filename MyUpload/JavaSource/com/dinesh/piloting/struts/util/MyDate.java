package com.dinesh.piloting.struts.util;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    public MyDate() {
    }

    public static String getDate() {
        SimpleDateFormat lFormat;
        Calendar MyDate = Calendar.getInstance();
        MyDate.setTime(new java.util.Date());
        java.util.Date date = MyDate.getTime();
        lFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String gRtnStr = lFormat.format(date);
        return gRtnStr;
    }

    
    private static transient int gregorianCutoverYear = 1582;

    
    private static final int[] DAYS_P_MONTH_LY = {
                                                 31, 29, 31, 30, 31, 30, 31, 31,
                                                 30, 31, 30, 31};
    
    private static final int[] DAYS_P_MONTH_CY = {
                                                 31, 28, 31, 30, 31, 30, 31, 31,
                                                 30, 31, 30, 31};
    
    private static final int Y = 0, M = 1, D = 2;

    
    private int[] ymd = null;

    /**
     * 
     * @param date
     * @throws IllegalArgumentException
     */
    public static void validate(String date) throws IllegalArgumentException {

        int[] ymd = splitYMD(date);

        if (ymd[M] == 0 || ymd[M] > 12) {
            throw new IllegalArgumentException("Year not in range");
        }

        if (true == isLeapYear(ymd[0])) {
            if (ymd[D] == 0 || ymd[D] > DAYS_P_MONTH_LY[ymd[M] - 1]) {
                throw new IllegalArgumentException("Leap year");
            }
        } else {
            if (ymd[D] == 0 || ymd[D] > DAYS_P_MONTH_CY[ymd[M] - 1]) {
                throw new IllegalArgumentException("Wrong date");
            }
        }
    }

    /**
     * 
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        return year >= gregorianCutoverYear ?
                ((year % 4 == 0) && ((year % 100 != 0) ||
                                     (year % 400 == 0))) : 
                (year % 4 == 0); 
    }

    /**
     * 
     * @param year
     * @param month
     * @param day
     * @return
     */
    private int[] addOneDay(int year, int month, int day) {
        if (isLeapYear(year)) {
            day++;
            if (day > DAYS_P_MONTH_LY[month - 1]) {
                month++;
                if (month > 12) {
                    year++;
                    month = 1;
                }
                day = 1;
            }
        } else {
            day++;
            if (day > DAYS_P_MONTH_CY[month - 1]) {
                month++;
                if (month > 12) {
                    year++;
                    month = 1;
                }
                day = 1;
            }
        }
        int[] ymd = {
                    year, month, day};
        return ymd;
    }

    /**
     * 
     * @param date
     * @param days
     * @return
     */
    public String addDaysByLoop(String date, int days) {
        validate(date);
        int[] ymd = splitYMD(date);
        for (int i = 0; i < days; i++) {
            ymd = addOneDay(ymd[Y], ymd[M], ymd[D]);
        }
        return formatYear(ymd[Y]) +
                formatMonthDay(ymd[M]) +
                formatMonthDay(ymd[D]);
    }

    /**
     * 
     * @param year
     * @param month
     * @param day
     * @return
     */
    private int[] reduceOneDay(int year, int month, int day) {
        if (isLeapYear(year)) {
            day--;
            if (day <= 0) {
                month--;
                if (month < 1) {
                    year--;
                    month = 12;
                }
                day = DAYS_P_MONTH_LY[month - 1];
            }
        } else {
            day--;
            if (day <= 0) {
                month--;
                if (month < 1) {
                    year--;
                    month = 12;
                }
                day = DAYS_P_MONTH_CY[month - 1];
            }
        }
        int[] ymd = {
                    year, month, day};
        return ymd;
    }

    /**
     * 
     * @param date
     * @param days
     * @return
     */
    public String reduceDaysByLoop(String date, int days) {
        validate(date);
        int[] ymd = splitYMD(date);
        for (int i = 0; i < days; i++) {
            ymd = reduceOneDay(ymd[Y], ymd[M], ymd[D]);
        }
        return formatYear(ymd[Y]) +
                formatMonthDay(ymd[M]) +
                formatMonthDay(ymd[D]);
    }

    /**
     * 
     * @param date
     * @param days
     * @return
     * @throws IllegalArgumentException
     */
    public String addDays(Date date, int days) throws IllegalArgumentException {
        return addDays(formatDate(date), days);
    }

    /**
     * 
     * @param date
     * @param days
     * @return
     * @throws IllegalArgumentException
     */
    public String addDays(String date, int days) throws
            IllegalArgumentException {

        validate(date);
        ymd = splitYMD(date);

        if (isLeapYear(ymd[Y])) {
            ymd[D] += days;
            if (ymd[D] > DAYS_P_MONTH_LY[ymd[M] - 1]) {
                ymd[M]++;
                ymd[D] = ymd[D] - DAYS_P_MONTH_LY[ymd[M] - 1 - 1];
                if (ymd[M] > 12) {
                    ymd[M] -= 12;
                    ymd[Y]++;
                }
                if (ymd[D] > DAYS_P_MONTH_LY[ymd[M] - 1]) {
                    addDays(formatYear(ymd[Y]) +
                            formatMonthDay(ymd[M]) +
                            formatMonthDay(DAYS_P_MONTH_LY[ymd[M] - 1]),
                            ymd[D] - DAYS_P_MONTH_LY[ymd[M] - 1]);
                }
            }
        } else {
            ymd[D] += days;
            if (ymd[D] > DAYS_P_MONTH_CY[ymd[M] - 1]) {
                ymd[M]++;
                ymd[D] = ymd[D] - DAYS_P_MONTH_CY[ymd[M] - 1 - 1];
                if (ymd[M] > 12) {
                    ymd[M] -= 12;
                    ymd[Y]++;
                }
                if (ymd[D] > DAYS_P_MONTH_CY[ymd[M] - 1]) {
                    addDays(formatYear(ymd[Y]) +
                            formatMonthDay(ymd[M]) +
                            formatMonthDay(DAYS_P_MONTH_CY[ymd[M] - 1]),
                            ymd[D] - DAYS_P_MONTH_CY[ymd[M] - 1]);
                }
            }
        }
        return formatYear(ymd[Y]) +
                formatMonthDay(ymd[M]) +
                formatMonthDay(ymd[D]);
    }

    /**
     * 
     * @param date
     * @param days
     * @return
     * @throws IllegalArgumentException
     */
    public String reduceDays(Date date, int days) throws
            IllegalArgumentException {
        return reduceDays(formatDate(date), days);
    }

    /**
     * 
     * @param date
     * @param days
     * @return
     * @throws IllegalArgumentException
     */
    public String reduceDays(String date, int days) throws
            IllegalArgumentException {

        validate(date);
        ymd = splitYMD(date);

        if (isLeapYear(ymd[Y])) {
            ymd[D] -= days;
            if (ymd[D] <= 0) {
                ymd[M]--;
                if (ymd[M] < 1) {
                    ymd[M] += 12;
                    ymd[Y]--;
                }
                ymd[D] = ymd[D] + DAYS_P_MONTH_LY[ymd[M] - 1];
                if (ymd[D] <= 0) {
                    reduceDays(formatYear(ymd[Y]) +
                               formatMonthDay(ymd[M]) +
                               formatMonthDay(1),
                               abs(ymd[D] - 1));
                }
            }
        } else {
            ymd[D] -= days;
            if (ymd[D] <= 0) {
                ymd[M]--;
                if (ymd[M] < 1) {
                    ymd[M] += 12;
                    ymd[Y]--;
                }
                ymd[D] = ymd[D] + DAYS_P_MONTH_CY[ymd[M] - 1];
                if (ymd[D] <= 0) {
                    reduceDays(formatYear(ymd[Y]) +
                               formatMonthDay(ymd[M]) +
                               formatMonthDay(1),
                               abs(ymd[D] - 1));
                }
            }
        }
        return formatYear(ymd[Y]) +
                formatMonthDay(ymd[M]) +
                formatMonthDay(ymd[D]);
    }

    /**
     * 
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    /**
     * 
     * @param date
     * @return
     */
    public static int[] splitYMD(String date) {
        int[] ymd = {
                    0, 0, 0};
        ymd[Y] = Integer.parseInt(date.substring(0, 4));
        ymd[M] = Integer.parseInt(date.substring(4, 6));
        ymd[D] = Integer.parseInt(date.substring(6, 8));
        return ymd;
    }

    /**
     * 
     * @param decimal
     * @return
     */
    public static String formatMonthDay(int decimal) {
        DecimalFormat df = new DecimalFormat("00");
        return df.format(decimal);
    }

    /**
     * 
     * @param decimal
     * @return
     */
    public static String formatYear(int decimal) {
        DecimalFormat df = new DecimalFormat("0000");
        return df.format(decimal);
    }

    /**
     * 
     * @param num
     * @return
     */
    public static int abs(int num) {
        return (num > 0) ? num : -num;
    }

    public static String getYear(String date) {
        return date.substring(0, 4);
    }

    public static String getMonth(String date) {
        return date.substring(4, 6);
    }

    public static String getDay(String date) {
        return date.substring(6, 8);
    }

    public static String addMonth(String date) {
        int month = setZ(date.substring(4, 6));
        int year = setZ(date.substring(0, 4));
        if (month + 1 > 12) {
            year++;
            month = 1;
        } else {
            month++;
        }

        return setZ(year) + "" + setZ(month) + date.substring(6, 8) +
                date.substring(8, 10) +
                date.substring(10, 12) + date.substring(12, 14);
    }

    public static int setZ(String i) {
        if (!i.equals("0")) {
            if (i.startsWith("0")) {
                return Integer.parseInt(i.substring(1, 2));
            }
        }
        return Integer.parseInt(i);
    }

    public static String setZ(int i) {
        if (i < 10 && i > 0) {
            return "0" + i;
        } else {
            return "" + i;
        }
    }

    public static String chengeDays(String date, int day) {
        return date.substring(0, 6) + setZ(day) + date.substring(8, 14);
    }

    public static String jianMonth(String date) {
        int month = setZ(date.substring(4, 6));
        int year = setZ(date.substring(0, 4));
        if (month - 1 < 1) {
            year--;
            month = 12;
        } else {
            month--;
        }

        return setZ(year) + "" + setZ(month) + date.substring(6, 8) +
                date.substring(8, 10) +
                date.substring(10, 12) + date.substring(12, 14);
    }


    public static String printDays() {
        String date = getDate();
        return getYear(date) + "." + getMonth(date) + "." + getDay(date);
    }

    public static String printDays(String date) {
        return getYear(date) + "." + getMonth(date) + "." + getDay(date);
    }

    public int getMonthDays(int month, boolean type) {
        int res = 0;
        switch (month) {
        case 1:
            res = 31;
            break;
        case 2:
            if (type) {
                res = 29;
            } else {
                res = 28;
            }
            break;
        case 3:
            res = 31;
            break;
        case 4:
            res = 30;
            break;
        case 5:
            res = 31;
            break;
        case 6:
            res = 30;
            break;
        case 7:
            res = 31;
            break;
        case 8:
            res = 31;
            break;
        case 9:
            res = 30;
            break;
        case 10:
            res = 31;
            break;
        case 11:
            res = 30;
            break;
        case 12:
            res = 31;
            break;
        }
        return res;
    }

    public int getYearDay(int years) {
        int res = 0;
        for (int i = 1; i <= years; i++) {
            if (isLeapYear(i)) {
                res += 366;
            } else {
                res += 365;
            }
        }
        return res;
    }

    public static long jianfa(String star, String end) {
        long days=0;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
            Date d1 = null;
            d1 = f.parse(formatDate(star));
            Date d2 = f.parse(formatDate(end));
           days=(long)((d2.getTime()-d1.getTime())/(60*60*24));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return days;
    }
    public static String formatDate(String date)
    {
        String res=date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
        return res;
    }
}
