package Component;

import java.awt.Color;
import java.util.Observable;
import Validator.moveValidator;
public class Piece extends Observable {
	protected Color color;
	protected Board board;
	protected int x;
	protected int y;
	public Piece(Color color, Board board){
		this.color = color;
		this.board = board;
	}
	public boolean move(int x, int y){
		moveValidator validator = new moveValidator(this, x, y);
		if(!validator.validateBoundary()) return false;
		if(!validate(validator))
			return false;
		this.x = x;
		this.y = y;
		return true;
	}
	protected boolean validate(moveValidator validator){
		return true;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public Board getBoard(){
		return this.board;
	}
}
