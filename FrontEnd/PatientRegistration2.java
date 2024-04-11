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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import BackEnd.Patient;


public class PatientRegistration2 {

    private static Stage currStage;

    public static Scene getPatientRegistration2(Stage stage, String firstName, String lastName, String phoneNumber, String email, String password, String dob)
    {

        currStage = stage;
        currStage.setTitle("Patient Registration");

        BorderPane patientRegistration = new BorderPane();
		
		
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
		
		
		
		TextField providerField = new TextField();
		providerField.setPromptText("Insurance Provider");
		providerField.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		providerField.setMaxWidth(300);
		
		
		
		TextField providerPhone = new TextField();
		providerPhone.setPromptText("Provider Phone Number");
		providerPhone.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		providerPhone.setMaxWidth(300);
		
		
		
		TextField policyField = new TextField();
		policyField.setPromptText("Policy ID #");
		policyField.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		policyField.setMaxWidth(300);
		
		
		
		leftBox.getChildren().add(providerField);
		leftBox.getChildren().add(providerPhone);
		leftBox.getChildren().add(policyField);
		leftBox.setAlignment(Pos.CENTER);
		
		
		
		TextField pharmacyField = new TextField();
		pharmacyField.setPromptText("Pharmacy Name");
		pharmacyField.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		pharmacyField.setMaxWidth(300);
		
		
		
		TextField pharmacyPhone = new TextField();
		pharmacyPhone.setPromptText("Pharmacy Phone #");
		pharmacyPhone.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		pharmacyPhone.setMaxWidth(300);
		
		
		
		TextField pharmacyAddress = new TextField();
		pharmacyAddress.setPromptText("Pharmacy Address");
		pharmacyAddress.setStyle("-fx-padding: 10;" +
			 	                   "-fx-font-size: 16px;" +
			 	                   "-fx-border-color: black;" +
				                   "-fx-border-width: 1;" +
				                   "-fx-border-radius: 5;" +
				                   "-fx-pref-height: 40;");
		pharmacyAddress.setMaxWidth(300);
		
		
		
		rightBox.getChildren().add(pharmacyField);
		rightBox.getChildren().add(pharmacyPhone);
		rightBox.getChildren().add(pharmacyAddress);
		rightBox.setAlignment(Pos.CENTER);

		Label updateLabel = new Label();
		updateLabel.setTextFill(Color.BLUE);
		
		
		fieldBox.getChildren().add(updateLabel);
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
		
		
		patientRegistration.setTop(upperHolder);
		patientRegistration.setCenter(fieldBox);
		patientRegistration.setBottom(registerContainer);
		
		int counter = 0;
		
		class RegisterButtonHandler implements EventHandler<ActionEvent>
		{

			private static int counter;

			public RegisterButtonHandler(int counter)
			{
				this.counter = counter;
			}

			public void handle(ActionEvent event)
			{
				if(!providerField.getText().isEmpty() && !providerPhone.getText().isEmpty() && !policyField.getText().isEmpty() && !pharmacyField.getText().isEmpty() && !pharmacyPhone.getText().isEmpty() && !pharmacyAddress.getText().isEmpty())
                {
                    String insuranceProvider = providerField.getText();
                    String providerPhoneNumber = providerPhone.getText();
                    String insurancePolicy = policyField.getText();

                    String pharmacyName = pharmacyField.getText();
                    String pharmacyPhoneNumber = pharmacyPhone.getText();
                    String pharmacyAddr = pharmacyAddress.getText();

                    boolean doesUIDExist = true;

                    int uid = 0;

                    while(doesUIDExist)
                    {
                        uid = Patient.generateRandUID();

                        doesUIDExist = Patient.doesPatientExist("" + uid);
                    }

					if(counter == 0)
					{
						updateLabel.setText("Your UID is : " + uid + "\n" + "Please press register again");
						counter += 1;
					}
					else
					{
						Patient.addPatient(uid, firstName, lastName, password, email, phoneNumber, dob, insuranceProvider, providerPhoneNumber, insurancePolicy, pharmacyName, pharmacyPhoneNumber, pharmacyAddr);

						Scene patientLoginScene = PatientLoginPage.getPatientLoginPage(currStage);
						currStage.setScene(patientLoginScene);
					}

                    
                }
			}
		}
		
		RegisterButtonHandler registerHandler = new RegisterButtonHandler(counter);
		registerButton.setOnAction(registerHandler);

        Scene patientRegistration2 = new Scene(patientRegistration, 1150, 700);
        return patientRegistration2;
    }
    
}
