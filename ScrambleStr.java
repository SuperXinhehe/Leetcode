import java.util.*;

// either isScramble(s11,s21) and isScramble(s12,s22) is true
// or isScramble(s11,s12) and isScramble(s12,s21) is true
public class ScrambleStr {
	public boolean isScramble(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		if(s1.equals(s2)) {
			return true;
		}
		//check characters OR USE isValid function to check
		int L = s1.length();
		int chars[] = new int[26];
		for (int i=0;i<L;i++) {
			chars[s1.charAt(i) - 'a']++;
			chars[s2.charAt(i) - 'a']--;

		}
		for (int i=0;i<26;i++) {
			if(chars[i]!=0) {
				return false;
			}
		}

		for (int i=1;i<L;i++) {
			String s11 = s1.substring(0,i);
			String s12 = s1.substring(i,L);
			String s21 = s2.substring(0,i);
			String s22 = s2.substring(i,L);
			if(isScramble(s11,s21) && isScramble(s12,s22))
				return true;
			s21 = s2.substring(0,L-i);
			s22 = s2.substring(L-i,L);
			if(isScramble(s11,s22) && isScramble(s12,s21))
				return true;
		}
		return false;
	}
	// dynamic programming version: 
	// to three dimension array scramble[][][] 
	// scramble[k][i][j] means two substrings of length k
	// one starts from i of s1 and another from j of string s2
	public boolean isScrambleDP(String s1,String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		if(s1.equals(s2)) {
			return true;
		}
		int L = s1.length();
		boolean[][][] scramble = new boolean[L][L][L];

	}
}