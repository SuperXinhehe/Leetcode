/*
	given a binary tree and a sum, determine if the tree has a root-to-leaf
	path such that adding up all the values along the path equals the given sum
*/

import java.util.*;

public class PathSum {

	public void printPath(TreeNode root, int sum) {
		if(root == null) return;
		List<TreeNode> path = new LinkedList<TreeNode>();
		HashMap<TreeNode,Boolean> marked = new HashMap<TreeNode,Boolean>();
		dfs(root, path, sum, 0, marked);
		if(path==null && path.isEmpty()) System.out.println("no path exists");
		else {
		for(int i=0;i<path.size();i++) {
			System.out.println(path.get(i).val);
		}
		}
	}
	// use dfs and back tracking to find the path that the sum 
	// of all the nodes are equals to the target sum value
	// recursive function and backtracking
	public void dfs(TreeNode root, List<TreeNode> path, int sum, int cursum, HashMap<TreeNode,Boolean> marked) {
		
		// path.add(root);
		if(root!=null) {
			System.out.println(cursum);
			path.forEach(ele->System.out.print(ele.val+" "));
			System.out.println();
		}
		if(cursum == sum) {
			// save current path
			return;
		}
		else {
			if(!marked.containsKey(root)) {
				path.add(root);
				marked.put(root,true);
				cursum = cursum + root.val;
			}
			TreeNode left = root.left;
			TreeNode right = root.right;
			if(left != null && !marked.containsKey(left)) {
				path.add(left);
				marked.put(left,true);
				cursum = cursum + left.val;
				dfs(left,new ArrayList<TreeNode>(path),sum,cursum,marked);
				path.remove(path.size()-1);
				cursum = cursum - left.val;
			}
			if(right != null && !marked.containsKey(right)) {
				path.add(right);
				System.out.println("adding right:"+right.val);
				marked.put(right,true);
				cursum = cursum + right.val;
				dfs(right,new ArrayList<TreeNode>(path),sum,cursum,marked);
				path.remove(path.size()-1);
				cursum = cursum - right.val;
			}
			if(marked.containsKey(root) && marked.get(root)) {
				path.remove(path.size()-1);
				cursum = cursum - root.val;				
			}
		}

	}
	public static void main(String args[]) {
		PathSum ps = new PathSum();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(6);
		ps.printPath(root,19);
	}
}