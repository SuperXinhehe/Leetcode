public class WordSearch {
	// for every char check its right and one below it
	//
	public boolean exist(char[][] board,String word) {
		int m = board.length;
		int n = board[0].length;
		if(m == 0 && n == 0) return false;
		boolean[][] marked = new boolean[m][n];
		for (int curi=0;curi<m;curi++) {
			for(int curj=0;curj<n;curj++) {
				if(findWord(board,marked,curi,curj,word,0)) return true;
			}
		}
		return false;
	}
	public boolean findWord(char[][] board, boolean[][] marked, int row, int col, String word, int index) {
		if(index==word.length()) return true;
		if(row<0 || col<0 || row>=board.length || col>=board[0].length || marked[row][col] || board[row][col]!=word.charAt(index)) {
			return false;
		}
		marked[row][col] = true;
		if(findWord(board,marked,row-1,col,word,index+1)) return true;
		if(findWord(board,marked,row+1,col,word,index+1)) return true;
		if(findWord(board,marked,row,col-1,word,index+1)) return true;
		if(findWord(board,marked,row,col+1,word,index+1)) return true;
		marked[row][col] = false;
		return false;
	}
	public static void main(String args[]) {

	}
}