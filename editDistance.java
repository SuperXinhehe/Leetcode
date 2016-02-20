import java.util.*;

public class editDistance {
	int[][] opt;
	// return the number of steps to convert a string to another string
	// converting str1 to str2
	public int editDistanceImpl(String str1, String str2) {

		int val;
		opt = new int[str1.length()+1][str2.length()+1];

		for(int t=0;t<=str1.length();t++) {
			opt[t][0] = t;
		}
		for(int k=0;k<=str2.length();k++) {
			opt[0][k] = k;
		}

		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					opt[i][j] = opt[i-1][j-1];
				}
				// else {
				// 	val = opt[i-1][j-1]+1;
				// }
				else {
				opt[i][j] = Collections.min(
					Arrays.asList(
					// delete 
					opt[i-1][j]+1,
					// insert 
					opt[i][j-1]+1,
					// substitute
					// if the two chars are same then equals to opt[i-1][j-1]
					// otherwise the value is opt[i-1][j-1]+1
					opt[i-1][j-1]+1
					)
				);
				}
			}
		}
		// for(int r=0;r<str1.length();r++) {
		// 	for(int c=0;c<str2.length();c++) {
		// 		System.out.print(opt[r][c]);
		// 	}
		// 	System.out.println();
		// }
		return opt[str1.length()][str2.length()];
	}

	public void printPath(String s1, String s2) {

		StringBuilder s1b = new StringBuilder(s1);
		int m = s1.length();
		int n = s2.length();
		int i = m;
		int j = n;
		while(i!=0 && j!=0) {
			//int v1 = opt[i-1][j-1];
			
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				i--;
				j--;
				System.out.println("------Same------");
				System.out.println("s1: "+s1b);
			}
			else {
				int v2 = opt[i-1][j-1] + 1;
				int v3 = opt[i-1][j] + 1;
				int v4 = opt[i][j-1] + 1;
				int minv = Math.min(Math.min(v2,v3),v4);
				if(minv == v2) {
					System.out.println("s1: "+s1b);
					System.out.println("----------substitution---------");
					s1b.setCharAt(i-1,s2.charAt(j-1));
					i--;
					j--;
					System.out.println("s1: "+s1b);
				}
				else if(minv == v3) {
					System.out.println("s1: "+s1b);
					System.out.println("-----------Deletion-----------");
					s1b.deleteCharAt(i-1);
					i--;
					System.out.println("s1: "+s1b);
				}
				else if(minv == v4) {
					System.out.println("------------- Insertion------------");
					char c = s2.charAt(j-1);
					s1b.insert(i,c);
					j--;
					System.out.println("s1: "+s1b);
				}
			}
			System.out.println("s2: "+s2);
		}
	}

	public static void main(String args[]) {
		editDistance edis = new editDistance();
		String s1 = "thispart";
		String s2 = "theparty";
		System.out.println(edis.editDistanceImpl(s1,s2));
		edis.printPath(s1,s2);
	}
}