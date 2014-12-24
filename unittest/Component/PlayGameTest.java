package Component;

import java.awt.Color;

import org.junit.Test;

import Component.Board;
import Component.Piece;
import junit.framework.TestCase;
public class PlayGameTest extends TestCase{
	Board board;
	@Test
	public void testInitiate(){
		board = new Board();
		assertTrue(board.getPieces().length == 8);
	}
}
