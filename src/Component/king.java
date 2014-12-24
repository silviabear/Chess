package Component;

import java.awt.Color;

import Validator.moveValidator;

public class king extends Piece{
	public king(Color color, Board o){
		super(color, o);
	}
	@Override
	protected boolean validate(moveValidator validator){
		if(Math.abs(this.x - x) > 1 || Math.abs(this.y - y) > 1)
			return false;
		return true;
	}
}
