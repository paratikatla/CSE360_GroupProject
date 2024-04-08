package BackEnd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SignIn {
    

    public boolean patientSignIn(String uid, String password)
    {
        if(Patient.doesPatientExist(uid))
        {
            try
            {
                String patientFile = "./" + uid + "/" + uid + "_PatientInformation.txt";

                BufferedReader reader = new BufferedReader(new FileReader(patientFile));

                String currentLine;
                while ((currentLine = reader.readLine()) != null) {

                    if (currentLine.startsWith("Password : ")) 
                    {
                        String correctPassword = currentLine.substring(11);

                        if(password.equals(correctPassword))
                        {
                            reader.close();
                            return true;
                        }
                    } 
                }

                reader.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean staffSignIn(String employeeID, String password)
    {
        if(Staff.doesStaffExist(employeeID))
        {
            try
            {
                String staffFile = "./" + employeeID + "/" + employeeID + "_StaffInformation.txt";

                BufferedReader reader = new BufferedReader(new FileReader(staffFile));

                String currentLine;
                while ((currentLine = reader.readLine()) != null) {

                    if (currentLine.startsWith("Password : ")) 
                    {
                        String correctPassword = currentLine.substring(11);

                        if(password.equals(correctPassword))
                        {
                            reader.close();
                            return true;
                        }
                    } 
                }

                reader.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }


}
