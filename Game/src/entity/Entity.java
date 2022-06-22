
package entity;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {
	
	GamePanel gp;
	public int x;
	public int y;
	public int speed;
	public BufferedImage up, down, left, right;
	public String direction;
	public Rectangle solidArea ;//= new Rectangle(0, 0, 48, 48);
	public boolean collisionOn = false;
	public int actionCounter = 0;
	public Entity(GamePanel gp) {
		this.gp = gp;
		
	}
	public void setAction() {
		
	}
	public void update() {
		
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		switch(direction) {
		case"up" :
			image = up;
			break;
		case"down":
		    image = down;
		    break;
		case"right":
			image = right;
			break;
		case"left":
			image = left;
			break;
		}
	
		g2.drawImage(image, x, y,gp.tileSize,gp.tileSize,null);
	}
}

	



