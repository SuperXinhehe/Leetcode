import java.util.*;

public class SameTree {
  
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p==null && q==null) return true;
    else if(p==null || q==null) return false; 
    if(p.val == q.val) {
      boolean b1 = isSameTree(p.left,q.left);
      boolean b2 = isSameTree(p.right,q.right);
      return b1&&b2;
    }
    return false;
  }

  public static void main(String args[]) {
    SameTree st = new SameTree();
    TreeNode p = new TreeNode(3);
    TreeNode q = new TreeNode(4);
    System.out.println(st.isSameTree(p,q));
  }


}
