package smeo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DayData {
    private Date myDate;
    private float cash;
    private float card;
    private float online;
    private float total;

    public DayData(int month, int day, int year, float card, float online, float cash) {
        // Constructor that creates a date with cash, card, online data
        this.myDate = createDate(year, month, day);
        this.cash = cash;
        this.card = card;
        this.online = online;
        this.total = cash + card + online;
    }

    private Date createDate(int year, int month, int day) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, day); // Note: month is zero-based in Calendar
        return calendar.getTime();
    }

    public String getData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return (dateFormat.format(this.myDate) + "\nCard-" + this.card + "\nOnline-" + this.online +
                "\nCash-" + this.cash + "\nTotal-" + this.total);
    }
}
