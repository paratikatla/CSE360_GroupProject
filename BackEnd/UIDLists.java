package BackEnd;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UIDLists {

    public static String patientFile = "PatientUIDList.txt";
    public static String staffFile = "StaffUIDList.txt";

    // Functions to get UID Lists for Patients and Staffs

    public static String getPatientUIDList()
	{
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(patientFile));
			String UIDList = reader.readLine();
			reader.close();
			
			if(UIDList != null)
			{
				return UIDList;
			}
			else
			{
				return "";
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
            return "";
		}
		
	}

    public static String getStaffUIDList()
	{
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(staffFile));
			String UIDList = reader.readLine();
			reader.close();
			
			if(UIDList != null)
			{
				return UIDList;
			}
			else
			{
				return "";
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
            return "";
		}
		
	}



    // Add Patient and Staff to UID List for existence validation

    public static void addPatientToUIDList(int uid)
	{
		
		String UIDList = getPatientUIDList();
		
		if(UIDList != null)
		{
			UIDList = UIDList + uid + " ";
		}
		else
		{
			UIDList = "" + uid;
		}
		
		
		try
		{	
			FileWriter writer = new FileWriter(patientFile, false);
			writer.write(UIDList);
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

    public static void addStaffToUIDList(String uid)
	{
		
		String UIDList = getStaffUIDList();
		
		if(UIDList != null)
		{
			UIDList = UIDList + uid + " ";
		}
		else
		{
			UIDList = "" + uid;
		}
		
		
		try
		{	
			FileWriter writer = new FileWriter(staffFile, false);
			writer.write(UIDList);
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}



    // Method to clear UID Lists

	public static void clearPatientUIDList()
	{
		try 
		{
            FileWriter writer = new FileWriter(patientFile, false); // false to overwrite
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void clearStaffUIDList()
	{
		try 
		{
            FileWriter writer = new FileWriter(staffFile, false); // false to overwrite
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}


}
