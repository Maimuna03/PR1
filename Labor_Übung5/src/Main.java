import java.util.Scanner;

public class Main {

	//Create method to display the menu
	public static void displayMenu() {
		System.out.println("\nMenü:");
		System.out.println("Monatsansicht anzeigen (1)");
		System.out.println("Ereignis hinzufügen (2)");
		System.out.println("Progamm beenden (0)");
	}

	public static void main(String[] args) {
		
		//Open new scanner and declare variables
		Scanner sc = new Scanner(System.in);
		int choice;
		int year, month, day;
		String eventText, eventTime;

		//Create object of the class Calender
		Calender myCalendar = new Calender();
		
		System.out.println("\nWillkommen zum Kalender !");

		//Loop that works as long the user chooses menu option 1 or 2 
		do {
			displayMenu();
			
			System.out.print("=> ");
			
			choice = sc.nextInt();
			sc.nextLine(); // Consume newline left-over
			
			System.out.println();

			switch (choice) {
			case 1:
				System.out.println("Von welchem Jahr wollen Sie eine Monatsansicht?");
				System.out.print("=> ");
				

				year = sc.nextInt();
				sc.nextLine(); // Consume newline left-over
				
				System.out.println();


				System.out.println("\nGeben Sie den Monat (als Zahl) ein:");
				System.out.print("=> ");

				month = sc.nextInt();
				sc.nextLine(); // Consume newline left-over
				
				System.out.println();
				
				myCalendar.printCalendar(year, month);
				
				System.out.println();
				
				myCalendar.printEventList(year, month);

				System.out.println();

				break;
			case 2:
				System.out.println("In welchem Jahr wollen Sie ein Ereignis hinzufügen?");
				System.out.print("=> ");
				year = sc.nextInt();
				sc.nextLine(); // Consume newline left-over

				System.out.println("In welchem Monat wollen Sie ein Ereignis hinzufügen? (1-12)");
				System.out.print("=> ");
				month = sc.nextInt();
				sc.nextLine(); // Consume newline left-over

				System.out.println("Geben Sie den Tag (1-31) ein");
				System.out.print("=> ");
				day = sc.nextInt();
				sc.nextLine(); // Consume newline left-over

				System.out.println("\nBennen Sie das Ereignis?");
				System.out.print("=> ");
				eventText = sc.nextLine();

				System.out.println("\nGeben Sie den Zeitpunkt des Ereignis an? (z.B. Mittags, 18Uhr usw.)");
				System.out.print("=> ");
				eventTime = sc.nextLine();
				
				myCalendar.addEvent(year, month, day, new Event(eventText, eventTime));
			
				System.out.println();

				break;
			case 0:
				System.out.println("Programm wird beendet.");
				break;
			default:
				System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
				break;
			}

		} while (choice != 0);

		sc.close();

	}

}
