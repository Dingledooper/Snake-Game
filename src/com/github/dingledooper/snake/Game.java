package com.github.dingledooper.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Game extends JPanel {

	private static final long serialVersionUID = -1740374726318204194L;
	
	public static final int WIDTH = 600, HEIGHT = 640;
	public static final int DELAY = 100;
	public static final int BORDERY = 40;
	
	public Status status;
	public int score, bestScore;
	
	private Snake snake;
	private Timer timer;
	private Cherry cherry;
	private Random random = new Random();

	public Game() {
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		
		setStatus(Status.PLAY);
		cherry = new Cherry(snake);
		cherry.spawn();
				
		new Window(this, "Snake", WIDTH, HEIGHT);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		new Paint(this, (Graphics2D) g, snake, cherry);
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void setStatus(Status status) {
		this.status = status;
		
		switch (status) {
		case PLAY:
			snake = new Snake(this, random.nextInt(30), random.nextInt(30) + 2);
			addKeyListener(new KeyInput(this, snake));
			
			timer = new Timer();
			timer.schedule(new GameLoop(), 0, DELAY);
			
			score = 0;
			break;
		case OVER:
			timer.cancel();
			break;
		}
	}
	
	public void checkOver() {
		Point head = snake.getHead();
		if (head.getX() < 0 || head.getX() > 29
		 || head.getY() < 2 || head.getY() > 31
		 || snake.collides(head)) {
			setStatus(Status.OVER);
		}
	}
	
	private class GameLoop extends TimerTask {
		
		@Override
		public void run() {
			checkOver();
			repaint();
		}
		
	}
	
}