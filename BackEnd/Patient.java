package BackEnd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Patient 
{

	int uid;
	String firstName;
	String lastName;
	String password;
	String email;
	String phoneNumber;
	String dob;
	String insuranceProvider;
	String providerPhone;
	String policyID;
	String pharmacyName;
	String pharmacyPhone;
	String pharmacyAddress;

	public void setUid(int uid) {
		this.uid = uid;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}



	public void setProviderPhone(String providerPhone) {
		this.providerPhone = providerPhone;
	}



	public void setPolicyID(String policyID) {
		this.policyID = policyID;
	}



	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}



	public void setPharmacyPhone(String pharmacyPhone) {
		this.pharmacyPhone = pharmacyPhone;
	}



	public void setPharmacyAddress(String pharmacyAddress) {
		this.pharmacyAddress = pharmacyAddress;
	}


	public void setFullName(String fullName)
	{
		int spaceIndex = fullName.indexOf(' ');

		this.firstName = fullName.substring(0, spaceIndex);
		this.lastName = fullName.substring(spaceIndex + 1);
	}



	public int getUid() {
		return uid;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getPassword() {
		return password;
	}



	public String getEmail() {
		return email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public String getDob() {
		return dob;
	}



	public String getInsuranceProvider() {
		return insuranceProvider;
	}



	public String getProviderPhone() {
		return providerPhone;
	}



	public String getPolicyID() {
		return policyID;
	}



	public String getPharmacyName() {
		return pharmacyName;
	}



	public String getPharmacyPhone() {
		return pharmacyPhone;
	}



	public String getPharmacyAddress() {
		return pharmacyAddress;
	}

	public String getFullName()
	{
		return firstName + lastName;
	}

	



	public Patient(int uid, String firstName, String lastName, String password, String email, String phoneNumber, String dob, String insuranceProvider, String providerPhone, String policyID, String pharmacyName, String pharmacyPhone, String pharmacyAddress)
	{
		this.uid = uid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.insuranceProvider = insuranceProvider;
		this.providerPhone = providerPhone;
		this.policyID = policyID;
		this.pharmacyName = pharmacyName;
		this.pharmacyPhone = pharmacyPhone;
		this.pharmacyAddress = pharmacyAddress;
	}
	
	

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

	public Patient patientSignIn(String uid, String password)
    {
        if(doesPatientExist(uid))
        {
            try
            {
                String patientFile = "./" + uid + "/" + uid + "_PatientInformation.txt";

                BufferedReader reader = new BufferedReader(new FileReader(patientFile));


				String nameLine = reader.readLine();
				
				String fullName = nameLine.substring(7);
				int spaceIndex = fullName.indexOf(" ");
				String firstName = fullName.substring(0, spaceIndex);
				String lastName = fullName.substring(7);



				reader.readLine();



				String passwordLine = reader.readLine();
				String correctPassword = passwordLine.substring(11);
				if(!(password.equals(correctPassword)))
				{
					reader.close();
					return null;
				}



				String emailLine = reader.readLine();
				String email = emailLine.substring(8);


				
				String phoneNumberLine = reader.readLine();
				String phoneNumber = phoneNumberLine.substring(15);



				String birthDateLine = reader.readLine();
				String birthDate = birthDateLine.substring(16);



				reader.readLine();



				String insuranceProviderLine = reader.readLine();
				String insuranceProvider = insuranceProviderLine.substring(21);



				String insuranceProviderPhoneLine = reader.readLine();
				String insuranceProviderPhone = insuranceProviderPhoneLine.substring(insuranceProviderPhoneLine.indexOf(':') + 2);
				


				String policyIDLine = reader.readLine();
				String policyID = policyIDLine.substring(policyIDLine.indexOf(':') + 2);



				reader.readLine();



				String pharmacyNameLine = reader.readLine();
				String pharmacyName = pharmacyNameLine.substring(pharmacyNameLine.indexOf(':') + 2);



				String pharmacyPhoneLine = reader.readLine();
				String pharmacyPhone = pharmacyPhoneLine.substring(pharmacyPhoneLine.indexOf(':') + 2);



				String pharmacyAddressLine = reader.readLine();
				String pharmacyAddress = pharmacyAddressLine.substring(pharmacyAddressLine.indexOf(':') + 2);

				
				int stringUID = Integer.parseInt(uid);

				Patient signedInPatient = new Patient(stringUID, firstName, lastName, correctPassword, email, phoneNumber, birthDate, insuranceProvider, insuranceProviderPhone, policyID, pharmacyName, pharmacyPhone, pharmacyAddress);
                

                reader.close();

				return signedInPatient;
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return null;
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
