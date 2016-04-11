import java.util.*;

public class April092016 {

	public int MaxSumIncreSub(int[] nums) {
		int[] out = new int[nums.length];
		
		out[0] = nums[0];
		int res = out[0];
		for (int i=1;i<nums.length;i++) {
			int max = 0;
			int cur;
			for (int j=0;j<i;j++) {
				if (nums[j] < nums[i]) {
					cur = nums[i] + out[j];
					if (cur > max) {
						max = cur;
					}
				}
			}
			out[i] = max;
			if(out[i] > res) {
				res = out[i];
			}
		}
		return res;
	}

	public int DistinctSubstr(String s, String t) {
		int[][] out = new int[t.length][s.length];
		if(s.length<t.length) return 0;
		for (int i=0;i<t.length;i++) {
			out[t][i] = 0;
		}
		for (int i=1;i<=s.length;i++) {
			for (int j=1;j<=t.length;j++) {
				if(s.charAt(i) == t.charAt(j)) {
					out[j][i] = out[j][i-1] + out[j-1][i-1];
				}
				else out[j][i] = out[j][i-1];
			}
		}
		return out[t.length-1][s.length-1];

	}

	public void printPostorder(TreeNode node) {
		if(node == null) return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.val + " ");
	}

	public void printInorder(TreeNode node) {
		if(node == null) return;
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);

	}

	public static void main(String[] args) {
		April092016 a = new April092016();
		int[] nums = {1,101,2,3,100,4,5};
		System.out.println(a.MaxSumIncreSub(nums));
	}
}