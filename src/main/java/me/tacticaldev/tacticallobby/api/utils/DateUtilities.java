package me.tacticaldev.tacticallobby.api.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtilities {

    public static int second = 1;
    public static int minute = second * 60;
    public static int hour = minute * 60;
    public static int day = hour * 24;
    public static int week = day * 7;
    public static int month = day * 30;
    public static int year = day * 365;

    public static String milliesToDateHours(Long date) {
        Instant instance = Instant.ofEpochMilli(date);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instance, ZoneId.of("Europe/Paris"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(false ? "kk:mm" : "hh:mm a");

        return zonedDateTime.format(formatter);
    }

    public static String milliesToDateDay(Long date) {
        Instant instance = Instant.ofEpochMilli(date);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instance, ZoneId.of("Europe/Paris"));

        String day = zonedDateTime.format(DateTimeFormatter.ofPattern("d"));
        String month = integerToMonth(Integer.parseInt(zonedDateTime.format(DateTimeFormatter.ofPattern("M"))));
        String year = zonedDateTime.format(DateTimeFormatter.ofPattern("u"));

        return day + " " + month + " " + year;
    }

    public static String getDay(Long date) {
        Instant instance = Instant.ofEpochMilli(date);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instance, ZoneId.of(("Europe/Paris")));

        return zonedDateTime.format(DateTimeFormatter.ofPattern("d"));
    }

    public static String getMonth(Long date) {
        Instant instance = Instant.ofEpochMilli(date);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instance, ZoneId.of("Europe/Paris"));

        return zonedDateTime.format(DateTimeFormatter.ofPattern("M"));
    }

    public static String getYear(Long date) {
        Instant instance = Instant.ofEpochMilli(date);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instance, ZoneId.of("Europe/Paris"));

        return zonedDateTime.format(DateTimeFormatter.ofPattern("u"));
    }

    public static String formatSecondsShort(Long sec) {
        int minutes = (int) (sec / 60);
        if (minutes >= 60) {
            int hours = minutes / 60;
            minutes %= 60;
            if (hours >= 24) {
                int days = hours / 24;
                return String.format("%02d:%02d:%02d", days, hours % 24, minutes);
            }
            return String.format("00:%02d:%02d", hours, minutes);
        }
        return String.format("00:00:%02d", minutes);
    }

    public static String formatSecondsLong(Long seconds) {
        if (seconds < 60) {
            return seconds + "s";
        } else {
            int minutes = (int) (seconds / 60);
            int s = 60 * minutes;
            int secondsLeft = (int) (seconds - s);
            if (minutes < 60) {
                return secondsLeft > 0 ? String.valueOf(minutes + "m " + secondsLeft + "s") : String.valueOf(minutes + "m");
            } else {
                String time;
                int days;
                int inMins;
                int leftOver;
                if (minutes < 1440) {
                    time = "";
                    days = minutes / 60;
                    time = days + "h";
                    inMins = 60 * days;
                    leftOver = minutes - inMins;
                    if (leftOver >= 1) {
                        time = time + " " + leftOver + "m";
                    }

                    if (secondsLeft > 0) {
                        time = time + " " + secondsLeft + "s";
                    }

                    return time;
                } else {
                    time = "";
                    days = minutes / 1440;
                    time = days + "d";
                    inMins = 1440 * days;
                    leftOver = minutes - inMins;
                    if (leftOver >= 1) {
                        if (leftOver < 60) {
                            time = time + " " + leftOver + "m";
                        } else {
                            int hours = leftOver / 60;
                            time = time + " " + hours + "h";
                            int hoursInMins = 60 * hours;
                            int minsLeft = leftOver - hoursInMins;
                            if (leftOver >= 1) {
                                time = time + " " + minsLeft + "m";
                            }
                        }
                    }

                    if (secondsLeft > 0) {
                        time = time + " " + secondsLeft + "s";
                    }

                    return time;
                }
            }
        }
    }

    public static String formatSecondsShort(int seconds) {
        int minutes = (int) (seconds / 60);
        if (minutes >= 60) {
            int hours = minutes / 60;
            minutes %= 60;
            if (hours >= 24) {
                int days = hours / 24;
                return String.format("%02d:%02d:%02d", days, hours % 24, minutes);
            }
            return String.format("00:%02d:%02d", hours, minutes);
        }
        return String.format("00:00:%02d", minutes);
    }

    public static String formatSecondsLong(int seconds) {
        if (seconds < 60) {
            return seconds + "s";
        } else {
            int minutes = (int) (seconds / 60);
            int s = 60 * minutes;
            int secondsLeft = (int) (seconds - s);
            if (minutes < 60) {
                return secondsLeft > 0 ? String.valueOf(minutes + "m " + secondsLeft + "s") : String.valueOf(minutes + "m");
            } else {
                String time;
                int days;
                int inMins;
                int leftOver;
                if (minutes < 1440) {
                    time = "";
                    days = minutes / 60;
                    time = days + "h";
                    inMins = 60 * days;
                    leftOver = minutes - inMins;
                    if (leftOver >= 1) {
                        time = time + " " + leftOver + "m";
                    }

                    if (secondsLeft > 0) {
                        time = time + " " + secondsLeft + "s";
                    }

                    return time;
                } else {
                    time = "";
                    days = minutes / 1440;
                    time = days + "d";
                    inMins = 1440 * days;
                    leftOver = minutes - inMins;
                    if (leftOver >= 1) {
                        if (leftOver < 60) {
                            time = time + " " + leftOver + "m";
                        } else {
                            int hours = leftOver / 60;
                            time = time + " " + hours + "h";
                            int hoursInMins = 60 * hours;
                            int minsLeft = leftOver - hoursInMins;
                            if (leftOver >= 1) {
                                time = time + " " + minsLeft + "m";
                            }
                        }
                    }

                    if (secondsLeft > 0) {
                        time = time + " " + secondsLeft + "s";
                    }

                    return time;
                }
            }
        }
    }

    public static String integerToMonth(int i) {
        if (i == 1) return "January";
        if (i == 2) return "February";
        if (i == 3) return "March";
        if (i == 4) return "April";
        if (i == 5) return "May";
        if (i == 6) return "June";
        if (i == 7) return "July";
        if (i == 8) return "August";
        if (i == 9) return "September";
        if (i == 10) return "October";
        if (i == 11) return "November";
        if (i == 12) return "December";
        return "Unknown";
    }
}
