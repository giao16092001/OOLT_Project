package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Entity;
import entity.Monster1;
import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
    //Screen setting
    final int originalTileSize = 16; //16x16 title(Kich thuoc tieu chuan cua 1 o trong ban do)
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;// 48x48 tile 
	public final int maxScreenCol = 15;
	public int maxScreenRow = 13;
	public int screenWidth = tileSize * maxScreenCol;//768 pixels
	public int screenHeigh = tileSize * maxScreenRow;// 576 pixels
	
	KeyHandler KeyH = new KeyHandler();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	Player player = new Player(this, KeyH);
	ArrayList<Entity> monster = new ArrayList<Entity>();;
	
	public MonsterSetter mSetter = new MonsterSetter(this);
	//FPS(Frame Per Second)
	int FPS = 60;
	
    TileManager tileM = new TileManager(this);
    
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeigh));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(KeyH);
		this.setFocusable(true);
	}
	public void setup() {
		mSetter.setMonster();
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
    public void run() {
    	double drawInterval = 1000000000/FPS;
    	double delta = 0;
    	long lastTime = System.nanoTime();
    	long currentTime;
    	long timer = 0;
    	int drawCount = 0;
    	
    	while(gameThread != null) {
    		currentTime = System.nanoTime();
    		delta += (currentTime - lastTime)/drawInterval;
    		timer += (currentTime - lastTime);
    		lastTime = currentTime;
    		if(delta >= 1) {
    			update();
    			repaint();
    			delta--;
    			drawCount++;
    		}
    		if(timer >= 1000000000) {
    			System.out.println("FPS: " + drawCount);
    			drawCount = 0;
    			timer = 0;
    		}
    	}
    	}
	public void update() {
		player.update();
		for(int i = 0; i < monster.size(); i++) {
			if(monster.get(i) != null) {
				monster.get(i).update();
			}
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		tileM.draw(g2);
		for(int i=0; i < monster.size(); i++) {
			if(monster.get(i) != null) {
				monster.get(i).draw(g2);
			}
		}
		player.draw(g2);
		g2.dispose();
	}
}
