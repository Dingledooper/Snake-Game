package com.github.dingledooper.snake;

import java.awt.Point;
import java.util.LinkedList;

public class Snake {
	
	public static final int SIZE = 18, SCALE = 20;

	private Game game;
	private Point head;
	private LinkedList<Point> tail;
	private Direction direction;
	
	public Snake(Game game, int x, int y) {
		this.game = game;
		
		head = new Point(x, y);
		tail = new LinkedList<Point>();
		tail.add(head);
		
		direction = Direction.NEUTRAL;
	}
	
	public void turn(Direction direction) {
		Point dir = Direction.getCoordinates(direction);
		
		head = new Point(head.x + dir.x, head.y + dir.y);
		tail.addFirst(head);
		tail.removeLast();
	}
	
	public void eat(Cherry cherry) {
		if (equals(cherry)) {
			cherry.spawn();
			addTail();
			
			game.score++;
			game.bestScore = Math.max(game.score, game.bestScore);
		}
	}
	
	public void addTail() {
		Point dir = Direction.getCoordinates(direction); 
		tail.addLast(new Point(head.x + dir.x, head.y + dir.y));
	}
	
	public Point getHead() {
		return head;
	}

	public LinkedList<Point> getTail() {
		return tail;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setHead(Point head) {
		this.head = head;
	}

	public void setTail(LinkedList<Point> tail) {
		this.tail = tail;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public boolean collides(Point p) {
		for (int i = 1; i < tail.size(); i++) {
			if (tail.get(i).getX() == p.getX() && tail.get(i).getY() == p.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(Point p) {
		for (Point t : tail) {
			if (t.getX() == p.getX() && t.getY() == p.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(Cherry cherry) {
		return head.getX() == cherry.getX() && head.getY() == cherry.getY();
	}
	
}