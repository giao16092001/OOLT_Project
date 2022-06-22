package main;

import entity.Monster;

public class MonsterSetter {
	GamePanel gp;
	public MonsterSetter(GamePanel gp) {
		this.gp = gp;
	}
	public void setMonster() {
		gp.monster[0] = new Monster(gp);
		gp.monster[0].x = 50;
		gp.monster[0].y = 50;
		gp.monster[1] = new Monster(gp);
		gp.monster[1].y = 100;
		gp.monster[1].x = 100;
	}

}
