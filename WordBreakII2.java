import java.util.*;

public class WordBreakII2 {
  // method to traceback and get the words
  // public List<String> wordBreakII (List<String> dict,String words,int[] count) {
  // 	for(int i=0;i<count.length-1;i++) {
  // 		for (int j=i+1;j<count.length;j++) {

  // 		}
  // 	}
    
  // }
  // class to count how many valid words
  public int wordBreak(List<String> dict, String words) {
  	int[] count = new int[words.length()+1];
  	String[] grid = new String[words.length()+1];
  	List<String>[] out = new List[words.length() + 1];
  	count[0] = 0;
  	grid[0] = "";
  	for(int i=1;i<words.length();i++) {
  		int max = count[i-1];
  		for(int j=0;j<i;j++) {
  			int cur = check(dict,words.substring(j,i+1));
  			if(cur == 1) {
  				List<String> l = out[i];
  				if(l!=null) {
  					// grid[i] = grid[i] + words.substring(j,i+1);
  					out[i].add(words.substring(j,i+1));
  				}
  				else {
  					l = new ArrayList<String>();
  					l.add(words.substring(j,i+1));
  					out[i] = l;
  				}
  				// if(j!=0) {
  				// 	if(grid[i]!=null) {
  				// 		grid[i] = grid[i] + 
  				// 	}
  				// 	// grid[i] = grid[j-1] + " " + grid[i];
  				// }
  			}
  			if(j!=0) {
  				cur = cur + count[j-1];
  			}
  			if(cur > max) {
  				max = cur;
  			}
  		}
  		count[i] = max;
  		System.out.println(max);
  	}
  	for(List<String> l : out) {
  		if(l!=null) 
  			l.forEach(ele->System.out.print(ele));
  			System.out.println();
  	}
  	return count[words.length()-1];
  }
  public int check(List<String> dict,String w) {
  	// System.out.println(w);
  	if(dict.contains(w)) return 1;
  	else return 0;
  }

  public static void main(String[] args) {
  	WordBreakII2 wb2 = new WordBreakII2();
  	String words = "catsanddog";
  	List<String> dict = Arrays.asList(new String[] {"cat","cats","and","sand","dog"});
  	System.out.println("number of words in string "+wb2.wordBreak(dict,words));
  }

}
