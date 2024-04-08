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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PatientLoginPage {
    
    private static Stage currStage;

    public static Scene getPatientLoginPage(Stage stage)
    {

        currStage = stage;

        currStage.setTitle("Patient Login");

        BorderPane patientLogin = new BorderPane();
		
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
		
		Label staffLabel = new Label("Patient Login");
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

        TextField passwordTextField = new TextField();
        passwordTextField.setPromptText("Password");
        passwordTextField.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
        passwordTextField.setMaxWidth(300);
        
        Button loginButton = new Button("Login");
        
        loginButton.setStyle("-fx-font-size: 14px; " +  
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
        loginHolder.getChildren().add(loginButton);
        loginHolder.setAlignment(Pos.CENTER);
        
        
        VBox extraFields = new VBox(5);
        
        VBox createAccount = new VBox();
        
        Label noAccount = new Label("Don't have an account?");
        Button createAccountButton = new Button("Create Account");
        createAccountButton.setStyle("-fx-font-size: 14px; " +  
				   	                 "-fx-padding: 10 20; " + 
					                 "-fx-border-color: black; " + 
					                 "-fx-border-width: 2; " + 
					                 "-fx-background-color: white; " + 
					                 "-fx-background-radius: 5; " + 
					                 "-fx-border-radius: 5;" +
					                 "-fx-pref-height: 20;" + 
					                 "-fx-pref-width: 150;");
        
        
        createAccount.getChildren().add(noAccount);
        createAccount.getChildren().add(createAccountButton);
        createAccount.setAlignment(Pos.CENTER);
        
        
        
        VBox notPatient = new VBox();
        
        Label notPatientLabel = new Label("Not a patient?");
        Button staffLogin = new Button("Staff Login");
        staffLogin.setStyle("-fx-font-size: 14px; " +  
			                  "-fx-padding: 10 20; " + 
			                  "-fx-border-color: black; " + 
			                  "-fx-border-width: 2; " + 
			                  "-fx-background-color: white; " + 
			                  "-fx-background-radius: 5; " + 
			                  "-fx-border-radius: 5;" +
			                  "-fx-pref-height: 20;" + 
			                  "-fx-pref-width: 150;");
        
        notPatient.getChildren().add(notPatientLabel);
        notPatient.getChildren().add(staffLogin);
        notPatient.setAlignment(Pos.CENTER);
        
        
        extraFields.getChildren().add(createAccount);
        extraFields.getChildren().add(notPatient);
        extraFields.setAlignment(Pos.CENTER);
        
        
        BorderPane.setMargin(extraFields, new Insets(0, 0, 10, 0));
        
        
        
		patientLogin.setTop(upperHolder);
		patientLogin.setCenter(loginHolder);
		patientLogin.setBottom(extraFields);
		
		// class NotPatientButtonHandler implements EventHandler<ActionEvent>
		// {
		// 	public void handle(ActionEvent event)
		// 	{
		// 		StaffLogin staffLoginPage = new StaffLogin(mainApp, loginInfo);
		// 		mainApp.navigateTo(staffLoginPage);
		// 	}
		// }
		
		// NotPatientButtonHandler notPatientHandler = new NotPatientButtonHandler();
		// staffLogin.setOnAction(notPatientHandler);
		
		
		
		// class PatientCreationButtonHandler implements EventHandler<ActionEvent>
		// {
		// 	public void handle(ActionEvent event)
		// 	{
		// 		PatientCreation patientCreationPage = new PatientCreation(mainApp, loginInfo);
		// 		mainApp.navigateTo(patientCreationPage);
		// 	}
		// }
		
		// PatientCreationButtonHandler patientCreationHandler = new PatientCreationButtonHandler();
		// createAccountButton.setOnAction(patientCreationHandler);
		
		
		
		// class LoginButtonHandler implements EventHandler<ActionEvent>
		// {
		// 	public void handle(ActionEvent event)
		// 	{
		// 		if(loginInfo.findPatient(emailTextField.getText(), passwordTextField.getText()))
		// 		{
		// 			SampleSuccessfulLogin successfulLogin = new SampleSuccessfulLogin(mainApp);
		// 			mainApp.navigateTo(successfulLogin);
		// 		}
		// 		else
		// 		{
		// 			System.out.print("Patient not found\n");
		// 			System.out.print(emailTextField.getText() + " + " + passwordTextField.getText() + "\n");
		// 		}
		// 	}
		// }
		
		// LoginButtonHandler loginHandler = new LoginButtonHandler();
		// loginButton.setOnAction(loginHandler);


        Scene patientLoginScene = new Scene(patientLogin, 700, 500);
        return patientLoginScene;
    }
}
