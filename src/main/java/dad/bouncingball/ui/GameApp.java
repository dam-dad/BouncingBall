package dad.bouncingball.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApp extends Application {
	
	public static Stage primaryStage;
	
	private GameController gameController = new GameController();

	@Override
	public void start(Stage primaryStage) throws Exception {

		GameApp.primaryStage = primaryStage;

		primaryStage.setTitle("Bouncing Ball");
		primaryStage.setScene(new Scene(gameController.getView()));
		primaryStage.show();
		
	}

}
