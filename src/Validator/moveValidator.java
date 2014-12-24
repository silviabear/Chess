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
	public boolean validateNotSelf(){
		if(piece.getBoard().getPieces()[x][y] != null){
			if(piece.getBoard().getPieces()[x][y].getColor() != piece.getColor())
				return true;
			return false;
		}
		return true;
	}
	public boolean validateBoundary(){
		if(x > 7 || x < 0 || y >7 || y < 0)
			return false; 
		return true;
	}	
   public boolean validateNoLeap(){
	   if(validateStraight()){
		   if(x != piece.getX()){ 
			   for(int i = Math.min(piece.getX(), x); i < Math.max(piece.getX(), x); i++){
				   if(piece.getBoard().getPieces()[i][y] != null && i != Math.min(piece.getX(), x)){
					   return false;}
			   }
		   } 
		   else{
			   for(int i = Math.min(piece.getY(), y); i < Math.max(piece.getY(), y); i++){
				   if(piece.getBoard().getPieces()[x][i] != null && i != Math.min(piece.getY(), y))
					   return false;
			   }
		   } 
	   }
	   else{
		   for(int i = Math.min(piece.getX(), x); i < Math.max(piece.getX(), x); i++){
				   if(piece.getBoard().getPieces()[i][piece.getY() - 
				      Math.abs(piece.getX() - x)/(piece.getX() - x)*
				      (i - Math.min(piece.getX(), x))] != null
				      && i != Math.min(piece.getX(), x))
					   return false; 
		   }
	   }
	   return true;
   }
   public boolean validateStraight(){
	   if(x != piece.getX() && y != piece.getY())
		   return false;
	   return true;
   }
   public boolean validateDiagonal(){
	   if(Math.abs(piece.getX() - x) != Math.abs(piece.getY() - y))
		   return false;
	   return true;
   }
   public int getX(){
	   return this.x;
   }
   public int getY(){
	   return this.y;
   }
 
}
