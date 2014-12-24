package Component;

import java.awt.Color;

import Validator.moveValidator;

public class knight extends Piece{

	public knight(Color color, Board o, int x, int y) {
		super(color, o, x, y);
	}
	@Override
	protected boolean validate(moveValidator validator){
		if(Math.abs(validator.getX() - x )*Math.abs(validator.getY() - y) != 2)
			   return false;
		   return true;
	}
}
