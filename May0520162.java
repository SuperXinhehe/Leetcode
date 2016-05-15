import java.util.*;
public class May0520162 {
	static TreeMap<Integer,Integer> tm;
	public static void sortWithNulls(int[] nums) {
		int ind = 0;
		// use treemap to record every element's index
		// ordered from min to max...
		tm = new TreeMap<Integer,Integer>();
		for (int i=0;i<nums.length;i++) {
			if(nums[i] == -1) {
				ind = i;
			}
			else {
				tm.put(nums[i],i);
			}
			
		}
		List<Integer> keyset = new ArrayList<Integer>(tm.keySet());
		// keyset.forEach(ele->System.out.print(ele));
		// System.out.println();
		for (int k=0;k<nums.length-1;k++) {
			// not equal need to move
			// System.out.println(nums[k] + " " + keyset.get(k));
			if(nums[k] != keyset.get(k)) {
				if(k != ind) {
					// move the -1 to right slot
					swap(nums,k,ind);

					ind = k;
				}
				swap(nums,ind,tm.get(k));
				ind = tm.get(k);
			}
			// for (int ele:nums) {
			// 	System.out.print(ele + " ");
			// }
			// System.out.println();
		}
	}

	public static void swap(int[] nums,int i,int j) {
		int t = nums[i];
		tm.put(t,j);
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args) {
		int[] nums = {3,1,0,2,-1,4};
		sortWithNulls(nums);
		for (int ele: nums) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}
}