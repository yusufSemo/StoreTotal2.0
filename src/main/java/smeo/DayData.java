package smeo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayData {
    private LocalDate MyDate;
    private float Cash;
    private float Card;
    private float Online;
    private float Total;

    public DayData(int month, int day, int year, float card, float online, float cash){
        //constructor that creates a date with cash,card,online data
        this.MyDate = LocalDate.of(year, month, day);
        this.Cash = cash;
        this.Card = card;
        this.Online = online;
        this.Total = cash+card+online;
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
        String formattedDate = MyDate.format(formatter);
        return formattedDate;
    }

}
