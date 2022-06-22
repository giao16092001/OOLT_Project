package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Monster extends Entity{
	
	public Monster(GamePanel gp) {
		super(gp);
		direction = "down";
		speed = 2;
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
}

	
	