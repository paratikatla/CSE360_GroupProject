package BackEnd;

import javafx.scene.text.TextFlow;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Messaging {
    
    public static void sendMessage(String uid, String message, TextFlow messageFlow)
    {
        if(!message.isEmpty())
        {
            Text text = new Text(message + "\n");

            if(Patient.doesPatientExist(uid))
            {
                text.setFill(Color.BLACK);
            }
            else if(Staff.doesStaffExist(uid))
            {
                text.setFill(Color.BLUE);
            }

            messageFlow.getChildren().add(text);
        }
    }

}
