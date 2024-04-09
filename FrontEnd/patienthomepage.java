package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DropMode;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class patienthomepage extends Application {

public void start(Stage stage) {
	stage.setTitle("Patient home portal");
	
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
    
    
    
    
    
    
	
	
	Button acount_settings = new Button("Account settings");
	acount_settings.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

	

	Label Inbox = new Label("Inbox");
	Inbox.setAlignment(Pos.CENTER);
	Inbox.setPrefHeight(50);
	Inbox.setPrefWidth(520);
	Inbox.setStyle("-fx-border-radius: 15px");
	Inbox.setStyle("-fx-border-color : Black");
	TextArea InboxArea = new TextArea();
	Button messagingphysician = new Button("Message your physician");
	messagingphysician.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

	Label Prescription = new Label("Prescription");
	Prescription.setAlignment(Pos.CENTER);
	Prescription.setPrefHeight(50);
	Prescription.setPrefWidth(520);
	Prescription.setStyle("-fx-border-radius: 15px");
	Prescription.setStyle("-fx-border-color : Black");
	
	
	TextArea prescriptiontext = new TextArea();
	Label appointments = new Label("Your Appointments");
	appointments.setAlignment(Pos.CENTER);
	appointments.setPrefHeight(30);
	appointments.setPrefWidth(520);
	appointments.setStyle("-fx-border-radius: 15px");
	appointments.setStyle("-fx-border-color : Black");
	TextArea appointmentsArea = new TextArea();
	Label appointmentsummery = new Label("Appointment summery for MM/DD/YYYY");
	Label doctorsnote = new Label("Doctor's Notes");
	Label medicinesprescribed = new Label("Medicines Prescribed");
	Label immunizationgiven = new Label("Immunization Given");	
	
	VBox Inboxone = new VBox (1, Inbox, InboxArea);
	VBox Prescriptionone = new VBox (1,Prescription,prescriptiontext);
	
	HBox patientone = new HBox (300,acount_settings);
	patientone.setAlignment(Pos.TOP_LEFT);
	VBox leftside = new VBox (25, patientone,Inboxone,messagingphysician,Prescriptionone);
	leftside.setPadding(new Insets(20));
	leftside.setAlignment(Pos.CENTER);
	
	
	
	VBox Summary = new VBox(40,doctorsnote,medicinesprescribed,immunizationgiven);
	Summary.setPrefHeight(100);
	Summary.setPrefWidth(500);
	Summary.setStyle("-fx-border-radius: 25px");
	Summary.setStyle("-fx-border-color : Black");
	Summary.setAlignment(Pos.TOP_LEFT);
	
	
	
	
	VBox Appointmentsone = new VBox (0,appointments,appointmentsArea);
	Appointmentsone.setAlignment(Pos.CENTER);
	
	VBox Rightcenter = new VBox (0,appointmentsummery,Summary);
	VBox rightside = new VBox(75,Appointmentsone,Rightcenter);
	
	rightside.setAlignment(Pos.CENTER);

	
	HBox  mainpage = new HBox (30,leftside,rightside);
	mainpage.setAlignment(Pos.CENTER);
	mainpage.setPadding(new Insets(40));
	
	
	
	
	
	VBox total1 = new VBox(1,header,mainpage);
	total1.setPadding(new Insets(10));
	


	 Scene scene1 = new Scene(total1, 1150, 700);
     stage.setScene(scene1);
     stage.show();
     
     
     acount_settings.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
             // Create a new stage for the patient history view
             Stage patientHistoryStage = new Stage();

             // Instantiate the second class and call its start method
             patientaccountsettingspage patientHistory = new patientaccountsettingspage();
             patientHistory.start(patientHistoryStage); // Start the second application in a new window
         }
     });
 }
}
	
