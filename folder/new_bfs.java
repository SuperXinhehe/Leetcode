import java.util.*;

public class new_bfs {
	Node root;
	public new_bfs(Node root) {
		this.root = root;
	}

	public void Update(int value, int newScore) {
		if(root==null) return;
		if(value == root.val) root.score = newScore;
		// if the value is less than the root's value
		if(value < root.val) {
			root.left.Update(value,newScore);
		}
		else {
			root.right.Update(value,newScore);
		}
	}

	public int SubTreeScore(int value) {
		if(root.val==value) {
			return root.score + (root.left.SubTreeScore(value)+root.right.SubTreeScore(value));
		}
		else return (root.left.SubTreeScore(value)+root.right.SubTreeScore(value));
	}
}