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

	public static void main(String args[]) {
		TriSubseq ts = new TriSubseq();
		int[] nums = {3,0,1,2,4};
		System.out.println(ts.subseq(nums));
	}
}