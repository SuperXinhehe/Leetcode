public class JumpGame2 {
    public int jump(int[] nums) {
        if(nums.length==0) return 0;
        int i=0;
        int j;
        int c = 0;
        while(i<nums.length-1) {
        	// System.out.println("round : "+c);
            j = nums[i];
            if(j==0) return c;
            int max = 0;
            int bound = j+i;
            // go over the possible steps and find the maximum step
            if(j+i > nums.length-1){
            	bound = nums.length-1;
            }
            // System.out.println("bound is: "+ bound);
            for(int k=i;k<bound;k++) {
                if(max<nums[k]) {
                    max = nums[k];
                }
            }
            i = i + max;
            System.out.println("max is: "+ max);
            System.out.println("i is: "+i);
            c++;
        }
        return c;
    }

    public static void main(String[] args) {
    	JumpGame2 JG = new JumpGame2();
    	int[] nums = {1,2,3,4,5};
    	System.out.println(JG.jump(nums));
    }
}