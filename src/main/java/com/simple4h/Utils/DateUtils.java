package com.simple4h.Utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Create By Simple4H
 * Date: 2019-07-10 11:00
 */
public class DateUtils {

    public static LocalDate FUTURE_LOCAL_DATE;
    public static Date FUTURE_DATE;

    private static final DateTimeFormatter DATE_FORMAT_WITH_SLASH = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    // 格式成没连字符的ymd格式
    private static final DateTimeFormatter DATE_FORMAT_WITHOUT_HYPHEN = DateTimeFormatter.ofPattern("yyyyMMdd");

    static {
        FUTURE_LOCAL_DATE = LocalDate.of(9999, 1, 1);
        FUTURE_DATE = toDate(FUTURE_LOCAL_DATE);
    }

    private static Pattern numPattern = Pattern.compile("\\d+");

    private static ZonedDateTime toZonedDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault());
    }
    public static LocalDateTime toLocalDateTime(Date date) {
        return toZonedDateTime(date).toLocalDateTime();
    }
    public static LocalDate toLocalDate(Date date) {
        return toZonedDateTime(date).toLocalDate();
    }
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDate(Long timeMillis) {
        return timeMillis == null ? null : new Date(timeMillis);
    }
    public static Date toDateWithoutMinuteAndSeconds(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.getTime();
    }

    public static Date startOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        return calendar.getTime();
    }

    public static Date endOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date startOfDate(LocalDate localDate) {
        return DateUtils.toDate(localDate.atStartOfDay());
    }
    public static Date endOfDate(LocalDate localDate) {
        return DateUtils.toDate(localDate.atTime(LocalTime.MAX));
    }

    /**
     * @return 这个月第一天的开始时间
     */
    public static Date getFirstDayOfThisMonth() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        return Date.from(firstDayOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getFirstDayOfThisMonth(LocalDate today) {
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        return Date.from(firstDayOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getStartOfToday() {
        LocalDate today = LocalDate.now();
        return Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date expiresInToDate(long expireIn, TemporalUnit temporalUnit) {
        return Date.from(Instant.now().plus(expireIn, temporalUnit));
    }

    /**
     * 转换yyyy-MM-dd HH:mm:ss或者yyyy-MM-dd格式的字符串为Date
     */
    public static Date parseDate(String dateStr) {
        SimpleDateFormat sdf;
        if (dateStr.contains("-")) {
            if (dateStr.length() > 10) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } else {
                sdf = new SimpleDateFormat("yyyy-MM-dd");;
            }
            try {
                return sdf.parse(dateStr);
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (numPattern.matcher(dateStr).matches()) {
            return new Date(Long.parseLong(dateStr));
        } else {
            throw new IllegalArgumentException("unknown datetime string: " + dateStr);
        }
    }

    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static LocalDate parseLocalDate(String dateStr) {
        if (dateStr.contains("-")) {
            if (dateStr.length() > 10) {
                dateStr = dateStr.substring(0, 10);
            }
            try {
                return LocalDate.parse(dateStr, dateFormatter);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (numPattern.matcher(dateStr).matches()) {
            long millis = Long.parseLong(dateStr);
            return LocalDateTime.ofEpochSecond(millis / 1000, 0, ZoneOffset.UTC).toLocalDate();
        } else {
            throw new IllegalArgumentException("unknown localdate string: " + dateStr);
        }
    }

    public static long localDateToTimestamp(LocalDate date) {
        return date.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
    }

    public static String formatToYmd(Date date) {
        if(date == null) return "";
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String formatToYmdWithoutHyphen(Date date) {
        if (date == null) return "";
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }

    // 转换成无连字符的ymd格式
    public static String formatToYmdWithoutHyphen(LocalDate date) {
        if (date == null) return "";
        return DATE_FORMAT_WITHOUT_HYPHEN.format(date);
    }

    public static String formatToYmdhms(Date date) {
        if(date == null) return "";
        SimpleDateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return ymdhmsFormat.format(date);
    }

    public static String formatToYmdhmsWithoutSpace(Date date) {
        if(date == null) return "";
        SimpleDateFormat ymdhmsFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return ymdhmsFormat.format(date);
    }

    public static Long toLong(Date date) {
        if(date == null) {
            return null;
        }
        return date.getTime();
    }

    public static Long toLong(LocalDate localDate) {
        if (localDate == null) return null;
        return toLong(toDate(localDate));
    }

    public static String formatDate(Temporal time) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateFormat.format(time);
    }

    public static String formatDateWithSlash(Temporal time) {
        return DATE_FORMAT_WITH_SLASH.format(time);
    }

    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static String formatLocalDate(LocalDate date,String format) {
        if (format == null) {
            format = "/";
        }
        format = "yyyy".concat(format).concat("MM").concat(format).concat("dd");
        return new SimpleDateFormat(format).format(toDate(date));
    }

    public static Date dateMin(Date a, Date b) {
        return a.after(b)? b : a;
    }


    public static int differentDays(Date startTime, Date entTime) {
        Calendar start = Calendar.getInstance();
        start.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(entTime);
        int day1 = start.get(Calendar.DAY_OF_YEAR);
        int day2 = end.get(Calendar.DAY_OF_YEAR);

        int year1 = start.get(Calendar.YEAR);
        int year2 = end.get(Calendar.YEAR);

        //同一年
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    //闰年
                    timeDistance += 366;
                } else {
                    //不是闰年
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else { //不同年
            return day2 - day1;
        }
    }

    public static String formatToHms(Date date) {
        if(date == null) return "";
        SimpleDateFormat ymdhmsFormat = new SimpleDateFormat("HH:mm:ss");
        return ymdhmsFormat.format(date);
    }

    public static Date parseToTime(String timeStr) {
        if (StringUtils.isBlank(timeStr)) return null;
        SimpleDateFormat ymdhmsFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            return ymdhmsFormat.parse(timeStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Date startDateOfThisWeek(LocalDate today){
        LocalDate firstDayOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        return toDate(firstDayOfWeek);
    }
}
