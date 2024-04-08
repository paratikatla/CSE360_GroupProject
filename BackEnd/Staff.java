package BackEnd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Staff {
    
    public void addStaff(String firstName, String lastName, String dob, String role, String employeeID, String staffEmail, String password)
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
