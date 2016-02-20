import java.util.*;

public class findMaxDisticNumber {

	public void getStr(String str) {
		int maxlen = 1;
		String maxStr = null;
		int s = 0;
		int ind = 0;
		String curstr = str.substring(0,1);
		for (int t = 1;t<str.length();t++) {
			// if curstr not contains the char at index t
			// update the current str to be substring start from s to t
			// store the maxStr and maxlen
			char c = str.charAt(t);
			String str2 = c+"";
			if(!curstr.contains(str2)) {
				curstr = str.substring(s,t+1);
				if(curstr.length() > maxlen) {
					maxlen = curstr.length();
					maxStr = curstr;
				}
			}
			else {
				ind = curstr.indexOf(str.charAt(t));

				// update the start index
				s = s + ind + 1;
				curstr = str.substring(s,s+1);
			}
		}
		System.out.println("The longest distinct numbers list is: " + maxlen);
		System.out.println("The longest String is: " + maxStr);
	}
	public static void main(String args[]) {
		String str = "aabcbcdbac";
		findMaxDisticNumber fmdn = new findMaxDisticNumber();
		fmdn.getStr(str);
	}
}