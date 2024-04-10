package BackEnd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Staff {

    String employeeID;
    String role;
    String firstName;
    String lastName;
    String dob;
    String staffEmail;
    String password;

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
		return firstName + lastName;
	}

    public void setFullName(String fullName)
	{
		int spaceIndex = fullName.indexOf(' ');

		this.firstName = fullName.substring(0, spaceIndex);
		this.lastName = fullName.substring(spaceIndex + 1);
	}

    public Staff(String employeeID, String role, String firstName, String lastName, String dob, String staffEmail)
    {
        this.employeeID = employeeID;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.staffEmail = staffEmail;
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
				String lastName = fullName.substring(7);

                reader.readLine();

                String passwordLine = reader.readLine();
                String correctPassword = passwordLine.substring(passwordLine.indexOf(':') + 2);
                if(password != correctPassword)
                {
                    reader.close();
                    return null;
                }

                String emailLine = reader.readLine();
                String email = emailLine.substring(emailLine.indexOf(':') + 2);

                String roleLine = reader.readLine();
                String role = roleLine.substring(roleLine.indexOf(':') + 2);

                String dobLine = reader.readLine();
                String dob = dobLine.substring(dobLine.indexOf(':') + 2);

                Staff signedInStaff = new Staff(employeeID, role, firstName, lastName, dob, email);

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

    public static void resetStaffPassword(int uid, String password)
    {

		String staffFile = "./" + uid + "/" + uid + "_StaffInformation.txt";
			
        replaceLine(staffFile, "Password : ", password);

    }

    public static void changeStaffEmail(int uid, String email)
    {

		String staffFile = "./" + uid + "/" + uid + "_StaffInformation.txt";
			
        replaceLine(staffFile, "Email : ", email);

    }

    public static void changeStaffRole(int uid, String role)
    {

		String staffFile = "./" + uid + "/" + uid + "_StaffInformation.txt";
			
        replaceLine(staffFile, "Role : ", role);

    }

}
