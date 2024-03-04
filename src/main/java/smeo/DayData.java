package smeo;


import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DayData {
    private final LocalDate MyDate;
    private float Cash;
    private float Card;
    private float Online;
    private float Total;
    private String WeekDay;

    public DayData(int month, int day, int year, float card, float online, float cash){
        //constructor that creates a date with cash,card,online data
        this.MyDate = LocalDate.of(year, month, day);
        this.Cash = cash;
        this.Card = card;
        this.Online = online;
        this.Total = cash+card+online;
        DayOfWeek days = MyDate.getDayOfWeek();
        this.WeekDay= days.getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    @Override
    public String toString() {
        // Format the date to MM/DD/YYYY
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = MyDate.format(formatter);

        // Return data with the formatted date
        return (formattedDate + "\nCard-" + this.Card + "\nOnline-" + this.Online
                + "\nCash-" + this.Cash + "\nTotal-" + this.Total);
    }
    public String getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return MyDate.format(formatter);
    }
    public String DatetoString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return MyDate.format(formatter);
    }
    public String getMonthAndYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMyyyy", Locale.ENGLISH);
        return MyDate.format(formatter);
    }
    public String toJsonString() {
        return "{\n"
                + "\"MyDate\":\"" + MyDate.toString() + "\",\n"
                + "\"Cash\":" + Cash + ",\n"
                + "\"Card\":" + Card + ",\n"
                + "\"Online\":" + Online + ",\n"
                + "\"Total\":" + Total + ",\n"
                + "\"WeekDay\":\"" + WeekDay + "\""
                + "\n}";
    }
    public void toJsonFile(){
        File jsonFile = new File("/Users/yusufsemo/Desktop/jsonData/" + getMonthAndYear() + ".json");
            //BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile,true));
        boolean notExists = !jsonFile.exists();
        boolean containsDuplicate = false;
        StringBuilder fileContent = new StringBuilder();
        if(!notExists) {
            try {
                FileReader fileReader = new FileReader(jsonFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isEmpty()) {
                        fileContent.append(line).append("\n");
                    }
                }
                bufferedReader.close();
                fileReader.close();
                System.out.println(fileContent);
                System.out.println("subString 2987492874293 "+ DatetoString());
                if (!fileContent.isEmpty()) {
                    if(fileContent.indexOf(DatetoString()) != -1){
                        containsDuplicate = true;
                        int startDate = fileContent.indexOf("{\n" + "\"MyDate\":\""+DatetoString());
                        int endDate = startDate;

                        while(fileContent.charAt(endDate) != '}'){
                            endDate++;
                        }
                        fileContent.replace(startDate,endDate+1,String.valueOf(this.toJsonString()));

                    }
                    if(!containsDuplicate){
                        fileContent.deleteCharAt(fileContent.length() - 2);
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(fileContent);
        try {
            FileWriter myWriter = new FileWriter(jsonFile);
            BufferedWriter writer = new BufferedWriter(myWriter);
            if(!containsDuplicate) {
                if (notExists) {
                    writer.write("[\n");
                }
                if (!fileContent.toString().isEmpty()) {
                    writer.write(fileContent + ",");
                }
                writer.write(this.toJsonString() + "]");

            }else{
                writer.write(fileContent.toString());
            }
            writer.close();
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

