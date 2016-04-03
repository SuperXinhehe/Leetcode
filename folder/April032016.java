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

	public ListNode reverse(ListNode mid) {
		if(mid == null) {
			return mid;
		}
		ListNode prev = null;
		ListNode curr = mid;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			
		}
	}
}