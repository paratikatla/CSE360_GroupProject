package FrontEnd;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import BackEnd.Patient;

public class PasswordReset {

    private static Stage currStage;

    public static Scene getPasswordReset1(Stage stage, Patient patient)
    {

        currStage = stage;

        currStage.setTitle("Password Reset");

        BorderPane passwordReset = new BorderPane();
		
		VBox upperHolder = new VBox(30);
		HBox titleHolder = new HBox(10);
		
		
		Label title = new Label("Pediatric OAS");
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		Image logoImage = new Image("https://www.rmofmarquis.com/wp-content/themes/rmmarquis/images/no-image-available.png");
		ImageView logo = new ImageView();
		logo.setImage(logoImage);
		logo.setFitHeight(60);
		logo.setFitWidth(60);
		
		titleHolder.getChildren().add(title);
		titleHolder.getChildren().add(logo);
		titleHolder.setAlignment(Pos.CENTER);
		
		Label staffLabel = new Label("Password Reset");
		staffLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		upperHolder.getChildren().add(titleHolder);
		upperHolder.getChildren().add(staffLabel);
		upperHolder.setAlignment(Pos.CENTER);
		
		BorderPane.setMargin(upperHolder, new Insets(20, 0, 0, 0));
		
		
		
		VBox loginHolder = new VBox(30);
		
        TextField emailTextField = new TextField();
        emailTextField.setPromptText("Email");
        emailTextField.setStyle("-fx-padding: 10;" + 
			                    "-fx-font-size: 16px;" + 
			                    "-fx-border-color: black;" +
			                    "-fx-border-width: 1;" +
			                    "-fx-border-radius: 5;" +
			                    "-fx-pref-width: 50;" +
			                    "-fx-pref-height: 40;");
								emailTextField.setMaxWidth(300);

        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setPromptText("Password");
        passwordTextField.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
        passwordTextField.setMaxWidth(300);
		
        
        Button continueButton = new Button("Continue");
        
        continueButton.setStyle("-fx-font-size: 14px; " +  
			                 "-fx-padding: 10 20; " + 
			                 "-fx-border-color: black; " + 
			                 "-fx-border-width: 2; " + 
			                 "-fx-background-color: white; " + 
			                 "-fx-background-radius: 5; " + 
			                 "-fx-border-radius: 5;" +
			                 "-fx-pref-height: 20;" + 
			                 "-fx-pref-width: 200;");

		Button cancelButton = new Button("Continue");

		cancelButton.setStyle("-fx-font-size: 14px; " +  
							"-fx-padding: 10 20; " + 
							"-fx-border-color: black; " + 
							"-fx-border-width: 2; " + 
							"-fx-background-color: white; " + 
							"-fx-background-radius: 5; " + 
							"-fx-border-radius: 5;" +
							"-fx-pref-height: 20;" + 
							"-fx-pref-width: 200;");
       
        
        loginHolder.getChildren().add(emailTextField);
        loginHolder.getChildren().add(passwordTextField);
        loginHolder.getChildren().add(continueButton);
		loginHolder.getChildren().add(cancelButton);
        loginHolder.setAlignment(Pos.CENTER);
        
        
        
        
        
        
		passwordReset.setTop(upperHolder);
		passwordReset.setCenter(loginHolder);
		
		
		class ContinueButtonHandler implements EventHandler<ActionEvent>
		{
			public void handle(ActionEvent event)
			{
				if(!emailTextField.getText().isEmpty() && !passwordTextField.getText().isEmpty())
				{
					if((emailTextField.getText().equals(patient.getEmail())) && passwordTextField.getText().equals(patient.getPassword()))
					{
						Scene passwordResetScene2 = getPasswordReset2(currStage, patient);
						currStage.setScene(passwordResetScene2);
					}
				}
			}
		}
		
		ContinueButtonHandler continueButtonHandler = new ContinueButtonHandler();
		continueButton.setOnAction(continueButtonHandler);

		class CancelButtonHandler implements EventHandler<ActionEvent>
		{
			public void handle(ActionEvent event)
			{
				Scene patientAccountSettingsScene = PatientAccountSettingsPage.getPatientAccountSettingsPage(currStage, patient);
				currStage.setScene(patientAccountSettingsScene);
			}
		}

		CancelButtonHandler cancelButtonHandler = new CancelButtonHandler();
		cancelButton.setOnAction(cancelButtonHandler);


        Scene passwordResetPage = new Scene(passwordReset, 1150, 700);
        return passwordResetPage;
    }


	public static Scene getPasswordReset2(Stage stage, Patient patient)
    {

        currStage = stage;

        currStage.setTitle("Password Reset");

        BorderPane passwordReset = new BorderPane();
		
		VBox upperHolder = new VBox(30);
		HBox titleHolder = new HBox(10);
		
		
		Label title = new Label("Pediatric OAS");
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		Image logoImage = new Image("https://www.rmofmarquis.com/wp-content/themes/rmmarquis/images/no-image-available.png");
		ImageView logo = new ImageView();
		logo.setImage(logoImage);
		logo.setFitHeight(60);
		logo.setFitWidth(60);
		
		titleHolder.getChildren().add(title);
		titleHolder.getChildren().add(logo);
		titleHolder.setAlignment(Pos.CENTER);
		
		Label staffLabel = new Label("Password Reset");
		staffLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		upperHolder.getChildren().add(titleHolder);
		upperHolder.getChildren().add(staffLabel);
		upperHolder.setAlignment(Pos.CENTER);
		
		BorderPane.setMargin(upperHolder, new Insets(20, 0, 0, 0));
		
		
		
		VBox loginHolder = new VBox(30);
		
        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setPromptText("Password");
        passwordTextField.setStyle("-fx-padding: 10;" + 
			                    "-fx-font-size: 16px;" + 
			                    "-fx-border-color: black;" +
			                    "-fx-border-width: 1;" +
			                    "-fx-border-radius: 5;" +
			                    "-fx-pref-width: 50;" +
			                    "-fx-pref-height: 40;");
								passwordTextField.setMaxWidth(300);

		PasswordField passwordConfirmTextField = new PasswordField();
        passwordConfirmTextField.setPromptText("Confirm Password");
        passwordConfirmTextField.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		passwordConfirmTextField.setMaxWidth(300);
		
        
        Button confirmButton = new Button("Confirm");
        
        confirmButton.setStyle("-fx-font-size: 14px; " +  
			                 "-fx-padding: 10 20; " + 
			                 "-fx-border-color: black; " + 
			                 "-fx-border-width: 2; " + 
			                 "-fx-background-color: white; " + 
			                 "-fx-background-radius: 5; " + 
			                 "-fx-border-radius: 5;" +
			                 "-fx-pref-height: 20;" + 
			                 "-fx-pref-width: 200;");
       
        
        loginHolder.getChildren().add(passwordTextField);
        loginHolder.getChildren().add(passwordConfirmTextField);
        loginHolder.getChildren().add(confirmButton);
        loginHolder.setAlignment(Pos.CENTER);
        
        
        
		passwordReset.setTop(upperHolder);
		passwordReset.setCenter(loginHolder);
		
		
		class ConfirmButtonHandler implements EventHandler<ActionEvent>
		{
			public void handle(ActionEvent event)
			{
				if(!passwordTextField.getText().isEmpty() && !passwordConfirmTextField.getText().isEmpty())
				{
					if(passwordTextField.getText().equals(passwordConfirmTextField.getText()))
					{
						Patient.resetPatientPassword(patient.getUid(), passwordTextField.getText());

						Scene patientAccountSettingsScene = PatientAccountSettingsPage.getPatientAccountSettingsPage(currStage, patient);
						currStage.setScene(patientAccountSettingsScene);
					}
					
				}
			}
		}
		
		ConfirmButtonHandler confirmButtonHandler = new ConfirmButtonHandler();
		confirmButton.setOnAction(confirmButtonHandler);


        Scene passwordResetPage = new Scene(passwordReset, 1150, 700);
        return passwordResetPage;
    }
    
}
