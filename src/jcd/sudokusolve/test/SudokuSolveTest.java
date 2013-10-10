package jcd.sudokusolve.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuSolveTest {

	static final int B = 0;
	static final int[] BD1 = {
		2, B, B, B, B, B, B, B, B,
        1, B, B, B, B, B, B, B, B,
        B, B, B, B, B, B, B, B, B,
        B, B, B, B, B, B, B, B, B,
        B, B, B, B, B, B, B, B, B,
        B, B, B, B, B, B, B, B, B,
        B, B, B, B, B, B, B, B, B,
        B, B, B, B, B, B, B, B, B,
        B, B, B, B, B, B, B, B, B,
	};
	
	static final int[] BD2 = {
		1, 2, 3, 4, 5, 6, 7, 8, 9, 
        B, B, B, B, B, B, B, B, B, 
        B, B, B, B, B, B, B, B, B, 
        B, B, B, B, B, B, B, B, B, 
        B, B, B, B, B, B, B, B, B,
        B, B, B, B, B, B, B, B, B,
        B, B, B, B, B, B, B, B, B,
        B, B, B, B, B, B, B, B, B,
        B, B, B, B, B, B, B, B, B,
	};
	static final int[] BD3 = {
		1, B, B, B, B, B, B, B, B, 
		2, B, B, B, B, B, B, B, B, 
		3, B, B, B, B, B, B, B, B, 
		4, B, B, B, B, B, B, B, B, 
		5, B, B, B, B, B, B, B, B,
		6, B, B, B, B, B, B, B, B,
		7, B, B, B, B, B, B, B, B,
		8, B, B, B, B, B, B, B, B,
		9, B, B, B, B, B, B, B, B,
	};
	
	static final int[] BD4 = {
	   	    2, 7, 4, B, 9, 1, B, B, 5,
	        1, B, B, 5, B, B, B, 9, B,
	        6, B, B, B, B, 3, 2, 8, B,
	        B, B, 1, 9, B, B, B, B, 8,
	        B, B, 5, 1, B, B, 6, B, B,
	        7, B, B, B, 8, B, B, B, 3,
	        4, B, 2, B, B, B, B, B, 9,
	        B, B, B, B, B, B, B, 7, B,
	        8, B, B, 3, 4, 9, B, B, B,
	};
	
	static final int[] BD4s = {
		2, 7, 4, 8, 9, 1, 3, 6, 5,
        1, 3, 8, 5, 2, 6, 4, 9, 7,
        6, 5, 9, 4, 7, 3, 2, 8, 1,
        3, 2, 1, 9, 6, 4, 7, 5, 8,
        9, 8, 5, 1, 3, 7, 6, 4, 2,
        7, 4, 6, 2, 8, 5, 9, 1, 3,
        4, 6, 2, 7, 5, 8, 1, 3, 9,
        5, 9, 3, 6, 1, 2, 8, 7, 4,
        8, 1, 7, 3, 4, 9, 5, 2, 6,
	};
	
	

	@Test
	public void test() {
	 writeBoard(solve(BD4));
	 //writeBoard(BD4s);
	}



	private int[] solve(int[] board) {
		// TODO Auto-generated method stub
		return BD1;
	}



	private void writeBoard(int[] board) {
		
		for(int row = 0; row < 9 ; row++){
			if (row %3 == 0)
				System.out.println(" -----------------------");
			for(int col = 0 ; col < 9 ; col++){
				if (col % 3 == 0 )
					System.out.print("| ");
				System.out.print(board[ row*9 + col] == 0 ? " " : Integer.toString(board[row*9 + col]));
				System.out.print(" ");
			}
			System.out.println("|");
		}
		System.out.println(" -----------------------");
	}

}
