package BackEnd;

import javafx.scene.text.TextFlow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Messaging {

    public static void initTextFlow(String uid, TextFlow messageFlow)
    {
        try
        {
            String fileName = "./" + uid + "/" + uid + "_MessagingHistory.txt";

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String currentLine;
            while((currentLine = reader.readLine()) != null)
            {
                int indexOfSpace = currentLine.indexOf(" ");
                String messageText = currentLine.substring(indexOfSpace + 3);
                
                String id = currentLine.substring(0, indexOfSpace);
                String name;

                Text message = new Text();

                if(Util.isNumeric(id))
                {
                    name = Patient.getFullNameByID(uid);
                    message.setFill(Color.BLACK);
                }
                else
                {
                    String role = Staff.getRoleByID(id);

                    if(role.equals("Nurse"))
                    {
                        name = "Nurse " + Staff.getLastNameByID(id);
                    }
                    else
                    {
                        name = "Dr." + Staff.getLastNameByID(id);
                    }

                    message.setFill(Color.BLUE);
                }
                

                message.setText(name + " : " + messageText + "\n");

                messageFlow.getChildren().add(message);

            }

            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void patientSendMessage(Patient patient, String message, TextFlow messageFlow)
    {
        if(!message.isEmpty())
        {
            String fileName = "./" + patient.getUid() + "/" + patient.getUid() + "_MessagingHistory.txt";

            String name = patient.getFullName();
            Text text = new Text(name + " : " + message + "\n");

            text.setFill(Color.BLACK);

            messageFlow.getChildren().add(text);

            try
            {
                FileWriter writer = new FileWriter(fileName, true);

                writer.write(patient.getUid() + " : " + message + "\n");

                writer.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            String currMessageList = Staff.getMessageAsStringList(patient.getDoctorUID());

            if(!currMessageList.contains("" + patient.getUid()))
            {
                Staff.addToMessageList(patient.getDoctorUID(), "" + patient.getUid());
            }

            

        }
    }

    public static void staffSendMessage(Staff staff, String patientUid, String message, TextFlow messageFlow)
    {
        if(!message.isEmpty())
        {
            String fileName = "./" + patientUid + "/" + patientUid + "_MessagingHistory.txt";

            String name;

            Text text = new Text();

            String role = staff.getRole();

            if(role.equals("Nurse"))
            {
                name = "Nurse " + Staff.getLastNameByID(staff.getEmployeeID());
            }
            else
            {
                name = "Dr." + Staff.getLastNameByID(staff.getEmployeeID());
            }

            text.setText(name + " : " + message + "\n");
            

            text.setFill(Color.BLUE);

            messageFlow.getChildren().add(text);

            try
            {
                FileWriter writer = new FileWriter(fileName, true);


                writer.write(staff.getEmployeeID() + " : " + message + "\n");

                writer.close();

            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            Patient.changeMessageStatus(Integer.parseInt(patientUid), "true");


        }
    }

}
