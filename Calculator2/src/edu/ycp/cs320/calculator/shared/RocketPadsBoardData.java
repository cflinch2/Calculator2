package edu.ycp.cs320.calculator.shared;

import java.io.Serializable;

public class RocketPadsBoardData implements Serializable {
	private RocketPadsDirection[][] data;
	
	public RocketPadsBoardData() {
		data = new RocketPadsDirection[RocketPadsGame.BOARD_HEIGHT][RocketPadsGame.BOARD_WIDTH];
	}
	
	public RocketPadsDirection getPad(int x, int y) {
		return data[y][x];
	}
	
	public void setPad(int x, int y, RocketPadsDirection pad) {
		data[y][x] = pad;
	}

}
