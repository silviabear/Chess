package Component;

import java.awt.Color;

import Validator.moveValidator;

public class rook extends Piece{

	public rook(Color color, Board o, int x, int y) {
		super(color, o, x, y);
		// TODO Auto-generated constructor stub
	}	
	@Override
	protected boolean validate(moveValidator validator){
		if(!validator.validateStraight())
			return false;
		if(!validator.validateNoLeap()){
			System.out.println("ben");
			return false;}
		return true;
	}
}
