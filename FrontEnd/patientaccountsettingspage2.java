package application;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class patientaccountsettingspage2 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Pediatric OAS - Patient Account Settings");
        
        
    	HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(15));
        header.setSpacing(1);
        header.setStyle("-fx-background-color: #336699;");

        // Left part of the header - Staff and Patient Information
        HBox top = new HBox(50);
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
        header.setAlignment(Pos.TOP_CENTER);
        
        
        
        
        
        
        
        
        

        // Patient Account Settings header
       
        Button homeButton = new Button("Back to Home");
        homeButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
       
        HBox headerBox = new HBox(220, homeButton);
        headerBox.setAlignment(Pos.TOP_RIGHT);

        // Contact Information Section
        Label emailLabel = new Label("Email");
        TextField emailTextField = new TextField();
        emailTextField.setPromptText("Current Email");

        Label phoneLabel = new Label("Phone Number");
        TextField phoneTextField = new TextField();
        phoneTextField.setPromptText("Current Phone Number");

        VBox contactInfoBox = new VBox(10, emailLabel, emailTextField, phoneLabel, phoneTextField);
        contactInfoBox.setPadding(new Insets(70));
        contactInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 4;");
        

        // Providers Information Section
        Label insuranceProviderLabel = new Label("Insurance Provider:");
        TextField insuranceProviderName = new TextField();
        insuranceProviderName.setPromptText("Provider Name");

        TextField insuranceProviderContact = new TextField();
        insuranceProviderContact.setPromptText("Provider Contact");

        TextField policyID = new TextField();
        policyID.setPromptText("Policy ID");

        Label pharmacyLabel = new Label("Pharmacy:");
        TextField pharmacyName = new TextField();
        pharmacyName.setPromptText("Provider Name");

        TextField pharmacyContact = new TextField();
        pharmacyContact.setPromptText("Provider Contact");

        VBox providersInfoBox = new VBox(10, insuranceProviderLabel, insuranceProviderName, insuranceProviderContact, policyID, pharmacyLabel, pharmacyName, pharmacyContact);
        providersInfoBox.setPadding(new Insets(70));
        providersInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 2;");

        
        HBox totalbox = new HBox(100, contactInfoBox,providersInfoBox);
        totalbox.setAlignment(Pos.CENTER);
     
        // Change Password Section
        Button changePasswordButton = new Button("Change Password");
        changePasswordButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        changePasswordButton.setMaxSize(170, 100);

        // Save and Cancel buttons
        Button saveChangesButton = new Button("Save Changes");
        saveChangesButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

        
        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        cancelButton.setMaxSize(170, 100);
        saveChangesButton.setMaxSize(170, 100);

        HBox buttonsBox = new HBox(60,  cancelButton,saveChangesButton);
        buttonsBox.setAlignment(Pos.CENTER);

        // Main Layout
        VBox mainLayout = new VBox(30,header,headerBox, totalbox, changePasswordButton, buttonsBox);
        mainLayout.setPadding(new Insets(0));
        mainLayout.setAlignment(Pos.CENTER.TOP_CENTER);

        // Scene and Stage setup
        Scene scene = new Scene(mainLayout, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    
    
    package application;


    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;

    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Priority;
    import javafx.scene.layout.Region;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class patientaccountsettingspage2 extends Application {

        @Override
        public void start(Stage stage) {
            stage.setTitle("Pediatric OAS - Patient Account Settings");
            
            
        	HBox header = new HBox();
            header.setAlignment(Pos.CENTER);
            header.setPadding(new Insets(15));
            header.setSpacing(1);
            header.setStyle("-fx-background-color: #336699;");

            // Left part of the header - Staff and Patient Information
            HBox top = new HBox(50);
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
            header.setAlignment(Pos.TOP_CENTER);
            
            
            
            
            
            
            
            
            

            // Patient Account Settings header
           
            Button homeButton = new Button("Back to Home");
            homeButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
           
            HBox headerBox = new HBox(220, homeButton);
            headerBox.setAlignment(Pos.TOP_RIGHT);

            // Contact Information Section
            Label emailLabel = new Label("Email");
            TextField emailTextField = new TextField();
            emailTextField.setPromptText("Current Email");

            Label phoneLabel = new Label("Phone Number");
            TextField phoneTextField = new TextField();
            phoneTextField.setPromptText("Current Phone Number");

            VBox contactInfoBox = new VBox(10, emailLabel, emailTextField, phoneLabel, phoneTextField);
            contactInfoBox.setPadding(new Insets(70));
            contactInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 4;");
            

            // Providers Information Section
            Label insuranceProviderLabel = new Label("Insurance Provider:");
            TextField insuranceProviderName = new TextField();
            insuranceProviderName.setPromptText("Provider Name");

            TextField insuranceProviderContact = new TextField();
            insuranceProviderContact.setPromptText("Provider Contact");

            TextField policyID = new TextField();
            policyID.setPromptText("Policy ID");

            Label pharmacyLabel = new Label("Pharmacy:");
            TextField pharmacyName = new TextField();
            pharmacyName.setPromptText("Provider Name");

            TextField pharmacyContact = new TextField();
            pharmacyContact.setPromptText("Provider Contact");

            VBox providersInfoBox = new VBox(10, insuranceProviderLabel, insuranceProviderName, insuranceProviderContact, policyID, pharmacyLabel, pharmacyName, pharmacyContact);
            providersInfoBox.setPadding(new Insets(70));
            providersInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 2;");

            
            HBox totalbox = new HBox(100, contactInfoBox,providersInfoBox);
            totalbox.setAlignment(Pos.CENTER);
         
            // Change Password Section
            Button changePasswordButton = new Button("Change Password");
            changePasswordButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            changePasswordButton.setMaxSize(170, 100);

            // Save and Cancel buttons
            Button saveChangesButton = new Button("Save Changes");
            saveChangesButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

            
            Button cancelButton = new Button("Cancel");
            cancelButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            cancelButton.setMaxSize(170, 100);
            saveChangesButton.setMaxSize(170, 100);

            HBox buttonsBox = new HBox(60,  cancelButton,saveChangesButton);
            buttonsBox.setAlignment(Pos.CENTER);

            // Main Layout
            VBox mainLayout = new VBox(30,header,headerBox, totalbox, changePasswordButton, buttonsBox);
            mainLayout.setPadding(new Insets(0));
            mainLayout.setAlignment(Pos.CENTER.TOP_CENTER);

            // Scene and Stage setup
            Scene scene = new Scene(mainLayout, 900, 600);
            stage.setScene(scene);
            stage.show();
        }

    }

    package application;


    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;

    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Priority;
    import javafx.scene.layout.Region;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class patientaccountsettingspage2 extends Application {

        @Override
        public void start(Stage stage) {
            stage.setTitle("Pediatric OAS - Patient Account Settings");
            
            
        	HBox header = new HBox();
            header.setAlignment(Pos.CENTER);
            header.setPadding(new Insets(15));
            header.setSpacing(1);
            header.setStyle("-fx-background-color: #336699;");

            // Left part of the header - Staff and Patient Information
            HBox top = new HBox(50);
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
            header.setAlignment(Pos.TOP_CENTER);
            
            
            
            
            
            
            
            
            

            // Patient Account Settings header
           
            Button homeButton = new Button("Back to Home");
            homeButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
           
            HBox headerBox = new HBox(220, homeButton);
            headerBox.setAlignment(Pos.TOP_RIGHT);

            // Contact Information Section
            Label emailLabel = new Label("Email");
            TextField emailTextField = new TextField();
            emailTextField.setPromptText("Current Email");

            Label phoneLabel = new Label("Phone Number");
            TextField phoneTextField = new TextField();
            phoneTextField.setPromptText("Current Phone Number");

            VBox contactInfoBox = new VBox(10, emailLabel, emailTextField, phoneLabel, phoneTextField);
            contactInfoBox.setPadding(new Insets(70));
            contactInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 4;");
            

            // Providers Information Section
            Label insuranceProviderLabel = new Label("Insurance Provider:");
            TextField insuranceProviderName = new TextField();
            insuranceProviderName.setPromptText("Provider Name");

            TextField insuranceProviderContact = new TextField();
            insuranceProviderContact.setPromptText("Provider Contact");

            TextField policyID = new TextField();
            policyID.setPromptText("Policy ID");

            Label pharmacyLabel = new Label("Pharmacy:");
            TextField pharmacyName = new TextField();
            pharmacyName.setPromptText("Provider Name");

            TextField pharmacyContact = new TextField();
            pharmacyContact.setPromptText("Provider Contact");

            VBox providersInfoBox = new VBox(10, insuranceProviderLabel, insuranceProviderName, insuranceProviderContact, policyID, pharmacyLabel, pharmacyName, pharmacyContact);
            providersInfoBox.setPadding(new Insets(70));
            providersInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 2;");

            
            HBox totalbox = new HBox(100, contactInfoBox,providersInfoBox);
            totalbox.setAlignment(Pos.CENTER);
         
            // Change Password Section
            Button changePasswordButton = new Button("Change Password");
            changePasswordButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            changePasswordButton.setMaxSize(170, 100);

            // Save and Cancel buttons
            Button saveChangesButton = new Button("Save Changes");
            saveChangesButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

            
            Button cancelButton = new Button("Cancel");
            cancelButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            cancelButton.setMaxSize(170, 100);
            saveChangesButton.setMaxSize(170, 100);

            HBox buttonsBox = new HBox(60,  cancelButton,saveChangesButton);
            buttonsBox.setAlignment(Pos.CENTER);

            // Main Layout
            VBox mainLayout = new VBox(30,header,headerBox, totalbox, changePasswordButton, buttonsBox);
            mainLayout.setPadding(new Insets(0));
            mainLayout.setAlignment(Pos.CENTER.TOP_CENTER);

            // Scene and Stage setup
            Scene scene = new Scene(mainLayout, 900, 600);
            stage.setScene(scene);
            stage.show();
        }

    }

    package application;


    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;

    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Priority;
    import javafx.scene.layout.Region;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class patientaccountsettingspage2 extends Application {

        @Override
        public void start(Stage stage) {
            stage.setTitle("Pediatric OAS - Patient Account Settings");
            
            
        	HBox header = new HBox();
            header.setAlignment(Pos.CENTER);
            header.setPadding(new Insets(15));
            header.setSpacing(1);
            header.setStyle("-fx-background-color: #336699;");

            // Left part of the header - Staff and Patient Information
            HBox top = new HBox(50);
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
            header.setAlignment(Pos.TOP_CENTER);
            
            
            
            
            
            
            
            
            

            // Patient Account Settings header
           
            Button homeButton = new Button("Back to Home");
            homeButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
           
            HBox headerBox = new HBox(220, homeButton);
            headerBox.setAlignment(Pos.TOP_RIGHT);

            // Contact Information Section
            Label emailLabel = new Label("Email");
            TextField emailTextField = new TextField();
            emailTextField.setPromptText("Current Email");

            Label phoneLabel = new Label("Phone Number");
            TextField phoneTextField = new TextField();
            phoneTextField.setPromptText("Current Phone Number");

            VBox contactInfoBox = new VBox(10, emailLabel, emailTextField, phoneLabel, phoneTextField);
            contactInfoBox.setPadding(new Insets(70));
            contactInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 4;");
            

            // Providers Information Section
            Label insuranceProviderLabel = new Label("Insurance Provider:");
            TextField insuranceProviderName = new TextField();
            insuranceProviderName.setPromptText("Provider Name");

            TextField insuranceProviderContact = new TextField();
            insuranceProviderContact.setPromptText("Provider Contact");

            TextField policyID = new TextField();
            policyID.setPromptText("Policy ID");

            Label pharmacyLabel = new Label("Pharmacy:");
            TextField pharmacyName = new TextField();
            pharmacyName.setPromptText("Provider Name");

            TextField pharmacyContact = new TextField();
            pharmacyContact.setPromptText("Provider Contact");

            VBox providersInfoBox = new VBox(10, insuranceProviderLabel, insuranceProviderName, insuranceProviderContact, policyID, pharmacyLabel, pharmacyName, pharmacyContact);
            providersInfoBox.setPadding(new Insets(70));
            providersInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 2;");

            
            HBox totalbox = new HBox(100, contactInfoBox,providersInfoBox);
            totalbox.setAlignment(Pos.CENTER);
         
            // Change Password Section
            Button changePasswordButton = new Button("Change Password");
            changePasswordButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            changePasswordButton.setMaxSize(170, 100);

            // Save and Cancel buttons
            Button saveChangesButton = new Button("Save Changes");
            saveChangesButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

            
            Button cancelButton = new Button("Cancel");
            cancelButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            cancelButton.setMaxSize(170, 100);
            saveChangesButton.setMaxSize(170, 100);

            HBox buttonsBox = new HBox(60,  cancelButton,saveChangesButton);
            buttonsBox.setAlignment(Pos.CENTER);

            // Main Layout
            VBox mainLayout = new VBox(30,header,headerBox, totalbox, changePasswordButton, buttonsBox);
            mainLayout.setPadding(new Insets(0));
            mainLayout.setAlignment(Pos.CENTER.TOP_CENTER);

            // Scene and Stage setup
            Scene scene = new Scene(mainLayout, 900, 600);
            stage.setScene(scene);
            stage.show();
        }

    }
    package application;


    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;

    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Priority;
    import javafx.scene.layout.Region;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class patientaccountsettingspage2 extends Application {

        @Override
        public void start(Stage stage) {
            stage.setTitle("Pediatric OAS - Patient Account Settings");
            
            
        	HBox header = new HBox();
            header.setAlignment(Pos.CENTER);
            header.setPadding(new Insets(15));
            header.setSpacing(1);
            header.setStyle("-fx-background-color: #336699;");

            // Left part of the header - Staff and Patient Information
            HBox top = new HBox(50);
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
            header.setAlignment(Pos.TOP_CENTER);
            
            
            
            
            
            
            
            
            

            // Patient Account Settings header
           
            Button homeButton = new Button("Back to Home");
            homeButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
           
            HBox headerBox = new HBox(220, homeButton);
            headerBox.setAlignment(Pos.TOP_RIGHT);

            // Contact Information Section
            Label emailLabel = new Label("Email");
            TextField emailTextField = new TextField();
            emailTextField.setPromptText("Current Email");

            Label phoneLabel = new Label("Phone Number");
            TextField phoneTextField = new TextField();
            phoneTextField.setPromptText("Current Phone Number");

            VBox contactInfoBox = new VBox(10, emailLabel, emailTextField, phoneLabel, phoneTextField);
            contactInfoBox.setPadding(new Insets(70));
            contactInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 4;");
            

            // Providers Information Section
            Label insuranceProviderLabel = new Label("Insurance Provider:");
            TextField insuranceProviderName = new TextField();
            insuranceProviderName.setPromptText("Provider Name");

            TextField insuranceProviderContact = new TextField();
            insuranceProviderContact.setPromptText("Provider Contact");

            TextField policyID = new TextField();
            policyID.setPromptText("Policy ID");

            Label pharmacyLabel = new Label("Pharmacy:");
            TextField pharmacyName = new TextField();
            pharmacyName.setPromptText("Provider Name");

            TextField pharmacyContact = new TextField();
            pharmacyContact.setPromptText("Provider Contact");

            VBox providersInfoBox = new VBox(10, insuranceProviderLabel, insuranceProviderName, insuranceProviderContact, policyID, pharmacyLabel, pharmacyName, pharmacyContact);
            providersInfoBox.setPadding(new Insets(70));
            providersInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 2;");

            
            HBox totalbox = new HBox(100, contactInfoBox,providersInfoBox);
            totalbox.setAlignment(Pos.CENTER);
         
            // Change Password Section
            Button changePasswordButton = new Button("Change Password");
            changePasswordButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            changePasswordButton.setMaxSize(170, 100);

            // Save and Cancel buttons
            Button saveChangesButton = new Button("Save Changes");
            saveChangesButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

            
            Button cancelButton = new Button("Cancel");
            cancelButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            cancelButton.setMaxSize(170, 100);
            saveChangesButton.setMaxSize(170, 100);

            HBox buttonsBox = new HBox(60,  cancelButton,saveChangesButton);
            buttonsBox.setAlignment(Pos.CENTER);

            // Main Layout
            VBox mainLayout = new VBox(30,header,headerBox, totalbox, changePasswordButton, buttonsBox);
            mainLayout.setPadding(new Insets(0));
            mainLayout.setAlignment(Pos.CENTER.TOP_CENTER);

            // Scene and Stage setup
            Scene scene = new Scene(mainLayout, 900, 600);
            stage.setScene(scene);
            stage.show();
        }

    }
    package application;


    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;

    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Priority;
    import javafx.scene.layout.Region;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class patientaccountsettingspage2 extends Application {

        @Override
        public void start(Stage stage) {
            stage.setTitle("Pediatric OAS - Patient Account Settings");
            
            
        	HBox header = new HBox();
            header.setAlignment(Pos.CENTER);
            header.setPadding(new Insets(15));
            header.setSpacing(1);
            header.setStyle("-fx-background-color: #336699;");

            // Left part of the header - Staff and Patient Information
            HBox top = new HBox(50);
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
            header.setAlignment(Pos.TOP_CENTER);
            
            
            
            
            
            
            
            
            

            // Patient Account Settings header
           
            Button homeButton = new Button("Back to Home");
            homeButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
           
            HBox headerBox = new HBox(220, homeButton);
            headerBox.setAlignment(Pos.TOP_RIGHT);

            // Contact Information Section
            Label emailLabel = new Label("Email");
            TextField emailTextField = new TextField();
            emailTextField.setPromptText("Current Email");

            Label phoneLabel = new Label("Phone Number");
            TextField phoneTextField = new TextField();
            phoneTextField.setPromptText("Current Phone Number");

            VBox contactInfoBox = new VBox(10, emailLabel, emailTextField, phoneLabel, phoneTextField);
            contactInfoBox.setPadding(new Insets(70));
            contactInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 4;");
            

            // Providers Information Section
            Label insuranceProviderLabel = new Label("Insurance Provider:");
            TextField insuranceProviderName = new TextField();
            insuranceProviderName.setPromptText("Provider Name");

            TextField insuranceProviderContact = new TextField();
            insuranceProviderContact.setPromptText("Provider Contact");

            TextField policyID = new TextField();
            policyID.setPromptText("Policy ID");

            Label pharmacyLabel = new Label("Pharmacy:");
            TextField pharmacyName = new TextField();
            pharmacyName.setPromptText("Provider Name");

            TextField pharmacyContact = new TextField();
            pharmacyContact.setPromptText("Provider Contact");

            VBox providersInfoBox = new VBox(10, insuranceProviderLabel, insuranceProviderName, insuranceProviderContact, policyID, pharmacyLabel, pharmacyName, pharmacyContact);
            providersInfoBox.setPadding(new Insets(70));
            providersInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 2;");

            
            HBox totalbox = new HBox(100, contactInfoBox,providersInfoBox);
            totalbox.setAlignment(Pos.CENTER);
         
            // Change Password Section
            Button changePasswordButton = new Button("Change Password");
            changePasswordButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            changePasswordButton.setMaxSize(170, 100);

            // Save and Cancel buttons
            Button saveChangesButton = new Button("Save Changes");
            saveChangesButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

            
            Button cancelButton = new Button("Cancel");
            cancelButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            cancelButton.setMaxSize(170, 100);
            saveChangesButton.setMaxSize(170, 100);

            HBox buttonsBox = new HBox(60,  cancelButton,saveChangesButton);
            buttonsBox.setAlignment(Pos.CENTER);

            // Main Layout
            VBox mainLayout = new VBox(30,header,headerBox, totalbox, changePasswordButton, buttonsBox);
            mainLayout.setPadding(new Insets(0));
            mainLayout.setAlignment(Pos.CENTER.TOP_CENTER);

            // Scene and Stage setup
            Scene scene = new Scene(mainLayout, 900, 600);
            stage.setScene(scene);
            stage.show();
        }

    }
    package application;


    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;

    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Priority;
    import javafx.scene.layout.Region;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class patientaccountsettingspage2 extends Application {

        @Override
        public void start(Stage stage) {
            stage.setTitle("Pediatric OAS - Patient Account Settings");
            
            
        	HBox header = new HBox();
            header.setAlignment(Pos.CENTER);
            header.setPadding(new Insets(15));
            header.setSpacing(1);
            header.setStyle("-fx-background-color: #336699;");

            // Left part of the header - Staff and Patient Information
            HBox top = new HBox(50);
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
            header.setAlignment(Pos.TOP_CENTER);
            
            
            
            
            
            
            
            
            

            // Patient Account Settings header
           
            Button homeButton = new Button("Back to Home");
            homeButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
           
            HBox headerBox = new HBox(220, homeButton);
            headerBox.setAlignment(Pos.TOP_RIGHT);

            // Contact Information Section
            Label emailLabel = new Label("Email");
            TextField emailTextField = new TextField();
            emailTextField.setPromptText("Current Email");

            Label phoneLabel = new Label("Phone Number");
            TextField phoneTextField = new TextField();
            phoneTextField.setPromptText("Current Phone Number");

            VBox contactInfoBox = new VBox(10, emailLabel, emailTextField, phoneLabel, phoneTextField);
            contactInfoBox.setPadding(new Insets(70));
            contactInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 4;");
            

            // Providers Information Section
            Label insuranceProviderLabel = new Label("Insurance Provider:");
            TextField insuranceProviderName = new TextField();
            insuranceProviderName.setPromptText("Provider Name");

            TextField insuranceProviderContact = new TextField();
            insuranceProviderContact.setPromptText("Provider Contact");

            TextField policyID = new TextField();
            policyID.setPromptText("Policy ID");

            Label pharmacyLabel = new Label("Pharmacy:");
            TextField pharmacyName = new TextField();
            pharmacyName.setPromptText("Provider Name");

            TextField pharmacyContact = new TextField();
            pharmacyContact.setPromptText("Provider Contact");

            VBox providersInfoBox = new VBox(10, insuranceProviderLabel, insuranceProviderName, insuranceProviderContact, policyID, pharmacyLabel, pharmacyName, pharmacyContact);
            providersInfoBox.setPadding(new Insets(70));
            providersInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 2;");

            
            HBox totalbox = new HBox(100, contactInfoBox,providersInfoBox);
            totalbox.setAlignment(Pos.CENTER);
         
            // Change Password Section
            Button changePasswordButton = new Button("Change Password");
            changePasswordButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            changePasswordButton.setMaxSize(170, 100);

            // Save and Cancel buttons
            Button saveChangesButton = new Button("Save Changes");
            saveChangesButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

            
            Button cancelButton = new Button("Cancel");
            cancelButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            cancelButton.setMaxSize(170, 100);
            saveChangesButton.setMaxSize(170, 100);

            HBox buttonsBox = new HBox(60,  cancelButton,saveChangesButton);
            buttonsBox.setAlignment(Pos.CENTER);

            // Main Layout
            VBox mainLayout = new VBox(30,header,headerBox, totalbox, changePasswordButton, buttonsBox);
            mainLayout.setPadding(new Insets(0));
            mainLayout.setAlignment(Pos.CENTER.TOP_CENTER);

            // Scene and Stage setup
            Scene scene = new Scene(mainLayout, 900, 600);
            stage.setScene(scene);
            stage.show();
        }

    }
    package application;


    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;

    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Priority;
    import javafx.scene.layout.Region;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class patientaccountsettingspage2 extends Application {

        @Override
        public void start(Stage stage) {
            stage.setTitle("Pediatric OAS - Patient Account Settings");
            
            
        	HBox header = new HBox();
            header.setAlignment(Pos.CENTER);
            header.setPadding(new Insets(15));
            header.setSpacing(1);
            header.setStyle("-fx-background-color: #336699;");

            // Left part of the header - Staff and Patient Information
            HBox top = new HBox(50);
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
            header.setAlignment(Pos.TOP_CENTER);
            
            
            
            
            
            
            
            
            

            // Patient Account Settings header
           
            Button homeButton = new Button("Back to Home");
            homeButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
           
            HBox headerBox = new HBox(220, homeButton);
            headerBox.setAlignment(Pos.TOP_RIGHT);

            // Contact Information Section
            Label emailLabel = new Label("Email");
            TextField emailTextField = new TextField();
            emailTextField.setPromptText("Current Email");

            Label phoneLabel = new Label("Phone Number");
            TextField phoneTextField = new TextField();
            phoneTextField.setPromptText("Current Phone Number");

            VBox contactInfoBox = new VBox(10, emailLabel, emailTextField, phoneLabel, phoneTextField);
            contactInfoBox.setPadding(new Insets(70));
            contactInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 4;");
            

            // Providers Information Section
            Label insuranceProviderLabel = new Label("Insurance Provider:");
            TextField insuranceProviderName = new TextField();
            insuranceProviderName.setPromptText("Provider Name");

            TextField insuranceProviderContact = new TextField();
            insuranceProviderContact.setPromptText("Provider Contact");

            TextField policyID = new TextField();
            policyID.setPromptText("Policy ID");

            Label pharmacyLabel = new Label("Pharmacy:");
            TextField pharmacyName = new TextField();
            pharmacyName.setPromptText("Provider Name");

            TextField pharmacyContact = new TextField();
            pharmacyContact.setPromptText("Provider Contact");

            VBox providersInfoBox = new VBox(10, insuranceProviderLabel, insuranceProviderName, insuranceProviderContact, policyID, pharmacyLabel, pharmacyName, pharmacyContact);
            providersInfoBox.setPadding(new Insets(70));
            providersInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 2;");

            
            HBox totalbox = new HBox(100, contactInfoBox,providersInfoBox);
            totalbox.setAlignment(Pos.CENTER);
         
            // Change Password Section
            Button changePasswordButton = new Button("Change Password");
            changePasswordButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            changePasswordButton.setMaxSize(170, 100);

            // Save and Cancel buttons
            Button saveChangesButton = new Button("Save Changes");
            saveChangesButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

            
            Button cancelButton = new Button("Cancel");
            cancelButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            cancelButton.setMaxSize(170, 100);
            saveChangesButton.setMaxSize(170, 100);

            HBox buttonsBox = new HBox(60,  cancelButton,saveChangesButton);
            buttonsBox.setAlignment(Pos.CENTER);

            // Main Layout
            VBox mainLayout = new VBox(30,header,headerBox, totalbox, changePasswordButton, buttonsBox);
            mainLayout.setPadding(new Insets(0));
            mainLayout.setAlignment(Pos.CENTER.TOP_CENTER);

            // Scene and Stage setup
            Scene scene = new Scene(mainLayout, 900, 600);
            stage.setScene(scene);
            stage.show();
        }

    }

    package application;


    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;

    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Priority;
    import javafx.scene.layout.Region;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class patientaccountsettingspage2 extends Application {

        @Override
        public void start(Stage stage) {
            stage.setTitle("Pediatric OAS - Patient Account Settings");
            
            
        	HBox header = new HBox();
            header.setAlignment(Pos.CENTER);
            header.setPadding(new Insets(15));
            header.setSpacing(1);
            header.setStyle("-fx-background-color: #336699;");

            // Left part of the header - Staff and Patient Information
            HBox top = new HBox(50);
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
            header.setAlignment(Pos.TOP_CENTER);
            
            
            
            
            
            
            
            
            

            // Patient Account Settings header
           
            Button homeButton = new Button("Back to Home");
            homeButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
           
            HBox headerBox = new HBox(220, homeButton);
            headerBox.setAlignment(Pos.TOP_RIGHT);

            // Contact Information Section
            Label emailLabel = new Label("Email");
            TextField emailTextField = new TextField();
            emailTextField.setPromptText("Current Email");

            Label phoneLabel = new Label("Phone Number");
            TextField phoneTextField = new TextField();
            phoneTextField.setPromptText("Current Phone Number");

            VBox contactInfoBox = new VBox(10, emailLabel, emailTextField, phoneLabel, phoneTextField);
            contactInfoBox.setPadding(new Insets(70));
            contactInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 4;");
            

            // Providers Information Section
            Label insuranceProviderLabel = new Label("Insurance Provider:");
            TextField insuranceProviderName = new TextField();
            insuranceProviderName.setPromptText("Provider Name");

            TextField insuranceProviderContact = new TextField();
            insuranceProviderContact.setPromptText("Provider Contact");

            TextField policyID = new TextField();
            policyID.setPromptText("Policy ID");

            Label pharmacyLabel = new Label("Pharmacy:");
            TextField pharmacyName = new TextField();
            pharmacyName.setPromptText("Provider Name");

            TextField pharmacyContact = new TextField();
            pharmacyContact.setPromptText("Provider Contact");

            VBox providersInfoBox = new VBox(10, insuranceProviderLabel, insuranceProviderName, insuranceProviderContact, policyID, pharmacyLabel, pharmacyName, pharmacyContact);
            providersInfoBox.setPadding(new Insets(70));
            providersInfoBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 2;");

            
            HBox totalbox = new HBox(100, contactInfoBox,providersInfoBox);
            totalbox.setAlignment(Pos.CENTER);
         
            // Change Password Section
            Button changePasswordButton = new Button("Change Password");
            changePasswordButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            changePasswordButton.setMaxSize(170, 100);

            // Save and Cancel buttons
            Button saveChangesButton = new Button("Save Changes");
            saveChangesButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

            
            Button cancelButton = new Button("Cancel");
            cancelButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
            cancelButton.setMaxSize(170, 100);
            saveChangesButton.setMaxSize(170, 100);

            HBox buttonsBox = new HBox(60,  cancelButton,saveChangesButton);
            buttonsBox.setAlignment(Pos.CENTER);

            // Main Layout
            VBox mainLayout = new VBox(30,header,headerBox, totalbox, changePasswordButton, buttonsBox);
            mainLayout.setPadding(new Insets(0));
            mainLayout.setAlignment(Pos.CENTER.TOP_CENTER);

            // Scene and Stage setup
            Scene scene = new Scene(mainLayout, 900, 600);
            stage.setScene(scene);
            stage.show();
        }

    }

}
