public class google1 {

	public int JumpGame (int[] nums) {
		int i = 0;
		int count = 1;
		while (i < nums.length - 1) {
			int steps = nums[i];
			int max = 0;
			for (int j=i+1;j<=i+steps;j++) {
				if(nums[j] + j > max) {
					max = nums[j] + j;
				}
			}
			i = i + max + 1;
			count++;
		}
		return count;
	}

	public int maxPoints(Point[] points) {
		if(points == null || points.length== 0) return 0;
		HashMap<Double,Integer> res = new HashMap<Double,Integer>();
		int max = 0;
		
	}
	public static void main(String[] args) {
		google1 g = new google1();
		int[] nums = {2,3,1,1,2};
		System.out.println(g.JumpGame(nums));
	}
}