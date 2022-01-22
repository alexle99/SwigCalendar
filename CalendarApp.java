import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    String s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(ts);
    Event e = new Event("eventName", s, s);
*/

public class CalendarApp {

    private HashMap<String, ArrayList<Calendar>> hashMap;
    private Map<String, ArrayList<Calendar>> map;
    private Hashtable<String, ArrayList<Calendar>> hashTable;

    public static void main(String[] args) {

        while (true) {

            System.out.print(">>>> ");
            String input = System.console().readLine();
            String[] inputList = input.split(" ");
            String cmd = inputList[0];

            switch (cmd) {

                case "logIn":
                    System.out.println("log in");
                    break;

                case "addCalendar":
                    System.out.println("Calendar Name: ");

                default:
                    System.out.println("quitting");
                    break;
            }

            // for (String inputWord: inputList ){

            // }

            if (input.equals("quit")) {
                System.out.println("Quiting");
                break;
            }
            break;
        }

    }

}
