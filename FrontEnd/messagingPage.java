package FrontEnd;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.TextFlow;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

import javax.swing.Action;

import BackEnd.Messaging;
import BackEnd.Patient;
import BackEnd.Staff;





public class MessagingPage {

    static Stage currStage;

    public static Scene getMessagingPage(Stage stage, Patient patient)
    {
        currStage = stage;
		
		currStage.setTitle("Messaging Portal");
		
		BorderPane root = new BorderPane();
        VBox container = new VBox(10);


        ScrollPane scrollPane = new ScrollPane();

        TextFlow messageFlow = new TextFlow();
        Messaging.initTextFlow("" + patient.getUid(), messageFlow);

        messageFlow.setPrefHeight(200);
        scrollPane.setContent(messageFlow);
        scrollPane.setFitToWidth(true);

        TextField inputField = new TextField();
        Button sendButton = new Button("Send");

        class SendButtonHandler implements EventHandler<ActionEvent>
        {

            public void handle(ActionEvent arg0) 
            {
                Messaging.patientSendMessage(patient, inputField.getText().trim(), messageFlow);
                inputField.clear();

                scrollPane.layout();
                scrollPane.setVvalue(1.0d);
            }
            
        }

        SendButtonHandler sendButtonHandler = new SendButtonHandler();
        sendButton.setOnAction(sendButtonHandler);

        Button backButton = new Button("Back to Home Page");

        class BackButtonHandler implements EventHandler<ActionEvent>
        {
            public void handle(ActionEvent e)
            {
                Scene patientHomeScene = PatientHomePage.getPatientHomePage(currStage, patient);
                currStage.setScene(patientHomeScene);
            }
        }

        BackButtonHandler backButtonHandler = new BackButtonHandler();
        backButton.setOnAction(backButtonHandler);

        container.getChildren().addAll(scrollPane, inputField, sendButton, backButton);
        container.setAlignment(Pos.CENTER);
        root.setCenter(container);

        Scene messagingPage = new Scene(root, 1150, 700);
		return messagingPage;
    }

    public static Scene getMessagingPage(Stage stage, Staff staff, String uid)
    {
        currStage = stage;
		
		currStage.setTitle("Messaging Portal");
		
		BorderPane root = new BorderPane();
        VBox container = new VBox(10);


        ScrollPane scrollPane = new ScrollPane();

        TextFlow messageFlow = new TextFlow();
        Messaging.initTextFlow(uid, messageFlow);

        messageFlow.setPrefHeight(200);
        scrollPane.setContent(messageFlow);
        scrollPane.setFitToWidth(true);

        TextField inputField = new TextField();
        Button sendButton = new Button("Send");

        class SendButtonHandler implements EventHandler<ActionEvent>
        {

            public void handle(ActionEvent arg0) 
            {
                Messaging.staffSendMessage(staff, uid, inputField.getText().trim(), messageFlow);
                inputField.clear();

                scrollPane.layout();
                scrollPane.setVvalue(1.0d);
            }
            
        }

        SendButtonHandler sendButtonHandler = new SendButtonHandler();
        sendButton.setOnAction(sendButtonHandler);

        Button backButton = new Button("Back to Home Page");

        class BackButtonHandler implements EventHandler<ActionEvent>
        {
            public void handle(ActionEvent e)
            {
                Scene staffHomeScene = StaffViewHome.getStaffHomeView(stage, staff);
                currStage.setScene(staffHomeScene);
            }
        }

        BackButtonHandler backButtonHandler = new BackButtonHandler();
        backButton.setOnAction(backButtonHandler);

        container.getChildren().addAll(scrollPane, inputField, sendButton, backButton);
        container.setAlignment(Pos.CENTER);
        root.setCenter(container);

        Scene messagingPage = new Scene(root, 1150, 700);
		return messagingPage;
    }

}
