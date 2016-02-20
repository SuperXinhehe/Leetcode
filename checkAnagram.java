import java.util.*;
public class checkAnagram {
	public boolean isAnagram(String s,String t) {
		if(s.equals(t)) return true;
		else {
			char[] char1 = s.toCharArray();
        	char[] char2 = t.toCharArray();
        	Arrays.sort(char1);
        	Arrays.sort(char2);
        	String s1 = new String(char1);
        	String s2 = new String(char2);
        	if(s1.equals(s2)) {
            	return true;
        	}
        	else return false;
		}
	}
	public static void main(String args[]) {
		checkAnagram isa = new checkAnagram();
		System.out.println(isa.isAnagram("",""));
		System.out.println(isa.isAnagram("anagram","nagaram"));
		System.out.println(isa.isAnagram("rat","car"));
	}
}