import java.util.*;

public class symmetricTree {
  public boolean isSymmetric(TreeNode root) {
   if(root==null) return true;
   return isSymmetric(root.left,root.right);
  }

  public boolean isSymmetric(TreeNode l, TreeNode r) {
   if(l==null && r==null) { 
    return true;
   }
   else if (r==null || l==null) {
    return false;
   }
   if (l.val != r.val) return false;
  }

}
