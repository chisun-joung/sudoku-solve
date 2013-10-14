package jcd.sudokusolve.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuSolveTestSecond {

	private static final int SIZE = 9 * 9;
	private int[] BD = new int[SIZE];

	@Test
	public void test() {
		displayBoard(BD);
		displayBoard(solve(BD));
	}

	private int[] solve(int[] board) {
		if(solve_board(0,0,board))
			return board;
		else
		return null;
	}

	private boolean solve_board(int row, int col, int[] board) {
		
		if(row == 9){
			row = 0;
			if(++col == 9){
				return true;
			}
		}
		
		if(board[row*9 + col]!= 0)
			return solve_board(row+1,col,board);
		
		for(int num = 1; num <=9 ; num++){
			if(isValidNumber(row,col,num,board)){
				board[row*9 + col] = num;
				if(solve_board(row+1,col,board)) {
					return true;
				}
			}
		}
		
		board[row*9 + col ] = 0;
		return false;
	}

	private boolean isValidNumber(int row, int col, int num, int[] board) {
		return isValidRowNumber(col,num,board) && isValidColNumber(row,num,board) && isValidBoxNumber(row,col,num, board);
	}

	private boolean isValidBoxNumber(int row, int col, int num, int[] board) {
		int rowOffset = (row/3) *3;
		int colOffset = (col/3) *3;
		
		for(int i=0; i< 3; i++)
			for(int j=0; j<3; j++){
				if(board[(rowOffset+i)*9 + (colOffset +j)] == num)
					return false;
			}
		
		return true;
	}

	private boolean isValidColNumber(int row, int num, int[] board) {
		for(int col = 0 ; col < 9 ; col++){
			if(board[row*9 + col] == num) 
				return false;
		}
		return true;
	}

	private boolean isValidRowNumber(int col, int num, int[] board) {
		for(int row = 0 ; row < 9 ; row++){
			if(board[row*9 + col] == num) 
				return false;
		}
		return true;
	}

	private void displayBoard(int[] board) {
		if(board == null)
			System.out.printf("No Solutions \n");
		for (int i = 0; i < SIZE; i++) {
			if (i % 9 == 0)
				System.out.println();
			System.out.printf("%d ", board[i]);
		}
		System.out.println();
	}

}
