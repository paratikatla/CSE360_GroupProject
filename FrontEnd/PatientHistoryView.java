package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PatientHistoryView extends Application {
	
    public void start(Stage primaryStage) {    	
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
        
        TableView<String> table = new TableView<>();
        TableColumn<String, String> dateCol = new TableColumn<>("Date");
        TableColumn<String, String> doctorCol = new TableColumn<>("Doctor Consulted");
        TableColumn<String, String> reasonCol = new TableColumn<>("Reason");
        TableColumn<String, String> detailsCol = new TableColumn<>("Details");
        TableColumn<String, String> viewCol = new TableColumn<>("View");
        
        double tableWidth = table.widthProperty().get();

        dateCol.prefWidthProperty().bind(table.widthProperty().multiply(0.13));
        doctorCol.prefWidthProperty().bind(table.widthProperty().multiply(0.18));
        reasonCol.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
        detailsCol.prefWidthProperty().bind(table.widthProperty().multiply(0.39));
        viewCol.prefWidthProperty().bind(table.widthProperty().multiply(0.10));

        table.getColumns().addAll(dateCol, doctorCol, reasonCol, detailsCol, viewCol);

        HBox bottomBar = new HBox();
        bottomBar.setPadding(new Insets(10));
        Button exitHistoryButton = new Button("Exit Patient History");
        exitHistoryButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        bottomBar.getChildren().add(exitHistoryButton);

        VBox bottom = new VBox(table, bottomBar);
        bottom.setAlignment(Pos.CENTER);
        VBox rootLayout = new VBox(10);
        rootLayout.getChildren().addAll(header, bottom);

        Scene scene = new Scene(rootLayout, 1000, 600);
        primaryStage.setTitle("Pediatric OAS - Patient History");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}