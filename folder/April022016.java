import java.util.*;


public class April022016 {
	public int ShortestWordDist(String[] words,String w1,String w2) {
		int n = words.length;
		int i1,i2;
		for(int i=0;i<n;i++) {
			if(words[i] == w1 || words[i] == w2) {
				if(i1 == null) {
					i1 = i;
				}
				else {
					i2 = i;
					return i2 - i1 + 1;
				}
				
			}
		}
		return 0;
	}

	// delete node from linked list
	// public void deleteNode(ListNode node) {
	// 	node.val = node.next.val;
	// 	node.next = node.next.next;
	// }

	public ListNode removeElement(ListNode head,int val) {
		// use helper to store the head of the node...
		// p listnode go over the whole list nodes...
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode p = helper;
		while(p.next != null) {
			if(p.next.val == val) {
				ListNode next = p.next;
				p.next = next.next;
			}else{
				p = p.next;
			}

		}
		return helper.next;
	}


}
