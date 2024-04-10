package FrontEnd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NurseViewBelow12 extends Application {

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

        Label patientInfoLabel = new Label("Patient Information:");
        patientInfoLabel.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20px");

        VBox body_top = new VBox(10);
        Label allergiesLabel = new Label("Allergies:");
        allergiesLabel.setStyle("-fx-font-weight: BOLD; -fx-font-size: 15px");
        allergiesLabel.setAlignment(Pos.BASELINE_LEFT);
        TextArea allergiesInput = new TextArea();
        allergiesInput.setPromptText("Type here");
        allergiesInput.setMaxWidth(600);
        allergiesInput.setMaxHeight(170);
        body_top.getChildren().addAll(allergiesLabel, allergiesInput);
        body_top.setAlignment(Pos.CENTER);
        
        VBox body_bottom = new VBox(10);
        Label healthConcernsLabel = new Label("Health Concerns:");
        healthConcernsLabel.setStyle("-fx-font-weight: BOLD; -fx-font-size: 15px");
        TextArea healthConcernsInput = new TextArea();
        healthConcernsInput.setPromptText("Type here");
        healthConcernsInput.setMaxWidth(600);
        healthConcernsInput.setMaxHeight(170);
        body_bottom.getChildren().addAll(healthConcernsLabel, healthConcernsInput);
        body_bottom.setAlignment(Pos.CENTER);
        
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        submitButton.setPrefWidth(111);
        Button viewHistoryButton = new Button("View Patient History");
        viewHistoryButton.setStyle("-fx-background-color: #5B9BD5; -fx-text-fill: white;");
        viewHistoryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage patientHistoryStage = new Stage();
                PatientHistoryView patientHistory = new PatientHistoryView();
                patientHistory.start(patientHistoryStage);
            }
        });
        HBox clicks = new HBox(30, submitButton, viewHistoryButton);
        clicks.setPadding(new Insets(0,0,20,0));
        clicks.setAlignment(Pos.CENTER);
        
        VBox body = new VBox(30, patientInfoLabel, body_top, body_bottom, clicks);
        body.setAlignment(Pos.CENTER);
        
        borderPane.setTop(header);
        borderPane.setCenter(body);
        
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setTitle("Hospital Portal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
