import java.util.*;

public class April052016 {
	
	public int divide(int dividend, int divisor) {
		if(divisor==0) return Integer.MAX_VALUE;
		if(divisor == -1 && dividend == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;
		// get positive values
		long dvd = Math.abs((long) dividend);
		long div = Math.abs((long) divisor);
		int result = 0;
		while (dvd >= div) {
			// calculate the number of left shifts
			int numShift = 0;
			while (dvd >= (div << numShift)) {
				System.out.println(dvd);
				System.out.print("divisor: ");
				System.out.println(div << numShift);
				numShift++;
			}
			System.out.println("shifts: "+numShift);
			// dvd minus the largets shift divisor
			result += 1<<(numShift-1);
			System.out.println("result is "+ result);
			dvd -= (div << (numShift - 1));
		}
		return 0;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i=0;i<nums.length-2;i++) {
			if(i>0 &&(nums[i] == nums[i-1])) continue;
			for (int j=i+1,k=nums.length-1;j<k;) {
				if(nums[i] + nums[j] + nums[k] == 0) {
					list.add(Arrays.asList(nums[i],nums[j],nums[k]));
					j++;
					k--;
					while((j<k) && (nums[j] == nums[j-1])) j++;
					while((j<k) && (nums[k] == nums[k+1])) k--;
				} else if (nums[i] + nums[j] + nums[k] > 0) k--;
				else j++;
			}
		}
		return list;
	}

	// given a string find the first element which is non-repetitive 
	// element must be present in the string
	public String first(String str) {
		int count;
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for(int i=0;i<str.length();i++) {
			if(!hm.containsKey(str.charAt(i)+"")) {
				count = 0;
			}
			else {
				count = hm.get(str.charAt(i)+"");
			}
			hm.put(str.charAt(i)+"",count+1);
		}
		for(Map.Entry<String,Integer> entry: hm.entrySet()) {
			if(entry.getValue() == 1) {
				System.out.println(entry.getKey());
				return entry.getKey();
			}
		}
		return "";
	}

	// finding the next greater number...
	// public String findNextGreater(String str) {
	// 	boolean increase = true;
	// 	boolean decrease = true;
	// 	for(int i=str.length()-1;i>0;i--) {
	// 		// increasing
	// 		if(Integer.parseInt(str.charAt(i)) <= Integer.parseInt(str.charAt(i-1))) {
	// 			increase = false;
	// 		} else {
	// 			decrease = false;
	// 		}
	// 	}
	// 	// if constantly increasing then swap last two digits
	// 	if(increase) {
	// 		String strb = str.substring(0,str.length()-2);
	// 		strb = strb + str.substring(str.length()-1) + str.substring(str.length()-2,str.length()-1);
	// 		return strb;
	// 	}
	// 	if(decrease) return "Not Possible";

	// 	// if not strictly increasing or decreasing : 
	// 	// find the next smaller number 
	// 	int ind = 0;
	// 	for(int i=str.length()-1;i>0;i--) {
	// 		if(Integer.parseInt(str.charAt(i) > Integer.parseInt(str.charAt(i-1)))) {
	// 			ind = i-1;
	// 			break;
	// 		}
	// 	}
	// 	//...
	// 	return "";
	// }

	// an array of 1s followed by 0s find the # of 0s...
	public int NumberZeros(int[] nums) {
		// getting the first index and last index and get the length of 
		// all the zeros
		int start = 0;
		int end = 0;
		if(nums.length == 0 && nums[0] !=0 ) return 0;
		if(nums.length == 0 && nums[0] == 0) return 1;
		int mid = nums.length/2;
		if(nums[mid] == 0) {
			if(nums[mid-1] == 1) return nums.length-mid;
			else {
				start = 0;
				end = mid - 1;
			}
		}
		if(nums[mid] == 1) {
			if(nums[mid+1] == 0) return nums.length-mid-1;
			else {
				start = mid+1;
				end = nums.length-1;
			}
		}
		System.out.println(start);
		System.out.println(end);
		int out = BinarySearch(nums,start,end);

		return nums.length-out;
	}

	public int BinarySearch(int[] nums,int start, int end) {
		if(end-start+1 <= 1) return 0;
		if(end-start+1 == 2) {
			if(nums[start] == 1 && nums[end] == 0) return end;
			else return 0;
		}
		int mid = (end-start)/2;
		int[] left = Arrays.copyOfRange(nums,start,mid);
		int[] right = Arrays.copyOfRange(nums,mid,end+1);
		return BinarySearch(left,start,mid) + BinarySearch(right,mid,end);
	}
	// return the pair of positive and negative values 
	// that have the closest value to zero
	public int[] getPair(int[] nums) {
		Arrays.sort(nums);
		int i=0;
		int j=nums.length-1;
		int curdist = Integer.MAX_VALUE;
		int[] out = new int[2];
		while(i<j) {
			int sum = nums[i]+nums[j];
			// if(nums[i]*nums[j]<0) {
				if(Math.abs(nums[i]+nums[j]) < curdist) {
					curdist = Math.abs(nums[i]+nums[j]);
					out[0] = nums[i];
					out[1] = nums[j];
				}
			// }
			if(sum > 0) {
				j--;
			}
			else if(sum < 0) {
				i++;
			}
			else {
				out[0] = nums[i];
				out[1] = nums[j];
			}
		}
		return out;

	}

	public List<List<TreeNode>> allPaths(TreeNode root) {
		List<TreeNode> inner = new ArrayList<TreeNode>();
		List<List<TreeNode>> out = new ArrayList<List<TreeNode>>();
		List<List<TreeNode>> res = dfs(root,inner,out);
		return res;
	}

	public List<List<TreeNode>> dfs(TreeNode root, List<TreeNode> inner, List<List<TreeNode>> out) {
		if(root.left == null && root.right == null) {
			inner.add(root);
			out.add(new ArrayList<TreeNode>(inner));
			return out;
		}
		else {
				inner.add(root);
				if(root.left!=null)
					out = dfs(root.left,new ArrayList<TreeNode>(inner),out);
				if(root.right!=null)
					out = dfs(root.right,new ArrayList<TreeNode>(inner),out);
				inner.remove(inner.size()-1);

			}
		return out;
	}

	// public Node bitree2listUtil(Node node) {
	// 	if(node==null)
	// 		return node;

	// 	// convert the left subtree and link to root
	// 	if(node.left != null) {
	// 		Node left = bitree2listUtil(node.left);
	// 		for(; left.right !=null;left = left.right);

	// 		// make root as next of the predecessor
	// 		left.right = node;
	// 		node.left = left;


	// 	}

	// 	//convert the right subtree and link to root
	// 	if(node.right != null) {
	// 		Node right = bintree2listUtil(node.right);
	// 		for(;right.left != null;right = right.left);
	// 		right.left = node;
	// 	    node.right = right;
	// 	}
	// 	return node;
	// }

	// a product array puzzle:
	// solve without division operator in O(n)
	public int[] ProductArrayPuzzle(int[] arr) {
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int[] prod = new int[arr.length];
		left[0] = 1;
		right[arr.length-1] = 1;
		for(int i = 1;i<arr.length;i++) {
			left[i] = left[i-1]*arr[i-1];
		}
		for(int j = arr.length-2;j>=0;j--) {
			right[j] = right[j+1] * arr[j+1];
		}
		for(int k=0;k<arr.length;k++) {
			prod[k] = left[k]*right[k];
		}
		return prod;
	}

	//given a binary tree convert to double linkedlist...
	// given an array of integers replace each element by 
	// hashmap:
	public List<String> anagrams(String[] strs) {
		HashMap<String, LinkedList<String>> dict = new HashMap<String,LinkedList<String>>();
		for(int i=0;i<strs.length;i++) {
			String s = strs[i];
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String sortStr = String.valueOf(chars);
			if (dict.containsKey(sortStr)) {
				dict.get(sortStr).add(s);
			} else {
				LinkedList<String> list = new LinkedList<String>();
				list.add(s);
				dict.put(sortStr,list);
			}
		}
		List<String> ret = new LinkedList<String>();
		for (LinkedList<String> list: dict.values()) {
			if(list.size() > 1) {
				ret.addAll(list);
			}
		}
		return ret;
	}

	// method check if the tree is binary search tree:
	public boolean isBSTUtil(Node node, int min, int max) {
		if(node == null) {
			return true;
		}

		if(node.val<min || node.val > max) {
			return false;
		}
		// for the left branch the max is the node's value...
		else return (isBSTUtil(node.left,min,node.val) 
			&& isBSTUtil(node.right,node.val,max));
	}
	
	// level order tree traversal for bst
	public List<TreeNode> LevelOrderBST(TreeNode root) {
		List<TreeNode> l = new ArrayList<TreeNode>();
		if(root==null) {
		}
		else {
			LinkedList<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			TreeNode cur = root;
			while(!q.isEmpty()) {
				// poll retrieve and remove the head of the queue 
				cur = q.poll();
				l.add(cur);
				if(cur.left!=null) q.add(cur.left);
				if(cur.right!=null) q.add(cur.right);
			}
		}
		return l;
	}

	// get the min through matrix
	// finding the mininum value in the all paths of this matrix
	public int getMinMatrix(int[][] matrix) {
		if(matrix.length == 0) return 0;
		int[][] count = new int[matrix.length][matrix[0].length];
		count[0][0] = matrix[0][0];
		for(int i=1;i<matrix.length;i++) {
			count[i][0] = count[i-1][0] + matrix[i][0];
		}
		for(int j=1;j<matrix[0].length;j++) {
			count[0][j] = count[0][j-1] + matrix[0][j];
		}

		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[0].length;j++) {
				count[i][j] = Math.min(count[i-1][j]+matrix[i][j],count[i][j-1]+matrix[i][j]);
			}
		}

		return -1*(count[matrix.length-1][matrix[0].length-1])+1;

	}

	// if you have inifinite stream of the repeative number find the top k frequentist 
	// numbers from its stream

	public static void main(String[] args) {
		April052016 a = new April052016();
		
		// int[] arr = {10,3,5,6,2};
		// int[] out = a.ProductArrayPuzzle(arr);
		// for(int e:out) {
		// 	System.out.print(e+" ");
		// }
		// System.out.println();
		// a.divide(35,5);
		// System.out.println(a.first("teeterson"));
		// int[] nums = {1,1,1,1,0,0};
		// System.out.println(a.NumberZeros(nums));
		// int[] nums2 = {3,5,-9,-4,17,11};
		// int[] out = a.getPair(nums2);
		// System.out.println(out[0]);
		// System.out.println(out[1]);
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		// root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(7);
		// List<TreeNode> l = a.LevelOrderBST(root);
		// l.forEach(ele->System.out.print(ele.val+" "));
		List<List<TreeNode>> out = a.allPaths(root);
		for(List<TreeNode> o: out) {
			o.forEach(ele->System.out.print(ele.val));
			System.out.println();
		}

		// int[][] matrix = {
		// 	{2,3,4},
		// 	{-5,-6,7},
		// 	{8,3,1}
		// };
		// System.out.println(a.getMinMatrix(matrix));

	}
}