import java.util.*;
public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> out = new ArrayList<String>();
		for(String s: words) {
			if(exist(board,s)) {
				out.add(s);
			}
		}
		return out;
	}

	public boolean exist(char[][] board,String word) {
		int m = board.length;
		int n = board[0].length;
		if(m == 0 && n == 0) return false;
		boolean[][] marked = new boolean[m][n];
		String[][] strs = new String[m][n];
		for (int curi=0;curi<m;curi++) {
			for(int curj=0;curj<n;curj++) {
				if(findWord(board,marked,curi,curj,word,0,strs)) return true;
			}
		}
		return false;
	}
	public boolean findWord(char[][] board, boolean[][] marked, int row, int col, String word, int index, String[][] strs) {
		if(index==word.length()) return true;
		if(row<0 || col<0 || row>=board.length || col>=board[0].length || marked[row][col] || board[row][col]!=word.charAt(index) || strs[row][col]!=null && !strs[row][col].equals(word.substring(0,index+1))) {
			return false;
		}
		marked[row][col] = true;
		strs[row][col] = word.substring(0,index+1);
		if(findWord(board,marked,row-1,col,word,index+1,strs)) return true;
		if(findWord(board,marked,row+1,col,word,index+1,strs)) return true;
		if(findWord(board,marked,row,col-1,word,index+1,strs)) return true;
		if(findWord(board,marked,row,col+1,word,index+1,strs)) return true;
		marked[row][col] = false;
		strs[row][col] = word.substring(0,index);
		return false;
	}
	public static void main(String args[]) {
		char[][] board = {
			{'o','a','a','n'},
			{'e','t','a','e'},
			{'i','h','k','r'},
			{'i','f','l','v'}
		};
		String[] words = {"oath","pea","eat","rain"};
		WordSearchII ws = new WordSearchII();
		List<String> out = ws.findWords(board, words);
		out.forEach(ele->System.out.print(ele + ","));
	}
}