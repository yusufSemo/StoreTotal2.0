package smeo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;


public class MonthData {
    private final int DaysInMonth;
    private final int MonthIdx;
    private final int Year;

    public MonthData(int monthIdx, int year){
        YearMonth yearMonthObject = YearMonth.of(year, monthIdx);
        this.MonthIdx = monthIdx;
        this.Year = year;
        this.DaysInMonth = yearMonthObject.lengthOfMonth();
    }
    public static String getDayOfWeek(int dayNumber) {
        dayNumber = (dayNumber%7)+1;
        return switch (dayNumber) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> throw new IllegalArgumentException("Invalid day number: " + dayNumber);
        };
    }
    public static int getDayNumber(int year, int month, int day) {
        LocalDate myDate = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = myDate.getDayOfWeek();

        return switch (dayOfWeek) {
            case SUNDAY -> 1;
            case MONDAY -> 2;
            case TUESDAY -> 3;
            case WEDNESDAY -> 4;
            case THURSDAY -> 5;
            case FRIDAY -> 6;
            case SATURDAY -> 7;
        };
    }

    public String toJson() {
        StringBuilder returnString = new StringBuilder("[");
        int dayNum = getDayNumber(Year, MonthIdx, 1);

        for (int i = 0; i < DaysInMonth; i++) {
            returnString.append("\n" + "{\n" + "\"MyDate\":\"2022-").append(String.format("%02d", MonthIdx)).append("-").append(String.format("%02d", (i + 1))).append("\",\n").append("\"Cash\":0.0,\n").append(  // Placeholder for Cash
                    "\"Card\":0.0,\n").append(  // Placeholder for Card
                    "\"Online\":0.0,\n").append(  // Placeholder for Online
                    "\"Total\":0.0,\n").append(  // Placeholder for Total
                    "\"WeekDay\":\"").append(getDayOfWeek(dayNum)).append("\"\n").append("},");
            dayNum++;
        }
        returnString.append("]");

        return returnString.toString();
    }

}