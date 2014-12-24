package Validator;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import Component.Board;
import Component.Piece;
import junit.framework.TestCase;

public class moveValidatorTest extends TestCase {
	Board board;
	moveValidator validator;
	@Before
	public void setUp(){
		board = new Board();
	}
	@Test
	public void testValidateBoundary(){
		Piece piece = new Piece(Color.black, board, 0, 0);
		validator = new moveValidator(piece, 8, 8);
		assertFalse(validator.validateBoundary());
		validator = new moveValidator(piece, 5, 5);
		assertTrue(validator.validateBoundary());
	}
	@Test
	public void testValidateNoLeap(){ 
		Piece piece = new Piece(Color.black, board, 0, 0);
		validator = new moveValidator(piece, 0, 3);
		assertFalse(validator.validateNoLeap());
		validator = new moveValidator(piece, 3, 3);
		assertFalse(validator.validateNoLeap());
		validator = new moveValidator(piece, 3, 0);
		assertFalse(validator.validateNoLeap());
		piece = new Piece(Color.black, board, 2, 2);
		validator = new moveValidator(piece, 6, 2);
		assertTrue(validator.validateNoLeap()); 
		validator = new moveValidator(piece, 2, 6);
		assertTrue(validator.validateNoLeap());
		validator = new moveValidator(piece, 5, 5);
		assertTrue(validator.validateNoLeap()); 
	}
	@Test
	public void testValidateStraight(){
		Piece piece = new Piece(Color.black, board, 0, 1);
		validator = new moveValidator(piece, 2, 3);
		assertFalse(validator.validateStraight());
		validator = new moveValidator(piece, 3, 1);
		assertTrue(validator.validateStraight()); 
	}
	@Test
	public void testValidateDiagonal(){
		Piece piece = new Piece(Color.black, board, 0, 0);
		validator = new moveValidator(piece, 2, 3);
		assertFalse(validator.validateDiagonal());
		validator = new moveValidator(piece, 3, 3);
		assertTrue(validator.validateDiagonal());
	}
	@Test
	public void testValidateNotSelf(){ 
		Piece piece = new Piece(Color.black, board, 0, 0);
		validator = new moveValidator(piece, 7, 0);
		assertTrue(validator.validateNotSelf()); 
		validator = new moveValidator(piece, 1, 0);
		assertFalse(validator.validateNotSelf());
	}
} 
