package BackEnd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class Util {

	
	// Utility function simply used to check if a String value is a number
	public static boolean isNumeric(String str) {
	    try {
	        int i = Integer.parseInt(str);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

	public static boolean isOlderThan12Years(String dateStr) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        LocalDate birthdate = LocalDate.parse(dateStr, formatter);
        
        LocalDate currentDate = LocalDate.now();
        
        Period period = Period.between(birthdate, currentDate);
        
        return (period.getYears() >= 12);
    }

}
