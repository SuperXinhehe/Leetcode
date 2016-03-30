import java.util.*;

public class CodingInterview {
	// finding the longest palindromic substring
	// dynamic programming O(n^2)
	public String LongestPalindStr(String str) {
		int[][] out = new int[str.length()][str.length()];
		String lstr = "";
		int maxlen = 0;
		// initialize 
		for(int i=0;i<str.length();i++) {
			out[i][i] = 1;
			if(i!=str.length()-1) {
				if(str.charAt(i) == str.charAt(i+1)) {
					out[i][i+1] = 1;
					lstr = str.substring(i,i+2);
					maxlen = 2;
				}
			}
		}
		printTable(out);
		// for whole table:
		for(int l=3;l<=str.length();l++) {
			for(int i=0;i<=str.length()-l;i++) {
				int j = i + l - 1;
				if(str.charAt(i) == str.charAt(j)) {
					out[i][j] = out[i+1][j-1];
					if(out[i][j] == 1 && l > maxlen) {
						lstr = str.substring(i,j+1);
						maxlen = l;
					}
				}
				else {
					out[i][j] = 0;
				}
			}
		}
		return lstr;
	}

	public String LongestPalindStrII(String str) {
		if(str.isEmpty()) return "";
		if(str.length() == 1) {
			return str;
		}
		String longest = str.substring(0,1);
		for(int i=0;i<str.length();i++) {
			// get the longest string with center of i
			String tmp = helper(str,i,i);
			if(tmp.length() > longest.length()) {
				longest = tmp;
			}
			tmp = helper(str,i,i+1);
			if(tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}

	public String helper(String s, int begin, int end) {
		while(begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin+1, end);
	}

	public void printTable(int[][] out) {
		for(int[] l: out) {
			for(int ele: l) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

	public boolean WordBreak(String s, String[] dict) {
		boolean[] t = new boolean[s.length() + 1];
		t[0] = true;
		for(int i=0;i<s.length();i++) {

			// continue from the match position
			if(!t[i])
				continue;
			System.out.println(i);
			for(String a: dict) {
				int len = a.length();
				int end = i + len;
				if(end > s.length())
					continue;
				if(t[end]) continue;
				if(s.substring(i,end).equals(a)) {
					System.out.println(s.substring(i,end));
					t[end] = true;
				}
			}
		}
		for(boolean c: t) {
			System.out.print(c+" ");
		}
		System.out.println();
		return t[s.length()];

	}

	public List<String> wordBreakII(String s, String[] dict) {
		// array contains all the arraylist...
		List<String> dp[] = new ArrayList[s.length() + 1];
		dp[0] = new ArrayList<String>();

		for(int i=0;i<s.length();i++) {
			if(dp[i] == null) {
				continue;
			}
			for(String word:dict) {
				int len = word.length();
				int end = i + len;
				if(end > s.length()) {
					continue;
				}
				if(s.substring(i,end).equals(word)) {
					if(dp[end] == null) {
						dp[end] = new ArrayList<String>();
					}
					dp[end].add(word);
				}
			}
		}
		List<String> result = new LinkedList<String>();
		if(dp[s.length()] == null) {
			return result;
		}
		ArrayList<String> temp = new ArrayList<String>();
		dfs(dp,s.length(),result,temp);
		return result;

	}

	public void dfs(List<String> dp[],int end, List<String> result,ArrayList<String> tmp) {
		if(end<=0) {
			String path = tmp.get(tmp.size()-1);
			for(int i=tmp.size()-2;i>=0;i--) {
				path += " " + tmp.get(i);
			}
			result.add(path);
			return;

		}

		for(String str: dp[end]) {
			tmp.add(str);
			System.out.println(str);
			/// recursive call and bootstrap 
			dfs(dp,end-str.length(),result,tmp);
			tmp.remove(tmp.size()-1);
		}
	}

	// word ladder: 

	public static void main(String[] args) {
		CodingInterview ci = new CodingInterview();
		String str = "dabcba";
		String s = "catsanddog";
		// System.out.println(ci.LongestPalindStr(str));
		String[] dict = {"cat","cats","and","sand","dog"};
		// System.out.println(ci.WordBreak(str,dict));
		List<String> out = ci.wordBreakII(s,dict);
		out.forEach(ele->System.out.println(ele));
		System.out.println();
	}
}