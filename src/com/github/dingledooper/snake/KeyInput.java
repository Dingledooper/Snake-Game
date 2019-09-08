package com.github.dingledooper.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Game game;
	private Snake snake;
	
	public KeyInput(Game game, Snake snake) {
		this.game = game;
		this.snake = snake;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if ((keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP)    && snake.getDirection() != Direction.DOWN)  snake.setDirection(Direction.UP);
		if ((keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT)  && snake.getDirection() != Direction.RIGHT) snake.setDirection(Direction.LEFT);
		if ((keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN)  && snake.getDirection() != Direction.UP)    snake.setDirection(Direction.DOWN);
		if ((keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) && snake.getDirection() != Direction.LEFT)  snake.setDirection(Direction.RIGHT);
		
		if (keyCode == KeyEvent.VK_ENTER && game.status == Status.OVER) {
			game.setStatus(Status.PLAY);
		}
	}
	
}