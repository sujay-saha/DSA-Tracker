package LinkedList;

import java.util.PriorityQueue;

  //Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class KVPair implements Comparable<KVPair>{
    int val;
    ListNode node;
    KVPair(int val,ListNode node){
        this.val = val;
        this.node = node;
    }

    public int compareTo(KVPair obj)
    {
        return this.val - obj.val;
    }
}
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head =null, temp=head;
        PriorityQueue<KVPair> queue = new PriorityQueue<>();
        for(ListNode list: lists){
            if(list!=null)
                queue.add(new KVPair(list.val,list));
        }
        while(!queue.isEmpty()){
            KVPair kVPair = queue.remove();
            ListNode node = kVPair.node, next = node.next;
            if(next!= null)
                queue.add(new KVPair(next.val,next));
            if(temp==null){
                head = node;
                temp = head;
            }else{
                temp.next=node;
                temp = temp.next;
            }

        }
        return head;
    }
}