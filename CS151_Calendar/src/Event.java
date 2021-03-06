import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event implements Comparable<Event>{
	private String name, date, start, end;
	private Date dDate=null;
	private Date dStart=null;
	private Date dEnd=null;

	Event() {
		name = "";
		date = "";
		start = "";
		end = "";

	}

	Event(String n, String d, String s, String e) {
		name = n;
		date = d;
		start = s;
		end = e;
		stringToDate();

	}

	public void setName(String n) {
		name = n;
	}

	public void setDate(String d) {
		date = d;

	}

	public void setStart(String s) {
		start = s;

	}

	public void setEnd(String e) {
		end = e;

	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}
	
	public Date getdDate() {
		return dDate;
	}
	
	public Date getdStart() {
		return dStart;
	}
	
	public Date getdEnd() {
		return dEnd;
	}
	
	public String eventToString(Event input) {
		return input.date + " " + input.start + " " + " " + input.end + " " + input.name;
	}
	
	public String eventToString1() {
		return date + " " + start + " " + " " + end + " " + name;
	}
	
	public Event stringToEvent(String in) {
		int nameStartIndex=0;
		for (int i = 0; i < 10; i++)//for loop for date
			date+=in.charAt(i);
		for(int i=10;i<=15;i++) {//for loop for start
			if(Character.isDigit(in.charAt(i))||in.charAt(i)==':')
				start+=in.charAt(i);
		}
		for(int i=16; i<=22;i++) {//for loop for end
			if(Character.isDigit(in.charAt(i))||in.charAt(i)==':')
				end+=in.charAt(i);
		}

		String temp = date + " " + start + " " + " " + end + " ";//length of string before name
		nameStartIndex=temp.length();
		
		for(int i=nameStartIndex;i<in.length();i++) {//find name
			name+=in.charAt(i);
		}
			
		Event tempE=new Event(name, date, start, end);
		return tempE;
		 
	}
	
	public void stringToDate() {
		try {
			SimpleDateFormat formatter1=new SimpleDateFormat("MM/dd/yyyy");  
			SimpleDateFormat formatter2=new SimpleDateFormat("k:mm");  
			 dDate=formatter1.parse(date);
			 dStart=formatter2.parse(start);
			 dEnd=formatter2.parse(end);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public int compareTo(Event e) {
	
		int dateCompare = this.dDate.compareTo(e.dDate);

		if(dateCompare == 0)
			return this.dStart.compareTo(e.dStart);

		return dateCompare;
	}
	
	public boolean collision(Event e) {
		if(e.dDate.equals(this.dDate)) {
			if(e.dStart.equals(this.dStart)||e.dEnd.equals(this.dEnd))
				return true;
			else if(e.dStart.after(this.dStart)&&e.dStart.before(this.dEnd))
				return true;
			else if(e.dEnd.after(this.dStart)&&e.dEnd.before(this.dEnd))
				return true;
		}
		return false;
		
	}

}
