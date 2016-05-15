public int findKthLargest(int[] nums,int k) {
	mergeSort(nums);
	return nums[k-1];
}

public void mergeSort(int[] nums) {
	int[] tmp = new int[nums.length];
	mergeSort(nums,tmp,0,nums.length-1);
}

private void mergeSort(int[] a, int[] tmp, int left,int right) {
	if(left < right) {
		int mid = (left + right) / 2;
		mergeSort(a,tmp,left,mid);
		mergeSort(a,tmp,mid+1,right);
		merge(a,tmp,left,mid+1,right);
	}
}

private void merge(int[] a, int[] tmp, int left, int right, int rightEnd) {
	int leftEnd = right - 1;
	int k = left;
	int num = rightEnd - left + 1;
	while (left <= leftEnd && right <= rightEnd) {
		if (a[left] >= a[right]) {
			tmp[k++] = a[left++];
		}
		else {
			tmp[k++] = a[right++];
		}
	}
	while (left <= leftEnd) {
		tmp[k++] = a[left++];
	} 
	while (right <= rightEnd) {
		tmp[k++] = a[right++];
	}
	// copy tmp back
	for (int i=0;i<num;i++,rightEnd--) {
		a[rightEnd] = tmp[rightEnd];
	}
}

// iterative trips
LinkedList<String> res;
Map<String, PriorityQueue<String>> mp;
public List<Integer> findItinerary(String[][] tickets) {
	int (tickets == null || tickets.length==0) return new LinkedList<String>();
	res = new LinkedList<String>();
	mp = new HashMap<String, PriorityQueue<String>>();
	for (String[] ticket : tickets) {
		if (!mp.containsKey(ticket[0])) {
			mp.put(ticket[0],new PriorityQueue<String>());
		}
		mp.get(ticket[0]).offer(ticket[1]);
	}
	dfs("JFK");
	return res;
}

public void dfs(String cur) {
	while (mp.containsKey(cur) && !mp.get(cur).isEmpty()) {
		dfs(mp.get(cur).poll());
	}
	res.addFirst(cur);
}

import java.util.*;
public class Solution {
	public LinkedHashMap<String,TreeSet<String>> hm = new LinkedHashMap<String,TreeSet<String>>();
    public List<String> findItinerary(String[][] tickets) {
        List<String> ans = new ArrayList<String>();
		for(int i=0;i<tickets.length;i++) {
			TreeSet<String> l;
			if(hm.containsKey(tickets[i][0])) {
				l = hm.get(tickets[i][0]);
			}
			else {
				l = new TreeSet<String>();
			}
			l.add(tickets[i][1]);
			hm.put(tickets[i][0],l);
		}
		// output a list from dfs function...
		ans = dfs("JFK",ans);
		// reverse the ans list...
		Collections.reverse(ans);
		return ans;
    }
    
	public List<String> dfs (String source, List<String> ans) {
		TreeSet<String> l = hm.get(source);
// 		System.out.println("adding :"+source);
		if(l==null) {
			ans.add(source);
			return ans;
		}
// 		ans.forEach(ele->System.out.print(ele));
		// System.out.println("....ans list:");
		while(!l.isEmpty()) {
			String v = l.first();
// 			System.out.println(v);
			l.remove(v);
			ans = dfs(v,ans);
		}
		ans.add(source);
		return ans;
	}
}

public class QueueWithTwoStacks<Item> {
	private Stack<Item> stack1; // back of queue
	private Stack<Item> stack2; // front queue

	public QueueWithTwoStacks() {
		stack1 = new Stack<Item>();
		stack2 = new Stack<Item>();
	}
	// move all items from stack1 to stack2
	private void moveStack1ToStack2() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}

	public int size() {
		return stack1.size() + stack2.size();
	}

	public Item peek() {
		if (isEmpty()) throw new NoSuchElementException("Queue Underflow");
		if (stack2.isEmpty()) moveStack1ToStack2();
		return stack2.peek();
	}
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue Underflow");
		if (stack2.isEmpty()) moveStack1ToStack2();
		return stack2.pop();
	}

}

int[][] tree;
int[][] nums;
int m;
int n;

public NumMatrix(int[][] matrix) {
	if (matrix.length==0 || matrix[0].length == 0) {
		m = matrix.length;
		n = matrix[0].length;
		tree = new int[m+1][n+1];
		nums = new int[m][n];
		for (int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				update(i,j,matrix[i][j]);
			}
		}
	}
}

public void update(int row,int col,int val) {
	if(m==0||n==0) return;
	int delta = val - nums[row][col];
	nums[row][col] = val;
	for (int i=row + 1;i<=m;i+=i & (-i)) {
		for (int j=col+1;j<=n;j+=j&(-j)) {

		}
	}
}



// unsorted slots with numbers [3,1,0,2,x,4]
// empty spot is represented by -1
public int[] SortWithEmptySlot(int[] nums) {
	int ind = 0;
	// use treemap to record every element's index
	// ordered from min to max...
	TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
	for (int i=0;i<nums.length;i++) {
		if(nums[i] == -1) {
			ind = i;
		}
		tm.put(nums[i],i);
	}
	Set keyset = tm.keySet();
	for (int k=0;k<nums.length;k++) {
		// not equal need to move
		if(nums[k] != keyset.get(k)) {
			if(k != ind) {
				// move the -1 to right slot
				swap(nums,k,ind);
				ind = k;
			}
			swap(nums,ind,tm.get(k));
			ind = tm.get(k);
		}
	}
	return nums;
}

public void swap(int[] nums,int i,int j) {
	int t = nums[i];
	nums[i] = nums[j];
	nums[j] = t;
}






























