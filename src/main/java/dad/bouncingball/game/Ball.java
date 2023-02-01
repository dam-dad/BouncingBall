package dad.bouncingball.game;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

import dad.bouncingball.engine.Entity;
import dad.bouncingball.engine.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends Entity {
	
	private Body body; 

	public Ball(Game game, float posX, float posY) {
		super(game);
		
		this.x = posX;
		this.y = posY;
		
		// variables of character size
		this.width = 10f;
		this.height = 10f;

		initBody();
	}
	
	private void initBody() {
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DYNAMIC;
		bodyDef.position.set(x, y);

		CircleShape shape = new CircleShape();
		shape.setRadius(width);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 0.5f;
		fixtureDef.friction = 0.2f;
		fixtureDef.restitution = 0.8f;
		
		body = getGame().getPhysics().getWorld().createBody(bodyDef);
		body.createFixture(fixtureDef);
		
	}
	
	public void render(GraphicsContext gc) {
				
		gc.setFill(Color.RED);
		gc.fillOval(x, y, width, height);
		
	}
	
	@Override
	public void update(float timeDifference) {
		x = body.getPosition().x;
		y = body.getPosition().y;
	}

}