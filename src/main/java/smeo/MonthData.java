package smeo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class MonthData {
    private final int DaysInMonth;
    private final int MonthIdx;
    private final int Year;
    private LocalDate MyDate;
    public MonthData(int monthIdx, int year){
        YearMonth yearMonthObject = YearMonth.of(year, monthIdx);
        this.MonthIdx = monthIdx;
        this.Year = year;
        this.DaysInMonth = yearMonthObject.lengthOfMonth();
        this.MyDate = LocalDate.of(Year, MonthIdx, 1);
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

    public String getMonthAndYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMyyyy", Locale.ENGLISH);
        return MyDate.format(formatter);
    }
    public void toFile(){
        String FileContent = this.toJson();
        File jsonFile = new File("/Users/yusufsemo/Desktop/jsonData/" + getMonthAndYear() + ".json");
        //check if the file already exists, if it does, do nothing.
        boolean FileExists = jsonFile.exists();
        if(FileExists) return;
        try {
            FileWriter myWriter = new FileWriter(jsonFile);
            BufferedWriter writer = new BufferedWriter(myWriter);
            writer.write(toJson());
            writer.close();
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
//writer.close();
//        myWriter.close();