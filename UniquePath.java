import java.util.*;

public class UniquePath {
	public int uniquePaths (int m, int n) {
		// since for first line and column,all should be 1
		// initiate the two d array
		int[][] counts = new int[m+1][n+1];
		for(int i=0;i<m;i++) {
			counts[i][0] = 1;
		}
		for(int j=0;j<n;j++) {
			counts[0][j] = 1;
		}
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				counts[i][j] = counts[i-1][j] + counts[i][j-1];
			}
		}
		return counts[m-1][n-1];
	}
	public int uniquePaths(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] counts = new int[m+1][n+1];
		for(int i=0;i<m;i++) {
			// once there is a 1 in line then make all 0 after that
			if(grid[i][0]==1) {
				for(int j=i;j<m;j++) {
					counts[j][0] = 0;
				}
				break;
			} 
			counts[i][0] = 1;
		}
		for(int j=0;j<n;j++) {
			if(grid[0][j] == 1) {
				for(int i = j;i<n;i++) {
					counts[0][i] = 0;
				}
				break;
			}
			counts[0][j] = 1;
		}
		// for (int i=0;i<m;i++) {
		// 	for (int j=0;j<n;j++) {
		// 		System.out.print(counts[i][j]);
		// 	}
		// 	System.out.println();
		// }
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				if(grid[i][j]==1) {
					counts[i][j] = 0;
				}
				else {
					counts[i][j] = counts[i-1][j] + counts[i][j-1];
				}
			}
		}
		return counts[m-1][n-1];
	}
	public static void main(String[] args) {
		UniquePath up = new UniquePath();
		// System.out.println(up.uniquePaths(3,4));
		int[][] grid = {
			{0,0,0},
			{0,1,0},
			{0,0,0}
		};
		System.out.println(up.uniquePaths(grid));
	}

}