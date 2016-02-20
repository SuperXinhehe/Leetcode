import java.util.*;

public class printChar {
public static void printChar(int k) {
	char c = 'a';
	char print = c;
	for (int i=0;i<k;i++) {
		print = c;
		for(int j=0;j<=i;j++) {
			System.out.print(print++);
		}
		System.out.println();

	}
}
public static void main(String args[]) {
	printChar(6);
}
}