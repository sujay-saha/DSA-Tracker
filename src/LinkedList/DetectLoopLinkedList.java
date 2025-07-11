package LinkedList;

public class DetectLoopLinkedList {

    public class ListNode {
        int val;
        ReverseLinkedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ReverseLinkedList.ListNode next) { this.val = val; this.next = next; }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next ==null){
            return false;
        }

        ListNode sNode = head;
        ListNode fNode = head;

        while(fNode.next!=null && fNode.next.next!=null){
            sNode = sNode.next;
            fNode = fNode.next.next;
            if(fNode==sNode){
                return true;
            }
        }
        return false;
    }
}
