package tile;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
	    tile = new Tile[10];
		getTileImage();
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		loadMap();
	}

	private void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/background/background_Play.png"));

			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/boxsat.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/boxgo.png"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/boxgo2.png"));
			tile[3].collision = true;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap() {
		try {
			InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				String line = br.readLine();
				while(col < gp.maxScreenCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxScreenCol) {
					col = 0;
					row++;
				}
			}
		}
		catch (Exception e) {
			
		}
	}
	public void draw(Graphics2D g2) {
		g2.drawImage(tile[0].image,0,0,gp.screenWidth,gp.screenHeigh, null);
	    int col = 0;
	    int row = 0;
	    int x = 0;
	    int y = 0;
	    while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
	    	int tileNum = mapTileNum[col][row];
	    	if(tileNum != 0) {
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
	    	}
	    	col++;
	    	x += gp.tileSize;
	    	if(col == gp.maxScreenCol) {
	    		col = 0;
	    		x =0;
	    		row++;
	    		y += gp.tileSize;
	    	}
	    	
	    }
	}
	
	

}
