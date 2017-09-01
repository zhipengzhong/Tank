package com.young.tank;

import java.awt.Graphics;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class CreateMap {
	public int img_x = 0;
	public int img_y = 11;
	public int material_x;
	public int material_y;
	public int refurbish = 1;
	public int imgid = 1;
	public int size_x = 32;		//默认尺寸32
	public int size_y = 32;
	public int directions_x;
	public int directions_y;
	public int fps;
	
	private int select;
	private boolean down_key;
	
	
	public CreateMap() {
		super();
		Data.matarry.clear();
		Data.matarry.add(new Boss(19, 5, 192, 384, 3));
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 6; j++) {
				if (i >= 2 && j >= 2 && i < 6){
					continue;
				}
				Data.matarry.add(new Wall(0, 0, 176 + i * 8 , 368 + j * 8, 3));
			}
		}
		
	}

	public void anew(int fps) {
		this.fps = fps;
		if (imgid == 0 && fps % (Data.WINDOW_FPS / refurbish) <= Data.WINDOW_FPS / refurbish / 2){
			imgid = 1;
		}
		if (imgid == 1 && fps % (Data.WINDOW_FPS / refurbish) <=  Data.WINDOW_FPS / refurbish && fps % (Data.WINDOW_FPS / refurbish) > Data.WINDOW_FPS / refurbish / 2){
			imgid = 0;
		}
	}
	
	public void draw(Graphics g, CreateCanvas cc) {
		if (imgid == 1){
			g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
					34 * img_x + 1, 34 * img_y + 1, 34 * (img_x + 1) - 1, 34 * (img_y + 1) - 1, cc);
		}else {
//			g.drawImage(Data.TANK_PLAN, material_x + Data.MIN_X, material_y + Data.MIN_Y, material_x + 32 + Data.MIN_X, material_y + 32 + Data.MIN_Y, 
//					34 * 20 + 1, 34 * 10 + 1, 34 * 21 - 1, 34 * 11 - 1, cc);
		}
	}
	
	public void downKey(int num){
		if (num == 0){
			material_y -= 32;
			if (material_y <= 0){
				material_y = 0;
			}
			down_key = false;
		}else if (num == 1){
			material_y += 32;
			if (material_y >= 384){
				material_y = 384;
			}
			down_key = false;
		}else if (num == 2){
			material_x -= 32;
			if (material_x <= 0){
				material_x = 0;
			}
			down_key = false;
		}else if (num == 3){
			material_x += 32;
			if (material_x >= 384){
				material_x = 384;
			}
			down_key = false;
		}else if (num == 4){
			if (down_key){
				select++;
				if (select > 12){
					select = 0;
				}
				selectMaterial();
			}else {
				selectMaterial();
			}
			
			
			down_key = true;
			
		}else if (num == 5){
			if (down_key){
				select--;
				if (select < 0){
					select = 12;
				}
				selectMaterial();
			}else {
				selectMaterial();
			}
			
			
			down_key = true;
			
		}else if (num == 6){
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Map.tmp"));
				oos.writeObject(Data.matarry);
				oos.close();
					System.out.println("已保存");
//					ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Map.tmp"));
//					Data.matarry = (CopyOnWriteArrayList<Material>) ois.readObject();
//					ois.close();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			Data.matarry.clear();
			new GameStart();
			Data.start = 3;
		}
		
		
//		System.out.println(directions_x + "..." + directions_x);
	}
	
	public void selectMaterial(){
		if (select == 0){
			DelMaterial();
		}else if (select == 1){
			Material mat1 = new Grass(4, 7, material_x, material_y, 3);
			DelMaterial();
			Data.matarry.add(mat1);
		}else if (select == 2){
			Material mat1 = new Sea(0, 7, material_x, material_y, 2);
			DelMaterial();
			Data.matarry.add(mat1);
		}else if (select == 3){
			DelMaterial();
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					Data.matarry.add(new Hard(0, 0, material_x + i * 16, material_y + j * 16, 3));
				}
			}
		}else if (select == 4){
			DelMaterial();
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 1; j++) {
					Data.matarry.add(new Hard(0, 0, material_x + i * 16, material_y + j * 16, 3));
				}
			}
		}else if (select == 5){
			DelMaterial();
			for (int i = 0; i < 1; i++) {
				for (int j = 0; j < 2; j++) {
					Data.matarry.add(new Hard(0, 0, material_x + i * 16, material_y + j * 16, 3));
				}
			}
		}else if (select == 6){
			DelMaterial();
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 1; j++) {
					Data.matarry.add(new Hard(0, 0, material_x + i * 16, material_y + j * 16 + 16, 3));
				}
			}
		}else if (select == 7){
			DelMaterial();
			for (int i = 0; i < 1; i++) {
				for (int j = 0; j < 2; j++) {
					Data.matarry.add(new Hard(0, 0, material_x + i * 16 + 16, material_y + j * 16, 3));
				}
			}
		}else if (select == 8){
			DelMaterial();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					Data.matarry.add(new Wall(0, 0, material_x + i * 8 ,material_y + j * 8, 3));
				}
			}
		}else if (select == 9){
			DelMaterial();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 2; j++) {
					Data.matarry.add(new Wall(0, 0, material_x + i * 8 ,material_y + j * 8, 3));
				}
			}
		}else if (select == 10){
			DelMaterial();
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					Data.matarry.add(new Wall(0, 0, material_x + i * 8 ,material_y + j * 8, 3));
				}
			}
		}else if (select == 11){
			DelMaterial();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 2; j++) {
					Data.matarry.add(new Wall(0, 0, material_x + i * 8,material_y + j * 8 + 16, 3));
				}
			}
		}else if (select == 12){
			DelMaterial();
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					Data.matarry.add(new Wall(0, 0, material_x + i * 8 + 16,material_y + j * 8, 3));
				}
			}
		}
		
		
	}
	
	public void DelMaterial(){
		for (Material mat : Data.matarry) {
			if (mat.material_x / 32 == material_x /32 && mat.material_y / 32 == material_y / 32){
				Data.matarry.remove(mat);
			}
		}
	}
}
