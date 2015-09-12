package jeffrey.rain.graphics;

import java.util.Random;

import jeffrey.rain.level.tile.Tile;

public class Screen {

	private int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;

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

	public void render(int xOffset, int yOffset) {
		for (int y = 0; y < height; y++) {
			int yp = y + yOffset;
			if (yp < 0 || yp >= height) continue;
			for (int x = 0; x < width; x++) {
				int xp = x + xOffset;
				if (xp < 0 || xp >= width) continue;
				pixels[(xp) + (yp) * width] = Sprite.grass.pixels[(x&15) + (y&15) * 16];
			}
		}
	}
	
	public void renderTile(int xPos, int yPos, Tile tile) {
		for (int y = 0; y < tile.sprite.SIZE; y++){
			int yAbsolute = y + yPos;
			for(int x = 0; x < tile.sprite.SIZE; x++){
				int xAbsolute = x + xPos;
				if(xAbsolute < 0 || xAbsolute >= width || yAbsolute < 0 || yAbsolute >= width) break;
				pixels[xAbsolute + yAbsolute * width] = tile.sprite.pixels[x + y *tile.sprite.SIZE];
 			}
		}
	}
}
