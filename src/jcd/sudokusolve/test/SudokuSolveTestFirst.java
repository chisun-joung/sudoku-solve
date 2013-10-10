package jcd.sudokusolve.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuSolveTestFirst {
	static final int BOARDSIZE = 9 * 9;
	static int[] BD1 = new int[BOARDSIZE];

	@Test
	public void test() {
		displayBoard(BD1);
	}

	private void displayBoard(int[] board) {

		for (int i = 0; i < BOARDSIZE; i++) {
			if (i % 9 == 0)
				System.out.println();
			System.out.printf("%d ", board[i]);
		}
	}

}
