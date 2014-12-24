package Component;

import java.awt.Color;

import Validator.moveValidator;

public class bishop extends Piece {
	public bishop(Color color, Board o) {
		super(color, o);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected boolean validate(moveValidator validator){
		if(!validator.validateNoLeap())
			return false;
		return true;
	}
}
