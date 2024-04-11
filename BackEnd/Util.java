package BackEnd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

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

	public static List<String> generatePrescriptions() {
        List<String> prescriptions = new ArrayList<>();
        // Add dummy prescription data
        prescriptions.add("Amoxicillin");
        prescriptions.add("Ibuprofen");
        prescriptions.add("Lisinopril");
        prescriptions.add("Levothyroxine");
        prescriptions.add("Metformin");
        prescriptions.add("Atorvastatin");
        prescriptions.add("Simvastatin");
        prescriptions.add("Alprazolam");
        prescriptions.add("Gabapentin");
        prescriptions.add("Hydrocodone");
        prescriptions.add("Sertraline");
        prescriptions.add("Amlodipine");
        prescriptions.add("Omeprazole");
        prescriptions.add("Losartan");
        prescriptions.add("Metoprolol");
        prescriptions.add("Azithromycin");
        prescriptions.add("Zolpidem");
        prescriptions.add("Furosemide");
        prescriptions.add("Fluticasone");
        prescriptions.add("Tramadol");
        prescriptions.add("Citalopram");
        prescriptions.add("Bupropion");
        prescriptions.add("Cymbalta");
        prescriptions.add("Venlafaxine");
        prescriptions.add("Duloxetine");
        prescriptions.add("Carvedilol");
        prescriptions.add("Oxycodone");
        prescriptions.add("Escitalopram");
        prescriptions.add("Pravastatin");
        prescriptions.add("Metronidazole");
        prescriptions.add("Fluoxetine");
        prescriptions.add("Prednisone");
        prescriptions.add("Fluconazole");
        prescriptions.add("Trazodone");
        prescriptions.add("Diazepam");
        prescriptions.add("Folic Acid");
        prescriptions.add("Meloxicam");
        prescriptions.add("Pantoprazole");
        prescriptions.add("Warfarin");
        prescriptions.add("Prednisolone");
        prescriptions.add("Amitriptyline");
        prescriptions.add("Lorazepam");
        prescriptions.add("Oxycodone");
        prescriptions.add("Duloxetine");
        prescriptions.add("Hydrochlorothiazide");
        prescriptions.add("Prednisolone");
        prescriptions.add("Potassium");
        prescriptions.add("Methylprednisolone");
        prescriptions.add("Clonazepam");
        return prescriptions;
    }


	public static MenuButton populatePrescriptionMenu() {
		MenuButton prescriptionMenuButton = new MenuButton("Prescriptions");
		Menu prescriptionMenu = new Menu("Select Prescription");

		// List of 50 most common doctor prescriptions (dummy data)
		List<String> prescriptions = generatePrescriptions();

		for (String prescription : prescriptions) {
			MenuItem menuItem = new MenuItem(prescription);
			menuItem.setOnAction(event -> {
				// Handle selection action here
				System.out.println("Selected prescription: " + prescription);
				prescriptionMenuButton.setText(prescription);
			});
			prescriptionMenu.getItems().add(menuItem);
		}

		prescriptionMenuButton.getItems().add(prescriptionMenu);
		return prescriptionMenuButton;
	}

}
