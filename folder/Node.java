public class Node {
	int val;
	int score;
	Node left = null;
	Node right = null;
	public Node(int val,int score,Node left, Node right) {
		this.val = val;
		this.score = score;
		this.left = left;
		this.right = right;
	}
}