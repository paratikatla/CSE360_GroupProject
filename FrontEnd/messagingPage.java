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
import BackEnd.Messaging;





public class messagingPage {

    static Stage currStage;

    public Scene getMessagingPage(Stage stage, Scene scene, String uidList, String uid)
    {
        currStage = stage;
		
		currStage.setTitle("Messaging Portal");
		
		BorderPane root = new BorderPane();
        VBox container = new VBox(10);


        ScrollPane scrollPane = new ScrollPane();

        TextFlow messageFlow = new TextFlow();

        messageFlow.setPrefHeight(200);
        scrollPane.setContent(messageFlow);
        scrollPane.setFitToWidth(true);

        TextField inputField = new TextField();
        Button sendButton = new Button("Send");

        class SendButtonHandler implements EventHandler<ActionEvent>
        {

            public void handle(ActionEvent arg0) 
            {
                Messaging.sendMessage(uid, inputField.getText().trim(), messageFlow);
                inputField.clear();

                scrollPane.layout();
                scrollPane.setVvalue(1.0d);
            }
            
        }

        SendButtonHandler sendButtonHandler = new SendButtonHandler();
        sendButton.setOnAction(sendButtonHandler);

        container.getChildren().addAll(scrollPane, inputField, sendButton);
        root.setCenter(container);

        Scene messagingPage = new Scene(root, 700, 500);
		return messagingPage;
    }

}
