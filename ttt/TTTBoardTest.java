package ttt;

import static org.junit.Assert.*;

import org.junit.Test;

public class TTTBoardTest {
	
	/**
	 * makes sure the isWon method is working
	 * properly
	 */
	@Test
	public void testIsWon() {
		TTTBoard tboard = new TTTBoard();
		tboard.move(1);
		tboard.move(4);
		tboard.move(3);
		tboard.move(5);
		tboard.move(2);
		assertEquals(true, tboard.isWon());
		tboard.reset();
		tboard.move(1);
		tboard.move(2);
		tboard.move(4);
		tboard.move(5);
		tboard.move(2);
		tboard.move(8);
		assertEquals(true, tboard.isWon());
		tboard.reset();
		tboard.move(1);
		tboard.move(2);
		tboard.move(4);
		tboard.move(5);
		tboard.move(2);
		assertEquals(false, tboard.isWon());
	}
	
	/**
	 * makes sure the isDrawn method is working
	 * properly
	 */
	@Test
	public void testIsDrawn() {
		TTTBoard tboard = new TTTBoard();
		tboard.move(5);
		tboard.move(3);
		tboard.move(6);
		tboard.move(4);
		tboard.move(1);
		tboard.move(9);
		tboard.move(2);
		tboard.move(8);
		tboard.move(7);
		assertEquals(true, tboard.isDrawn());
		tboard.reset();
		tboard.move(2);
		tboard.move(1);
		tboard.move(3);
		tboard.move(5);
		tboard.move(4);
		tboard.move(7);
		tboard.move(6);
		tboard.move(8);
		assertEquals(false, tboard.isDrawn());
	}
	
	@Test
	public void testExceptions() {
		// makes sure an exception is thrown if there is already a win
		TTTBoard tboard = new TTTBoard();
		tboard.move(1);
		tboard.move(4);
		tboard.move(3);
		tboard.move(5);
		tboard.move(2);
		try {
			tboard.move(9);
			fail("pls throw an error.");
		} catch (IllegalArgumentException e) {
		}
		
		tboard.reset();
		
		// makes sure exception is thrown if there is already a draw
		tboard.move(2);
		tboard.move(1);
		tboard.move(3);
		tboard.move(5);
		tboard.move(4);
		tboard.move(7);
		tboard.move(6);
		tboard.move(8);
		tboard.move(9);
		
		try {
			tboard.move(1);
			fail("should be an error here");
		} catch (IllegalArgumentException e) {
		}
		
		tboard.reset();
		
		// makes sure an exception is thrown if that position is already taken
		tboard.move(1);
		try {
			tboard.move(1);
			fail("where r u error?");
		} catch(IllegalArgumentException e) {
		}
		
		tboard.reset();
		try {
			tboard.move(10);
			fail("c'mon man. error pls.");
		} catch(IllegalArgumentException e) {
		}
	}
	
	@Test
	public void testGetToMove() {
		TTTBoard tboard = new TTTBoard();
		assertEquals("X", tboard.getToMove());
		tboard.move(1);
		assertEquals("O", tboard.getToMove());
		tboard.move(4);
		assertEquals("X", tboard.getToMove());
		tboard.move(3);
		assertEquals("O", tboard.getToMove());
		tboard.move(5);
		assertEquals("X", tboard.getToMove());
		tboard.move(2);
		assertEquals("O", tboard.getToMove());
	}
	
	/**
	 * makes sure all the getters (getXWins, getOWins, getDrawCount)
	 * are working properly
	 */
	@Test
	public void testGetters() {
		// test xwins getter
		TTTBoard tboard = new TTTBoard();
		tboard.move(1);
		tboard.move(4);
		tboard.move(3);
		tboard.move(5);
		tboard.move(2);
		tboard.reset();
		tboard.move(1);
		tboard.move(4);
		tboard.move(3);
		tboard.move(5);
		tboard.move(2);
		tboard.reset();
		tboard.move(1);
		tboard.move(4);
		tboard.move(3);
		tboard.move(5);
		tboard.move(2);
		tboard.reset();
		assertEquals(3, tboard.getXWins());
		
		// test owins getter
		tboard.move(1);
		tboard.move(2);
		tboard.move(4);
		tboard.move(5);
		tboard.move(2);
		tboard.move(8);
		tboard.reset();
		tboard.move(1);
		tboard.move(2);
		tboard.move(4);
		tboard.move(5);
		tboard.move(2);
		tboard.move(8);
		tboard.reset();
		tboard.move(1);
		tboard.move(2);
		tboard.move(4);
		tboard.move(5);
		tboard.move(2);
		tboard.move(8);
		tboard.reset();
		tboard.move(1);
		tboard.move(2);
		tboard.move(4);
		tboard.move(5);
		tboard.move(2);
		tboard.move(8);
		tboard.reset();
		assertEquals(4, tboard.getOWins());
		
		// test draws getter
		tboard.move(5);
		tboard.move(3);
		tboard.move(6);
		tboard.move(4);
		tboard.move(1);
		tboard.move(9);
		tboard.move(2);
		tboard.move(8);
		tboard.move(7);
		tboard.reset();
		assertEquals(1, tboard.getDrawCount());
	}
}
