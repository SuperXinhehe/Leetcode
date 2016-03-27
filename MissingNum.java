public class MissingNum {
	public int missNum(int[] nums) {
		int max = 0;
		boolean check = false;
		int sum = 0;
		for(int i=0;i<nums.length;i++) {
			if(max < nums[i]) {
				max = nums[i];
			}
			sum = sum + nums[i];
			// if there is a number that is missing between else max = max + 1
			if(nums[i] != i) {
				check = true;
			}
		}
		if(!check) max = max + 1;
		int sum2 = ((1+max)*max)/2;
		return (sum2 - sum);

	}
	public static void main(String[] args) {
		MissingNum mn = new MissingNum();
		int[] nums = {1,0};
		System.out.println(missNum(nums));
	}
}