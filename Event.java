import java.util.ArrayList;

/*
    Time stored as "yyyy-mm-dd hh:mm:ss"
*/

class Event {
    private String name;
    private String startTime;
    private String endTime;
    private ArrayList<String> guests;
    private Boolean repeat;

    // public Event(String n, String startT, String endT) {
    public Event(String n) {
        name = n;
        startTime = "yyyy-mm-dd hh:mm:ss";
        endTime = "yyyy-mm-dd hh:mm:ss";
        guests = new ArrayList<String>();
        repeat = false;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setStartTime(String d) {
        startTime = d;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String d) {
        endTime = d;
    }

    public String getEndTime() {
        return endTime;
    }

    public void addGuest(String guest) {
        guests.add(guest);
    }

    public ArrayList<String> getGuests() {
        return guests;
    }

    public void repeatWeekly(Boolean b) {
        repeat = b;
    }

    public Boolean getRepeatWeekly() {
        return repeat;
    }

}