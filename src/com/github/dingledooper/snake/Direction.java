package com.github.dingledooper.snake;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public enum Direction {
	
	UP,
	DOWN,
	LEFT,
	RIGHT,
	NEUTRAL;
	
	private static Map<Direction, Point> directions = new HashMap<Direction, Point>() {
		
		private static final long serialVersionUID = -1212372444009830384L;
		
	{
		put(UP,      new Point(0, -1));
		put(DOWN,    new Point(0, 1));
		put(LEFT,    new Point(-1, 0));
		put(RIGHT,   new Point(1, 0));
		put(NEUTRAL, new Point(0, 0));
	}};
	
	public static Point getCoordinates(Direction direction) {
		return directions.get(direction);
	}

}