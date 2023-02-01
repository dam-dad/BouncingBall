package dad.bouncingball.engine;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

public class Physics {
	
	public static final float PTM_RATIO = 32f; 					// pixels to meters ratio
	private static final Vec2 DEFAULT_GRAVITY = new Vec2(0.0f, 0.98f);
	
	private World world;	
	private float physicsTime = 0.0f;
	private float physicsTimeStep = 1.0f / 60.0f; // 60 fps
	private int velocityIterations = 8;
	private int positionInterations = 3;
	
	public Physics() {
		world = new World(DEFAULT_GRAVITY);
	}
	
	public void update(float diff) {
		physicsTime += diff;
		if (physicsTime >= 0.0f) {
			physicsTime -= physicsTimeStep;
			world.step(physicsTime, velocityIterations, positionInterations);
		}
	}
	
	public World getWorld() {
		return world;
	}

}
