import java.util.*;

public class PermutationPalindrome {
	
	public List<String> permutePalindrome(String str) {
		List<String> permutes = new ArrayList<String>();
		permutes = getPermutes("", str,permutes);
		return permutes;
	}

	public List<String> getPermutes(String prefix, String str, List<String> permutes) {
		int n = str.length();
		if(n==0) {
			if(isPalindrome(prefix) && !permutes.contains(prefix)) {
				permutes.add(prefix);
			}
			return permutes;
		}
		for(int i=0;i<str.length();i++) {
			String sub = prefix + str.charAt(i);
			getPermutes(sub,str.substring(0,i)+str.substring(i+1,n),permutes);
		}
		return permutes;
	}
	public boolean isPalindrome(String str) {
		if(str.length() == 1 || str.length() == 0) {
			return true;
		}
		if(str.charAt(0) == str.charAt(str.length()-1)) {
			return isPalindrome(str.substring(1,str.length()-1));
		}
		return false;
	}

	public static void main(String args[]) {
		List<String> permutes = new ArrayList<String>();
		PermutationPalindrome PP = new PermutationPalindrome();
		permutes = PP.permutePalindrome("aabb");
		permutes.forEach(ele->System.out.print(ele+", "));
		System.out.println();
	}
}