package FrontEnd;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class LoginPageSelector 
{

    private static Stage currStage;

    public static Scene getLoginPageSelector(Stage stage)
    {

		currStage = stage;
		
        currStage.setTitle("OAS Login Selection");

        BorderPane loginPage = new BorderPane();
		
		HBox titleHolder = new HBox(10);
		
		
		Label title = new Label("Pediatric OAS");
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		Image logoImage = new Image("https://www.rmofmarquis.com/wp-content/themes/rmmarquis/images/no-image-available.png");
		ImageView logo = new ImageView();
		logo.setImage(logoImage);
		logo.setFitHeight(60);
		logo.setFitWidth(60);
		
		titleHolder.getChildren().add(title);
		titleHolder.getChildren().add(logo);
		titleHolder.setAlignment(Pos.CENTER);
		
		
		VBox buttonHolder = new VBox(40);
		Button staffLogin = new Button("Staff Login");
		Button patientLogin = new Button("Patient Login");
		
		staffLogin.setFont(Font.font("Arial", 12));
		patientLogin.setFont(Font.font("Arial", 12));
		
		
		
		staffLogin.setStyle("-fx-font-size: 14px; " +  
			                "-fx-padding: 10 20; " + 
			                "-fx-border-color: black; " + 
			                "-fx-border-width: 2; " + 
			                "-fx-background-color: white; " + 
			                "-fx-background-radius: 5; " + 
			                "-fx-border-radius: 5;" +
			                "-fx-pref-height: 20;" + 
			                "-fx-pref-width: 200;");
		
		patientLogin.setStyle("-fx-font-size: 14px; " +  
				              "-fx-padding: 10 20; " + 
				              "-fx-border-color: black; " + 
				              "-fx-border-width: 2; " + 
				              "-fx-background-color: white; " + 
				              "-fx-background-radius: 5; " + 
				              "-fx-border-radius: 5;" +
				              "-fx-pref-height: 20;" + 
				              "-fx-pref-width: 200;");
		
		
		buttonHolder.getChildren().add(staffLogin);
		buttonHolder.getChildren().add(patientLogin);
		buttonHolder.setAlignment(Pos.CENTER);
		
		loginPage.setTop(titleHolder);
		loginPage.setCenter(buttonHolder);
		BorderPane.setMargin(titleHolder, new Insets(20, 0, 0, 0));
		
		class StaffLoginButtonHandler implements EventHandler<ActionEvent>
		{
			public void handle(ActionEvent event)
			{
				Scene staffLoginPage = StaffLoginPage.getStaffLoginPage(currStage);
				currStage.setScene(staffLoginPage);
			}
		}
		
		class PatientLoginButtonHandler implements EventHandler<ActionEvent>
		{
			public void handle(ActionEvent event)
			{
				Scene patientLoginScene = PatientLoginPage.getPatientLoginPage(currStage);
				currStage.setScene(patientLoginScene);
			}
		}
		
		StaffLoginButtonHandler staffButtonHandler = new StaffLoginButtonHandler();
		staffLogin.setOnAction(staffButtonHandler);
		
		PatientLoginButtonHandler patientButtonHandler = new PatientLoginButtonHandler();
		patientLogin.setOnAction(patientButtonHandler);

        Scene loginPageSelector = new Scene(loginPage, 1150, 700);
		return loginPageSelector;
    }
    
}
