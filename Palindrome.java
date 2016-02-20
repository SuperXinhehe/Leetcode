import java.util.*;
public class Palindrome {

	public static boolean isPalidromeRecursively(String input) {
		if(input.length() <=1 ) return true;
		else {
			char firstChar = input.charAt(0);
			char secondChar = input.charAt(input.length()-1);
			return (firstChar==secondChar) && isPalidromeRecursively(input.substring(1,input.length()-1));
		}
	}
	public static void main(String args[]) {
		String input = "abcdcbaa";
		System.out.println(isPalidromeRecursively(input));
	}
}