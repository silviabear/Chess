package Component;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class PieceOperationTest extends TestCase {
	Board board;
	@Before
	public void setUp(){
		board = new Board();
	}
	@Test
	public void testKnightMove(){
		knight piece = board.getKnight().get(Color.black).get(0);
		assertFalse(piece.move(1, 1));
		assertTrue(piece.move(2, 2)); 
	}
	@Test
	public void testQueenMove(){
		queen piece = board.getQueen().get(Color.black);
		assertFalse(piece.move(5, 3));
		Piece p = board.getPieces()[1][3];
		p.move(3, 3);
		p.move(4, 3);
		p.move(5, 3);
		assertTrue(piece.move(4, 3));
		assertTrue(piece.move(4, 6));
		assertTrue(piece.move(5, 7));
		assertFalse(piece.move(3, 2));
	}
	@Test
	public void testBishopMove(){
		bishop piece = board.getBishop().get(Color.black).get(0);
		assertFalse(piece.move(1, 0));
		assertFalse(piece.move(2, 4));
		Piece p = board.getPieces()[1][3];
		p.move(3, 3);
		assertTrue(piece.move(2, 4));
	}
	@Test
	public void testRookMove(){
		rook piece = board.getRook().get(Color.black).get(0);
		assertFalse(piece.move(3, 0));
		pawn p = board.getPawn().get(Color.black).get(0);
		p.move(3, 0);  
		assertTrue(piece.move(2, 0));
		assertTrue(piece.move(2, 6));
		assertFalse(piece.move(5, 4));
	}
	@Test
	public void testKingMove(){
		king piece = board.getKing().get(Color.black);
		assertFalse(piece.move(0, 3));
		Piece p = board.getPieces()[1][3];
		p.move(2, 3);
		assertTrue(piece.move(1, 3)); 
		assertFalse(piece.move(4, 5));
	}
	@Test
	public void testPawnMove(){
		pawn piece = board.getPawn().get(Color.black).get(0);
	    assertTrue(piece.move(3, 0));
	    assertTrue(piece.move(4, 0));
	    assertTrue(piece.move(5, 0)); 
	    assertFalse(piece.move(5, 1));
	    assertTrue(piece.move(6, 1));  
	    assertFalse(piece.move(3, 4));
	    piece = board.getPawn().get(Color.white).get(0);
	    assertTrue(piece.move(4, 0));
	    assertTrue(piece.move(3, 0));
	    assertTrue(piece.move(2, 0)); 
	    assertFalse(piece.move(2, 1));
	    assertTrue(piece.move(1, 1));  
	    assertFalse(piece.move(3, 4));
	}
}
