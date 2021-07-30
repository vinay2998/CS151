import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class InputCheck {

	private DateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
	private DateFormat TimeFor = new SimpleDateFormat("k:mm");

	public boolean mainMenuCheck(String s) {
		if (s.equalsIgnoreCase("v") || s.equalsIgnoreCase("c") || s.equalsIgnoreCase("g") || s.equalsIgnoreCase("e")
				|| s.equalsIgnoreCase("d") || s.equalsIgnoreCase("q"))
			return true;
		else
			return false;
	}

	public boolean viewMenuCheck(String s) {
		if (s.equalsIgnoreCase("d") || s.equalsIgnoreCase("m"))
			return true;
		else
			return false;

	}

	public boolean pnmMenuCheck(String s) {
		if (s.equalsIgnoreCase("p") || s.equalsIgnoreCase("n") || s.equalsIgnoreCase("g"))
			return true;
		else
			return false;
	}
	static boolean deleteCheck(String s) {
		if (s.equalsIgnoreCase("a") || s.equalsIgnoreCase("s"))
			return true;
		else
			return false;
	}

	static boolean dateCheck(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            //ex.printStackTrace();
        	System.out.println("Wrong Format");
        }
        return date != null;
    }
	
	
}
