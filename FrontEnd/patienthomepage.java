package FrontEnd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.DropMode;

import org.w3c.dom.events.Event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import BackEnd.Appointment;
import BackEnd.Patient;
import BackEnd.PatientAppointmentHistory;

public class PatientHomePage{

	private static Stage currStage;

	public static Scene getPatientHomePage(Stage stage, Patient patient) 
	{

		currStage = stage;

		currStage.setTitle("Patient Home Page");
		
		HBox header = new HBox();
		header.setAlignment(Pos.CENTER);
		header.setPadding(new Insets(15));
		header.setSpacing(10);
		header.setStyle("-fx-background-color: #336699;");

		// Left part of the header - Staff and Patient Information
		HBox top = new HBox(20);
		VBox topLeft = new VBox();
	
	
		VBox topRight = new VBox();

		String patientName = patient.getFullName();
		int patientUID = patient.getUid();

		Label patientInfo = new Label(patientName);
		Label patientID = new Label("" + patientUID);
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
		
		
		
		
		
		
		
		
		Button acount_settings = new Button("Account Settings");
		acount_settings.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

		

		VBox inbox = new VBox(10);
        inbox.setPadding(new Insets(25));
        inbox.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #C1C1C1; -fx-border-radius: 5;");
        Label inboxLabel = new Label("Inbox");
        inbox.getChildren().add(inboxLabel);
        inboxLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label notificationLabel = new Label();

		if(Patient.getMessageStatus(patientUID))
		{
			notificationLabel.setText("You have new notifications");
		}
		else
		{
			notificationLabel.setText("You have no new notifications");
		}

        notificationLabel.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white; -fx-padding: 5px;");
        inbox.getChildren().add(notificationLabel);
        inbox.setAlignment(Pos.CENTER);

		Button messagingPhysician = new Button("Message your Physician");
		messagingPhysician.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

		class MessagePhysicianHandler implements EventHandler<ActionEvent>
		{
			public void handle(ActionEvent arg0)
			{
				Patient.changeMessageStatus(patientUID, "false");

				Scene physicianMessageScene = MessagingPage.getMessagingPage(currStage, patient);
				currStage.setScene(physicianMessageScene);
			}
		}

		MessagePhysicianHandler messagePhysicianHandler = new MessagePhysicianHandler();
		messagingPhysician.setOnAction(messagePhysicianHandler);

		Label Prescription = new Label("Prescriptions");
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
		ScrollPane appointmentsArea = new ScrollPane();

		PatientAppointmentHistory appointmentHistory = new PatientAppointmentHistory("" + patient.getUid());
		ArrayList<Appointment> history = appointmentHistory.getHistory();

		VBox appointmentContainer = new VBox(10);

		ScrollPane appointmentData = new ScrollPane();


		Label appointmentsummery = new Label("Appointment summery for MM/DD/YYYY");
		Label doctorsnote = new Label("Doctor's Notes");
		Label medicinesprescribed = new Label("Medicines Prescribed");
		


		class AppointmentButtonHandler implements EventHandler<ActionEvent>
		{
			private Appointment appointment;

			public AppointmentButtonHandler(Appointment appointment)
			{
				this.appointment = appointment;
			}
			public void handle(ActionEvent e)
			{
				appointmentsummery.setText("Appointment summary for " + appointment.getDate() + " : ");
				doctorsnote.setText("Doctor's Notes : \n" + appointment.getDocExam().getNotes());
				medicinesprescribed.setText("Medicines Prescribed : \n" + appointment.getDocExam().getPrescription());
				appointmentData.layout();
        		appointmentData.setVvalue(1.0d);
			}
		}

		System.out.println("HISTORY SIZE : " + history.size() + "\n");

		for(int i = 0; i < history.size(); i++)
		{
			Appointment appointment = history.get(i);

			System.out.println(appointment.getDate());

			Button appointmentButton = new Button(appointment.getDate());

			AppointmentButtonHandler appointmentButtonHandler = new AppointmentButtonHandler(appointment);
			appointmentButton.setOnAction(appointmentButtonHandler);

			appointmentContainer.getChildren().add(appointmentButton);
		}
		
		appointmentContainer.setAlignment(Pos.CENTER);

		appointmentsArea.setContent(appointmentContainer);
		
		VBox Prescriptionone = new VBox (1,Prescription,prescriptiontext);
		
		HBox patientone = new HBox (300,acount_settings);
		patientone.setAlignment(Pos.TOP_LEFT);
		VBox leftside = new VBox (25, patientone,inbox,messagingPhysician,Prescriptionone);
		leftside.setPadding(new Insets(20));
		leftside.setAlignment(Pos.CENTER);
		
		
		
		VBox Summary = new VBox(40,doctorsnote,medicinesprescribed);
		Summary.setPrefHeight(100);
		Summary.setPrefWidth(500);
		Summary.setStyle("-fx-border-radius: 25px");
		Summary.setStyle("-fx-border-color : Black");
		Summary.setAlignment(Pos.TOP_LEFT);

		appointmentData.setContent(Summary);
		
		

		
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
		
		
		acount_settings.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				// Instantiate the second class and call its start method
				Scene patientAccountsSettingPage = PatientAccountSettingsPage.getPatientAccountSettingsPage(currStage, patient);
				currStage.setScene(patientAccountsSettingPage); // Start the second application in a new window
			}
		});

		Scene patientHomePage = new Scene(total1, 1150, 700);
		return patientHomePage;
	}
}
	
