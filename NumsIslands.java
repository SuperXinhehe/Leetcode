import java.util.*;

public class NumsIslands {
	
	// public int numIslands(char[][] grid) {
	// 	boolean[][] mark = new boolean[grid.length][grid[0].length];
	// 	List<Char> inner = new ArrayList<Char>();
	// 	List<List<Char>> outer = new ArrayList<List<Char>>();
	// 	int out = dfs(grid,0,0,marked,inner,outer);
	// }

	// public int dfs(char[][] grid,int r,int c, boolean[][] marked,List<Char> inner,List<List<Char>> outer) {
	// 	// Stack<Char> gs = new Stack<Char>();
	// 	// List<Char> inner = new ArrayList<Char>();
	// 	// List<List<Char>> outer = new ArrayList<List<Char>>();
	// 	if(!marked[r][c]) {
	// 		gs.push(grid[r][c])
	// 		marked[r][c] = true;
	// 		if(r<grid.length-1 && c<grid[0].length-1) {

	// 			if(grid[r+1][c] == 1||grid[r][c+1] == 1) {
	// 				if(grid[r+1][c]==1) {
	// 					dfs(grid,r+1,c,marked,count);
	// 				}
	// 				if(grid[r][c+1]==1) {
	// 					dfs(grid,r,c+1,marked,count);
	// 				}
	// 			}

	// 		}
	// 		else if(r<grid.length-1) {
	// 			if(grid[r+1][c]==1) {
	// 				dfs(grid,r+1,c,marked,inner,outer);
	// 			}
	// 		}
	// 		if(c<grid[0].length-1) {
	// 			if(grid[r][c+1]==1) {
	// 				dfs(grid,r,c+1,marked,inner,outer);
	// 			}
	// 		}
	// 	}
	// }

	public static Stack<List<Integer>> printIslands(char[][] grid) {
		Stack<List<Integer>> s = new Stack<List<Integer>>();
		boolean[][] marked = new boolean[grid.length][grid[0].length];
		s.add(new ArrayList(Arrays.asList(new Integer[]{0,0})));
		marked[0][0] = true;
		while(!s.isEmpty()) {
			List<Integer> point = s.pop();
			int r = point.get(0);
			int c = point.get(1);
			marked[r][c] = true;
			if(r<grid.length-1 && !marked[r+1][c] && grid[r+1][c] == 1){
				s.push(new ArrayList(Arrays.asList(new Integer[]{r+1,c})));
				// marked[r+1][c] = true;
			}
			if(c<grid[0].length-1 && !marked[r][c+1] && grid[r][c+1] == 1){
				s.push(new ArrayList(Arrays.asList(new Integer[]{r,c+1})));
				// marked[r][c+1] = true;
			}
		}
		return s;
	}
	public static void main(String args[]) {
		char[][] grid = {
			{1,1,0,0},
			{1,1,1,0},
			{1,0,0,1},
			{0,0,0,1}
		};
		Stack<List<Integer>> s = printIslands(grid);
		for(List<Integer> l: s) {
			l.forEach(ele->System.out.print(ele));
			System.out.println();
		}
	}
}