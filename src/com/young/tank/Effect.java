package com.young.tank;

import java.awt.Graphics;

public class Effect extends Material{//子弹特效
	private static final long serialVersionUID = 3402035641659328509L;
	
	int fps;
	int num1;
	int num2;
	int m;
	
	
	public Effect(int img_x, int img_y, int material_x, int material_y, int refurbish, int num) {
		super(img_x, img_y, material_x, material_y, refurbish);
		this.num1 = num / 10;
		this.num2 = num % 10;
//		super.attack_id = 1;
		super.ispenetrate = true;
		super.ispass = true;
	}

	public Effect(int img_x, int img_y, int material_x, int material_y, int refurbish) {
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
//		if (m == 0){
//			m = fps;
//		}
//		this.fps = fps - m;
		this.fps++;
		if (this.fps % (Data.WINDOW_FPS / refurbish  * 2.5) <= Data.WINDOW_FPS / refurbish * 0.5){
			imgid = 1;
		}else if(this.fps % (Data.WINDOW_FPS / refurbish  * 2.5) <= Data.WINDOW_FPS / refurbish * 1){
			imgid = 2;
		}else if(this.fps % (Data.WINDOW_FPS / refurbish  * 2.5) <= Data.WINDOW_FPS / refurbish * 1.5){
			imgid = 3;
		}else if(this.fps % (Data.WINDOW_FPS / refurbish  * 2.5) <= Data.WINDOW_FPS / refurbish * 2){
			imgid = 4;
		}else if(this.fps % (Data.WINDOW_FPS / refurbish  * 2.5) <= Data.WINDOW_FPS / refurbish * 2.5){
			imgid = 5;
		}else if(this.fps % (Data.WINDOW_FPS / refurbish  * 2.5) <= Data.WINDOW_FPS / refurbish * 3){
			imgid = 6;
		}
		if(fps >= Data.WINDOW_FPS * 100 - 10){
			Data.matarry.remove(this);
		}
	}
	
	@Override
	public void draw(Graphics g, CreateCanvas cc) {
		if (num1 == 1){
			if (imgid <= num2){
				if (imgid == 1){
					g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
							34 * img_x + 1, 34 * img_y + 1, 34 * (img_x + 1) - 1, 34 * (img_y + 1) - 1, cc);
				} else if(imgid == 2){
					g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
							34 * (img_x + 1) + 1, 34 * img_y + 1, 34 * (img_x + 2) - 1, 34 * (img_y + 1) - 1, cc);
				} else if(imgid == 3){
					g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
							34 * (img_x + 2) + 1, 34 * img_y + 1, 34 * (img_x + 3) - 1, 34 * (img_y + 1) - 1, cc);
				} else if(imgid == 4){
					g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X - 16, material_y + Data.MIN_Y - 16, material_x + 48 + Data.MIN_X, material_y + 48 + Data.MIN_Y, 
							34 * (img_x + 3) + 1, 34 * img_y + 1, 34 * (img_x + 5) - 1, 34 * (img_y + 2) - 1, cc);
				} else if(imgid == 5){
					g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X - 16, material_y + Data.MIN_Y - 16, material_x + 48 + Data.MIN_X, material_y + 48 + Data.MIN_Y, 
							34 * (img_x + 5) + 1, 34 * img_y + 1, 34 * (img_x + 7) - 1, 34 * (img_y +2) - 1, cc);
				}
			}else{
				Data.matarry.remove(this);
			}
		}else if(num1 == 2){
			if (imgid <= num2){
				if (imgid == 1){
					g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
							34 * img_x + 1, 34 * img_y + 1, 34 * (img_x + 1) - 1, 34 * (img_y + 1) - 1, cc);
				} else if(imgid == 2){
					g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
							34 * (img_x + 1) + 1, 34 * img_y + 1, 34 * (img_x + 2) - 1, 34 * (img_y + 1) - 1, cc);
				}
			}else{
				Data.matarry.remove(this);
			}
		}else if(num1 == 3){
			if (imgid <= num2){
				if(imgid == 1){
					g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
							34 * (img_x + 2) + 1, 34 * img_y + 1, 34 * (img_x + 3) - 1, 34 * (img_y + 1) - 1, cc);
				} else if(imgid == 2){
					g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X - 16, material_y + Data.MIN_Y - 16, material_x + 48 + Data.MIN_X, material_y + 48 + Data.MIN_Y, 
							34 * (img_x + 3) + 1, 34 * img_y + 1, 34 * (img_x + 5) - 1, 34 * (img_y + 2) - 1, cc);
				}
			}else{
				Data.matarry.remove(this);
			}
		}else if(num1 == 4){
			gameover();
			g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 66 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
					34 * 4 + 1, 34 * img_y + 1, 34 * 6 - 1, 34 * (img_y + 1) - 1, cc);
			
		}else {
			Data.matarry.remove(this);
		}
		
		
		
	}

	@Override
	public void wounded(Bullet bullet, int principal, int dire , int num) {
		// TODO 自动生成的方法存根
		
	}
	
	
	public void gameover(){
		if (material_y >= Data.MAX_Y / 2 - 40){
			material_y--;
		}
	}

}
