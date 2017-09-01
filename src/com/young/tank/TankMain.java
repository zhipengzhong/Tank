package com.young.tank;

import java.net.MalformedURLException;

public class TankMain{
	static CreateWindow window;

	public static void main(String[] args) throws MalformedURLException {
//		new AudioPlay().play("src\\com\\young\\tank\\bu.wav");
//		new AudioPlay().loop("src\\com\\young\\tank\\move.wav");
		window = new CreateWindow(Data.WINDOW_TITLE, Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT, Data.WINDOW_FPS, Data.WINDOW_ICOIMG);
	}
}