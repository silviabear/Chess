package Component;

import java.awt.Color;

import Validator.moveValidator;

public class rook extends Piece{

	public rook(Color color, Board o) {
		super(color, o);
		// TODO Auto-generated constructor stub
	}	
	@Override
	protected boolean validate(moveValidator validator){
		if(!validator.validateStraight())
			return false;
		if(!validator.validateNoLeap())
			return false;
		return true;
	}
}
