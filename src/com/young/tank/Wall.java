package com.young.tank;

import java.awt.Graphics;

public class Wall extends Material{
	private static final long serialVersionUID = 7273384988167714846L;
//墙
	
	
	
	private int temp_img_x;
	private int temp_img_y;
	
	
	
	public Wall(int img_x, int img_y, int material_x, int material_y, int refurbish) {
		super(img_x, img_y, material_x, material_y, refurbish);
		super.attack_id = 1;
		super.ispenetrate = false;
		super.size_x = 8;
		super.size_y = 8;
	}

	@Override
	public void setMaterial_x(int material_x) {
		if (material_x <= Data.TANKE_REGION_MIN_X){
			this.material_x = Data.TANKE_REGION_MIN_X;
		}else if (material_x >= Data.TANKE_REGION_MAX_X - size_x){
			this.material_x = Data.TANKE_REGION_MAX_X - size_x;
		}else{
			this.material_x = material_x;
		}
	}

	@Override
	public void setMaterial_y(int material_y) {
		if (material_y <= Data.TANKE_REGION_MIN_Y){
			this.material_y = Data.TANKE_REGION_MIN_Y;
		}else if (material_y >= Data.TANKE_REGION_MAX_Y - size_y){
			this.material_y = Data.TANKE_REGION_MAX_Y - size_y;
		}else{
			this.material_y = material_y;
		}
	}
	
	@Override
	public void anew(int fps) {
		temp_img_x = material_x % 32 / 8;
		temp_img_y = material_y % 32 / 8;
	}

	@Override
	public void draw(Graphics g, CreateCanvas cc) {
		// TODO 自动生成的方法存根
//		imgId();
		g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X , material_y + Data.MIN_Y , material_x + 8 + Data.MIN_X, material_y + 8 + Data.MIN_Y, 
				34 * 2 + 1 + temp_img_x * 8, 34 * 7 + 1 + temp_img_y * 8, 34 * 2 + 8 + temp_img_x * 8, 34 * 7 + 8 + temp_img_y * 8, cc);
		
	}

	@Override
	public void wounded(Bullet bullet, int principal, int dire, int num) {
		Data.matarry.remove(bullet);
		Data.matarry.remove(this);
		if (principal <= 2){
			new AudioPlay().play("src\\com\\young\\tank\\brickErase.wav");
		}
		
	}
}
