package FrontEnd;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class oas extends Application
{
    public void start(Stage primaryStage)
    {
        Scene loginSelector = LoginPageSelector.getLoginPageSelector(primaryStage);

        primaryStage.setScene(loginSelector);
        primaryStage.show();
    }

    public static void main(String[] args) {
		launch(args);
	}
}
