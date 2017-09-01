package com.young.tank;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class CreateCanvas extends JPanel{

	/**
	 * Time:20170324
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(Data.MIN_X, Data.MIN_Y, 416, 416);
		
		
		for (Material mat : Data.matarry) {
			mat.draw(g, this);
		}
		
		
		
		if (Data.start == 1){
			TankOther.draw(g, this);
		}
		if (Data.start == 2){
			Data.create_map.draw(g, this);
		}
		if (Data.start == 3){
			GameStart.draw(g, this);
		}
		
//		g.drawImage(imge(Data.TANK_PLAN), Data.tank_x, Data.tank_y , Data.tank_x + 32, Data.tank_y + 32, 
//				34 * Data.IMGE_x + 1, 34 * Data.IMGE_y + 1, 34 * (Data.IMGE_x + 1) - 1, 34 * (Data.IMGE_y + 1) - 1, this);
		
//		g.drawImage(imge(Data.TANK_PLAN), Data.tank_x, Data.tank_y, Data.tank_x + 32, Data.tank_y + 64, 
//				34 * Data.IMGE_x + 1, 34 * Data.IMGE_y + 1, 34 * (Data.IMGE_x + 1) - 1, 34 * (Data.IMGE_y + 1) - 1, this);
		//0,0 画在JPanel左上顶点坐标
		//0,0画在JPanel 的右下顶点
		//0,0 选取图片的左上顶点
		//0,0选取图片的右下顶点
	}
	
	public Image imge(String path){
		return Toolkit.getDefaultToolkit().getImage(new Data().getClass().getResource(path));
	}
	
	
}
