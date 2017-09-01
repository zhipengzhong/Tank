package com.young.tank;

import java.awt.Graphics;
import java.io.Serializable;

public abstract class Material implements Serializable{
	private static final long serialVersionUID = 1L;
	public int img_x;
	public int img_y;
	public int material_x;
	public int material_y;
	public int refurbish;
	public int imgid = 0;
	public int size_x = 32;		//默认尺寸32
	public int size_y = 32;
	
	public int attack_id;		//可被攻击子弹等级
	public boolean ispenetrate;	//是否可被穿透
	public boolean ispass;
	
	public Material(int img_x, int img_y, int material_x, int material_y, int refurbish) {
		super();
		this.img_x = img_x;
		this.img_y = img_y;
		this.material_x = material_x;
		this.material_y = material_y;
		this.refurbish = refurbish;
	}

	public int getImg_x() {
		return img_x;
	}

	public void setImg_x(int img_x) {
		this.img_x = img_x;
	}

	public int getImg_y() {
		return img_y;
	}

	public void setImg_y(int img_y) {
		this.img_y = img_y;
	}

	public int getMaterial_x() {
		return material_x;
	}

	public int getMaterial_y() {
		return material_y;
	}

	public int getRefurbish() {
		return refurbish;
	}

	public void setRefurbish(int refurbish) {
		this.refurbish = refurbish;
	}
	
	public abstract void setMaterial_x(int material_x);
	
	public abstract void setMaterial_y(int material_y);
	
	public abstract void anew(int fps);
	
	public abstract void draw(Graphics g, CreateCanvas cc);
	
	public abstract void wounded(Bullet bullet, int principal, int directions, int num);
}
