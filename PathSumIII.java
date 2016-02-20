import java.util.*;

public class PathSumIII {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(dfs(root,sum)) return true;
        else return false;
    }
    
    public boolean dfs(TreeNode root, int sum) {
        // System.out.println(sum);
        // System.out.println("value of the root is: "+root.val);
        if((root.val <= sum && sum >= 0) || (sum <= 0 && root.val >= sum)) {
            if(root.left == null && root.right == null) {
                if(root.val - sum == 0) return true;
                else return false;
            }
            // cursum + root.val < sum
            else {
                boolean out1 = false;
                boolean out2 = false;
                if(root.left!=null) {
                    out1 = dfs(root.left,sum - root.val);
                }
                if(root.right!=null) {
                    out2 = dfs(root.right,sum - root.val);
                }
                boolean out = out1 || out2;
                return out;
            }
        }
        return false;
    }

    public static void main(String args[]) {
      PathSumIII ps = new PathSumIII();
      TreeNode root = new TreeNode(8);
      root.left = new TreeNode(9);
      root.right = new TreeNode(-6);
      // root.left.left = new TreeNode(1);
      // root.left.right = new TreeNode(3);
      root.right.left = new TreeNode(5);
      root.right.right = new TreeNode(9);
      // root.left.left.left = new TreeNode();
      System.out.println(ps.hasPathSum(root,7));
    }

}
