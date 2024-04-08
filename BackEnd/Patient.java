package BackEnd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Patient {

    public static void addPatient(int uid, String firstName, String lastName, String password, String email, String phoneNumber, String dob, String insuranceProvider, String providerPhone, String policyID, String pharmacyName, String pharmacyPhone, String pharmacyAddress)
	{
		try
		{
			UIDLists.addPatientToUIDList(uid);

			String directoryName = "./" + uid;
			File directory = new File(directoryName);
			directory.mkdirs();
			
			String fileName = uid + "_PatientInformation.txt";
			File patientFile = new File(directory, fileName);
			patientFile.createNewFile();
			
			FileWriter writer = new FileWriter(patientFile, false);
			
			writer.write("Name : " + firstName + " " + lastName + "\n");
			writer.write("Patient ID : " + uid + "\n");
			writer.write("Password : " + password + "\n");
			writer.write("Email : " + email + "\n");
			writer.write("Phone Number : " + phoneNumber + "\n");
			writer.write("Date of Birth : " + dob + "\n\n");
			
			writer.write("Insurance Provider : " + insuranceProvider + "\n");
			writer.write("Insurance Provider Phone Number : " + providerPhone + "\n");
			writer.write("Policy ID : " + policyID + "\n\n");

			writer.write("Pharmacy : " + pharmacyPhone + "\n");
			writer.write("Pharmacy Phone Number : " + pharmacyPhone + "\n");
			writer.write("Pharmacy Address : " + pharmacyAddress + "\n");

			writer.close();
			
			System.out.println("Patient Created");
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	// Function used to check if a patient exists within the system
	public static boolean doesPatientExist(String uid)
	{
		String uidList = UIDLists.getPatientUIDList();
		
		if(uidList.contains(uid))
		{
			return true;
		}
		
		return false;
	}

	public static void replaceLine(String filePath, String field, String newText)
	{
		String tempFile = "temp.txt";
		boolean replaced = false;

		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String currentLine;
            while ((currentLine = reader.readLine()) != null) {

                if (currentLine.startsWith(field)) 
				{
                    writer.write(field + newText);
                    replaced = true;
                } 
				else 
				{
                    writer.write(currentLine);
                }
                writer.newLine();
            }

			reader.close();
			writer.close();

            if(!replaced) 
			{
                System.out.println("Line was not found.");
            }

			File originalFile = new File(filePath);
			File tempFileObject = new File(tempFile);

			if(originalFile.delete()) 
			{
				if (!tempFileObject.renameTo(originalFile)) 
				{
					System.err.println("Could not rename the temporary file to the original filename.");
				}
			} 
			else 
			{
				System.err.println("Could not delete the original file.");
			}

		}
		catch (IOException e) 
		{
            e.printStackTrace();
        }
	}

    public static void resetPatientPassword(int uid, String password)
    {

		String patientFile = "./" + uid + "/" + uid + "_PatientInformation.txt";
			
        replaceLine(patientFile, "Password : ", password);

    }

	public static void changePatientEmail(int uid, String email)
    {

		String patientFile = "./" + uid + "/" + uid + "_PatientInformation.txt";
			
        replaceLine(patientFile, "Email : ", email);

    }

	public static void changePatientPhoneNumber(int uid, String phoneNumber)
    {

		String patientFile = "./" + uid + "/" + uid + "_PatientInformation.txt";
			
        replaceLine(patientFile, "Phone Number : ", phoneNumber);

    }

	public static void changePatientInsuranceProvider(int uid, String insuranceProvider)
    {

		String patientFile = "./" + uid + "/" + uid + "_PatientInformation.txt";
			
        replaceLine(patientFile, "Insurance Provider : ", insuranceProvider);

    }

	public static void changePatientInsuranceProviderNumber(int uid, String insuranceProviderNumber)
    {

		String patientFile = "./" + uid + "/" + uid + "_PatientInformation.txt";
			
        replaceLine(patientFile, "Insurance Provider Phone Number : ", insuranceProviderNumber);

    }

	public static void changePatientInsurancePolicyID(int uid, String policyID)
    {

		String patientFile = "./" + uid + "/" + uid + "_PatientInformation.txt";
			
        replaceLine(patientFile, "Policy ID : ", policyID);

    }

	public static void changePatientPharmacy(int uid, String pharmacyName)
    {

		String patientFile = "./" + uid + "/" + uid + "_PatientInformation.txt";
			
        replaceLine(patientFile, "Pharmacy : ", pharmacyName);

    }

	public static void changePatientPharmacyPhoneNumber(int uid, String pharmacyPhoneNumber)
    {

		String patientFile = "./" + uid + "/" + uid + "_PatientInformation.txt";
			
        replaceLine(patientFile, "Pharmacy Phone Number : ", pharmacyPhoneNumber);

    }

	public static void changePatientPharmacyAddress(int uid, String pharmacyAddress)
    {

		String patientFile = "./" + uid + "/" + uid + "_PatientInformation.txt";
			
        replaceLine(patientFile, "Pharmacy Address : ", pharmacyAddress);

    }
}
