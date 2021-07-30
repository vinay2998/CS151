
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MyCalendarTester {
	
	
	public static void main(String[] args) {
		CalendarCLI cli = new CalendarCLI();
		//System.out.println(System.getProperty("java.runtime.version"));
		cli.run();
	}	
}
