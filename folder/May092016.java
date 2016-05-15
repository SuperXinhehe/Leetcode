public class May092016 {
	// finding the longest subarray of set of elements
	public int LongestSubarray (int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 0;
		int out = 0;
		for (int i=1;i<nums.length;i++) {
			int max = 0;
			for (int j=0;j<i;j++) {
				if(nums[j] < nums[i]) {
					int cur = res[j] + 1;
					if (max < cur) {
						max = cur;
					}
				}
			}
			res[i] = max;
			if(out < max) {
				out = max;
			}
		}
		return out;
	}

	public static void main(String args[]) {
		May092016 may = new May092016();
		int[] input = {1,56,58,57,90,92,94,93,91,45};
		System.out.println(may.LongestSubarray(input));
	}
}