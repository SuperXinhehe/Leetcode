import java.util.*;
// require no additional space and O(n) running time complexity
public class OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    
    if(head==null) return null;
    ListNode oddHead = head.clone();
    ListNode odd = head.clone();
    ListNode even = head.next.clone();
    ListNode evenHead = head.next.clone();
    while(even!=null && even.next!=null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return oddHead;
  }

  public static void main(String args[]) {
    

  }

}
