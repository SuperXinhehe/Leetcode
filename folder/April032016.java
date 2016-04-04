import java.util.*;
public class April032016 {
	// time exceeded... O(n^2)
	public boolean PalindromeLL(ListNode head) {
		if(head == null || head.next == null) return true;
		ListNode p = head;
		ListNode temp = head;
		// node p go over all the nodes until the last one
		while(temp.next != null) {
			p = temp;
			temp = temp.next;
		}
		if(head.val == temp.val) {
			p.next = null;
			return isPalindrome(head.next);
		}
		else return false;
	}


	// reverse last half linked list nodes...
	public ListNode reverse(ListNode mid) {
		if(mid == null) {
			return mid;
		}
		ListNode prev = null;
		ListNode curr = mid;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		mid = prev;
		return mid;
	}

	public boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null) {
			return true;
		}
		ListNode runner = head;
		ListNode curr = head;
		while(runner.next !=null && runner.next.next !=null) {
			curr = curr.next;
			runner = runner.next.next;
		}
		ListNode mid = curr.next;
		mid = reverse(mid);

		while(mid!=null) {
			if(head.val==mid.val) {
				head = head.next;
				mid = mid.next;
			}
			else {
				return false;
			}
		}
		return true;
	}


	// remove duplicates from sorted list:
	public ListNode deleteDuplicatesSortedList(ListNode head) {
		ListNode pre = new ListNode(0);
		ListNode head_cope = new ListNode(0);
		head_cope.next = head;
		while(head.next != null) {
			pre = head.next;
			if(pre.val == head.val) {
				head.next = pre.next;
			}
			else head = head.next;
		}
		return head_cope.next;
	}

	// remove all the duplicates in sorted list
	//***
	public ListNode deleteDuplicatesSortedListII(ListNode head) {
		ListNode pre = new ListNode(0);
		ListNode head_cope = new ListNode(0);
		head_cope.next = head;
		int curval = head.val;
		if(head.val == head.next.val) {
			head = head.next.next;
			curval = head.next.val;
		}
		while(head.next != null && head.next.next != null) {
			if(head.val == curval) {
				pre = head.next.next;
				head.next = head.next.next.next;
				curval = head.next.val;
			}
			else {
				pre = head.next;
				head.next = pre.next;
			}
		}
		return head;

	}

	// search for a range:
	// binary search
	public int[] searchRange(int[] nums,int target) {
		if (nums.length==0) {
			return new int[]{-1,-1};
		}
		int start, end, mid;
		int[] bound = new int[2];
		// search for left bound
		start = 0;
		end = nums.length - 1;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if(nums[mid] == target) {
				end = mid;
			}
			else if (nums[mid] < target) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		if(nums[start] == target) {
			bound[0] = start;
		}
		else if(nums[end] == target) {
			bound[0] = end;
		}
		else {
			bound[0] = bound[1] = -1;
			return bound;
		}
		// search for right bound
		start = 0;
		end = nums.length - 1;
		while(start + 1 < end) {
			mid = start + (end - start) / 2;
			if(nums[mid] == target) {
				start = mid;
			}
			else if(nums[mid] < target) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		if(nums[end] == target) {
			bound[1] = end;
		} else if(nums[start] == target) {
			bound[1] = start;
		}
		else {
			bound[0] = bound[1] = -1;
			return bound;
		}
		return bound;

	}
	// public int[] bSearch(int[] part,int target,int[] output) {
	// 	int len = part.length;
	// 	if(len == 1) {
	// 		if(part[0] == target) {
	// 			output[output.length-1] =  
	// 		}
	// 	}
	// }
	//backtracking
	public List<List<Integer>> combinationSum(int[] candidates,int target) {
		List<Integer> inner = new ArrayList<Integer>();
		List<List<Integer>> outer = new ArrayList<List<Integer>>();
		List<List<Integer>> out = comSumRecurse(candidates,target,inner,outer);
		return out;
	}

	public List<List<Integer>> comSumRecurse(int[] candidates,int target,List<Integer> inner, List<List<Integer>> outer) {
		if(target == 0) {
			List<Integer> i = new ArrayList<Integer>(inner);
			Collections.sort(i);
			if(!outer.contains(i)) {
				outer.add(i);
			}
			inner = new ArrayList<Integer>();
			return outer;
		}
		else {
			for(int i=0;i<candidates.length;i++) {
				if(candidates[i] <= target) {
					inner.add(candidates[i]);
					outer = comSumRecurse(candidates,target-candidates[i],inner,outer);
					inner.remove(inner.size()-1);						
				}
			}
		}
		return outer;
	}

	public static void main(String[] args) {
		April032016 a = new April032016();
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> out = a.combinationSum(candidates,target);
		for(List<Integer> o: out) {
			o.forEach(ele->System.out.print(ele));
			System.out.println();
		}
	}
}