package QueueDemo;

import java.util.PriorityQueue;
import java.util.Queue;
/*
* Part of the Queue Interface
* orders elements based on their natural ordering (for primitives lowest first)
* custom comparator for customized ordering
* does not allow null elements
*
* PQ is implemented by min heap by default(for natural ordering)
* Every nodes values would be less than or equal to its child nodes
* Based on this the top will have the smallest element
* Insertion:O(logn)
* Find Top: O(1)
* Deletion: O(logn)
* */
public class PriorityQueuePrac {

    private static void createPriorityQueue(){
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(15);
        queue.add(10);
        queue.add(30);
        queue.add(5);
        /*System.out.println("PQ: "+queue);
        System.out.println("PQ::PEEK_ "+queue.peek());
        System.out.println("PQ::REMOVE_ "+queue.remove());
        System.out.println("PQ::PEEK_ "+queue.peek());*/
        while(!queue.isEmpty()){
//            System.out.println("PQ: "+queue);
//            System.out.println("PQ::PEEK_ "+queue.peek());
            System.out.println("PQ::REMOVE_ "+queue.remove());
            //System.out.println("PQ::PEEK_ "+queue.peek());
        }
    }

    public static void main(String[] args) {
        createPriorityQueue();
    }
}
