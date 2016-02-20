public class minPathSum {
	
	public int minPathSum(int[][] grid) {
	    if(grid.length==0) return 0;
        if(grid.length == 1 && grid[0].length==1) return grid[0][0];
        int[][] opt = new int[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++) {
            if(i==0) opt[i][0] = grid[i][0];
            else opt[i][0] = grid[i][0] + opt[i-1][0];
        }
        
        for(int j=0;j<n;j++) {
            if(j==0) opt[0][j] = grid[0][j];
            else opt[0][j] = grid[0][j] + opt[0][j-1];
        }
        
        for(int i=1;i<grid.length;i++) {
            for(int j=1;j<n;j++) {
                opt[i][j] = Math.min(opt[i-1][j] + grid[i][j],opt[i][j-1] + grid[i][j]);
            }
        }
        for(int[] row:opt) {
            for(int e: row) {
                System.out.print(e);
            }
            System.out.println();
        }
        return opt[m-1][n-1];
	}
	public static void main(String args[]) {
		minPathSum ps = new minPathSum();
		int[][] grid = {
			{1,3,1},
			{1,5,1},
			{4,2,1}
		};
		System.out.println(ps.minPathSum(grid));
	}
}