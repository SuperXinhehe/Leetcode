import java.util.*;

public class WordBreakII {
	public List<String> wordBreakCount(String s, Set<String> wordDic) {
		int[] opt = new int[s.length()];
		List<String> words = new ArrayList<String>();
		opt[0] = 0;
		int mv;
		for(int j=1;j<s.length();j++) {
			mv = Integer.MIN_VALUE;
			for(int i=0;i<=j;i++) {
				int v;
				if(i!=0) {
					// System.out.println("word is: "+s.substring(i,j+1)+", add: "+opt[i-1]);
					// System.out.println(s.substring(0,i));
					v = score(s.substring(i,j+1),wordDic) + opt[i-1];
					if(score(s.substring(i,j+1),wordDic) > 0) {
						System.out.println("possible: "+s.substring(i,j+1));
						words.add(s.substring(i,j+1));
					}
				}
				else {
					// System.out.println("word is: "+s.substring(i,j+1)+", add: ");
					v = score(s.substring(i,j+1),wordDic);
					if(score(s.substring(i,j+1),wordDic) > 0) {
						System.out.println("possible: "+s.substring(i,j+1));
						words.add(s.substring(i,j+1));
					}
				}
				if(v > mv) {
					mv = v;
				}
			}
			opt[j] = mv;
			System.out.println("----"+j);
		}
		for(int ele:opt) {System.out.print(ele);}
		System.out.println();
		int count = opt[s.length()-1];
		HashMap<String,Boolean> hm = new HashMap<String,Boolean>();
		for(String word: words) {
			hm.put(word,false);
		}
		List<String> path = new ArrayList<String>();
		List<String> out = dfs(words,words.get(0),1,s,path,hm);
		//return opt[s.length()-1];
		return out;
	}
	//// traceback to find the words using dfs
	public List<String> dfs(List<String> words,String source,int count,String s,List<String> path,HashMap<String,Boolean> hm) {
		int ind;
		if(path.size() == 3) return path;
		else {
			while(hm.values.contains(false))
			path.add(source);
			ind = s.indexOf(source);
			count++;
			for(String word:words) {
				int curi = s.indexOf(word);
				if(curi == ind+source.length()) {
					path.add(word);
					dfs(words,word,count+1,s,path,hm);
					path.remove(word);
				}
			}
			return path;
		}
	}

	// public List<String> wordBreaker(int[] opt,String s) {
	// 	List<String> out = new ArrayList<String>();
	// 	int curnum = 0;
	// 	int startind = 0;
	// 	StringBuilder sb = new StringBuilder("");
	// 	for(int i=0;i<opt.length;i++) {
	// 		if(opt[i] == curnum + 1) {
	// 			sb.append(s.substring(startind,i+1));
	// 			sb.append(" ");
	// 			curnum++;
	// 			startind = i+1;
	// 		}
	// 	}
	// 	out.add(sb.toString());
	// 	return out;
	// }

	public int score(String substr, Set<String> wordDic) {
		if(wordDic.contains(substr)) {
			return 1;
		}
		else return 0;
	}

	public static void main(String args[]) {
		WordBreakII wb = new WordBreakII();
		Set<String> wordDic = new HashSet<String>(Arrays.asList(new String[]{"cat","cats","and","sand","dog"}));
		System.out.println(wb.wordBreakCount("catsanddog",wordDic).toString());
	}
}
