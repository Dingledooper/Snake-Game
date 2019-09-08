package com.github.dingledooper.snake;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

public class Paint {
	
	private Game game;
	private Graphics2D g2d;
	private Snake snake;
	private Cherry cherry;
	
	private static String scoreString;

	public Paint(Game game, Graphics2D g2d, Snake snake, Cherry cherry) {
		this.game = game;
		this.g2d = g2d;
		this.snake = snake;
		this.cherry = cherry;
		
		scoreString = Integer.toString(game.score);
		if (game.status == Status.PLAY) {
			update();
			render();
		} else {
			gameOver();
		}
	}
	
	public void update() {
		snake.turn(snake.getDirection());
		snake.eat(cherry);
	}
	
	public void render() {
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, 0, Game.WIDTH, Game.BORDERY);
		
		g2d.setColor(new Color(0, 100, 0));
		g2d.setStroke(new BasicStroke(4));
		g2d.drawRect(2, Game.BORDERY, Game.WIDTH - 2, Game.HEIGHT - Game.BORDERY - 2);
		
		g2d.setColor(Color.GREEN);
		for (Point p : snake.getTail()) {
			g2d.fillRect(p.x * Snake.SCALE, p.y * Snake.SCALE, Snake.SIZE, Snake.SIZE);
		}
		
		g2d.setColor(Color.RED);
		g2d.fillRect(cherry.getX() * Cherry.SCALE, cherry.getY() * Cherry.SCALE, Cherry.SIZE, Cherry.SIZE);
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.setFont(new Font("Arial", Font.PLAIN, 24));
		g2d.drawString("Score: " + game.score, 50, 28);
		g2d.drawString("Best Score: " + game.bestScore, 400, 28);
	}
	
	public void gameOver() {
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Monospaced", Font.PLAIN, 50));
		g2d.drawString("GAME OVER!", (Game.WIDTH - g2d.getFontMetrics().stringWidth("GAME OVER!")) / 2, 300);
		g2d.drawString("Your score:", (Game.WIDTH - g2d.getFontMetrics().stringWidth("Your score:")) / 2, 360);
		g2d.drawString(scoreString, (Game.WIDTH - g2d.getFontMetrics().stringWidth(scoreString)) / 2, 420);
	}

}