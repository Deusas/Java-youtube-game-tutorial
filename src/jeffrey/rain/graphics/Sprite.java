package jeffrey.rain.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite voidTile = new Sprite(16, 0x1B87E0);
	
	public static Sprite player_up_1 = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite player_side_1 = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite player_down_1 = new Sprite(32, 2, 5, SpriteSheet.tiles);

	public static Sprite player_up_2 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite player_down_2 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	
	public static Sprite player_up_3 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	public static Sprite player_side_3 = new Sprite(32, 1, 7, SpriteSheet.tiles);
	public static Sprite player_down_3 = new Sprite(32, 2, 7, SpriteSheet.tiles);
	
	
	/**
	 * 
	 * @param size
	 * @param x
	 * @param y
	 * @param sheet  spritesheet
	 */
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int [SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	/**
	 * 
	 * @param size
	 * @param colour sprite colour in hex.
	 */
	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour) {
		for (int i = 0; i < SIZE*SIZE; i++) {
			pixels[i] = colour;
		}
	}
	
	private void load() {
		for (int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + ( y + this.y) * sheet.SIZE];
			}
		}
		
	}
	
	
}
