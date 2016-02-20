import java.util.*;

public class InterleavString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s3.length() != s1.length() + s2.length()) return false;
    	if(s1.isEmpty() && s3.equals(s2)) return true;
		if(s2.isEmpty() && s3.equals(s1)) return true;
		
		boolean[][] opt = new boolean[s1.length()+1][s2.length()+1];
		opt[0][0] = true;
		for(int i=1;i<=s1.length();i++){
			if(s1.charAt(i-1) == s3.charAt(i-1) && opt[i-1][0]) {
				opt[i][0] = true;
			}
		}
		for(int i=1;i<=s2.length();i++){
			if(s2.charAt(i-1) == s3.charAt(i-1) && opt[0][i-1]) {
				opt[0][i] = true;
			}
		}
		for(int i=1;i<=s1.length();i++) {
			for(int j=1;j<=s2.length();j++) {
				char c = s3.charAt(i+j-1);
				if(c == s1.charAt(i-1) && opt[i-1][j])
					opt[i][j] = true;
				if(c == s2.charAt(j-1) && opt[i][j-1])
					opt[i][j] = true;
			}
		}
		for(boolean[] o:opt) {
			for(boolean b: o) {
				System.out.print(b +" ");
			}
			System.out.println();
		}
		return opt[s1.length()][s2.length()];

	}
	public static void main(String args[]) {
		InterleavString il = new InterleavString();
		System.out.println(il.isInterleave("a","b","ab"));
	}
}