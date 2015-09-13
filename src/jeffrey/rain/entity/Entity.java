package jeffrey.rain.entity;

import java.util.Random;

import jeffrey.rain.graphics.Screen;
import jeffrey.rain.level.Level;

public abstract class Entity {
	
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	public void update() {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		// REMOVE FROM LEVEL
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}
