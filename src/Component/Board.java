package Component;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Board implements Observer{
	private Piece[][] pieces;
	private HashMap<Color, king> King;
	private HashMap<Color, queen> Queen;
	private HashMap<Color, ArrayList<rook>> Rook;
	private HashMap<Color, ArrayList<bishop>> Bishop;
	private HashMap<Color, ArrayList<knight>> Knight;
	private HashMap<Color, ArrayList<pawn>> Pawn; 
	public Board(){
		pieces = new Piece[8][8];
		initiate(Color.black, 0, 1);
		initiate(Color.white, 7, 6);
		for(int i = 2; i < 6; i++)
			for (int j = 0; j < 8; j++)
				pieces[i][j] = null;
	}
	private void initiate(Color color, int row1, int row2){
		King.put(color, new king(color, this));
		pieces[row1][4] = King.get(color);	
		Queen.put(color, new queen(color, this));
		pieces[row1][3] = Queen.get(color);
		ArrayList<rook> trook = new ArrayList<rook>();
		trook.add(new rook(color, this));
		pieces[row1][0] = trook.get(0);
		trook.add(new rook(color, this));
		pieces[row1][7] = trook.get(1);
		Rook.put(color, trook);
		ArrayList<bishop> tbishop = new ArrayList<bishop>();
		tbishop.add(new bishop(color, this));
		pieces[row1][2] = tbishop.get(0);
		tbishop.add(new bishop(color, this));
		pieces[row1][5] = tbishop.get(1);
		Bishop.put(color, tbishop);
		ArrayList<knight> tknight = new ArrayList<knight>();
		tknight.add(new knight(color, this));
		pieces[row1][1] = tknight.get(0);
		tknight.add(new knight(color, this));
		pieces[row1][6] = tknight.get(1);
		Knight.put(color, tknight);
		ArrayList<pawn> tpawn = new ArrayList<pawn>();
		for(int i = 0; i < 8; i++){
			tpawn.add(new pawn(color, this));
			pieces[row2][i] = tpawn.get(i);
		}
		Pawn.put(color, tpawn);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	public Piece[][] getPieces(){
		return this.pieces;
	}
}
