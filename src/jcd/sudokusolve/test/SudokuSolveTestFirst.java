package jcd.sudokusolve.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuSolveTestFirst {
	static final int BOARDSIZE = 9 * 9;
	static final int B = 0;
	static final int[] BD1 = { 2, B, B, B, B, B, B, B, B, 1, B, B, B, B, B, B,
			B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B,
			B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B,
			B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, };

	static final int[] BD2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, B, B, B, B, B, B, B,
			B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B,
			B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B,
			B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, };
	static final int[] BD3 = { 1, B, B, B, B, B, B, B, B, 2, B, B, B, B, B, B,
			B, B, 3, B, B, B, B, B, B, B, B, 4, B, B, B, B, B, B, B, B, 5, B,
			B, B, B, B, B, B, B, 6, B, B, B, B, B, B, B, B, 7, B, B, B, B, B,
			B, B, B, 8, B, B, B, B, B, B, B, B, 9, B, B, B, B, B, B, B, B, };

	static final int[] BD4 = { 2, 7, 4, B, 9, 1, B, B, 5, 1, B, B, 5, B, B, B,
			9, B, 6, B, B, B, B, 3, 2, 8, B, B, B, 1, 9, B, B, B, B, 8, B, B,
			5, 1, B, B, 6, B, B, 7, B, B, B, 8, B, B, B, 3, 4, B, 2, B, B, B,
			B, B, 9, B, B, B, B, B, B, B, 7, B, 8, B, B, 3, 4, 9, B, B, B, };

	static final int[] BD4s = { 2, 7, 4, 8, 9, 1, 3, 6, 5, 1, 3, 8, 5, 2, 6, 4,
			9, 7, 6, 5, 9, 4, 7, 3, 2, 8, 1, 3, 2, 1, 9, 6, 4, 7, 5, 8, 9, 8,
			5, 1, 3, 7, 6, 4, 2, 7, 4, 6, 2, 8, 5, 9, 1, 3, 4, 6, 2, 7, 5, 8,
			1, 3, 9, 5, 9, 3, 6, 1, 2, 8, 7, 4, 8, 1, 7, 3, 4, 9, 5, 2, 6, };

	@Test
	public void test() {
		displayBoard(solve(BD4));
		displayBoard(BD4s);
		assertArrayEquals(BD4s, solve(BD4));
	}

	private int[] solve(int[] board) {

		if (solveBoard(0, 0, board))
			return board;
		else
			return null;
	}

	private boolean solveBoard(int row, int col, int[] board) {

		// check row col if col is 9 then , it find a solution.
		if (row == 9) {
			row = 0;
			if (++col == 9) {
				return true;
			}
		}

		// check value current position value
		if (board[position(row, col)] != 0) {
			return solveBoard(row + 1, col, board);
		}

		// find valid value for current position
		for (int num = 1; num <= 9; num++) {
			if (isValidNumber(row, col, num, board)) {
				board[position(row, col)] = num;
				if(solveBoard(row + 1, col, board)) {
					return true;
				}
			}
		}
		// reset backtracking
		board[position(row, col)] = 0;
		return false;
	}

	private boolean isValidNumber(int row, int col, int num, int[] board) {
		return isValidRowNumber(col, num, board)
				&& isValidColNumber(row, num, board)
				&& isValidBoxNumber(row, col, num, board);
	}

	private boolean isValidBoxNumber(int row, int col, int num, int[] board) {
		int boxOffsetRow = (row / 3) * 3;
		int boxOffsetCol = (col / 3) * 3;

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				if (board[position(boxOffsetRow + i, boxOffsetCol + j)] == num)
					return false;
			}

		return true;
	}

	private boolean isValidColNumber(int row, int num, int[] board) {
		for (int col = 0; col < 9; col++) {
			if (board[position(row, col)] == num)
				return false;
		}

		return true;
	}

	private boolean isValidRowNumber(int col, int num, int[] board) {

		for (int row = 0; row < 9; row++) {
			if (board[position(row, col)] == num)
				return false;
		}

		return true;
	}

	private int position(int row, int col) {
		return row * 9 + col;
	}

	private void displayBoard(int[] board) {

		if (board == null || board.length != BOARDSIZE) {
			System.out.printf("There are no solution");
			return;
		}
		for (int i = 0; i < BOARDSIZE; i++) {
			if (i % 9 == 0)
				System.out.println();
			System.out.printf("%d ", board[i]);
		}
		System.out.println();
	}

	
}
