// Breadth First Implementation
import java.util.*;
public class bfs {
	public LinkedList<LinkedList<String>> bfsImpl(LinkedList<String> input,String begin, String end) {
		LinkedList<LinkedList<String>> out = new LinkedList<LinkedList<String>>();
		// first in first out queue...
		LinkedList<String> inner = new LinkedList<String>();
		LinkedList<String> outer = new LinkedList<String>();

		HashMap<String,Boolean> hm = new HashMap<String,Boolean>();
		for(String s: input) {
			hm.put(s,false);
		}
		bfsRecursion(out, inner, input, outer, begin, end, hm);
		return out;
	}
	// finding the shortest path to the target
	// store the paths in map...
	public void bfsRecursion(LinkedList<LinkedList<String>> out, LinkedList<String> inner, LinkedList<String> input, LinkedList<String> outer, String begin, String end, HashMap<String,Boolean> hm) {
		inner.add(begin);
		System.out.println(begin+" is added");
		outer = new LinkedList<String>();
		while(!inner.isEmpty()) {
		String w = inner.poll();
		if(OneLetterDiff(w,end)) {
			inner.add(end);
			outer.add(end);
			out.add(new LinkedList<String>(outer));
			return;        
		}
		else {
			hm.put(w,true);
			for(String word:input) {
				if(!hm.get(word)&&OneLetterDiff(word,w)) {
					System.out.println("comparing: "+w+","+word);
					hm.put(word,true);
					inner.add(word);
					outer.add(word);
					System.out.println(word+" is added");
				}
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
		if(counter != 1) return false;
		return true;
	}
	public static void main(String args[]) {
		bfs b = new bfs();
		LinkedList<String> input = new LinkedList<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
		String begin = "hit";
		String end = "cog";
		LinkedList<LinkedList<String>> out = b.bfsImpl(input,begin,end);
		for(LinkedList<String> o:out) {
			o.forEach(ele->System.out.print(ele+","));
			System.out.println();
		}
		// System.out.println(b.OneLetterDiff("this","this"));
	}
}