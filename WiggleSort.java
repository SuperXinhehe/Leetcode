import java.util.*;

public class WiggleSort {
	// Given input [1,5,1,1,6,4]
	// sort to [num0 < num1 > num2 < num3 ...]
	public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            // 需要交换的情况：奇数时nums[i] < nums[i - 1]或偶数时nums[i] > nums[i - 1]
            if((i % 2 == 1 && nums[i] < nums[i-1]) || (i % 2 == 0 && nums[i] > nums[i-1])){
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
    // google interview problem: 
    // finding the longest alternative sequence:zig zag sequence and increasing subsequence
    // return the length of the longest wiggle sequence
    public void LongestWiggleSeq(int[] nums) {
    	int max = 0;
    	int cur = 1;
    	int i = 1;
    	List<Integer> curlist = new ArrayList<Integer>();
    	curlist.add(nums[0]);
    	List<Integer> out = new ArrayList<Integer>(curlist);
    	for (int j=1;j<nums.length;j++) {
    		if((i%2 == 1 && nums[j] < nums[j-1]) || (i%2 == 0 && nums[j] > nums[j-1])) {
    			cur++;
    			i++;
    		}
    		else {
    			curlist.add(nums[j-1]);
    			if(curlist.size() > max) {
    				max = curlist.size();
    				out = new ArrayList<Integer>(curlist);
    			}
    			cur = 1;
    			i = 1;
    			curlist = new ArrayList<Integer>();
    		}
    		curlist.add(nums[j-1]);

    	}
    	out.forEach(ele->System.out.println(ele));
    	System.out.println("Length is : "+out.size());
    	// return max;
    }
    // method to check if the sequence is wiggle sequence (zig zag sequence)
    // public boolean ZigZagSeq(int[] nums) {

    // }

	public int[] swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return nums;
	}

	public static void main(String[] args) {
		WiggleSort ws = new WiggleSort();
		int[] nums = {1, 2, 51, 50, 60, 55, 70, 68, 80, 76, 75, 12, 45};
		// ws.wiggleSort(nums);
		// for (int ele: nums) {
		// 	System.out.print(ele);
		// }
		// System.out.println();
		ws.LongestWiggleSeq(nums);
	}
}