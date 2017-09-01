package com.young.tank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class TankOther {
	private static int fps;
	private static int fps_1;
	private static int rand = 1;
	private static int rand_1 = 1;
	private static int tank_sum = 20;
	public static int tank_sum_1 = 4;
	
	
	
	@SuppressWarnings("unchecked")
	public TankOther() {
		super();
		try {
//			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Map.tmp"));
//			oos.writeObject(Data.matarry);
//			oos.close();
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Map.tmp"));
				Data.matarry = (CopyOnWriteArrayList<Material>) ois.readObject();
				ois.close();
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		for (Material mat : Data.matarry) {
			if (mat.material_x / 32 == 192 /32 && mat.material_y / 32 == 0 / 32){
				Data.matarry.remove(mat);
			}
			if (mat.material_x / 32 == 384 /32 && mat.material_y / 32 == 0 / 32){
				Data.matarry.remove(mat);
			}
			if (mat.material_x / 32 == 0 /32 && mat.material_y / 32 == 0 / 32){
				Data.matarry.remove(mat);
			}
			if (mat.material_x / 32 == 128 /32 && mat.material_y / 32 == 384 / 32){
				Data.matarry.remove(mat);
			}
			if (mat.material_x / 32 == 192 /32 && mat.material_y / 32 == 384 / 32){
				Data.matarry.remove(mat);
			}
			if (mat.material_x / 32 == 256 /32 && mat.material_y / 32 == 384 / 32){
				Data.matarry.remove(mat);
			}
		}
		Data.matarry.add(new Boss(19, 5, 192, 384, 3));
		new AudioPlay().play("src\\com\\young\\tank\\intro.wav");
	}

	public static void newtank(){
		int temp = 0;
		int temp_1 = 0;
		int temp1 = 0;
		fps++;
		fps_1++;
		if (fps >= 10000){
			fps = 0;
		}
		for (Material mat : Data.matarry) {
			if (mat instanceof Tank_npc){
				temp++;
			}
			if (mat instanceof Tank_man){
				temp1++;
			}
		}
		if (temp1 <= 0){
			if (tank_sum_1 > 0){
				if (fps_1 % rand_1 == 0){
					tank_sum_1--;
					rand_1 = new Random().nextInt(50) + 100;
					Data.mat = new Tank_man(0, 8, 128, 384, 3, 1, 3);
					Data.matarry.add(0 ,Data.mat);
				}
			}
		}else {
			fps_1 = 1;
		}
		
		if (tank_sum > 0){
			if (temp < 4){
				if (fps % rand == 0){
					tank_sum--;
					rand = new Random().nextInt(50) + 100;
					temp_1 = new Random().nextInt(3);
					if (temp_1 == 0){
						Data.matarry.add(0, new Tank_npc(0, 2, 192, 0, 3, 6, 5));					
					}else if (temp_1 == 1){
						Data.matarry.add(0, new Tank_npc(0, 2, 384,0, 3, 7, 5));
					}else if (temp_1 == 2){
						Data.matarry.add(0, new Tank_npc(0, 2, 0, 0, 3, 8, 5));
					}
				}
			}
		}else {
			fps = 0;
		}
	}
	
	public static void draw(Graphics g, CreateCanvas cc) {
		for (int i = 0; i <= tank_sum / 2; i++) {
			if (i == tank_sum / 2&& tank_sum % 2 == 1){
				g.drawImage(Data.TANK_PLAN, Data.MAX_X + 32, Data.MIN_Y + i * 16, Data.MAX_X + 64, Data.MIN_Y + i * 16 + 32, 
						34 * 1 + 1, 34 * 4 + 1, 34 * 2 - 1, 34 * 5 - 1, cc);
			}else if(i < tank_sum / 2){
				g.drawImage(Data.TANK_PLAN, Data.MAX_X + 32, Data.MIN_Y + i * 16, Data.MAX_X + 64, Data.MIN_Y + i * 16 + 32, 
						34 * 1 + 1, 34 * 4 + 1, 34 * 2 - 1, 34 * 5 - 1, cc);
				g.drawImage(Data.TANK_PLAN, Data.MAX_X + 52, Data.MIN_Y + i * 16, Data.MAX_X + 84, Data.MIN_Y + i * 16 +32, 
						34 * 1 + 1, 34 * 4 + 1, 34 * 2 - 1, 34 * 5 - 1, cc);
			}
		}
		g.drawImage(Data.TANK_PLAN, Data.MAX_X + 43, Data.MIN_Y + 230, Data.MAX_X + 75, Data.MIN_Y + 230 +32, 
				34 * 2 + 1, 34 * 4 + 1, 34 * 3 - 1, 34 * 5 - 1, cc);
		g.drawImage(Data.TANK_PLAN, Data.MAX_X + 36, Data.MIN_Y + 248, Data.MAX_X + 68, Data.MIN_Y + 248 +32, 
				34 * 10 + 1, 34 * 6 + 1, 34 * 11 - 1, 34 * 7 - 1, cc);
		g.setColor(Color.BLACK);
		g.setFont( new Font("微软雅黑",Font.BOLD,19));//设置字体
        g.drawString("" + tank_sum_1, Data.MAX_X + 62, Data.MIN_Y + 271);//画文本
		
	}
}
