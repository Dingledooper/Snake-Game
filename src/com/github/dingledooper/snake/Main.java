package com.github.dingledooper.snake;

import java.awt.EventQueue;

public class Main {
	
	public static final int WIDTH = 600, HEIGHT = 600;

	public Main() {
		new Game();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main();
			}
		});
	}
	
}