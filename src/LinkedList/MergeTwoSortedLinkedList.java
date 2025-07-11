package LinkedList;

public class MergeTwoSortedLinkedList {

    public class ListNode {
        int val;
        ReverseLinkedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ReverseLinkedList.ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode l1=list1,l2=list2;

        if(l1==null && l2 ==null)
            return null;
        ListNode mergedList=null,head =null;
        ListNode newNode = new ListNode();
        while(   l1!=null && l2!=null     ){
            if(l1.val<l2.val){
                newNode = new ListNode(l1.val,null);
                if(head==null){
                    mergedList =newNode;
                    head =mergedList;
                }else{
                    mergedList.next = newNode;
                    mergedList = mergedList.next;
                }
                l1=l1.next;
            }else{
                newNode = new ListNode(l2.val,null);
                if(head==null){
                    mergedList =newNode;
                    head =mergedList;
                }else{
                    mergedList.next = newNode;
                    mergedList = mergedList.next;
                }
                l2=l2.next;
            }
        }
        while(l1!=null){
            newNode = new ListNode(l1.val,null);
            if(head==null){
                mergedList =newNode;
                head =mergedList;
            }
            else{
                mergedList.next = newNode;
                mergedList = mergedList.next;
            }
            l1=l1.next;
        }
        while(l2!=null){
            newNode = new ListNode(l2.val,null);
            if(head==null){
                mergedList =newNode;
                head =mergedList;
            }
            else{
                mergedList.next = newNode;
                mergedList = mergedList.next;
            }
            l2=l2.next;
        }
        return head;
    }
}
