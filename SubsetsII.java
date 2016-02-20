import java.util.*;

public class SubsetsII {
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<Integer> inner = new ArrayList<Integer>();
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		getsets(inner,nums,0,out);
		out.add(new ArrayList<Integer>());
		return out;
	}

	public static void getsets(List<Integer> inner,int[] nums,int start,List<List<Integer>> out) {
		// backtracking
		for(int i=start;i<nums.length;i++) {
			int ele = nums[i];
			inner.add(ele);
			out.add(new ArrayList<Integer>(inner));
			getsets(inner,nums,i+1,out);
			inner.remove(inner.size()-1);
		}
	}

	public static void main(String args[]) {
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		int[] nums = {1,2,3};
		out = subsets(nums);
		for(List<Integer> l: out) {
			l.forEach(e->System.out.print(e));
			System.out.println();
		}
	}
}