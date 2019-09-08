package com.github.dingledooper.snake;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 825099357120395617L;

	public Window(Game game, String title, int width, int height) {
		super(title);

		add(game);
		pack();
		
		int x = getInsets().left + getInsets().right, y = getInsets().top + getInsets().bottom;
		setPreferredSize(new Dimension(width + x, height + y));
		setMaximumSize(new Dimension(width + x, height + y));
		setMinimumSize(new Dimension(width + x, height + y));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}