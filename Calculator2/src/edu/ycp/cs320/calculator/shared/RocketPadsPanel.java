package edu.ycp.cs320.calculator.shared;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

	public class RocketPadsPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		private static final int WIDTH = 900;
		private static final int HEIGHT = 900;
		
		// TODO: add fields to store state
		int[][] board = new int[3][3];
		
		// constructor
		public RocketPadsPanel() {
			setPreferredSize(new Dimension(WIDTH, HEIGHT));
			setBackground(Color.BLACK);
		}
				
		@Override
		public void paint(Graphics g) {
			super.paint(g); // paint background
			g.setColor(Color.WHITE);
			
			g.drawLine(75, 0, 75, 900);
			g.drawLine(150, 0, 150, 900);
			g.drawLine(225, 0, 225, 900);
			g.drawLine(300, 0, 300, 900);
			g.drawLine(375, 0, 375, 900);
			g.drawLine(450, 0, 450, 900);
			g.drawLine(525, 0, 525, 900);
			g.drawLine(600, 0, 600, 900);
			g.drawLine(675, 0, 675, 900);
			g.drawLine(750, 0, 750, 900);
			g.drawLine(825, 0, 825, 900);
			g.drawLine(900, 0, 900, 900);
			
			g.drawLine(0, 75, 900, 75);
			g.drawLine(0, 150, 900, 150);
			g.drawLine(0, 225, 900, 225);
			g.drawLine(0, 300, 900, 300);
			g.drawLine(0, 375, 900, 375);
			g.drawLine(0, 450, 900, 450);
			g.drawLine(0, 525, 900, 525);
			g.drawLine(0, 600, 900, 600);
			g.drawLine(0, 675, 900, 675);
			g.drawLine(0, 750, 900, 750);
			g.drawLine(0, 825, 900, 825);
			g.drawLine(0, 900, 900, 900);
			
			int x = 15;
			int y = 15;
			for(int a=0; a<3; a++){

				for(int i=0; i<3; i++){
					int nx = x + (i * 100);				
					int ny = y + (a * 100);
					
					if (board[a][i] == 1) {
						g.setColor(Color.GREEN);
						g.fillRect(nx,ny,75,75);
					}else if (board[a][i] == 2) {
						g.setColor(Color.BLUE);
						g.fillOval(nx, ny,75,75);
					}
				}
			}

			
		}
	
	
}
