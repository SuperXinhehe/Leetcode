import java.util.*;

public class SudokuSolver {
	// public static int row = 0;
	// public static int col = 0;
	public static boolean SolveSudoku(int[][] grid) {
		int row;
		int col;
		if(LocationAvaliable(grid).isEmpty()) {
			return true;
		}
		row = LocationAvaliable(grid).get(0);
		col = LocationAvaliable(grid).get(1);
		for(int num=1;num<=9;num++) {
			if(isSafe(grid,row,col,num)) {
				grid[row][col] = num;
				if(SolveSudoku(grid)) return true;
				grid[row][col] = 0;
			}
		}
		return false; // backtracking
	}

	public static List<Integer> LocationAvaliable(int[][] grid) 
	{
		List<Integer> out = new ArrayList<Integer>();
		for(int row=0;row<grid.length;row++) {
			for(int col=0;col<grid[0].length;col++) {
				if(grid[row][col] == 0) {
					out.add(row);
					out.add(col);
					return out;
				}
				
			}
		}
		return out;
	}
	public static boolean UsedInRow(int[][] grid, int row, int num) {
		for(int col=0;col<grid[0].length;col++) {
			if(grid[row][col] == num) {
				return true;
			}
		}
		return false;
	}

	public static boolean UsedInCol(int[][] grid, int col,int num) {
		for(int row=0;row<grid[0].length;row++) {
			if(grid[row][col] == num) return true;
		}
		return false;
	}

	public static boolean UsedInBox(int[][] grid, int boxStartRow, int boxStartCol,int num) {
		for(int row=0;row<3;row++){
			for(int col=0;col<3;col++) {
				if(grid[row+boxStartRow][col+boxStartCol] == num) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isSafe(int[][] grid,int row,int col, int num) {
		return !UsedInRow(grid,row,num) && !UsedInCol(grid,col,num) && !UsedInBox(grid,row-row%3,col-col%3,num);
	}

	public static void printGrid(int[][] grid) {
		for(int row=0;row<grid[0].length;row++){
			for(int col=0;col<grid.length;col++) {
				System.out.print(grid[row][col]);
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		int[][] grid = {
			{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
		};
		if(SolveSudoku(grid)) printGrid(grid);
		else System.out.println();
	}
}