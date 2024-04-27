import java.util.*;

public class KrankenhausOperationskalender extends Calender {

	private Map<Integer, List<Event>> operationRooms;

	public KrankenhausOperationskalender() {
		super();
		operationRooms = new HashMap<>();
		for (int i = 1; i <= 5; i++) {
			operationRooms.put(i, new ArrayList<>());
		}
	}
	
	Calender OpCalender = new Calender();

	public void addOperationEvent(int roomNumber, Event event) {
		if (operationRooms.containsKey(roomNumber)) {
			List<Event> roomSchedule = operationRooms.get(roomNumber);
			roomSchedule.add(event);
		} else {
			System.out.println("Ungültige Raumnummer für Operationssaal.");
		}
	}

	public void printDailySchedule(int day, int month, int year) {
		// Assuming you have methods to fetch events for a given day/month/year from the
		// calendar
		List<Event> events = OpCalender.getEventsForDay(day, month, year);

		System.out.println("Tagesansicht für " + day + "/" + month + "/" + year);
		for (int roomNumber = 1; roomNumber <= 5; roomNumber++) {
			System.out.println("Operationssaal " + roomNumber + ":");
			List<Event> roomEvents = operationRooms.get(roomNumber);
			for (Event event : roomEvents) {
				// Check if the event is scheduled for the given day and print its details
				if (event.getDay() == day && event.getMonth() == month && event.getYear() == year) {
					System.out.println("Uhrzeit: " + event.getEventTime() + " - Termin: " + event.getEventName());
				}
			}
		}
	}

	

}
