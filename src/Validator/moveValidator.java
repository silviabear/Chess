package Validator;

import Component.Piece;
public class moveValidator {
	Piece piece;
	int x;
	int y;
	public moveValidator(Piece piece, int x, int y){
		this.piece = piece;
		this.x = x;
		this.y = y;
	}
	public boolean validateBoundary(){
		if(x > 7 || x < 0 || y >7 || y < 0)
			return false;
		return true;
	}	
   public boolean validateNoLeap(){
	   if(validateStraight()){
		   if(x != piece.getX()){
			   for(int i = Math.min(piece.getX(), x); i <= Math.max(piece.getX(), x); i++){
				   if(piece.getBoard().getPieces()[i][y] != null)
					   return false;
			   }
		   }
		   else{
			   for(int i = Math.min(piece.getY(), y); i <= Math.max(piece.getY(), y); i++){
				   if(piece.getBoard().getPieces()[x][i] != null)
					   return false;
			   }
		   }
	   }
	   return true;
   }
   public boolean validateStraight(){
	   if(x != piece.getX() && y != piece.getY())
		   return false;
	   return true;
   }
}
