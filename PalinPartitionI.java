import java.util.*;
public class PalinPartitionI {
	// backtracking...
	public List<List<String>> partition(String s) {
		List<List<String>> out = new ArrayList<List<String>>();
		List<String> inner = new ArrayList<String>();
		if(s.isEmpty()) return out;
		// Boolean[] marked = new Boolean[s.length()];
		// for(int i=0;i<s.length();i++) {
		// 	marked[i] = false;
		// }
		backTracking(out,inner,s);
		return out;
	}
	public void backTracking(List<List<String>> out, List<String> inner, String s) {
		if(s.isEmpty()) {
			out.add(new ArrayList<String>(inner));
			return;
		}
		for(int i=1;i<=s.length();i++) {
			if(checkPalindrome(s.substring(0,i))) {
				inner.add(s.substring(0,i));
				backTracking(out,inner,new String(s.substring(i,s.length())));
				inner.remove(inner.size()-1);
			}
		}
	}
	// method to check if the string is palindrome
    // using linear time
    public boolean checkPalindrome(String str) {
        if(str.length() <= 1) return true;
        int mid = str.length()/2;
        String h1 = str.substring(0,mid);
        String h2;
        if(str.length()%2==0) {
        	h2 = str.substring(mid,str.length());
        }
        else {h2 = str.substring(mid+1,str.length());}
        
        String rh2 = new StringBuffer(h2).reverse().toString();
        if(h1.equals(rh2)) return true;
        else return false;
    }
	public static void main(String args[]) {
		PalinPartitionI pI = new PalinPartitionI();
		for(List<String> l: pI.partition("cbbbcc")) {
			System.out.println(l.toString());
		}
		// System.out.println(pI.checkPalindrome("efe"));
	}
}