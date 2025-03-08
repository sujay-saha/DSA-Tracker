package QueueDemo;

import java.util.PriorityQueue;
import java.util.Queue;

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
