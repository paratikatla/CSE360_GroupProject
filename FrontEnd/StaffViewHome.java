package FrontEnd;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import BackEnd.Staff;
import BackEnd.Util;
import BackEnd.Patient;
import BackEnd.Appointment;

public class StaffViewHome{
    
    private static Stage currStage;
    
    public static Scene getStaffHomeView(Stage stage, Staff staff) {
        
        currStage = stage;

        BorderPane borderPane = new BorderPane();
        
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(15));
        header.setSpacing(10);
        header.setStyle("-fx-background-color: #336699;");

        HBox top = new HBox(20);
        VBox topLeft = new VBox();
        Label staffInfo = new Label(staff.getFullName());
        Label staffID = new Label(staff.getEmployeeID());
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
        TextField patientUIDField = new TextField();
        // TextField lastNameField = new TextField();
        // DatePicker datePicker = new DatePicker();
        searchArea.add(new Label("Patient UID :"), 0, 0);
        searchArea.add(patientUIDField, 1, 0);
        // searchArea.add(new Label("Last Name:"), 0, 1);
        // searchArea.add(lastNameField, 1, 1);
        // searchArea.add(new Label("Date of Birth:"), 0, 2);
        // searchArea.add(datePicker, 1, 2);
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

        class ViewHistoryButtonHandler implements EventHandler<ActionEvent>
        {
            public void handle(ActionEvent e)
            {
                if(!patientIDLabel.getText().isEmpty())
                {
                    Scene patientHistoryViewScene = PatientHistoryView.getPatientHistoryView(currStage, staff, patientUIDField.getText());
                    currStage.setScene(patientHistoryViewScene);
                }
            }
        }

        ViewHistoryButtonHandler viewHistoryButtonHandler = new ViewHistoryButtonHandler();
        viewHistoryButton.setOnAction(viewHistoryButtonHandler);

        Button newAppointmentButton = new Button("Begin New Appointment");
        newAppointmentButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        newAppointmentButton.setAlignment(Pos.CENTER);


        searchButton.setOnAction(event -> {

            if(!patientUIDField.getText().isEmpty())
            {
                String uid = patientUIDField.getText();

                patientInfoLabel.setText("Patient Information");
                patientNameLabel.setText("Name: " + Patient.getFullNameByID(uid));
                patientBirthdateLabel.setText("Patient Birthdate: " + Patient.getDOBByID(uid));
                patientIDLabel.setText("Patient ID: " + uid);
            }
        });

        class NewButtonAppointmentHandler implements EventHandler<ActionEvent>
        {
            public void handle(ActionEvent arg0)
            {
                if(!patientIDLabel.getText().isEmpty())
                {

                    String patientUID = patientIDLabel.getText().substring(12);

                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String formatedDate = now.format(formatter);

                    

                    if(staff.getRole().equals("Nurse"))
                    {
                        String dob = Patient.getDOBByID(patientUID);

                        boolean olderThan12 = Util.isOlderThan12Years(dob);

                        Appointment appointment = new Appointment(Patient.grabPatient(patientUID), formatedDate);

                        if(olderThan12)
                        {
                            Scene nurseSceneOver12 = NurseViewOver12.getNurseViewOver12Scene(currStage, staff, Patient.grabPatient(patientUID), appointment);
                            currStage.setScene(nurseSceneOver12);
                        }
                        else
                        {
                            Scene nurseSceneUnder12 = NurseViewBelow12.getNurseViewBelow12(stage, staff, Patient.grabPatient(patientUID), appointment);
                            currStage.setScene(nurseSceneUnder12);
                        }
                    }

                    if(staff.getRole().equals("Doctor"))
                    {

                        String patientDirectoryPath = "./" + patientUID + "/";

                        String formattedDate = formatedDate.replace("/", "_");

                        String patientFilePath = patientDirectoryPath + patientUID + "_" + formattedDate + "_appointMent.txt";

                        Appointment appointment = new Appointment(patientFilePath, patientUID);

                        Scene doctorAppointmentScene = DoctorView.getDoctorView(currStage, staff, Patient.grabPatient(patientUID), appointment);
                        currStage.setScene(doctorAppointmentScene);
                    }
                }
            }
        }

        NewButtonAppointmentHandler newButtonAppointmentHandler = new NewButtonAppointmentHandler();
        newAppointmentButton.setOnAction(newButtonAppointmentHandler);
        
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
        inboxLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        ScrollPane inboxPane = new ScrollPane();

        VBox container = new VBox(10);
        container.getChildren().add(inboxLabel);

        int numMessages = Staff.getNumMessages(staff.getEmployeeID());
        String notificationText = "";

        if(numMessages > 0)
        {
            notificationText = "You have " + numMessages + " unread messages";
        }
        else
        {
            notificationText = "You have no new notifications";
        }

        Label notificationLabel = new Label(notificationText);
        notificationLabel.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white; -fx-padding: 5px;");
        inbox.getChildren().add(notificationLabel);

        ObservableList<String> messageList = Staff.getMessageList(staff.getEmployeeID());

        class OpenMessageButtonHandler implements EventHandler<ActionEvent>
        {
            Button button;

            OpenMessageButtonHandler(Button button, ObservableList<String> messageList)
            {
                this.button = button;
            }

            public void handle(ActionEvent arg0)
            {

                messageList.removeIf((uid -> {
                    boolean match = uid.equals((String)button.getUserData());

                    System.out.print(uid + "\n");
                    System.out.print((String)button.getUserData() + "\n");

                    if(match)
                    {
                        System.out.print("a\n");
                        Staff.reduceNumMessages(staff.getEmployeeID());
                    }

                    return match;
                }));

                String newMessageList = String.join(" ", messageList);

                Staff.changeMessageList(staff.getEmployeeID(), newMessageList);

                Scene messageScene = MessagingPage.getMessagingPage(stage, staff, (String)button.getUserData());
                currStage.setScene(messageScene);
            }
        }

        for(int i = 0; i < numMessages; i++)
        {
            String uid = messageList.get(i);
            Button messageButton = new Button(Patient.getFullNameByID(uid));
            messageButton.setUserData(uid);

            OpenMessageButtonHandler openMessageButtonHandler = new OpenMessageButtonHandler(messageButton, messageList);
            messageButton.setOnAction(openMessageButtonHandler);

            inbox.getChildren().add(messageButton);
        }

        inbox.setAlignment(Pos.CENTER);

        container.getChildren().add(inbox);

        inboxPane.setContent(container);
        
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
        
        Scene scene = new Scene(borderPane, 1150, 700);
        currStage.setTitle("Staff Home Portal");
        
        return scene;
    }
}
