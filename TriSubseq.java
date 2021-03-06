public class TriSubseq {
	public boolean subseq (int[] nums) {
		int x1 = Integer.MAX_VALUE;
		int x2 = Integer.MAX_VALUE;
		for (int i=0;i<nums.length;i++) {
			if(nums[i] <= x1) {
				x1 = nums[i];
			}
			else if(nums[i] <= x2) {
				x2 = nums[i];
			}
			// x2 < nums[i]
			else {
				return true;
			}
		}
		return false;
	}
	// dynamic programming longest increasing subsequence:
	// given an unsorted array of integers, find the length of 
	// longest increasing subsequence
	// count every i element smaller than jth element 
	// for i from 0 to j
	public int lengthOfLIS(int[] nums) {
		int[] count = new int[nums.length];
		count[0] = 1;
		int max;
		for (int i=1;i<nums.length;i++) {
			int c = 0;
			max = 0;
			for(int j=0;j<i;j++) {
				// only check the element that is less than current one
				// longest increasing sequence ending j..
				if(nums[j] < nums[i]) {
					if(max < count[j]) {
						max = count[j];
					}
				}
				
			}
			// System.out.println(curindex);
			//** count current or not
			count[i] = max + 1;

		}
		// for (int k = 0;k<count.length;k++) {
		// 	System.out.print(count[k]);
		// }
		getSequence(nums,count);
		// return count[nums.length-1];
		// return the maximum number in list count *** not necessary the last one
		max = 0;
		for(int ele: count) {
			if(ele>max) {
				max = ele;
			}
		}
		return max;
	}

	// method to print out the sequence...
	public void getSequence(int[] nums, int[] counts) {

		String path = "";
		int ind = 0;
		int m = 0;
		// add the maximum number first to the path and decrease...
		for(int i=counts.length-1;i>0;i--) {
			if(m<counts[i]) {
				// get the maximum number in the array
				m = counts[i];
				ind = i;
			}
		}
		path = path+nums[ind];

		int res = counts[ind] - 1;
		for (int i=ind-1;i>=0;i--) {
			if(counts[i]==res) {
				path = path + " " + nums[i];
				res--;
			}
		}
		System.out.println(path);
	}
	public static void main(String args[]) {
		TriSubseq ts = new TriSubseq();
		int[] nums = {1,3,6,7,9,4,10,5,6};
		// System.out.println(ts.subseq(nums));
		System.out.println("number of elements in sequence " + ts.lengthOfLIS(nums));
	}
}