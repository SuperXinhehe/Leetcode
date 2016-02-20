import java.util.*;

public class MinWindowString {
	
	public String getWindow(String s, String t) {
		if(s.length() == 1 && s.contains(t)) return s; 
		int i=0;
		int j=1;
		String substr = "";
		int curCount = 0;
		int minlen = Integer.MAX_VALUE;
		String curminStr = null;
		String c;
		List<Integer> indexList = new ArrayList<Integer>();
		while(j<=s.length()+1) {
			System.out.println(substr);
			System.out.println(curCount);
			if(curCount==3) {
				if(minlen > substr.length()) {
					minlen = substr.length();
					curminStr = substr;
				}
				//windows.put(substr,substr.length());
				indexList.remove(0);
				i = indexList.get(0);
				curCount--;
			}
			
			// if the length is exist the min length
			if(substr.length() > minlen) {
				if(s.charAt(indexList.get(indexList.size()-1))!=s.charAt(indexList.get(0))) {
					curCount--;
				}
				indexList.remove(0);
				if(!indexList.isEmpty()) {
					i = indexList.get(0);
				}
				else {
					i = j;
					j = i + 1;
				}
			}
			if(j<=s.length()) {
			c = s.charAt(j-1)+"";
			if(t.contains(c)) {
				indexList.add(j-1);
				// if the substring is already contains this character
				if(!substr.contains(c)) {
					curCount++;
				}
			}
			substr = s.substring(i,j);
			}
			j++;
		}
		return curminStr;

	}
	
	public static void main(String args[]) {
		MinWindowString mws = new MinWindowString();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(mws.getWindow(s,t));
	}
}