package FrontEnd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import BackEnd.Staff;
import BackEnd.Patient;
import BackEnd.Appointment;
import BackEnd.NurseExam;

public class ViewNurseNotes {

    private static Stage currStage;

    public static Scene getViewNurseNotes(Stage stage, Staff doctor, Appointment appointment) { 
        
        currStage = stage;

        currStage.setTitle("Patient Intake Form");

        BorderPane borderPane = new BorderPane();

        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(15));
        header.setSpacing(10);
        header.setStyle("-fx-background-color: #336699;");

        HBox top = new HBox(20);
        VBox topLeft = new VBox();
        Label staffInfo = new Label("Dr." + doctor.getLastName());
        Label staffID = new Label(doctor.getEmployeeID());
        topLeft.getChildren().addAll(staffInfo, staffID);
        
        VBox topRight = new VBox();
        Label patientInfo = new Label(appointment.getPatient().getFullName());
        Label patientID = new Label("" + appointment.getPatient().getUid());
        topRight.getChildren().addAll(patientInfo, patientID);
        top.getChildren().addAll(topLeft, topRight);
        top.setAlignment(Pos.CENTER_LEFT);

        Label clinicInfo = new Label("Pediatric OAS");
        clinicInfo.setAlignment(Pos.CENTER);
        clinicInfo.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20px");

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Label dateLabel = new Label(today.format(formatter));
        dateLabel.setPadding(new Insets(0,0,0,100));
        dateLabel.setAlignment(Pos.CENTER_RIGHT);
        dateLabel.setStyle("-fx-font-weight: BOLD");

        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);

        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        header.getChildren().addAll(top, leftSpacer, clinicInfo, rightSpacer, dateLabel);
        
        Label patientVitals = new Label("Patient Vitals");
        patientVitals.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20px");
        
        Label weight = new Label("Weight (lbs):");
        weight.setStyle("-fx-font-weight: BOLD; -fx-font-size: 15px");
        TextField weightField = new TextField();
        VBox w = new VBox(10, weight, weightField);
        
        Label height = new Label("Height (in):");
        height.setStyle("-fx-font-weight: BOLD; -fx-font-size: 15px");
        TextField heightField = new TextField();
        VBox h = new VBox(10, height, heightField);
        
        Label temp = new Label("Body Temperature (F):");
        temp.setStyle("-fx-font-weight: BOLD; -fx-font-size: 15px");
        TextField tempField = new TextField();
        VBox t = new VBox(10, temp, tempField);
        
        Label bloodpressure = new Label("Blood Pressure:");
        bloodpressure.setStyle("-fx-font-weight: BOLD; -fx-font-size: 15px");
        TextField bloodpressureField = new TextField();
        VBox bp = new VBox(10, bloodpressure, bloodpressureField);
        
        VBox body_left = new VBox(40, patientVitals, w, h, t, bp);
        
        Label patientInfoLabel = new Label("Patient Information:");
        patientInfoLabel.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20px");

        VBox body_right_top = new VBox(10);
        Label allergiesLabel = new Label("Allergies:");
        allergiesLabel.setStyle("-fx-font-weight: BOLD; -fx-font-size: 15px");
        allergiesLabel.setAlignment(Pos.BASELINE_LEFT);
        TextArea allergiesInput = new TextArea();
        allergiesInput.setPromptText("Type here");
        allergiesInput.setMaxWidth(600);
        allergiesInput.setMaxHeight(170);
        body_right_top.getChildren().addAll(allergiesLabel, allergiesInput);
        body_right_top.setAlignment(Pos.CENTER);
        
        VBox body_right_bottom = new VBox(10);
        Label healthConcernsLabel = new Label("Health Concerns:");
        healthConcernsLabel.setStyle("-fx-font-weight: BOLD; -fx-font-size: 15px");
        TextArea healthConcernsInput = new TextArea();
        healthConcernsInput.setPromptText("Type here");
        healthConcernsInput.setMaxWidth(600);
        healthConcernsInput.setMaxHeight(170);
        body_right_bottom.getChildren().addAll(healthConcernsLabel, healthConcernsInput);
        body_right_bottom.setAlignment(Pos.CENTER);

        weightField.setEditable(false);
        heightField.setEditable(false);
        tempField.setEditable(false);
        bloodpressureField.setEditable(false);
        allergiesInput.setEditable(false);
        healthConcernsInput.setEditable(false);

        if(appointment.getNurseExam().isU12())
        {
            weightField.setText("N/A");
            heightField.setText("N/A");
            tempField.setText("N/A");
            bloodpressureField.setText("N/A");
        }
        else
        {
            weightField.setText("" + appointment.getNurseExam().getWeight());
            heightField.setText("" + appointment.getNurseExam().getHeight());
            tempField.setText("" + appointment.getNurseExam().getBodyTemp());
            bloodpressureField.setText("" + appointment.getNurseExam().getBloodPressure());
        }

        allergiesInput.setText(appointment.getNurseExam().getAllergies());
        healthConcernsInput.setText(appointment.getNurseExam().getHealthConcerns());
        
        Button backButton = new Button("Return");
        backButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");

        class BackButtonHandler implements EventHandler<ActionEvent>
        {
            public void handle(ActionEvent e)
            {
                Scene doctorAppointmentViewScene = DoctorView.getDoctorView(currStage, doctor, appointment.getPatient(), appointment);
                currStage.setScene(doctorAppointmentViewScene);
            }
        }

        BackButtonHandler backButtonHandler = new BackButtonHandler();
        backButton.setOnAction(backButtonHandler);

        HBox clicks = new HBox(30, backButton);
        clicks.setAlignment(Pos.CENTER);
        clicks.setPadding(new Insets(0,0,20,0));
        
        VBox body_right = new VBox(30, patientInfoLabel, body_right_top, body_right_bottom, clicks);
        
        HBox body = new HBox(40, body_left, body_right);
        body.setAlignment(Pos.CENTER);
        body.setPadding(new Insets(20, 0,0,0));
        
        borderPane.setTop(header);
        borderPane.setCenter(body);
        
        Scene scene = new Scene(borderPane, 1150, 700);
        
        return scene;
    }
    
}
