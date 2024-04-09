package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StaffViewHome extends Application {
    
    private class Backend {
        Patient getPatient(String firstName, String lastName, String dateOfBirth) {
            return new Patient("John Doe", "01/01/2000", "johndoe01012000");
        }
    }
    
    private class Patient {
        String name;
        String birthdate;
        String id;
        
        Patient(String name, String birthdate, String id) {
            this.name = name;
            this.birthdate = birthdate;
            this.id = id;
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        Backend backend = new Backend();
        
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
        
        top.getChildren().addAll(topLeft);
        top.setAlignment(Pos.CENTER_LEFT);

        Label clinicInfo = new Label("Pediatric OAS");
        clinicInfo.setAlignment(Pos.CENTER);
        clinicInfo.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20px");

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Label dateLabel = new Label(today.format(formatter));
        dateLabel.setPadding(new Insets(0,0,0,0));
        dateLabel.setAlignment(Pos.CENTER_RIGHT);
        dateLabel.setStyle("-fx-font-weight: BOLD");

        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);

        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        header.getChildren().addAll(top, leftSpacer, clinicInfo, rightSpacer, dateLabel);
        
        HBox mainContent = new HBox(15);
        
        VBox leftSection = new VBox(10);
        leftSection.setAlignment(Pos.TOP_LEFT);
        leftSection.setPadding(new Insets(30));
        leftSection.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #C1C1C1; -fx-border-radius: 5;");
        
        GridPane searchArea = new GridPane();
        searchArea.setAlignment(Pos.CENTER);
        searchArea.setVgap(10);
        searchArea.setHgap(10);
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        DatePicker datePicker = new DatePicker();
        searchArea.add(new Label("First Name:"), 0, 0);
        searchArea.add(firstNameField, 1, 0);
        searchArea.add(new Label("Last Name:"), 0, 1);
        searchArea.add(lastNameField, 1, 1);
        searchArea.add(new Label("Date of Birth:"), 0, 2);
        searchArea.add(datePicker, 1, 2);
        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        searchButton.setMaxWidth(111);
        searchArea.add(searchButton, 1, 3);
        
        Label patientInfoLabel = new Label("Patient Information");
        patientInfoLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        Label patientNameLabel = new Label();
        Label patientBirthdateLabel = new Label();
        Label patientIDLabel = new Label();
        Button viewHistoryButton = new Button("View Patient History");
        viewHistoryButton.setStyle("-fx-background-color: #70AD47; -fx-text-fill: white;");
        viewHistoryButton.setAlignment(Pos.CENTER);
        viewHistoryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage patientHistoryStage = new Stage();
                PatientHistoryView patientHistory = new PatientHistoryView();
                patientHistory.start(patientHistoryStage); // Start the second application in a new window
            }
        });
        Button newAppointmentButton = new Button("Begin New Appointment");
        newAppointmentButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        newAppointmentButton.setAlignment(Pos.CENTER);

        searchButton.setOnAction(event -> {
       
            Patient patient = backend.getPatient(
                firstNameField.getText(),
                lastNameField.getText(),
                datePicker.getValue().toString()
            );
            patientInfoLabel.setText("Patient Information");
            patientNameLabel.setText("Name: " + patient.name);
            patientBirthdateLabel.setText("Patient Birthdate: " + patient.birthdate);
            patientIDLabel.setText("Patient ID: " + patient.id);
        });
        
        VBox patientInfoDisplay = new VBox(10);
        patientInfoDisplay.setPadding(new Insets(10));
        patientInfoDisplay.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #C1C1C1; -fx-border-radius: 5;");
        patientInfoDisplay.setAlignment(Pos.CENTER);
        patientInfoDisplay.getChildren().addAll(patientInfoLabel, patientNameLabel, patientBirthdateLabel, patientIDLabel, viewHistoryButton, newAppointmentButton);
        
        leftSection.getChildren().addAll(searchArea, patientInfoDisplay);
        
        VBox rightSection = new VBox(10);
        rightSection.setAlignment(Pos.TOP_RIGHT);
        rightSection.setPadding(new Insets(30));
        rightSection.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #C1C1C1; -fx-border-radius: 5;");
        
        VBox inbox = new VBox(10);
        inbox.setPadding(new Insets(25));
        inbox.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #C1C1C1; -fx-border-radius: 5;");
        Label inboxLabel = new Label("Inbox");
        inbox.getChildren().add(inboxLabel);
        inboxLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        Label notificationLabel = new Label("You have new notifications");
        notificationLabel.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white; -fx-padding: 5px;");
        inbox.getChildren().add(notificationLabel);
        Button message1Button = new Button("Message 1");
        message1Button.setMaxWidth(130);
        Button message2Button = new Button("Message 2");
        message2Button.setMaxWidth(130);
        Button message3Button = new Button("Message 3");
        message3Button.setMaxWidth(130);
        inbox.getChildren().addAll(message1Button, message2Button, message3Button);
        inbox.setAlignment(Pos.CENTER);
        
        VBox appointments = new VBox();
        inbox.setPadding(new Insets(25));
        appointments.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #C1C1C1; -fx-border-radius: 5;");
        appointments.getChildren().add(new Label("Appointments"));
        
        rightSection.getChildren().addAll(inbox, appointments);
        
        mainContent.setAlignment(Pos.CENTER);
        mainContent.getChildren().addAll(leftSection, rightSection);
        mainContent.setMaxHeight(450);
        mainContent.setPadding(new Insets(30, 0, 30, 0));
        
        borderPane.setTop(header);
        borderPane.setCenter(mainContent);
        
        Scene scene = new Scene(borderPane, 824, 558);
        primaryStage.setTitle("Staff Home Portal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
