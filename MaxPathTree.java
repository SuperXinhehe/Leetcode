import java.util.*;

// google interview problem: dfs 
public class MaxPathTree {
	//method to return the sum of the path
	public List<TreeNode> maxPath(TreeNode root) {
		List<TreeNode> path = new ArrayList<TreeNode>();
		List<TreeNode> maxpath = new ArrayList<TreeNode>();
		HashMap<TreeNode,Boolean> marked = new HashMap<TreeNode,Boolean>();
		List<TreeNode> out = dfs(root,path,marked,maxpath,0);
		return out;
	}

	public List<TreeNode> dfs(TreeNode root, List<TreeNode> path, HashMap<TreeNode,Boolean> marked, List<TreeNode> maxpath, int count) {
		if(root == null) {
			path.forEach(ele->System.out.print(ele.val));
			System.out.println("count is"+ count);
			int max = countPath(maxpath);
			System.out.println(max);
			if(max < count) {
				maxpath = new ArrayList<TreeNode>(path);
			}
			return maxpath;
		}
		else {
			if(!marked.containsKey(root)) {
				marked.put(root,true);
				count = count + root.val;
				path.add(root);
				maxpath = dfs(root.left,path,marked,maxpath,count);
				maxpath = dfs(root.right,path,marked,maxpath,count);
				marked.put(root,false);
				path.remove(path.size()-1);
				count = count - root.val;
			}
		}
		System.out.println("maxpath: ");
		maxpath.forEach(ele->System.out.print(ele.val));
		System.out.println();
		return maxpath;
	}

	public int countPath(List<TreeNode> maxpath) {
		if(maxpath.isEmpty()) return 0;
		TreeNode root = maxpath.get(0);
		if(maxpath.size() == 1) {
			return root.val;
		}
		return root.val + countPath(new ArrayList<TreeNode>(maxpath.subList(1,maxpath.size())));
	}

	public static void main(String[] args) {
		MaxPathTree mp = new MaxPathTree();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(2);
		List<TreeNode> out = mp.maxPath(root);
		out.forEach(ele->System.out.print(ele.val));
	}
}