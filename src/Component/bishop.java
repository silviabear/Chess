package Component;

import java.awt.Color;

import Validator.moveValidator;

public class bishop extends Piece {
	public bishop(Color color, Board o, int x, int y) {
		super(color, o, x, y);
	}
	@Override
	protected boolean validate(moveValidator validator){
		if(!validator.validateDiagonal())
			return false;
		if(!validator.validateNoLeap())
			return false;
		return true;
	}
}
