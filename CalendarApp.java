
// import java.sql.Timestamp;
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.HashMap;
import java.util.*;
/*
    >> How to use timestamp
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    String s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(ts);
    Event e = new Event("eventName", s, s);

    >> Hashmap over Hashtable
    - I don't plan on using threads so I don't need synchronization yet, hashmap is more efficient for this
    - I could use LinkedHashMap if I wanted to implement a map that holds the order of insertions
*/

public class CalendarApp {

    private HashMap<User, ArrayList<Calendar>> userDict;
    // private String currentUser;
    // private String currentCalendar;
    private User currentUser;
    private Calendar currentCalendar;

    private static final String CMD_PROMPT = String.join("\n",
            "\n----------------------------------",
            "COMMANDS:",
            "Log In = 1 *name*",
            "Add Calendar = 2 *calendar name*",
            "Add Event = 3 *event name*",
            "View Calendar = 4",
            "----------------------------------\n",
            ">>>> ");
    private String cmd;

    public CalendarApp() {
        userDict = new HashMap<User, ArrayList<Calendar>>();
        currentUser = null;
        currentCalendar = null;
    }

    public void run() {
        Boolean loop = true;
        while (loop) {
            String input = getInput();
            if (input.length() == 0) { // break out of input loop
                break;
            }
            cmd = input.substring(0, 1);
            switch (cmd) {
                case "1":
                    logIn(input);
                    break;

                case "2":
                    addCalendar(input);
                    break;

                case "3":
                    addEvent(input);
                    break;

                case "4":
                    viewAllCalendars();
                    break;

                case "5":
                    viewCurrentCalendar();
                    break;

                default:
                    System.out.println("\nQUITTING\n");
                    loop = false;
                    break;
            }
        }
    }

    private static String getInput() {
        System.out.print(CMD_PROMPT);
        String input = System.console().readLine();
        System.out.println();
        return input;
    }

    private void logIn(String input) {
        if (input.length() < 2) {
            return;
        }
        String userName = input.substring(2);
        Boolean userFound = false;
        for (User u : userDict.keySet()) {
            if (u.getName() == userName) {
                currentUser = u;
                userFound = true;
            }
        }
        if (!userFound) {
            User user = new User(userName);
            ArrayList<Calendar> calendar = new ArrayList<Calendar>();
            userDict.put(user, calendar);
            currentUser = user;
        }
    }

    private void addCalendar(String input) {
        if (input.length() < 2) {
            return;
        }
        if (currentUser == null) {
            System.out.println("Log in first");
            return;
        }
        String calendarName = input.substring(2);
        Calendar calendar = new Calendar(calendarName);
        currentCalendar = calendar;
        userDict.get(currentUser).add(calendar);
    }

    private void addEvent(String input) {
        if (currentCalendar == null) {
            System.out.println("Add calendar first");
            return;
        }
        String eventName = input.substring(2);
        Event event = new Event(eventName);
        currentCalendar.addEvent(event);
    }

    private void viewAllCalendars() {
        for (User s : userDict.keySet()) {
            System.out.println("USER: " + s.getName());
            for (Calendar c : userDict.get(s)) {
                System.out.println("CALENDAR: " + c.getName());
                for (Event e : c.getEvents()) {
                    System.out.println("EVENT: " + e.getName());
                }
            }
        }
    }

    private void viewCurrentCalendar() {
        for (Calendar c : userDict.get(currentUser)) {
            if (c == currentCalendar) {
                System.out.println("CALENDAR: " + currentCalendar.getName());
                for (Event e : c.getEvents()) {
                    System.out.println("EVENT: " + e.getName());
                }
            }
        }
    }
}
