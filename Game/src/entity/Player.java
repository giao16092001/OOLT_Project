package entity;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import tile.TileManager;

public class Player extends Entity{
	
	KeyHandler KeyH;
	TileManager tileM = new TileManager(gp);
	public Player(GamePanel gp,KeyHandler keyH) {
		super(gp);
		this.KeyH = keyH;
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 8;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValue();
		getPlayerImage();
	}
	
	public void setDefaultValue() {
		x = 0;
		y = 0;
		speed = 4;
		direction = "down";
	}
    
	public void getPlayerImage() {
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/player/khokho_up.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/player/khokho_down.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/player/khokho_left.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/player/khokho_right.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(KeyH.upPressed == true || KeyH.downPressed == true ||
				KeyH.leftPressed == true || KeyH.rightPressed == true) {
		    if(KeyH.upPressed == true) {
			   direction = "up";
		    }
		    else if(KeyH.downPressed == true) {
			   direction = "down";
		    }
		    else if(KeyH.leftPressed == true) {
			   direction = "left";
		    }
		    else if(KeyH.rightPressed == true) {
			   direction = "right";
		    }
		
		// check tile collision
		collisionOn = false;
		gp.cChecker.checkTile(this);
		
		// if collision is false, player can move
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
		
	}
	public void draw( Graphics2D g2) {
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
