import java.util.*;

public class SlidingWindowSum {
	
	public int[] sumSlidingWindow(int[] nums, int k) {
		int sum = 0;
		if(k >= nums.length) {
			for(int n: nums) {
				sum = sum + n;
			}
			return new int[]{sum};
		}
		int[] out = new int[nums.length-k+1];
		Queue<Integer> q = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		while(i<k) {
			q.add(nums[i]);
			sum = sum + nums[i];
			i++;
		}
		out[j] = sum;
		System.out.println("first sum is: "+sum);
		while(i<nums.length) {
			System.out.println("minus "+q.peek());
			sum = sum - q.poll();
			
			System.out.println(sum);
			q.add(nums[i]);
			System.out.println("adding: "+nums[i]);
			sum = sum + nums[i];
			j++;
			out[j] = sum;
			System.out.println(j+"th sum is: "+sum);
			i++;
		}
		return out;
	}
	public static void main(String args[]) {
		SlidingWindowSum swm = new SlidingWindowSum();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		System.out.println(Arrays.toString(swm.sumSlidingWindow(nums,k)));
	} 
}