import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class MyCalendar {

	private String name, date, start, end;
	Scanner in = new Scanner(System.in);
	String chosen = "";
	InputCheck ic = new InputCheck();
	String dateFor = "MM/dd/yyyy";
	String timeFor = "k:mm";
	DateTimeFormatter formatterD = DateTimeFormatter.ofPattern(dateFor);
	DateTimeFormatter formatterT = DateTimeFormatter.ofPattern(timeFor);
	LocalDate dateCheck;// = LocalDate.now();
	Event temp = new Event();
	private ArrayList<Event> eventList=new ArrayList<Event>();
	String eventForTxt;
	boolean flag=false;

	public void EventCreate() {
		
		inputName();
		inputDate();
		inputStart();
		inputEnd();
		temp = new Event(name, date, start, end);
		
		if(!checkCollision(temp)) {
			stringToDate(date);
			eventForTxt = stringOfEvent();
			System.out.println("Adding the following event to events.txt\n" + eventForTxt);
			addEventToFile(eventForTxt);
			eventList.add(temp);
		}else {
			System.out.println("There is an event scheduled for that time.");
		}
		
	}

	void inputName() {
		String s = null;

		System.out.println("Enter name of event");
		s = in.nextLine();
		name = s;
	}

	void inputDate() {
		boolean valid = false;
		String s = null;

		while (!valid) {
			System.out.println("Enter date in the fomat MM/DD/YYYY");
			s = in.nextLine();
			valid = ic.dateCheck(dateFor, s);
		}
		date = s;

	}

	void inputStart() {
		boolean valid = false;
		String s = null;

		while (!valid) {
			System.out.println("Enter start time in format H:MM");
			s = in.nextLine();
			valid = ic.dateCheck(timeFor, s);
		}
		start = s;

	}

	void inputEnd() {
		boolean valid = false;
		String s = null;

		while (!valid) {
			System.out.println("Enter end time in format H:MM");
			s = in.nextLine();
			valid = ic.dateCheck(timeFor, s);
		}
		end = s;

	}

	void stringToDate(String s) {
		dateCheck = LocalDate.parse(s, formatterD);
	}

	String stringOfEvent() {
		String eventString = date + " " + start + " " + " " + end + " " + name + "\n";
		return eventString;
	}

	void addEventToFile(String s) {
		try {
			String filename = "events.txt";
			FileWriter fw = new FileWriter(filename, true); // the true will append the new data
			fw.write(s);// appends the string to the file
			fw.close();
			System.out.println("Succesfully added!");
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
	void writeFile() {
		String s=null;
		sortEvents();
		
		try {
			String filename = "events.txt";
			FileWriter fw = new FileWriter(filename, false); 
			
			for(int i=0;i<eventList.size();i++) {
				fw.write(temp.eventToString(eventList.get(i))+"\n");
				}
			//fw.write(s);// appends the string to the file
			fw.close();
			System.out.println("Succesfully added!");
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}

	void readFile() {
		try {
			FileReader fr = new FileReader("events.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			
			while((line = br.readLine()) != null) {
				//System.out.println(line);
				temp=new Event();
				if(line.charAt(0)!='*')
					eventList.add(temp.stringToEvent(line));
			}
		}
		catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
	public void traverse() {
		sortEvents();
		for(int i=0;i<eventList.size();i++) {
			System.out.println(temp.eventToString(eventList.get(i)));
		}
	}
	
	
	public boolean deleteEvent(String n, String d) {
		boolean flag=false;
		for(int i=0;i<eventList.size();i++) {
				if(eventList.get(i).getDate().equalsIgnoreCase(d)&&eventList.get(i).getName().equalsIgnoreCase(n)) {
					eventList.remove(i--);
					flag=true;
				}
		}
		return flag;
	}
	
	public boolean deleteEvent(String d) {
		boolean flag=false;
		for(int i=0;i<eventList.size();i++) {
				if(eventList.get(i).getDate().equalsIgnoreCase(d)) {
					eventList.remove(i--);
					flag=true;
				}
		}
		return flag;
	}
	
	public boolean searchEvent(String d) {
		sortEvents();
		boolean flag=false;
		for(int i=0;i<eventList.size();i++) {
				if(eventList.get(i).getDate().equalsIgnoreCase(d)) {
					System.out.println(temp.eventToString(eventList.get(i)));
					flag=true;
				}
		}
		return flag;
	}
	
	void sortEvents() {
		Collections.sort(eventList);
	}
	
	boolean checkCollision(Event e) {
		for(int i=0;i<eventList.size();i++) {
			if(eventList.get(i).collision(e));
				return true;
		}
		return false;
	}
}
