package main;
import entity.Monster1;
import entity.Monster2;
import entity.Monster3;

public class MonsterSetter {
	GamePanel gp;
	public MonsterSetter(GamePanel gp) {
		this.gp = gp;
	}
	public void setMonster() {
		gp.monster.add(new Monster1(gp,gp.tileSize*14,gp.tileSize*10)) ;
		gp.monster.add(new Monster1(gp,gp.tileSize*8,gp.tileSize*8)) ;
		gp.monster.add(new Monster2(gp,0,300)) ;
		gp.monster.add(new Monster1(gp,gp.tileSize*14,gp.tileSize*10)) ;
		gp.monster.add(new Monster1(gp,gp.tileSize*8,gp.tileSize*8)) ;
		gp.monster.add(new Monster2(gp,0,300)) ;
		gp.monster.add(new Monster3(gp,gp.tileSize*6,gp.tileSize*5)) ;
		
	}

}
