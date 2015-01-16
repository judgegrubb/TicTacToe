package ttt;

import java.util.ArrayList;

/**
 * Represents the state of a tic-tac-toe board. This specification assumes that
 * you know how to play tic-tac-toe. Consult Wikipedia if you don't.
 * 
 * A tic-tac-toe board consists of nine squares, numbered like this:
 * 
 * <pre>
 *  1 | 2 | 3 
 * ---+---+--- 
 *  4 | 5 | 6
 * ---+---+--- 
 *  7 | 8 | 9
 * </pre>
 * 
 * Each square can be unoccupied, contain an X, or contain an O.
 * 
 * Beginning from an empty board, the players take turns moving until X wins, O
 * wins, or there is a draw. X always moves first.
 * 
 * In addition, a tic-tac-toe board knows how many times X has won, how many
 * times O has won, and how many times there has been a draw.
 */
public class TTTBoard
{
	private int xWins;
	private int oWins;
	private int draws;
	private int playerTurn;
	private ArrayList<Integer> xPositions;
	private ArrayList<Integer> oPositions;
	private ArrayList<Integer> positions;
    /**
     * Constructs an empty board in which X has won zero times, O has won zero
     * times, and there have been no draws.
     */
    public TTTBoard () {
    	xWins = 0;
    	oWins = 0;
    	draws = 0;
    	playerTurn = 1;
    	xPositions = new ArrayList<Integer>();
    	oPositions = new ArrayList<Integer>();
    	positions = new ArrayList<Integer>();
    }

    /**
     * If the current position is a win for X, a win for O, or a draw, throws an
     * IllegalArgumentException.
     * 
     * If the specified square is already occupied, throws an
     * IllegalArgumentException.
     * 
     * If square is invalid (less than 1 or greater than 9), throws an
     * IllegalArgumentException.
     * 
     * Otherwise, if it is X's turn to move, records an X move to the specified
     * square and returns "X". If it is O's turn to move, records an O move to
     * the specified square and returns "O". If the move makes the position a
     * win for X, the "wins for X" count is incremented. If the move makes the
     * position a win for O, the "wins for O" count is incremented. If the move
     * makes the position a draw, the "draws" count is incremented.
     */
    public String move (int square)
    {
    	// exception is thrown if there is already a draw or win
    	if (isDrawn() || isWon()) {
    		throw new IllegalArgumentException();
    	}
    	
    	// exception is thrown if that position is already taken
    	if (xPositions.size() > 0) {
	    	if (xPositions.contains(square)) {
	    		throw new IllegalArgumentException();
	    	}
    	}
    	
    	if (oPositions.size() > 0) {
    		if (xPositions.contains(square)) {
	    		throw new IllegalArgumentException();
	    	}
    	}
    	
    	// throws exception if square is out of range
    	if (square < 1 || square > 9) {
    		throw new IllegalArgumentException();
    	}
    	
    	if (getToMove().equals("O")) {
    		oPositions.add(square);
    		positions.add(square);
    		if (isWon()) {
    			oWins++;
    		} else if(isDrawn()) {
    			draws++;
    		}
    		playerTurn++;
    		return "O";
    	} else {
    		xPositions.add(square);
    		positions.add(square);
    		if (isWon()) {
    			xWins++;
    		} else if(isDrawn()) {
    			draws++;
    		}
    		playerTurn++;
    		return "X";
    	}
    }

    /**
     * Returns "X" (if it is X's turn to move) or "O" (otherwise).
     */
    public String getToMove ()
    {
    	if (playerTurn % 2 == 0) {
    		return "O";
    	} else {
    		return "X";
    	}
    }

    /**
     * Reports whether or not the board has a drawn position (all squares filled
     * in, neither X nor O has three in a row).
     */
    public boolean isDrawn ()
    {
    	if (positions.contains(1) 
    			&& positions.contains(2) 
    			&& positions.contains(3) 
    			&& positions.contains(4) 
    			&& positions.contains(5) 
    			&& positions.contains(6) 
    			&& positions.contains(7) 
    			&& positions.contains(8) 
    			&& positions.contains(9) 
    			&& !isWon()) {
    		return true;
    	} else {
    		return false;
    	}
    }

    /**
     * Reports whether or not the board has a won position (either X or O has
     * three in a row).
     */
    public boolean isWon ()
    {
    	if ((xPositions.contains(1) && xPositions.contains(2) && xPositions.contains(3)) || 
    			(xPositions.contains(4) && xPositions.contains(5) && xPositions.contains(6)) ||
    			(xPositions.contains(7) && xPositions.contains(8) && xPositions.contains(9)) ||
    			(xPositions.contains(1) && xPositions.contains(4) && xPositions.contains(7)) ||
    			(xPositions.contains(2) && xPositions.contains(5) && xPositions.contains(8)) ||
    			(xPositions.contains(3) && xPositions.contains(6) && xPositions.contains(9)) ||
    			(xPositions.contains(1) && xPositions.contains(5) && xPositions.contains(9)) ||
    			(xPositions.contains(3) && xPositions.contains(5) && xPositions.contains(7)) ||
    			
    			(oPositions.contains(1) && oPositions.contains(2) && oPositions.contains(3)) || 
    			(oPositions.contains(4) && oPositions.contains(5) && oPositions.contains(6)) ||
    			(oPositions.contains(7) && oPositions.contains(8) && oPositions.contains(9)) ||
    			(oPositions.contains(1) && oPositions.contains(4) && oPositions.contains(7)) ||
    			(oPositions.contains(2) && oPositions.contains(5) && oPositions.contains(8)) ||
    			(oPositions.contains(3) && oPositions.contains(6) && oPositions.contains(9)) ||
    			(oPositions.contains(1) && oPositions.contains(5) && oPositions.contains(9)) ||
    			(oPositions.contains(3) && oPositions.contains(5) && oPositions.contains(7))) {
    		return true;
    	} else {
    		return false;
    	}
    }

    /**
     * Resets the board so that a fresh game can be played. Does not modify the
     * scoring records.
     */
    public void reset ()
    {
    	playerTurn = 1;
    	xPositions = new ArrayList<Integer>();
    	oPositions = new ArrayList<Integer>();
    	positions = new ArrayList<Integer>();
    }

    /**
     * Returns the number of games that X has won.
     */
    public int getXWins ()
    {
        return xWins;
    }

    /**
     * Returns the number of games that O has won.
     */
    public int getOWins ()
    {
        return oWins;
    }

    /**
     * Returns the number of games that have been drawn.
     */
    public int getDrawCount ()
    {
        return draws;
    }
}
