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

public class DoctorView extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(15));
        header.setSpacing(10);
        header.setStyle("-fx-background-color: #336699;");

        HBox top = new HBox(20);
        VBox topLeft = new VBox();
        Label staffInfo = new Label("Staff Name");
        Label staffID = new Label("Employee ID");
        topLeft.getChildren().addAll(staffInfo, staffID);
        
        VBox topRight = new VBox();
        Label patientInfo = new Label("Patient Name");
        Label patientID = new Label("Patient ID");
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

        Label patientNotes = new Label("Patient Notes");
        patientNotes.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20px");
        VBox patientNotesContainer = new VBox(patientNotes);
        patientNotesContainer.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 5;");
        patientNotesContainer.setAlignment(Pos.CENTER);
        TextArea notes = new TextArea();
        notes.setPromptText("Type here");
        notes.setMaxWidth(600);
        notes.setPrefHeight(200);
        VBox note = new VBox(20, patientNotesContainer, notes);
        note.setAlignment(Pos.CENTER);
        
        Button nurseNotes = new Button("View Nurse Notes");
        nurseNotes.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        Button PatientHistory = new Button("View Patient History");
        PatientHistory.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        PatientHistory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage patientHistoryStage = new Stage();

                PatientHistoryView patientHistory = new PatientHistoryView();
                patientHistory.start(patientHistoryStage);
            }
        });
        HBox clicks = new HBox(20, nurseNotes, PatientHistory);
        clicks.setAlignment(Pos.CENTER);
        
        VBox body_left = new VBox(40, note, clicks);
        body_left.setAlignment(Pos.CENTER);
        body_left.setPadding(new Insets(10));
        body_left.setMaxHeight(300);
        body_left.setStyle("-fx-border-color: black; -fx-border-radius: 5px; -fx-border-thickness: 3px");
        
        Label Prescription = new Label("Medicine Prescription");
        Prescription.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20px");
        VBox prescriptionContainer = new VBox(Prescription);
        prescriptionContainer.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 5;");
        prescriptionContainer.setAlignment(Pos.CENTER);
        
        Label medication = new Label("Medications");
        medication.setStyle("-fx-font-weight: BOLD; -fx-font-size: 13px");
        MenuButton list = new MenuButton("Search");
        VBox first = new VBox(medication, list);
        
        Label quantity = new Label("Quantity");
        quantity.setStyle("-fx-font-weight: BOLD; -fx-font-size: 13px");
        TextField quantityField = new TextField();
        quantityField.setMaxWidth(600);
        VBox second = new VBox(quantity, quantityField);
        
        Label Signature = new Label("Signature");
        Signature.setStyle("-fx-font-weight: BOLD; -fx-font-size: 13px");
        TextArea signatureArea = new TextArea();
        signatureArea.setMaxWidth(600);
        signatureArea.setMaxHeight(100);
        VBox third = new VBox(Signature, signatureArea);
        
        Button submit = new Button("Submit");
        submit.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        submit.setPrefWidth(111);
        
        VBox body_right = new VBox(20, prescriptionContainer, first, second, third, submit);
        body_right.setAlignment(Pos.CENTER);
        body_right.setPadding(new Insets(10));
        body_right.setMaxHeight(300);
        body_right.setStyle("-fx-border-color: black; -fx-border-radius: 5px; -fx-border-thickness: 3px");
        
        HBox body = new HBox(30, body_left, body_right);
        body.setAlignment(Pos.CENTER);
        body.setPadding(new Insets(0,30,0,30));
        borderPane.setTop(header);
        borderPane.setCenter(body);
        
        Scene scene = new Scene(borderPane, 1150, 700);
        primaryStage.setTitle("Hospital Portal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
