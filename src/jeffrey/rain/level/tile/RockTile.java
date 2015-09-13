package jeffrey.rain.level.tile;

import jeffrey.rain.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public boolean solid() {
		return true;
	}
}
