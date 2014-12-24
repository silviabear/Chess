package Component;

import java.awt.Color;

import Validator.moveValidator;

public class king extends Piece{
	public king(Color color, Board o, int x, int y){
		super(color, o, x, y);
	}
	@Override
	protected boolean validate(moveValidator validator){
		if(Math.abs(validator.getX() - x) > 1 || Math.abs(validator.getY() - y) > 1)
			return false;
		return true;
	}
}
