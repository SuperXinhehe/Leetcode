import java.util.*;

public class BalancedBT {
  public boolean isBalanced(TreeNode root) {
   if(root==null) return true;
   return (isBalanced(root.left) && isBalanced(root.right) && 
    Math.abs(Height(root.left) - Height(root.right)) > 1);
  }

  public int Height(TreeNode root) {
   if(root==null) return -1;
   int hl = Height(root.left);
   int hr = Height(root.right);
   int h = 1 + Math.max(hl,hr);
   return h;

  }
  public static void main(String args[]) {
   
  }
}    
