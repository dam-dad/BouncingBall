package dad.bouncingball.game;

import java.util.Set;

import dad.bouncingball.engine.Game;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;

public class BouncingBallGame extends Game {
	
	public BouncingBallGame(Canvas canvas) {
		super(canvas);
	}

	@Override
	protected void init() {

		getEntities().addAll(
				new Ball(this, 120, 50),
				new Ball(this, 125, 35),
				new Ball(this, 125, 65),
				new Wall(this, 0, getHeight() - 20f, getWidth(), 10)
			);

	}

	@Override
	protected void processInput(Set<KeyCode> input) {
		// TODO Auto-generated method stub

	}

}
