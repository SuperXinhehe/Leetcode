import java.util.*;

public class WordLadderII {

	public List<List<String>> findLadders(String beginWord,String endWord, Set<String> wordList) {
		List<List<String>> out = new ArrayList<List<String>>();
		List<String> inner = new ArrayList<String>();
		HashMap<String,Boolean> hm = new HashMap<String, Boolean>();
		for(String w: wordList) {
			hm.put(w,false);
		}
		inner.add(beginWord);
		hm.put(beginWord,true);
		dfs(out,inner,wordList,beginWord,endWord,hm);
		return out;
	}
	public void dfs(List<List<String>> out, List<String> inner, Set<String> wordList,String beginWord,String endWord,HashMap<String,Boolean> hm) {
		String w = inner.get(inner.size()-1);
		if(OneLetterDiff(w,endWord)) {
			inner.add(endWord);
			// inner.forEach(ele->System.out.print(ele));
			// System.out.println();
			out.add(new ArrayList<String>(inner));
			return;
		}
		else {
			for(String word: wordList) {
				if(!hm.get(word)&&OneLetterDiff(w,word)) {
					System.out.println("word is: "+word+" w is: "+w);
					hm.put(word,true);
					inner.add(word);
					dfs(out,inner,wordList,beginWord,endWord,hm);
					inner.remove(inner.size()-1);
					hm.put(word,false);
				}
			}
		}
	}

	public boolean OneLetterDiff(String w,String word) {
		int counter = 0;
		for(int i=0;i<w.length();i++) {
			if(counter <= 1) {
				if(w.charAt(i) != word.charAt(i)) {
					counter++;
				}
			}
			else return false;
		}
		if(counter > 1) return false;
		return true;
	}

	public static void main(String args[]) {
		WordLadderII WLII = new WordLadderII();
		Set<String> wordList = new HashSet<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
		List<List<String>> out = WLII.findLadders("hit","cog",wordList);
		for(List<String> o: out) {
			o.forEach(ele->System.out.print(ele+", "));
			System.out.println();
		}
		// System.out.println(WLII.OneLetterDiff("lot","dog"));
	}	
}