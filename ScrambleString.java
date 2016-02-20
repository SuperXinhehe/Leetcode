import java.util.*;

public class ScrambleString {
	public 
}


    private void deleteNode(Node node, int val) {
        if(node != null) {
            int v = node.val;
            if(val == v) {
                node = null;
                Node m = node.mid;
                deleteNode(m,val);
            }
            else if(val > v){
                Node r = node.right;
                deleteNode(r,val);
            }
            else {
                Node l = node.left;
                deleteNode(l,val);
            }
        }
    }

    // method uses node and inserting value as inputs
    private void insertNode(Node node, int val) {
        if(node == null) node = new Node(val);
        else {
            int v = node.val;
            // if two node values are equal
            // recursive calls on the mid node
            if(v == val) {
                Node m_node = root.mid;
                insertNode(m_node,val);
            }
            // if current node value is greater than the insert value
            // recursive calls on the left node
            else if(v > val) {
                Node l_node = node.left;
                insertNode(l_node,val);
            }
            // if current node value is smaller than insert value
            // recursive calls on the right node
            else {
                Node r_node = node.right;
                insertNode(r_node,val);
            }
        }  
    }