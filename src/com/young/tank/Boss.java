package com.young.tank;

import java.awt.Graphics;

public class Boss extends Material{
	private static final long serialVersionUID = 1818992270089337283L;

	public Boss(int img_x, int img_y, int material_x, int material_y, int refurbish) {
		super(img_x, img_y, material_x, material_y, refurbish);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void setMaterial_x(int material_x) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void setMaterial_y(int material_y) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void anew(int fps) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void draw(Graphics g, CreateCanvas cc) {
		g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
				34 * img_x + 1, 34 * img_y + 1, 34 * (img_x + 1) - 1, 34 * (img_y + 1) - 1, cc);
	}

	@Override
	public void wounded(Bullet bullet, int principal, int directions, int num) {
		if (img_x == 19){
			if (directions == 1){
				Data.matarry.add(new Effect(20, 4, material_x + (num - 2) * 16, material_y + 16, 12, 22));
			}else if (directions == 2){
				Data.matarry.add(new Effect(20, 4, material_x + (num - 2) * 16, material_y - 16, 12, 22));
			}else if (directions == 3){
				Data.matarry.add(new Effect(20, 4, material_x - 16, material_y  + (num - 2) * 16, 12, 22));
			}else if (directions == 4){
				Data.matarry.add(new Effect(20, 4, material_x + 16, material_y  + (num - 2) * 16, 12, 22));
			}
			Data.matarry.remove(bullet);
			new AudioPlay().play("src\\com\\young\\tank\\kill.wav");
			new AudioPlay().play("src\\com\\young\\tank\\gameOver.wav");
			Data.matarry.add(new Effect(20, 4, material_x, material_y, 6, 14));
			Data.matarry.add(new Effect(20, 4, Data.MIN_X + 112, Data.MAX_Y, 12, 40));
			((Tank_man)(Data.mat)).setDie(true);
			img_x += 1;
		}
	}

}
