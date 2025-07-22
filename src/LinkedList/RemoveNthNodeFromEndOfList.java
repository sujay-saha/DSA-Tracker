package LinkedList;

public class RemoveNthNodeFromEndOfList {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
      
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }

        while(fast !=null){
            fast=fast.next;
            slow=slow.next;
        }
        if( slow.next !=null){
            slow.next = slow.next.next;
        }
        return dummy.next;
    }

}
