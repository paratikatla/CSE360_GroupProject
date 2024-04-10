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
import BackEnd.Staff;

public class StaffLoginPage {

    private static Stage currStage;

    public static Scene getStaffLoginPage(Stage stage)
    {

        currStage = stage;

        currStage.setTitle("Staff Login Page");

        BorderPane staffLogin = new BorderPane();
		
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
		
		Label staffLabel = new Label("Staff Login");
		staffLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		upperHolder.getChildren().add(titleHolder);
		upperHolder.getChildren().add(staffLabel);
		upperHolder.setAlignment(Pos.CENTER);
		
		BorderPane.setMargin(upperHolder, new Insets(20, 0, 0, 0));
		
		
		
		VBox loginHolder = new VBox(30);
		
        TextField uidTextField = new TextField();
        uidTextField.setPromptText("Employee ID");
        uidTextField.setStyle("-fx-padding: 10;" + 
			                    "-fx-font-size: 16px;" + 
			                    "-fx-border-color: black;" +
			                    "-fx-border-width: 1;" +
			                    "-fx-border-radius: 5;" +
			                    "-fx-pref-width: 50;" +
			                    "-fx-pref-height: 40;");
        uidTextField.setMaxWidth(300);

        PasswordField passwordTextField = new PasswordField();
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
       
        
        loginHolder.getChildren().add(uidTextField);
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
        
        
        
        VBox notStaff = new VBox();
        
        Label notStaffMember = new Label("Not a staff member?");
        Button patientLogin = new Button("Patient Login");
        patientLogin.setStyle("-fx-font-size: 14px; " +  
			                  "-fx-padding: 10 20; " + 
			                  "-fx-border-color: black; " + 
			                  "-fx-border-width: 2; " + 
			                  "-fx-background-color: white; " + 
			                  "-fx-background-radius: 5; " + 
			                  "-fx-border-radius: 5;" +
			                  "-fx-pref-height: 20;" + 
			                  "-fx-pref-width: 150;");
        
        notStaff.getChildren().add(notStaffMember);
        notStaff.getChildren().add(patientLogin);
        notStaff.setAlignment(Pos.CENTER);
        
        
        extraFields.getChildren().add(createAccount);
        extraFields.getChildren().add(notStaff);
        extraFields.setAlignment(Pos.CENTER);
        
        
        BorderPane.setMargin(extraFields, new Insets(0, 0, 10, 0));
        
        
		staffLogin.setTop(upperHolder);
		staffLogin.setCenter(loginHolder);
		staffLogin.setBottom(extraFields);
		
		class NotStaffButtonHandler implements EventHandler<ActionEvent>
		{
			public void handle(ActionEvent event)
			{
				Scene patientLoginScene = PatientLoginPage.getPatientLoginPage(currStage);
                currStage.setScene(patientLoginScene);
			}
		}
		
		NotStaffButtonHandler notStaffHandler = new NotStaffButtonHandler();
		patientLogin.setOnAction(notStaffHandler);

		class StaffLoginButtonHandler implements EventHandler<ActionEvent>
		{
			public void handle(ActionEvent event)
			{
				if(!uidTextField.getText().isEmpty() && !passwordTextField.getText().isEmpty())
				{
					Staff signedInStaff = Staff.staffSignIn(uidTextField.getText(), passwordTextField.getText());

					if(signedInStaff != null)
					{
						Scene staffHomeScene = StaffViewHome.getStaffHomeView(currStage, signedInStaff);
						currStage.setScene(staffHomeScene);
					}
					
				}
			}
		}

		StaffLoginButtonHandler staffLoginButtonHandler = new StaffLoginButtonHandler();
		loginButton.setOnAction(staffLoginButtonHandler);

		class CreateStaffAccountHandler implements EventHandler<ActionEvent>
		{

			public void handle(ActionEvent arg0) 
			{
				Scene staffRegistrationScene = StaffRegistrationPage.getStaffRegistrationPage(currStage);
				currStage.setScene(staffRegistrationScene);
			}
			
		}

		CreateStaffAccountHandler createStaffAccountHandler = new CreateStaffAccountHandler();
		createAccountButton.setOnAction(createStaffAccountHandler);

        Scene staffLoginScene = new Scene(staffLogin, 1150, 700);
        return staffLoginScene;
    }
    
}
