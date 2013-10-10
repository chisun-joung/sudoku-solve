package jcd.sudokusolve.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuSolveTest {

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
		writeBoard(solve(BD4));
		writeBoard(BD4s);
		writeBoard(solve(BD1));
		assertArrayEquals(BD4s, solve(BD4));
	}

	private int[] solve(int[] board) {
		if (isSolved(0, 0, board))
			return board;
		else
			return BD1;
	}

	private boolean isSolved(int row, int col, int[] board) {
		if (row == 9) {
			row = 0;
			if (++col == 9)
				return true;
		}
		if (board[row * 9 + col] != 0) {
			return isSolved(row + 1, col, board);
		}

		for (int num = 1; num <= 9; ++num) {
			if (isValid(row, col, num, board)) {
				board[row * 9 + col] = num;
				if (isSolved(row + 1, col, board)) {
					return true;
				}
			}
		}
		// reset on backtrack
		board[row * 9 + col] = 0;
		return false;
	}

	private boolean isValid(int row, int col, int num, int[] board) {

		return isValidRow(row, col, num, board)
				&& isValidCol(row, col, num, board)
				&& isValidBox(row, col, num, board);
	}

	private boolean isValidBox(int row, int col, int num, int[] board) {
		int boxRowOffset = (row / 3) * 3;
		int boxColOffset = (col / 3) * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (num == board[(boxRowOffset + i) * 9 + (boxColOffset + j)])
					return false;
			}
		}
		return true;
	}

	private boolean isValidCol(int row, int col, int num, int[] board) {
		for (int i = 0; i < 9; i++) {
			if (num == board[row * 9 + i])
				return false;
		}
		return true;

	}

	private boolean isValidRow(int row, int col, int num, int[] board) {
		for (int i = 0; i < 9; i++) {
			if (num == board[i * 9 + col])
				return false;
		}
		return true;
	}

	private void writeBoard(int[] board) {

		for (int row = 0; row < 9; row++) {
			if (row % 3 == 0)
				System.out.println(" -----------------------");
			for (int col = 0; col < 9; col++) {
				if (col % 3 == 0)
					System.out.print("| ");
				System.out.print(board[row * 9 + col] == 0 ? " " : Integer
						.toString(board[row * 9 + col]));
				System.out.print(" ");
			}
			System.out.println("|");
		}
		System.out.println(" -----------------------");
	}

}
