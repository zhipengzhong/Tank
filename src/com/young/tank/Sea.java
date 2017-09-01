package com.young.tank;

import java.awt.Graphics;

public class Sea extends Material{
	private static final long serialVersionUID = -4463388328533028937L;
	int fps;

//海
	
	
	
	public Sea(int img_x, int img_y, int material_x, int material_y, int refurbish) {
		super(img_x, img_y, material_x, material_y, refurbish);
//		super.attack_id = 1;
		super.ispenetrate = true;
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
		this.fps = fps;
		
//		if (this.fps >= 100000){
//			this.fps = 0;
//		}
		if (imgid == 0 && this.fps % (Data.WINDOW_FPS / refurbish) <= Data.WINDOW_FPS / refurbish / 2){
			imgid = 1;
		}
		if (imgid == 1 && this.fps % (Data.WINDOW_FPS / refurbish) <=  Data.WINDOW_FPS / refurbish && this.fps % (Data.WINDOW_FPS / refurbish) > Data.WINDOW_FPS / refurbish / 2){
			imgid = 0;
		}
		
	}

	@Override
	public void draw(Graphics g, CreateCanvas cc) {
		if (imgid == 1){
			g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
					34 * img_x + 1, 34 * img_y + 1, 34 * (img_x + 1) - 1, 34 * (img_y + 1) - 1, cc);
		}else {
			g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
					34 * (img_x + 1) + 1, 34 * img_y + 1, 34 * (img_x + 2) - 1, 34 * (img_y + 1) - 1, cc);
		}
		
	}

	
	@Override
	public void wounded(Bullet bullet, int principal, int dire, int num) {
		// TODO 自动生成的方法存根
		
	}

}
