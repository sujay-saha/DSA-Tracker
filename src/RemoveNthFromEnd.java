//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode head;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next=null; this.head = this;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head,ntemp = head;
        while(n>0){
            if(ntemp.next !=null){
                ntemp = ntemp.next;
                --n;
            }
            else{
                if(n==1){   //To check if head would be deleted
                    return head.next;
                }
                else{
                    return head;
                }
            }
        }
        while(ntemp.next!=null){
            ntemp = ntemp.next;
            temp = temp.next;
        }

        temp.next = temp.next.next; //Deleting the nth Element

        return head;
    }

    static void printLL(ListNode head){
        ListNode temp = head;
        System.out.println("--------LinkedList---------");
        while(temp!=null){
            System.out.print(temp.val+",");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        System.out.println("-----------------");

        printLL(removeNthFromEnd(head,5));
    }

}
