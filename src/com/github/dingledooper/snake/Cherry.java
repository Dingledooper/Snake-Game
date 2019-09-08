package com.github.dingledooper.snake;

import java.awt.Point;
import java.util.Random;

public class Cherry {
	
	public static final int SIZE = 18, SCALE = 20;
	
	private Snake snake;
	private Random random;
	
	private int x, y;
	
	public Cherry(Snake snake) {
		this.snake = snake;
		random = new Random();
	}
	
	public void spawn() {
		do {
			x = random.nextInt(30);
			y = random.nextInt(30) + 2;
		} while (snake.contains(new Point(x, y)));
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}