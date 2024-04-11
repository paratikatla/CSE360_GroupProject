package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	
	Scene scene;
	Scene scene1;
	Stage stage;
	
	public void start(Stage primaryStage) {
		VBox main = new VBox(40);
		Label mainTitle = new Label("Welcome to Heart Health Imaging and Recording System");
		mainTitle.setFont(Font.font("Welcome to Heart Health Imaging and Recording System", FontWeight.BOLD, 15));
		VBox choose = new VBox(25);
		Button btn1 = new Button("Patient Intake");
		btn1.setPrefHeight(40);
		btn1.setPrefWidth(200);
		btn1.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn1.setTextFill(Color.WHITESMOKE);
        btn1.setOnAction(e -> Main1.PatientIntakeForm());
		Button btn2 = new Button("CT Scan Tech View");
		btn2.setPrefHeight(40);
		btn2.setPrefWidth(200);
		btn2.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn2.setTextFill(Color.WHITESMOKE);
        btn2.setOnAction(e -> Main2.CTScanView());
		Button btn3 = new Button("Patient View");
		btn3.setPrefHeight(40);
		btn3.setPrefWidth(200);
		btn3.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn3.setTextFill(Color.WHITESMOKE);
        btn3.setOnAction(e -> Main3.PatientView());
        
		choose.getChildren().addAll(btn1,btn2,btn3);
		choose.setAlignment(javafx.geometry.Pos.CENTER);
		main.getChildren().addAll(mainTitle, choose);
		main.setAlignment(javafx.geometry.Pos.CENTER);

		Scene scene = new Scene(main, 500, 400);
		
		stage = primaryStage;
		stage.setScene(scene);
		stage.show();
		
	}
}













































































































































































































































































package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	
	Scene scene;
	Scene scene1;
	Stage stage;
	
	public void start(Stage primaryStage) {
		VBox main = new VBox(40);
		Label mainTitle = new Label("Welcome to Heart Health Imaging and Recording System");
		mainTitle.setFont(Font.font("Welcome to Heart Health Imaging and Recording System", FontWeight.BOLD, 15));
		VBox choose = new VBox(25);
		Button btn1 = new Button("Patient Intake");
		btn1.setPrefHeight(40);
		btn1.setPrefWidth(200);
		btn1.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn1.setTextFill(Color.WHITESMOKE);
        btn1.setOnAction(e -> Main1.PatientIntakeForm());
		Button btn2 = new Button("CT Scan Tech View");
		btn2.setPrefHeight(40);
		btn2.setPrefWidth(200);
		btn2.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn2.setTextFill(Color.WHITESMOKE);
        btn2.setOnAction(e -> Main2.CTScanView());
		Button btn3 = new Button("Patient View");
		btn3.setPrefHeight(40);
		btn3.setPrefWidth(200);
		btn3.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn3.setTextFill(Color.WHITESMOKE);
        btn3.setOnAction(e -> Main3.PatientView());
        
		choose.getChildren().addAll(btn1,btn2,btn3);
		choose.setAlignment(javafx.geometry.Pos.CENTER);
		main.getChildren().addAll(mainTitle, choose);
		main.setAlignment(javafx.geometry.Pos.CENTER);

		Scene scene = new Scene(main, 500, 400);
		
		stage = primaryStage;
		stage.setScene(scene);
		stage.show();
		
	}
}

















































































































































































package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	
	Scene scene;
	Scene scene1;
	Stage stage;
	
	public void start(Stage primaryStage) {
		VBox main = new VBox(40);
		Label mainTitle = new Label("Welcome to Heart Health Imaging and Recording System");
		mainTitle.setFont(Font.font("Welcome to Heart Health Imaging and Recording System", FontWeight.BOLD, 15));
		VBox choose = new VBox(25);
		Button btn1 = new Button("Patient Intake");
		btn1.setPrefHeight(40);
		btn1.setPrefWidth(200);
		btn1.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn1.setTextFill(Color.WHITESMOKE);
        btn1.setOnAction(e -> Main1.PatientIntakeForm());
		Button btn2 = new Button("CT Scan Tech View");
		btn2.setPrefHeight(40);
		btn2.setPrefWidth(200);
		btn2.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn2.setTextFill(Color.WHITESMOKE);
        btn2.setOnAction(e -> Main2.CTScanView());
		Button btn3 = new Button("Patient View");
		btn3.setPrefHeight(40);
		btn3.setPrefWidth(200);
		btn3.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn3.setTextFill(Color.WHITESMOKE);
        btn3.setOnAction(e -> Main3.PatientView());
        
		choose.getChildren().addAll(btn1,btn2,btn3);
		choose.setAlignment(javafx.geometry.Pos.CENTER);
		main.getChildren().addAll(mainTitle, choose);
		main.setAlignment(javafx.geometry.Pos.CENTER);

		Scene scene = new Scene(main, 500, 400);
		
		stage = primaryStage;
		stage.setScene(scene);
		stage.show();
		
	}
}








































































































package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	
	Scene scene;
	Scene scene1;
	Stage stage;
	
	public void start(Stage primaryStage) {
		VBox main = new VBox(40);
		Label mainTitle = new Label("Welcome to Heart Health Imaging and Recording System");
		mainTitle.setFont(Font.font("Welcome to Heart Health Imaging and Recording System", FontWeight.BOLD, 15));
		VBox choose = new VBox(25);
		Button btn1 = new Button("Patient Intake");
		btn1.setPrefHeight(40);
		btn1.setPrefWidth(200);
		btn1.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn1.setTextFill(Color.WHITESMOKE);
        btn1.setOnAction(e -> Main1.PatientIntakeForm());
		Button btn2 = new Button("CT Scan Tech View");
		btn2.setPrefHeight(40);
		btn2.setPrefWidth(200);
		btn2.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn2.setTextFill(Color.WHITESMOKE);
        btn2.setOnAction(e -> Main2.CTScanView());
		Button btn3 = new Button("Patient View");
		btn3.setPrefHeight(40);
		btn3.setPrefWidth(200);
		btn3.setStyle("-fx-background-color: #003366; -fx-background-radius: 4;");
        btn3.setTextFill(Color.WHITESMOKE);
        btn3.setOnAction(e -> Main3.PatientView());
        
		choose.getChildren().addAll(btn1,btn2,btn3);
		choose.setAlignment(javafx.geometry.Pos.CENTER);
		main.getChildren().addAll(mainTitle, choose);
		main.setAlignment(javafx.geometry.Pos.CENTER);

		Scene scene = new Scene(main, 500, 400);
		
		stage = primaryStage;
		stage.setScene(scene);
		stage.show();
		
	}
}
