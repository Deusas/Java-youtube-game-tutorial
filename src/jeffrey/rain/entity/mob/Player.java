package jeffrey.rain.entity.mob;

import jeffrey.rain.graphics.Screen;
import jeffrey.rain.graphics.Sprite;
import jeffrey.rain.input.Keyboard;

public class Player extends Mob{

	private Keyboard input;
	private Sprite sprite;
	private int flip = 0;
	private int anim = 0;
	private boolean walking = false;
	
	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_up_1;
	}
	
	public Player(int x, int y, Keyboard input){
		this.input = input;
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		int xa = 0, ya = 0;
		if(anim < 6000) anim++;
		else anim = 0;
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		
		if(xa != 0 || ya != 0){
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		
	}
	
	public void render(Screen screen) {
		flip = 0; 
		if(this.direction == 0) {
			sprite = Sprite.player_up_1;
			if (walking){
				if(anim % 30 > 20){
					sprite = Sprite.player_up_2;
				}
				if(anim % 30 < 10){
					sprite = Sprite.player_up_3;
				}
			}
		}
		if(this.direction == 1){
			sprite = Sprite.player_side_1;
			if (walking){
				if(anim % 30 > 20){
					sprite = Sprite.player_side_2;
				}
				if(anim % 30 < 10){
					sprite = Sprite.player_side_3;
				}
			}
		}
		if(this.direction == 2){
			sprite = Sprite.player_down_1;
			if (walking){
				if(anim % 30 > 20){
					sprite = Sprite.player_down_2;
				}
				if(anim % 30 < 10){
					sprite = Sprite.player_down_3;
				}
			}
		}
		if(this.direction == 3){
			sprite = Sprite.player_side_1;
			if (walking){
				if(anim % 30 > 20){
					sprite = Sprite.player_side_2;
				}
				if(anim % 30 < 10){
					sprite = Sprite.player_side_3;
				}
			}
			flip = 1;
		}
		screen.renderPlayer(x, y, sprite, flip);
	}
}
