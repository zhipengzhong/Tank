package com.young.tank;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.concurrent.CopyOnWriteArrayList;

public class Data {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 480;
	public static final int WINDOW_FPS = 100;
	public static final String WINDOW_TITLE = "《坦克大战》author：钟志鹏";
	public static final Image WINDOW_ICOIMG = Toolkit.getDefaultToolkit().getImage(new Data().getClass().getResource("ico.png"));
	public static final Image TANK_PLAN = Toolkit.getDefaultToolkit().getImage(new Data().getClass().getResource("tank_sprite.png"));//tank_sprite//space_sprite_full1
	public static final Image Start_Img = Toolkit.getDefaultToolkit().getImage(new Data().getClass().getResource("tank_main.png"));
	
	
	public static CopyOnWriteArrayList<Material> matarry = new CopyOnWriteArrayList<Material>();
	public static CreateMap create_map = new CreateMap();
	public static TankOther tank_othe;
	public static Material mat;
	
	public static final int TANKE_REGION_MIN_X = 0;
	public static final int TANKE_REGION_MIN_Y = 0;
	public static final int TANKE_REGION_MAX_X = 416;
	public static final int TANKE_REGION_MAX_Y = 416;
	public static final int MIN_X = 65;
	public static final int MIN_Y = 35;
	public static final int MAX_X = MIN_X + 416;
	public static final int MAX_Y = MIN_Y + 416;
	
	
	public static int start = 3;
	public static int IMGE_x = 4;
	public static int IMGE_y = 5;
	public static int tank_x = 45;
	public static int tank_y = 35;
}
