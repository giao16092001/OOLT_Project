package main;
import entity.Monster;

public class MonsterSetter {
	GamePanel gp;
	public MonsterSetter(GamePanel gp) {
		this.gp = gp;
	}
	public void setMonster() {
		gp.monster.add(new Monster(gp,325,325)) ;
		gp.monster.add(new Monster(gp,300,0)) ;
		gp.monster.add(new Monster(gp,0,300)) ;
	}

}
