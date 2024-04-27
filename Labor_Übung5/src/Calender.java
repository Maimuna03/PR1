import java.util.*;

public class Calender {

	private Map<Integer, Map<Integer, Map<Integer, List<Event>>>> calendar;

	//Constructor
	public Calender() {
		calendar = new HashMap<>();
	}

	//Method that prints the calendar in the console
	public void printCalendar(int year, int month) {
		
		int daysInMonth = getDaysInMonth(year, month);
		int startDay = getStartDay(year, month);

		// Ausgabe des Kopfteils mit den Wochentagen
		System.out.println("Mo Di Mi Do Fr Sa So");

		// Leerzeichen für den Anfang des Monats
		for (int i = 0; i < startDay; i++) {
			System.out.print("   ");
		}

		for (int day = 1; day <= daysInMonth; day++) {
			System.out.printf("%2d ", day);

			// Umbruch nach Sonntag
			if ((day + startDay) % 7 == 0) {
				System.out.println();
			}
		}
	}

	//Method to add event to event list
	public void addEvent(int year, int month, int day, Event event) {
		if (!calendar.containsKey(year)) {
			calendar.put(year, new HashMap<>());
		}
		Map<Integer, Map<Integer, List<Event>>> yearMap = calendar.get(year);

		if (!yearMap.containsKey(month)) {
			yearMap.put(month, new HashMap<>());
		}
		Map<Integer, List<Event>> monthMap = yearMap.get(month);

		if (!monthMap.containsKey(day)) {
			monthMap.put(day, new ArrayList<>());
		}
		List<Event> events = monthMap.get(day);

		events.add(event);
	}

	//Method to prit the event list
	public void printEventList(int year, int month) {

		System.out.println();

		System.out.println("----------------------------");

		int daysInMonth;
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			daysInMonth = 30;
			break;
		case 2:
			daysInMonth = isLeapYear(year) ? 29 : 28;
			break;
		default:
			daysInMonth = 31;
		}

		Map<Integer, Map<Integer, List<Event>>> yearMap = calendar.getOrDefault(year, new HashMap<>());
		Map<Integer, List<Event>> monthMap = yearMap.getOrDefault(month, new HashMap<>());

		List<Event> events = null;

		for (int day = 1; day <= daysInMonth; day++) {
			events = monthMap.getOrDefault(day, new ArrayList<>());

			for (Event event : events) {
				System.out.println(
						"Tag " + day + ":" + "\tZeit: " + event.getEventTime() + " - Termin: " + event.getEventName());
			}

		}

	}

	//Method to get the first weekday of the month
	public static int getStartDay(int year, int month) {
		
		if (month < 3) {
			month += 12;
			year--;
		}
		
		int century = year / 100;
		year = year % 100;

		int startDay = (1 + ((13 * (month + 1)) / 5) + year + (year / 4) + (century / 4) - (2 * century)) % 7;
		// The Zeller's Congruence gives 0 for saturday, but we want  0 for sunday,
		// so we calculate +1 mod 7
		return (startDay + 5) % 7;
	}

	//Method to get the number of days in the month
	public static int getDaysInMonth(int year, int month) {
		//Array that contains the number of days of the months
		int[] daysPerMonth = { 31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		return daysPerMonth[month - 1];
	}

	//Method to check if it is a leap year 
	public static boolean isLeapYear(int year) {
		
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	public List<Event> getEventsForDay(int year, int month, int day) {
        List<Event> eventsForDay = new ArrayList<>();
        Map<Integer, Map<Integer, List<Event>>> yearMap = calendar.getOrDefault(year, new HashMap<>());
        Map<Integer, List<Event>> monthMap = yearMap.getOrDefault(month, new HashMap<>());
        List<Event> events = monthMap.getOrDefault(day, new ArrayList<>());

        eventsForDay.addAll(events);
        return eventsForDay;
    }
}
