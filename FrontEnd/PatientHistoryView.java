package FrontEnd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import BackEnd.Appointment;
import BackEnd.PatientAppointmentHistory;
import BackEnd.Staff;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PatientHistoryView{

    private static Stage currStage;

    private static ObservableList<Appointment> appointments = FXCollections.observableArrayList();

    private static void initializeData(String patientUID)
    {
        PatientAppointmentHistory history = new PatientAppointmentHistory(patientUID);
        appointments.addAll(history.getHistory());
    }
	
    public static Scene getPatientHistoryView(Stage stage, Staff staff, String uid) { 
        
        currStage = stage;

        initializeData(uid);

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

        ScrollPane appointmentData = new ScrollPane();

        appointmentData.layout();
        appointmentData.setVvalue(1.0d);


		Label appointmentsummery = new Label("Appointment summery for MM/DD/YYYY");
		Label doctorsnote = new Label("Doctor's Notes");
		Label medicinesprescribed = new Label("Medicines Prescribed");

        VBox Summary = new VBox(40,doctorsnote,medicinesprescribed);
		Summary.setPrefHeight(100);
		Summary.setPrefWidth(500);
		Summary.setStyle("-fx-border-radius: 25px");
		Summary.setStyle("-fx-border-color : Black");
		Summary.setAlignment(Pos.TOP_LEFT);

		appointmentData.setContent(Summary);

        VBox container = new VBox(10);
        container.getChildren().addAll(appointmentsummery, appointmentData);

        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);

        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        header.getChildren().addAll(top, leftSpacer, clinicInfo, rightSpacer, dateLabel);
        
        TableView<Appointment> table = new TableView<>();
        table.setItems(appointments);

        TableColumn<Appointment, String> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Appointment, String> doctorCol = new TableColumn<>("Doctor Consulted");
        doctorCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDoctor().getLastName()));

        

        class AppointmentButtonHandler implements EventHandler<ActionEvent>
        {
            private Appointment appointment;

            public AppointmentButtonHandler(Appointment appointment)
            {
                this.appointment = appointment;
            }

            public void handle(ActionEvent event)
            {
                appointmentsummery.setText("Appointment summary for " + appointment.getDate() + " : ");
				doctorsnote.setText("Doctor's Notes : \n" + appointment.getDocExam().getNotes());
				medicinesprescribed.setText("Medicines Prescribed : \n" + appointment.getDocExam().getPrescription());
            }
        }

        TableColumn<Appointment, Void> viewCol = new TableColumn<>("View");

        viewCol.setCellFactory(column -> new TableCell<Appointment, Void>() {
            private final Button viewButton = new Button("View");

            {
                viewButton.setOnAction(event -> {
                    Appointment appointment = getTableView().getItems().get(getIndex());
                    new AppointmentButtonHandler(appointment).handle(event);

                    appointmentData.layout();
                    appointmentData.setVvalue(1.0d);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty)
            {
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null);
                } else {
                    setGraphic(viewButton);
                }
            }


        });
        
        double tableWidth = table.widthProperty().get();

        dateCol.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
        doctorCol.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
        viewCol.prefWidthProperty().bind(table.widthProperty().multiply(0.60));

        table.getColumns().addAll(dateCol, doctorCol, viewCol);

        HBox bottomBar = new HBox();
        bottomBar.setPadding(new Insets(10));
        Button exitHistoryButton = new Button("Exit Patient History");
        exitHistoryButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        bottomBar.getChildren().add(exitHistoryButton);

        class ExitPatientHistoryHandler implements EventHandler<ActionEvent>
        {
            public void handle(ActionEvent e)
            {
                Scene staffHomePage = StaffViewHome.getStaffHomeView(stage, staff);
                currStage.setScene(staffHomePage);
            }
        }

        VBox bottom = new VBox(table, bottomBar);
        bottom.setAlignment(Pos.CENTER);
        VBox rootLayout = new VBox(10);
        rootLayout.getChildren().addAll(header, bottom, container);

        container.setAlignment(Pos.CENTER);

        Scene scene = new Scene(rootLayout, 1150, 700);
        currStage.setTitle("Pediatric OAS - Patient History");
        
        return scene;
    }

}