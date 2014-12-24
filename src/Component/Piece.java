package Component;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class Piece extends Observable {
	private Color color;
	private Board board;
	private int x;
	private int y;
	public Piece(Color color, Board board){
		this.color = color;
		this.board = board;
	}
	public boolean move(int dx, int dy){
		if(!validate(x, y))
			return false;
		this.x = this.x + dx;
		this.y = this.y + dy;
		return true;
	}
	public boolean validate(int dx, int dy){
		return false;
	}
}
