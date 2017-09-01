package com.young.tank;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AudioPlay {
	AudioClip clip;
	
	
	public void play(final String path){
		new Thread(){
			public void run(){
				File file = new File(path); 
				URL radio = null;
				try {
					radio = file.toURI().toURL();
				} catch (MalformedURLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				clip = Applet.newAudioClip(radio);
				clip.play();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
//				new Applet().play(radio);
			}
		}.start();
	}
	
	public void loop(String path){
//		new Thread(){
//			public void run(){
				File file = new File(path); 
				URL radio = null;
				try {
					radio = file.toURI().toURL();
				} catch (MalformedURLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				clip = Applet.newAudioClip(radio);
				clip.loop();
//				try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e) {
//					// TODO 自动生成的 catch 块
//					e.printStackTrace();
//				}
//			}
//		}.start();
	}
	
	public void stop(){
//		new Thread(){
//			public void run(){
				clip.stop();
//			}
//		}.start();
	}
}
