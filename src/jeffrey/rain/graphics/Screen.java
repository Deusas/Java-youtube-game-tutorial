package jeffrey.rain.graphics;

import java.util.Random;

import jeffrey.rain.entity.mob.Player;
import jeffrey.rain.level.tile.Tile;

public class Screen {

	public int width;
	public int height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOffset, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xPos, int yPos, Tile tile) {
		xPos -= xOffset;
		yPos -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++){
			int yAbsolute = y + yPos;
			for(int x = 0; x < tile.sprite.SIZE; x++){
				int xAbsolute = x + xPos;
				if(xAbsolute < -tile.sprite.SIZE || xAbsolute >= width || yAbsolute < 0 || yAbsolute >= height) break;
				if (xAbsolute < 0) xAbsolute = 0;
				pixels[xAbsolute + yAbsolute * width] = tile.sprite.pixels[x + y *tile.sprite.SIZE];
 			}
		}
	}
	
	public void renderPlayer(int xPos, int yPos, Sprite sprite, int flip){
		xPos -= xOffset;
		yPos -= yOffset;
		for (int y = 0; y < 32; y++){
			int yAbsolute = y + yPos;
			int ys = y;
			if (flip == 2 || flip == 3) ys = 31- y;
			for(int x = 0; x < 32; x++){
				int xAbsolute = x + xPos;
				int xs = x;
				if (flip == 1 || flip == 3) xs = 31- x;
				if(xAbsolute < -32 || xAbsolute >= width || yAbsolute < 0 || yAbsolute >= height) break;
				if (xAbsolute < 0) xAbsolute = 0;
				int col = sprite.pixels[xs + ys * 32];
				if (col != 0xFFFF00FF) pixels[xAbsolute + yAbsolute * width] = col;
 			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
