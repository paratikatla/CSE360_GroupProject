package FrontEnd;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PatientRegistration1 {
    
    private static Stage currStage;

    public static Scene getPatientRegistration1(Stage stage)
    {

        currStage = stage;

        currStage.setTitle("Patient Registration");

        BorderPane patientCreation = new BorderPane();
		
		
		VBox upperHolder = new VBox(30);
		HBox titleHolder = new HBox(10);
		
		Label title = new Label("Pediatric OAS");
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		Image logoImage = new Image("https://www.rmofmarquis.com/wp-content/themes/rmmarquis/images/no-image-available.png");
		ImageView logo = new ImageView();
		logo.setImage(logoImage);
		logo.setFitHeight(60);
		logo.setFitWidth(60);
		
		Label patientLabel = new Label("Patient Account Creation");
		patientLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		titleHolder.getChildren().add(title);
		titleHolder.getChildren().add(logo);
		titleHolder.setAlignment(Pos.CENTER);
		
		upperHolder.getChildren().add(titleHolder);
		upperHolder.getChildren().add(patientLabel);
		upperHolder.setAlignment(Pos.CENTER);
		
		BorderPane.setMargin(upperHolder, new Insets(20, 0, 0, 0));
		
		
		
		HBox fieldBox = new HBox(100);
		VBox leftBox = new VBox(30);
		VBox rightBox = new VBox(30);
		
		
		
		TextField firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		firstNameField.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		firstNameField.setMaxWidth(300);
		
		
		
		TextField lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");
		lastNameField.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		lastNameField.setMaxWidth(300);
		
		
		
		TextField phoneField = new TextField();
		phoneField.setPromptText("Phone Number");
		phoneField.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		phoneField.setMaxWidth(300);
		
		
		
		leftBox.getChildren().add(firstNameField);
		leftBox.getChildren().add(lastNameField);
		leftBox.getChildren().add(phoneField);
		leftBox.setAlignment(Pos.CENTER);
		
		
		
		TextField emailField = new TextField();
		emailField.setPromptText("Email");
		emailField.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		emailField.setMaxWidth(300);
		
		
		
		TextField passwordField = new TextField();
		passwordField.setPromptText("Password");
		passwordField.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		passwordField.setMaxWidth(300);
		
		
		
		DatePicker datePicker = new DatePicker();
		
		
		
		rightBox.getChildren().add(emailField);
		rightBox.getChildren().add(passwordField);
		rightBox.getChildren().add(datePicker);
		rightBox.setAlignment(Pos.CENTER);
		
		
		
		fieldBox.getChildren().add(leftBox);
		fieldBox.getChildren().add(rightBox);
		fieldBox.setAlignment(Pos.CENTER);
		
		
		
		VBox continueContainer = new VBox();
		
		Button continueButton = new Button("Continue");
		continueButton.setStyle("-fx-font-size: 14px; " +  
				                "-fx-padding: 10 20; " + 
				                "-fx-border-color: black; " + 
				                "-fx-border-width: 2; " + 
				                "-fx-background-color: white; " + 
				                "-fx-background-radius: 5; " + 
				                "-fx-border-radius: 5;" +
				                "-fx-pref-height: 20;" + 
				                "-fx-pref-width: 150;");
		
		continueContainer.getChildren().add(continueButton);
		continueContainer.setAlignment(Pos.CENTER);
		
		BorderPane.setMargin(continueContainer, new Insets(0, 0, 10, 0));
		
		
		patientCreation.setTop(upperHolder);
		patientCreation.setCenter(fieldBox);
		patientCreation.setBottom(continueContainer);
		
		class ContinueButtonHandler implements EventHandler<ActionEvent>
		{
			public void handle(ActionEvent event)
			{
				if(!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty() && !phoneField.getText().isEmpty() && !emailField.getText().isEmpty() && !passwordField.getText().isEmpty() && !(datePicker.getValue() == null))
				{

                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    String phoneNumber = phoneField.getText();
                    String email = emailField.getText();
                    String password = passwordField.getText();

                    LocalDate date = datePicker.getValue();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    String formattedDate = date.format(formatter);

					Scene patientRegistration2 = PatientRegistration2.getPatientRegistration2(currStage, firstName, lastName, phoneNumber, email, password, formattedDate);
                    currStage.setScene(patientRegistration2);
				}
			}
		}
		
		ContinueButtonHandler continueHandler = new ContinueButtonHandler();
		continueButton.setOnAction(continueHandler);

        Scene patientRegistration1Scene = new Scene(patientCreation, 1150, 700);
        return patientRegistration1Scene;
    }

}
