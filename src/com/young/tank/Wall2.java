package com.young.tank;

import java.awt.Graphics;

public class Wall2 extends Material{
	private static final long serialVersionUID = 2919258279665521877L;
//墙
	
	
	
	private int[] temp_img_1 = new int[4];
	private int[] temp_img_2 = new int[4];
	private int[] temp_img_3 = new int[4];
	private int[] temp_img_4 = new int[4];
	
	
	
	public Wall2(int img_x, int img_y, int material_x, int material_y, int refurbish) {
		super(img_x, img_y, material_x, material_y, refurbish);
		super.attack_id = 1;
		super.ispenetrate = false;
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
		// TODO 自动生成的方法存根
		boolean temp = false;
		for (int i = 0; i < temp_img_1.length; i++) {
			if (temp_img_1[i] == 0){
				temp = true;
			}
		}
		for (int i = 0; i < temp_img_2.length; i++) {
			if (temp_img_2[i] == 0){
				temp = true;
			}
		}
		for (int i = 0; i < temp_img_3.length; i++) {
			if (temp_img_3[i] == 0){
				temp = true;
			}
		}
		for (int i = 0; i < temp_img_4.length; i++) {
			if (temp_img_4[i] == 0){
				temp = true;
			}
		}
		
		if (!temp){
			Data.matarry.remove(this);
		}
	}

	@Override
	public void draw(Graphics g, CreateCanvas cc) {
		// TODO 自动生成的方法存根
//		imgId();
		g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X , material_y + Data.MIN_Y , material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
				34 * 2 + 1, 34 * 7 + 1, 34 * 3 - 1, 34 * 8 - 1, cc);
		for (int i = 0; i < temp_img_1.length; i++) {
			if (temp_img_1[i] != 0){
				g.fillRect(material_x + Data.MIN_X + i * 8, material_y + Data.MIN_Y, 8, 8);
			}
		}
		for (int i = 0; i < temp_img_2.length; i++) {
			if (temp_img_2[i] != 0){
				g.fillRect(material_x + Data.MIN_X + i * 8, material_y + Data.MIN_Y + 8, 8, 8);
			}
		}
		for (int i = 0; i < temp_img_3.length; i++) {
			if (temp_img_3[i] != 0){
				g.fillRect(material_x + Data.MIN_X + i * 8, material_y + Data.MIN_Y + 16, 8, 8);
			}
		}
		for (int i = 0; i < temp_img_4.length; i++) {
			if (temp_img_4[i] != 0){
				g.fillRect(material_x + Data.MIN_X + i * 8, material_y + Data.MIN_Y + 24, 8, 8);
			}
		}
		
		
	}

	@Override
	public void wounded(Bullet bullet, int principal, int dire, int num) {
		if (destroy(dire,num)){
			Data.matarry.remove(bullet);
			new AudioPlay().play("src\\com\\young\\tank\\brickErase.wav");
		}
	}
	
	public boolean destroy(int a,int b){
		if (a == 1){
			if (temp_img_4[b] == 0 || temp_img_4[b - 1] == 0){
				if (b == 2){
					temp_img_4[0] = 1;
					temp_img_4[1] = 1;
					temp_img_4[2] = 1;
					temp_img_4[3] = 1;
				}else{
					temp_img_4[b] = 1;
					temp_img_4[b - 1] = 1;
				}
				return true;
			}else {
				if (temp_img_3[b] == 0 || temp_img_3[b - 1] == 0){
					if (b == 2){
						temp_img_3[0] = 1;
						temp_img_3[1] = 1;
						temp_img_3[2] = 1;
						temp_img_3[3] = 1;
					}else{
						temp_img_3[b] = 1;
						temp_img_3[b - 1] = 1;
					}
					return true;
				}else {
					if (temp_img_2[b] == 0 || temp_img_2[b - 1] == 0){
						if (b == 2){
							temp_img_2[0] = 1;
							temp_img_2[1] = 1;
							temp_img_2[2] = 1;
							temp_img_2[3] = 1;
						}else{
							temp_img_2[b] = 1;
							temp_img_2[b - 1] = 1;
						}
						return true;
					}else {
						if (temp_img_1[b] == 0 || temp_img_1[b - 1] == 0){
							if (b == 2){
								temp_img_1[0] = 1;
								temp_img_1[1] = 1;
								temp_img_1[2] = 1;
								temp_img_1[3] = 1;
							}else{
								temp_img_1[b] = 1;
								temp_img_1[b - 1] = 1;
							}
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
