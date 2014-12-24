package Component;

import java.awt.Color;

import Validator.moveValidator;

public class pawn extends Piece{

	public pawn(Color color, Board o, int x, int y) {
		super(color, o, x, y);
	}
	@Override
	public boolean validate(moveValidator validator){
		int direction;
		int initialX;
		if(this.color == Color.black){
			direction = 1;
			initialX = 1;
		} 
		else{
			direction = -1;
			initialX = 6;
		}
		if(this.board.getPieces()[validator.getX()][validator.getY()] != null
				&& Math.abs(validator.getX() - x) == 1 
				&& Math.abs(validator.getY() - y) == 1)
			return true; 
		else if(validator.getY() != this.y)
			return false;
		else if(direction*(validator.getX() - this.x) == 1)
			return true;
		else if(direction*(validator.getX() - this.x) == 2 && this.x == initialX)
			return true;	
		else 
			return false;
	}
}
