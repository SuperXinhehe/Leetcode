import java.util.*;
public class permutation {
	// print out top 6th permutations
	public List<List<Integer>> permute(int[] input) {
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		if(input.length == 0) return permutations;
		List<Integer> curr = new ArrayList<Integer>();
		Boolean[] marked = new Boolean[input.length];
		for(int i=0;i<input.length;i++) marked[i] = false;
		backTracking(permutations,curr,marked,input);
		return permutations;
	}
	public void backTracking(List<List<Integer>> permutations, List<Integer> curr, Boolean[] marked,int[] input) {
		if(curr.size() == input.length) {
			// adding the copy rather than the original reference...
			permutations.add(new ArrayList<Integer>(curr));
			return;
		}
		for(int i=0;i<input.length;i++) {
			if(!marked[i]) {
				marked[i] = true;
				curr.add(input[i]);
				backTracking(permutations,curr,marked,input);
				marked[i] = false;
				curr.remove(curr.size()-1);
			}
		}
	}
	public static void main(String args[]) {
		permutation p = new permutation();
		int[] input = {1,2,3};
		List<List<Integer>> l = p.permute(input);
		l.forEach(ele->System.out.println(ele.toString()));
	}
}