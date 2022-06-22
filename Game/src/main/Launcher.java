package main;

import javax.swing.JFrame;


public class Launcher {

	public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Boom Game");
        
        
        GamePanel gamePanel = new GamePanel();
		((GamePanel) window.add(gamePanel)).setup();

        window.pack(); 
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.startGameThread();
       
	}

}
