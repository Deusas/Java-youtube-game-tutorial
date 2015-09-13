package jeffrey.rain.entity.mob;

import jeffrey.rain.entity.Entity;
import jeffrey.rain.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int direction = 0;  // 0 NORTH-1 EAST - 2 SOUTH - 3 WEST
	protected boolean moving = false;
	
	public void move(int xa, int ya ) {
		
		if (xa > 0) direction = 1;
		if (xa < 0) direction = 3;
		if (ya > 0) direction = 2;
		if (ya < 0) direction = 0;
		
		if(!collision()){
			x += xa;
			y += ya;
		}
	}
	
	public void update() {
		
	}
	
	private boolean collision() {
		return false;
	}
	
	public void render() {
		
	}

}
