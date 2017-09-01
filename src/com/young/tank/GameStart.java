package com.young.tank;

import java.awt.Graphics;

public class GameStart {
	
	private static int start_id;
	private static int fps = 0;
	
	public GameStart() {
//		new AudioPlay().play("src\\com\\young\\tank\\hi.wav");
	}

	public static void downKey(int i) {
		if (i == 7){
			start_id++;
			if (start_id >= 3){
				start_id = 0;
			}
		}else if (i == 6){
			if (start_id == 2){
				Data.matarry.clear();
				new CreateMap();
				Data.start = 2;
			}else if (start_id == 0){
				Data.matarry.clear();
				new TankOther();
				Data.start = 1;
			}
		}
		
	}

	public static void anew(int n) {
		
	}

	public static void draw(Graphics g, CreateCanvas createCanvas) {
		
		fps++;
		if (fps >= 10000){
			fps = 0;
		}
		
		g.drawImage(Data.Start_Img, 0, 0, Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT, 
				0, 0, Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT, createCanvas);
		
		if (fps % (Data.WINDOW_FPS / 5) <= Data.WINDOW_FPS / 5 / 2){
			g.drawImage(Data.TANK_PLAN, 170, 270 + start_id * 32, 170 +32, 270 +32 + start_id * 32, 
					68 + 1, 34 * 8 + 1, 102 - 1, 34 * 9 - 1, createCanvas);
		}
		if (fps % (Data.WINDOW_FPS / 5) <=  Data.WINDOW_FPS / 5 && fps % (Data.WINDOW_FPS / 5) > Data.WINDOW_FPS / 5 / 2){
			g.drawImage(Data.TANK_PLAN, 170, 270 + start_id * 32, 170 +32, 270 +32 + start_id * 32, 
					102 + 1, 34 * 8 + 1, 136 - 1, 34 * 9 - 1, createCanvas);
		}
		
		
	}

}
