import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarCLI {
	private final String blankSpace = "\n___________________________________";

	LocalDate dateToday = LocalDate.now();
	LocalDate dateCheck = LocalDate.of(dateToday.getYear(), dateToday.getMonth().getValue(), 1);;
	int yearCheck = dateToday.getYear();
	int monthCheck = dateToday.getMonthValue();
	int dayCheck = dateToday.getDayOfMonth();
	Scanner in = new Scanner(System.in);
	String chosen = "";

	InputCheck ic = new InputCheck();
	MyCalendar ec= new MyCalendar();
	Event event=new Event();
	String dateFor="MM/dd/yyyy";
	DateTimeFormatter formatter =  DateTimeFormatter.ofPattern(dateFor);
	//formatter = formatter.withLocale( Locale.US );
	public void run() {
		ec.readFile();
		displayCalenderSpecificMonth(monthCheck, yearCheck);
		while (true) {
			chosen = mainMenu();
			switch (chosen) {
			case "v":
				viewMenu();
				break;
			case "c":
				//System.out.println("Create Chosen");
				ec.EventCreate();
				break;
			case "g":
				goMenu();
				break;
			case "e":
				ec.traverse();
				break;
			case "d":
				deleteMenu();
				break;
			case "q":
				System.out.println("Closing Calendar");
				ec.writeFile();
				System.exit(0);
				
			}
		}
	}
	

	String mainMenu() {
		boolean valid = false;
		String s = null;
		while (!valid) {
			System.out.println("Please select: ");
			System.out.println("[V]iew by  [C]reate, [G]o to [E]vent list [D]elete  [Q]uit");
			s = in.nextLine();
			valid = ic.mainMenuCheck(s);

		}
		return s.toLowerCase();

	}

	void viewMenu() {
		boolean valid = false;
		String s = null;
		while (!valid) {
			System.out.println("Please select:");
			System.out.println("[D]ay view or [M]view");
			s = in.nextLine();
			valid = ic.viewMenuCheck(s);
		}
		if (s.equalsIgnoreCase("d")) {
			dateCheck = dateToday;
			displayDayCalendar(dateCheck);
			while (!s.equalsIgnoreCase("g")) {
				s = pnmMenu();
				if (s.equalsIgnoreCase("n")) {
					dateCheck = dateCheck.plusDays(1);
					displayDayCalendar(dateCheck);
				} else if(s.equalsIgnoreCase("p")) {
					dateCheck = dateCheck.minusDays(1);
					displayDayCalendar(dateCheck);
				}
			}
		} else if(s.equals("m")) {
			dateCheck = dateToday;
			displayCalendarThisMonth(dateCheck);
			while (!s.equalsIgnoreCase("g")) {
				s = pnmMenu();
				if (s.equalsIgnoreCase("n")) {
					dateCheck = dateCheck.plusMonths(1);
					displayCalendarThisMonth(dateCheck);
				} else if(s.equalsIgnoreCase("p")) {
					dateCheck = dateCheck.minusMonths(1);
					displayCalendarThisMonth(dateCheck);
				}
			}
		} else {
			run();
		}
	}

	

	String pnmMenu() {
		boolean valid = false;
		String s = null;
		while (!valid) {
			System.out.println("Please select: ");
			System.out.println("[P]revious or [N]ext or [G]o back to the main menu ");
			s = in.nextLine();
			valid = ic.pnmMenuCheck(s);
		}
		return s;
	}
	
	void goMenu() {
		boolean valid=false;
		String s = null;
		while(!valid) {
			System.out.println("Enter date to go to in the fomat MM/DD/YYYY");
			s = in.nextLine();
			valid = ic.dateCheck(dateFor, s);
		}
		dateCheck=LocalDate.parse(s, formatter);
		displayDayCalendar(dateCheck);
		ec.searchEvent(s);
	}
	
	void deleteMenu() {
		String d=null, n=null, s=null;
		boolean valid=false;
		while(!valid) {
			System.out.println("Enter [A]ll or [S]pecific");
			s=in.nextLine();
			valid=ic.deleteCheck(s);
		}
		valid=false;
		if(s.equalsIgnoreCase("s")) {
			while(!valid) {
				System.out.println("Enter Date of event to delete in MM/DD/YYYY format");
				d=in.nextLine();
				valid= ic.dateCheck(dateFor, d);
			}
			System.out.println("Enter Name of event to delete");
			n=in.nextLine();
			if(ec.deleteEvent(n, d))
				System.out.println("Event deleted!");
			else
				System.out.println("No event found");
		}
		else if(s.equalsIgnoreCase("a")){
			while(!valid) {
				System.out.println("Enter Date of event to delete in MM/DD/YYYY format");
				d=in.nextLine();
				valid= ic.dateCheck(dateFor, d);
			}
			if(ec.deleteEvent(d))
				System.out.println("Event deleted!");
			else
				System.out.println("No event found");
		}
	}

	public static void displayDayCalendar(LocalDate c) {
		System.out.print(c.getDayOfWeek());
		System.out.print(" ");
		System.out.print(c.getDayOfMonth());
		System.out.print(" ");
		System.out.println(c.getMonth());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM d yyyy");
		System.out.println(" " + formatter.format(c));

		LocalDate x = LocalDate.of(c.getYear(), c.getMonth(), 1);
		
	}

	// Formatting the calendar according to the requirement
	void displayCalendarThisMonth(LocalDate temp) {
		int year = temp.getYear();
		int month = temp.getMonthValue();
		int day = temp.getDayOfMonth();

		LocalDate dateCheck = LocalDate.of(year, month, 1);

		int lastDay = dateCheck.lengthOfMonth();

		System.out.println(blankSpace);
		System.out.print(dateCheck.getMonth());
		System.out.print(" ");
		System.out.print(dateCheck.getYear());
		System.out.println();
		System.out.println("Su   Mo   Tu   We   Th   Fr   Sa");
		for (int i = 0; i < dateCheck.getDayOfWeek().getValue(); i++) {
			System.out.print("     ");
		}
		for (int i = 1; i <= lastDay; i++) {

			if (dateCheck.getDayOfWeek().getValue() == 6) {
				System.out.println();
			}
			dateCheck = LocalDate.of(dateCheck.getYear(), dateCheck.getMonth().getValue(), i);
			if (dateCheck.equals(dateToday))
				System.out.print("[");
			System.out.print(i);
			if (dateCheck.equals(dateToday))
				System.out.print("]");
			if (i < 10)
				System.out.print("    ");
			else
				System.out.print("   ");
		}
		
		System.out.println();
	}

	void displayCalenderSpecificMonth(int month, int year) {
		LocalDate dateCheck = LocalDate.of(year, month, 1);

		int lastDay = dateCheck.lengthOfMonth();

		System.out.println(blankSpace);
		System.out.print(dateCheck.getMonth());
		System.out.print(" ");
		System.out.print(dateCheck.getYear());
		System.out.println();
		System.out.println("Su   Mo   Tu   We   Th   Fr   Sa");
		for (int i = 0; i < dateCheck.getDayOfWeek().getValue(); i++) {
			System.out.print("     ");
		}
		for (int i = 1; i <= lastDay; i++) {

			if (dateCheck.getDayOfWeek().getValue() == 6) {
				System.out.println();
			}
			dateCheck = LocalDate.of(dateCheck.getYear(), dateCheck.getMonth().getValue(), i);
			if (dateCheck.equals(dateToday))
				System.out.print("[");
			System.out.print(i);
			if (dateCheck.equals(dateToday))
				System.out.print("]");
			if (i < 10)
				System.out.print("    ");
			else
				System.out.print("   ");
		}

	}

}
