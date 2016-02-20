public class minDepthBTree  {

	// use dfs find the min depth tree branch
	public int minDepth(TreeNode root) {
		if(root== null) return 0;
// 		int minv = Integer.MAX_VALUE;
		int counter = 0;
		counter = dfs(root);
		return counter;
	}

	public int dfs(TreeNode root) {
		if(root==null) return 0;
		TreeNode right = root.right;
		TreeNode left = root.left;
		if(right == null && left == null) return 1;
		if(root.left==null) return dfs(right) + 1;
		if(root.right==null) return dfs(left) + 1;
		return Math.min(dfs(right) + 1,
		dfs(left) + 1);
	}

	public static void main(String args[]) {
		minDepthBTree mDBT = new minDepthBTree();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		//TreeNode right = new TreeNode(3);
		root.left = left;
		//root.right = right;
		System.out.println(mDBT.minDepth(root));
	}
}