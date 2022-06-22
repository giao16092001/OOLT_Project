package entity;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Monster extends Entity{
	
	public Monster(GamePanel gp,int  x,int y) {
		super(gp);
		this.x = x;
		this.y = y;
		direction = "down";
		speed = 5;
		getMonsterImage();
	}
	public void getMonsterImage() {
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/monster/quaivat 1_up.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/monster/quaivat 1_down.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/monster/quaivat 1_left.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/monster/quaivat 1_right.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void setAction() {
		actionCounter++;
		if(actionCounter == 120) {
		Random random = new Random();
		int i = random.nextInt(100)+1;
		if(i <= 25) {
			direction = "up";
		}
		if(i > 25 && i<=50) {
			direction = "down";
		}
		if(i > 50 && i <= 75) {
			direction = "left";
		}
		if(i < 50 && i <= 100) {
			direction = "right";
		}
		actionCounter = 0;
	}
}
	public void update() {
		setAction();
		collisionOn = false;
		gp.cChecker.checkTile(this);
		if(collisionOn == false) {
			switch(direction) {
			case "up" :
				if(y>speed)
					y -= speed;
				break;
			case "left" :
				if(x>speed)
					x -= speed;
				break;
			case "down" :
				if(y+gp.tileSize < gp.screenHeigh)
					y += speed;
				break;
			case "right" :
				if(x+gp.tileSize < gp.screenWidth)
					x += speed;
				break;
			}
		}
	}


	
	