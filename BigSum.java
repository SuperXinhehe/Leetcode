import java.util.*;

public class BigSum {
	
	public int biggestSum(int[] nums) {
		int[] out = new int[nums.length];
		out[0] = 0;
		for(int i=1;i<nums.length;i++) {
			out[i] = Math.max(nums[i],nums[i]+out[i-1]);
		}
		return out[nums.length-1];
	}

	public static void main(String[] args) {
		int[] nums = {-2,5,-1,7,-3};
		BigSum bs = new BigSum();
		System.out.println(bs.biggestSum(nums));
	}

}