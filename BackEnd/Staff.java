package BackEnd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;

public class Staff {

    String employeeID;
    String role;
    String firstName;
    String lastName;
    String dob;
    String staffEmail;
    String password;
    ObservableList<String> messages;
    int numMessages;
    

    public ObservableList<String> getMessages() {
        return messages;
    }

    public void setMessages(ObservableList<String> messages) {
        this.messages = messages;
    }

    public int getNumMessages() {
        return numMessages;
    }

    public void setNumMessages(int numMessages) {
        this.numMessages = numMessages;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName()
	{
		return firstName + " " + lastName;
	}

    public void setFullName(String fullName)
	{
		int spaceIndex = fullName.indexOf(' ');

		this.firstName = fullName.substring(0, spaceIndex);
		this.lastName = fullName.substring(spaceIndex + 1);
	}

    public static String getLastNameByID(String employeeID)
    {
        if(Staff.doesStaffExist(employeeID))
        {
            try
            {
                String staffFile = "./" + employeeID + "/" + employeeID + "_StaffInformation.txt";

                BufferedReader reader = new BufferedReader(new FileReader(staffFile));

                String nameLine = reader.readLine();
                
                String fullName = nameLine.substring(7);
                int spaceIndex = fullName.indexOf(" ");
                String firstName = fullName.substring(0, spaceIndex);
                String lastName = fullName.substring(spaceIndex + 1);

                reader.close();
                return lastName;
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        return "";
    }

    public static String getRoleByID(String employeeID)
    {
        
        if(Staff.doesStaffExist(employeeID))
        {
            try
            {
                String staffFile = "./" + employeeID + "/" + employeeID + "_StaffInformation.txt";

                BufferedReader reader = new BufferedReader(new FileReader(staffFile));

                String nameLine = reader.readLine();

                reader.readLine();

                String passwordLine = reader.readLine();

                String emailLine = reader.readLine();


                String roleLine = reader.readLine();
                String role = roleLine.substring(roleLine.indexOf(':') + 2);

                reader.close();
                return role;
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        return "";
    }

    public Staff(String employeeID, String role, String firstName, String lastName, String dob, String staffEmail)
    {
        this.employeeID = employeeID;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.staffEmail = staffEmail;

        if(employeeID != null)
        {
            this.messages = getMessageList(employeeID);
            this.numMessages = getNumMessages(employeeID);

            messages.addListener((ListChangeListener<String>) change -> {
                while (change.next()) {
                    if (change.wasAdded() || change.wasRemoved()) {
                        numMessages += 1;
                    }
                }
            });
        }
        
    }
    
    public static void addStaff(String firstName, String lastName, String dob, String role, String employeeID, String staffEmail, String password)
    {

        try
        {
            UIDLists.addStaffToUIDList(employeeID);

            String directoryName = "./" + employeeID;
            File directory = new File(directoryName);
            directory.mkdirs();

            String fileName = employeeID + "_StaffInformation.txt";
            File staffFile = new File(directory, fileName);
            staffFile.createNewFile();

            FileWriter writer = new FileWriter(staffFile, false);

            writer.write("Name : " + firstName + " " + lastName + "\n");
            writer.write("Employee ID : " + employeeID + "\n");
            writer.write("Password : " + password + "\n");
			writer.write("Email : " + staffEmail + "\n");
            writer.write("Role : " + role + "\n");
            writer.write("Date of Birth : " + dob + "\n\n");
            writer.write("Messages : " + "\n");
            writer.write("NumMessages : 0\n");

            writer.close();
			
			System.out.println("Staff Created");
        }
        catch(IOException e)
		{
			e.printStackTrace();
		}
    }

    public static boolean doesStaffExist(String employeeID)
	{
		String uidList = UIDLists.getStaffUIDList();
		
		if(uidList.contains(employeeID))
		{
			return true;
		}
		
		return false;
	}

    public static Staff staffSignIn(String employeeID, String password)
    {
        System.out.print("a\n");
        if(Staff.doesStaffExist(employeeID))
        {
            System.out.print("a\n");
            try
            {
                String staffFile = "./" + employeeID + "/" + employeeID + "_StaffInformation.txt";

                System.out.print("a\n");

                BufferedReader reader = new BufferedReader(new FileReader(staffFile));

                System.out.print("a\n");

                String nameLine = reader.readLine();

                System.out.print("a\n");
				
				String fullName = nameLine.substring(7);
				int spaceIndex = fullName.indexOf(" ");
				String firstName = fullName.substring(0, spaceIndex);
				String lastName = fullName.substring(spaceIndex + 1);

                System.out.print("a\n");

                reader.readLine();

                String passwordLine = reader.readLine();
                String correctPassword = passwordLine.substring(11);
                if(!password.equals(correctPassword))
                {
                    System.out.print("b\n");
                    System.out.print(correctPassword + "\n");
                    reader.close();
                    return null;
                }

                System.out.print("a\n");

                String emailLine = reader.readLine();
                String email = emailLine.substring(emailLine.indexOf(':') + 2);

                String roleLine = reader.readLine();
                String role = roleLine.substring(roleLine.indexOf(':') + 2);

                String dobLine = reader.readLine();
                String dob = dobLine.substring(dobLine.indexOf(':') + 2);

                System.out.print("a\n");

                Staff signedInStaff = new Staff(employeeID, role, firstName, lastName, dob, email);

                System.out.print("a\n");

                reader.close();

                return signedInStaff;
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        
        return null;
    }

    public String getStaffName(String employeeID)
    {
        try
        {
            String staffFile = "./" + employeeID + "/" + employeeID + "_StaffInformation.txt";

            BufferedReader reader = new BufferedReader(new FileReader(staffFile));

            String nameLine = reader.readLine();

            String name = nameLine.substring(7);

            reader.close();

            return name;
        }
        catch (IOException e) 
		{
            e.printStackTrace();
        }

        return "Staff Member not found";
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

    public static void resetStaffPassword(String uid, String password)
    {

		String staffFile = "./" + uid + "/" + uid + "_StaffInformation.txt";
			
        replaceLine(staffFile, "Password : ", password);

    }

    public static void changeStaffEmail(String uid, String email)
    {

		String staffFile = "./" + uid + "/" + uid + "_StaffInformation.txt";
			
        replaceLine(staffFile, "Email : ", email);

    }

    public static void changeStaffRole(String uid, String role)
    {

		String staffFile = "./" + uid + "/" + uid + "_StaffInformation.txt";
			
        replaceLine(staffFile, "Role : ", role);

    }

    public static void changeMessageList(String uid, String list)
    {
        String staffFile = "./" + uid + "/" + uid + "_StaffInformation.txt";
			
        replaceLine(staffFile, "Messages : ", list);
    }

    public static void reduceNumMessages(String uid)
    {
        String staffFile = "./" + uid + "/" + uid + "_StaffInformation.txt";
		
        replaceLine(staffFile, "NumMessages : ", "" + (getNumMessages(uid) - 1));
    }

    public static void addToMessageList(String employeeID, String patientUID)
    {
        try
        {
            String staffFile = "./" + employeeID + "/" + employeeID + "_StaffInformation.txt";

            BufferedReader reader = new BufferedReader(new FileReader(staffFile));

            String currentLine;

            while((currentLine = reader.readLine()) != null)
            {
                if(currentLine.startsWith("Messages : "))
                {
                    String uidList = currentLine.substring(11);
                    replaceLine(staffFile, "Messages : ", uidList + " " + patientUID);
                }

                if(currentLine.startsWith("NumMessages : "))
                {
                    String numMessages = currentLine.substring(14);
                    replaceLine(staffFile, "NumMessages : ", ("" + (Integer.parseInt(numMessages) + 1)));
                }
            }

            reader.close();
        }
        catch (IOException e) 
		{
            e.printStackTrace();
        }

    }

    public static ObservableList<String> getMessageList(String employeeID)
    {
        String staffFile = "./" + employeeID + "/" + employeeID + "_StaffInformation.txt";

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(staffFile));

            String currentLine;
            String uidList = "";

            while((currentLine = reader.readLine()) != null)
            {
                if(currentLine.startsWith("Messages : "))
                {
                    uidList = currentLine.substring(11);
                }
            }

            String[] numberArray = uidList.split(" ");
            ObservableList<String> uidObservableList = FXCollections.observableArrayList();

            for (String number : numberArray) {
                uidObservableList.add(number);
            }

            reader.close();
            return uidObservableList;

        }
        catch (IOException e) 
		{
            e.printStackTrace();
        }

        return null;
    }

    public static String getMessageAsStringList(String employeeID)
    {
        String staffFile = "./" + employeeID + "/" + employeeID + "_StaffInformation.txt";

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(staffFile));

            String currentLine;
            String uidList = "";

            while((currentLine = reader.readLine()) != null)
            {
                if(currentLine.startsWith("Messages : "))
                {
                    uidList = currentLine.substring(11);
                }
            }

            

            reader.close();
            return uidList;

        }
        catch (IOException e) 
		{
            e.printStackTrace();
        }

        return "";
    }

    public static int getNumMessages(String employeeID)
    {
        String staffFile = "./" + employeeID + "/" + employeeID + "_StaffInformation.txt";

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(staffFile));

            String currentLine;
            int numMessages = 0;

            while((currentLine = reader.readLine()) != null)
            {
                if(currentLine.startsWith("NumMessages : "))
                {
                    numMessages = Integer.parseInt(currentLine.substring(14));
                }
            }


            reader.close();
            return numMessages;

        }
        catch (IOException e) 
		{
            e.printStackTrace();
        }

        return 0;
    }

}
