package Component;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

public class Board{
	private Piece[][] pieces;
	private HashMap<Color, king> King;
	private HashMap<Color, queen> Queen;
	private HashMap<Color, ArrayList<rook>> Rook;
	private HashMap<Color, ArrayList<bishop>> Bishop;
	private HashMap<Color, ArrayList<knight>> Knight;
	private HashMap<Color, ArrayList<pawn>> Pawn; 
	private Color winner;
	public Board(){
		pieces = new Piece[8][8];
		King = new HashMap<Color, king>();
		Queen = new HashMap<Color, queen>();
		Rook = new HashMap<Color, ArrayList<rook>>();
		Bishop = new HashMap<Color, ArrayList<bishop>>();
		Knight = new HashMap<Color, ArrayList<knight>>();
		Pawn = new HashMap<Color, ArrayList<pawn>>();
		initiate(Color.black, 0, 1);
		initiate(Color.white, 7, 6);
		for(int i = 2; i < 6; i++)
			for (int j = 0; j < 8; j++)
				pieces[i][j] = null;
		winner = null;
	}
	private void initiate(Color color, int row1, int row2){
		King.put(color, new king(color, this, row1, 4));
		pieces[row1][4] = King.get(color);	
		Queen.put(color, new queen(color, this, row1, 3));
		pieces[row1][3] = Queen.get(color);
		ArrayList<rook> trook = new ArrayList<rook>();
		trook.add(new rook(color, this, row1, 0));
		pieces[row1][0] = trook.get(0);
		trook.add(new rook(color, this, row1, 7));
		pieces[row1][7] = trook.get(1);
		Rook.put(color, trook);
		ArrayList<bishop> tbishop = new ArrayList<bishop>();
		tbishop.add(new bishop(color, this, row1, 2));
		pieces[row1][2] = tbishop.get(0);
		tbishop.add(new bishop(color, this, row1, 5));
		pieces[row1][5] = tbishop.get(1);
		Bishop.put(color, tbishop);
		ArrayList<knight> tknight = new ArrayList<knight>();
		tknight.add(new knight(color, this, row1, 1));
		pieces[row1][1] = tknight.get(0);
		tknight.add(new knight(color, this, row1, 6));
		pieces[row1][6] = tknight.get(1);
		Knight.put(color, tknight); 
		ArrayList<pawn> tpawn = new ArrayList<pawn>();
		for(int i = 0; i < 8; i++){
			tpawn.add(new pawn(color, this, row2, i));
			pieces[row2][i] = tpawn.get(i);
		}
		Pawn.put(color, tpawn);
	}
	public void update(Piece piece, int x, int y) {
		this.pieces[x][y] = piece;
		if(this.King.containsKey(this.pieces[x][y])){
			end(this.pieces[x][y].getColor());
			return;
		}
		this.pieces[piece.getX()][piece.getY()] = null;
	}
	public void end(Color color){
		winner = color;
	}
	public Piece[][] getPieces(){
		return this.pieces;
	}
	public  HashMap<Color, king> getKing(){
		return this.King;
	}
	public HashMap<Color, queen> getQueen(){
		return this.Queen;
	}
	public HashMap<Color, ArrayList<rook>> getRook(){
		return this.Rook;
	}
	public HashMap<Color, ArrayList<bishop>> getBishop(){
		return this.Bishop;
	}
	public  HashMap<Color, ArrayList<knight>> getKnight(){
		return this.Knight;
	}
	public HashMap<Color, ArrayList<pawn>> getPawn(){
		return this.Pawn;
	}
}
