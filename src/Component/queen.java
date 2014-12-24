package Component;

import java.awt.Color;

import Validator.moveValidator;

public class queen extends Piece {
	public queen(Color color, Board o, int x, int y){
		super(color, o, x, y);
	}
	@Override
	protected boolean validate(moveValidator validator){
		if(!validator.validateStraight() && !validator.validateDiagonal())
			return false;
		if(!validator.validateNoLeap())
			return false;
		return true;
	}
}
