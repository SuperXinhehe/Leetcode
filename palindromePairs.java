import java.util.*;
public class palindromePairs {

	public List<List<Integer>> pp(List<String> words) {
		List<List<Integer>> set = new ArrayList<List<Integer>>();
		for (int i=0;i<words.size()-1;i++) {
			for (int j=i+1;j<words.size();j++) {
				String pre = words.get(i);
				String post = words.get(j);
				if(checkpp(pre+post)) {
					List<Integer> l = new ArrayList<Integer>();
					l.add(i);
					l.add(j);
					set.add(l);
					System.out.println(pre+post);
				}
				if(checkpp(post+pre)) {
					List<Integer> l = new ArrayList<Integer>();
					l.add(j);
					l.add(i);
					set.add(l);	
					System.out.println(post+pre);
				}
			}
		}
		return set;
	}

	public boolean checkpp(String word) {
		if(word.length() == 0) return true;
		else {
			if(word.charAt(0) == word.charAt(word.length()-1)) {
				return checkpp(word.substring(1,word.length()-1));
			}
			else return false;
		}
	}

	public static void main(String[] args) {
		palindromePairs ppclass = new palindromePairs();
		List<String> words = Arrays.asList("bat","tab","cat");
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		out = ppclass.pp(words);
		out.forEach(ele->System.out.println(ele));
	}
}