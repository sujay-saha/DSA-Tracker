package LinkedList;

public class ReverseLinkedList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

        public ListNode reverseList(ListNode head) {
            ListNode temp = head;
            ListNode first = head, prev = head, prevFirst = null;
            while (temp != null) {
                first = temp;
                temp = temp.next;
                first.next = prevFirst;
                prevFirst = first;
            }
            return first;
        }

    public static void main(String[] args) {

    }
}
