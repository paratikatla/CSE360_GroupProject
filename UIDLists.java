import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UIDLists {

    public static String patientFile = "PatientUIDList.txt";
    public static String doctorFile = "DoctorUIDList.txt";

    // Functions to get UID Lists for Patients and Doctors

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

    public static String getDoctorUIDList()
	{
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(doctorFile));
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



    // Add Patient and Doctor to UID List for existence validation

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

    public static void addToDoctorUIDList(int uid)
	{
		
		String UIDList = getDoctorUIDList();
		
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
			FileWriter writer = new FileWriter(doctorFile, false);
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

	public static void clearDoctorUIDList()
	{
		try 
		{
            FileWriter writer = new FileWriter(doctorFile, false); // false to overwrite
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}


}
