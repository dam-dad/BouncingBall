package dad.bouncingball.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.bouncingball.game.BouncingBallGame;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

public class GameController implements Initializable {
	
	// logic
	
	private BouncingBallGame game;
	
	// view
	
	@FXML
	private BorderPane view; 
	
	@FXML
	private Canvas canvas;
	
	public GameController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		game = new BouncingBallGame(canvas);
//		game.fpsProperty().addListener((o, ov, nv) -> System.out.println(nv + "fps"));
		game.start();
		
	}
	
	public BorderPane getView() {
		return view;
	}

}
