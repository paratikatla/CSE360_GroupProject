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
import javafx.scene.control.ComboBox;
import BackEnd.Staff;

public class StaffRegistrationPage
{

    private static Stage currStage;

    public static Scene getStaffRegistrationPage(Stage stage)
    {
        currStage = stage;

        currStage.setTitle("Staff Registration");

        BorderPane staffCreation = new BorderPane();
		
		
		VBox upperHolder = new VBox(30);
		HBox titleHolder = new HBox(10);
		
		Label title = new Label("Pediatric OAS");
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		Image logoImage = new Image("https://www.rmofmarquis.com/wp-content/themes/rmmarquis/images/no-image-available.png");
		ImageView logo = new ImageView();
		logo.setImage(logoImage);
		logo.setFitHeight(60);
		logo.setFitWidth(60);
		
		Label patientLabel = new Label("Staff Account Creation");
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
		
		
		DatePicker datePicker = new DatePicker();



		ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Doctor", "Nurse");
        roleBox.setPromptText("Select Role");
        
		
		
		
		leftBox.getChildren().add(firstNameField);
		leftBox.getChildren().add(lastNameField);
		leftBox.getChildren().add(datePicker);
        leftBox.getChildren().add(roleBox);
		leftBox.setAlignment(Pos.CENTER);


        TextField employeeID = new TextField();
		employeeID.setPromptText("Employee ID");
		employeeID.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		employeeID.setMaxWidth(300);
		
		
		
		TextField emailField = new TextField();
		emailField.setPromptText("Staff Email");
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
		
		
		
		
		
		
		
		rightBox.getChildren().add(employeeID);
        rightBox.getChildren().add(emailField);
		rightBox.getChildren().add(passwordField);
		rightBox.setAlignment(Pos.CENTER);
		
		
		
		fieldBox.getChildren().add(leftBox);
		fieldBox.getChildren().add(rightBox);
		fieldBox.setAlignment(Pos.CENTER);
		
		
		
		VBox registerContainer = new VBox();
		
		Button registerButton = new Button("Register");
		registerButton.setStyle("-fx-font-size: 14px; " +  
				                "-fx-padding: 10 20; " + 
				                "-fx-border-color: black; " + 
				                "-fx-border-width: 2; " + 
				                "-fx-background-color: white; " + 
				                "-fx-background-radius: 5; " + 
				                "-fx-border-radius: 5;" +
				                "-fx-pref-height: 20;" + 
				                "-fx-pref-width: 150;");
		
		registerContainer.getChildren().add(registerButton);
		registerContainer.setAlignment(Pos.CENTER);
		
		BorderPane.setMargin(registerContainer, new Insets(0, 0, 10, 0));
		
		
		staffCreation.setTop(upperHolder);
		staffCreation.setCenter(fieldBox);
		staffCreation.setBottom(registerContainer);
		
		class RegisterButtonHandler implements EventHandler<ActionEvent>
		{
			public void handle(ActionEvent event)
			{
				if(!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty() && !employeeID.getText().isEmpty() && !emailField.getText().isEmpty() && !passwordField.getText().isEmpty() && !(datePicker.getValue() == null) && !(roleBox.getValue() == null))
				{

                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    String email = emailField.getText();
                    String password = passwordField.getText();

                    String uid = employeeID.getText();

                    LocalDate date = datePicker.getValue();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String formattedDate = date.format(formatter);

                    String role = roleBox.getValue();

                    Staff.addStaff(firstName, lastName, formattedDate, role, uid, email, password);

					Scene staffLoginScene = StaffLoginPage.getStaffLoginPage(currStage);
                    currStage.setScene(staffLoginScene);
				}
			}
		}
		
		RegisterButtonHandler continueHandler = new RegisterButtonHandler();
		registerButton.setOnAction(continueHandler);


        Scene staffRegistrationScene = new Scene(staffCreation, 1150, 700);
        return staffRegistrationScene;
    }

}