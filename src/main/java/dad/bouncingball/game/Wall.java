package dad.bouncingball.game;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;

import dad.bouncingball.engine.Entity;
import dad.bouncingball.engine.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Wall extends Entity {
	
	private Body body; 

	public Wall(Game game, float x, float y, float width, float height) {
		super(game);
		
		this.x = x;
		this.y = y;

		this.width = width;
		this.height = height;
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.STATIC;
		bodyDef.position.set(x, y);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width / 2.0f, height / 2.0f);
		
		body = getGame().getPhysics().getWorld().createBody(bodyDef);
		body.createFixture(shape, 0.0f);
	}
	
	public void render(GraphicsContext gc) {
				
		gc.setFill(Color.GREEN);
		gc.fillRect(x, y, width, height);
		
	}
	
	@Override
	public void update(float timeDifference) {
		x = body.getPosition().x;
		y = body.getPosition().y;
	}

}