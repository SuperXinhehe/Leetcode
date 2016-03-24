public class UniqueBST {
	// 1 as root depends on how many trees are there contains two elements
	public int numTrees(int n) {
		int[] count = new int[n+1];
		count[0] = 1;
		count[1] = 1;
		for(int i=2;i<n;i++) {
			for(int j=0;j<i;j++) {
				count[i] += count[i]*count[i-j-1]; 
			}
		}
		return count[n];

	}
}