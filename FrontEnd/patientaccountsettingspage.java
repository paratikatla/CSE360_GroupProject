package FrontEnd;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Action;

import org.w3c.dom.events.Event;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import BackEnd.Patient;

public class PatientAccountSettingsPage{

    private static Stage currStage;

    public static Scene getPatientAccountSettingsPage(Stage stage, Patient patient) {

        currStage = stage;

        currStage.setTitle("Pediatric OAS - Patient Account Settings");
        
        
    	HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(15));
        header.setSpacing(10);
        header.setStyle("-fx-background-color: #336699;");

        // Left part of the header - Staff and Patient Information
        HBox top = new HBox(20);
        VBox topLeft = new VBox();
      
     
        VBox topRight = new VBox();
        Label patientInfo = new Label("Patient Name");
        Label patientID = new Label("Patient ID");
        topRight.getChildren().addAll(patientInfo, patientID);
        top.getChildren().addAll(topLeft, topRight);
        top.setAlignment(Pos.CENTER_LEFT);

        // Center part of the header - Clinic Information
        Label clinicInfo = new Label("Pediatric OAS");
        clinicInfo.setAlignment(Pos.CENTER);
        clinicInfo.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20px");

        // Right part of the header - Date
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Label dateLabel = new Label(today.format(formatter));
        dateLabel.setPadding(new Insets(0,0,0,100));
        dateLabel.setAlignment(Pos.CENTER_RIGHT);
        dateLabel.setStyle("-fx-font-weight: BOLD");

        // Use Region as a spacer to push everything to the sides and center
        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);

        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        // Add everything to the header
        header.getChildren().addAll(top, leftSpacer, clinicInfo, rightSpacer, dateLabel);
        
        
        

        // Patient Account Settings header
       
        Button homeButton = new Button("Back to Home");
        homeButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
       
        class HomeButtonHandler implements EventHandler<ActionEvent>
        {
            public void handle(ActionEvent arg0)
            {
                Scene patientHomeScene = PatientHomePage.getPatientHomePage(currStage, patient);
                currStage.setScene(patientHomeScene);
            }
        }

        HomeButtonHandler homeButtonHandler = new HomeButtonHandler();
        homeButton.setOnAction(homeButtonHandler);

        HBox headerBox = new HBox(220, homeButton);
        headerBox.setAlignment(Pos.TOP_RIGHT);

        // Contact Information Section
        Label emailLabel = new Label("Email");
        TextField emailTextField = new TextField();

        String currentEmail = patient.getEmail();

        emailTextField.setText(currentEmail);

        Label phoneLabel = new Label("Phone Number");
        TextField phoneTextField = new TextField();

        String currentPhone = patient.getPhoneNumber();

        phoneTextField.setText(currentPhone);

        VBox contactInfoBox = new VBox(10, emailLabel, emailTextField, phoneLabel, phoneTextField);
        contactInfoBox.setPadding(new Insets(70));
        contactInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 2;");
        

        // Providers Information Section
        Label insuranceProviderLabel = new Label("Insurance Provider:");
        TextField insuranceProviderName = new TextField();
        insuranceProviderName.setPromptText("Insurance Provider");

        String currentProvider = patient.getInsuranceProvider();

        insuranceProviderName.setText(currentProvider);


        TextField insuranceProviderContact = new TextField();
        insuranceProviderContact.setPromptText("Provider Contact");

        String providerContact = patient.getProviderPhone();
        insuranceProviderContact.setText(providerContact);

        TextField policyID = new TextField();
        policyID.setPromptText("Policy ID");

        String currentPolicyID = patient.getPolicyID();
        policyID.setText(currentPolicyID);


        Label pharmacyLabel = new Label("Pharmacy:");
        TextField pharmacyName = new TextField();
        pharmacyName.setPromptText("Provider Name");

        String currentPharmacy = patient.getPharmacyName();
        pharmacyName.setText(currentPharmacy);

        TextField pharmacyContact = new TextField();
        pharmacyContact.setPromptText("Provider Contact");

        String currentPharmacyPhone = patient.getPharmacyPhone();
        pharmacyContact.setText(currentPharmacyPhone);

        VBox providersInfoBox = new VBox(10, insuranceProviderLabel, insuranceProviderName, insuranceProviderContact, policyID, pharmacyLabel, pharmacyName, pharmacyContact);
        providersInfoBox.setPadding(new Insets(70));
        providersInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 2;");

        
        HBox totalbox = new HBox(100, contactInfoBox,providersInfoBox);
        totalbox.setAlignment(Pos.CENTER);
     
        // Change Password Section
        Button changePasswordButton = new Button("Change Password");
        changePasswordButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

        class ChangePasswordButtonHandler implements EventHandler<ActionEvent>
        {
            public void handle(ActionEvent arg0)
            {
                Scene passwordResetScene = PasswordReset.getPasswordReset1(currStage, patient);
                currStage.setScene(passwordResetScene);
            }
        }

        ChangePasswordButtonHandler changePasswordButtonHandler = new ChangePasswordButtonHandler();
        changePasswordButton.setOnAction(changePasswordButtonHandler);

        // Save and Cancel buttons
        Button saveChangesButton = new Button("Save Changes");
        saveChangesButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

        class SaveChangesButtonHandler implements EventHandler<ActionEvent>
        {
            public void handle(ActionEvent arg0) {
                
                Patient.changePatientEmail(patient.getUid(), emailTextField.getText());
                Patient.changePatientPhoneNumber(patient.getUid(), phoneTextField.getText());
                Patient.changePatientInsuranceProvider(patient.getUid(), insuranceProviderName.getText());
                Patient.changePatientInsuranceProviderNumber(patient.getUid(), insuranceProviderContact.getText());
                Patient.changePatientInsurancePolicyID(patient.getUid(), policyID.getText());
                Patient.changePatientPharmacy(patient.getUid(), pharmacyName.getText());
                Patient.changePatientPharmacyPhoneNumber(patient.getUid(), pharmacyContact.getText());

            }
        }

        SaveChangesButtonHandler saveChangesButtonHandler = new SaveChangesButtonHandler();
        saveChangesButton.setOnAction(saveChangesButtonHandler);

        
        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

        class CancelButtonHandler implements EventHandler<ActionEvent>
        {
            public void handle(ActionEvent arg0)
            {
                emailTextField.setText(currentEmail);
                phoneTextField.setText(currentPhone);
                insuranceProviderName.setText(currentProvider);
                insuranceProviderContact.setText(providerContact);
                policyID.setText(currentPolicyID);
                pharmacyName.setText(currentPharmacy);
                pharmacyContact.setText(currentPharmacyPhone);
            }
        }

        CancelButtonHandler cancelButtonHandler = new CancelButtonHandler();
        cancelButton.setOnAction(cancelButtonHandler);

        HBox buttonsBox = new HBox(20,  cancelButton,saveChangesButton);
        buttonsBox.setAlignment(Pos.CENTER);

        // Main Layout
        VBox mainLayout = new VBox(20, header,headerBox, totalbox, changePasswordButton, buttonsBox);
        mainLayout.setPadding(new Insets(50));
        mainLayout.setAlignment(Pos.CENTER);

        // Scene and Stage setup
        Scene patientAccountSettingsPage = new Scene(mainLayout, 900, 700);
        return patientAccountSettingsPage;
    }

}
