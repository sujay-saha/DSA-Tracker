package QueueDemo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueuePrac {

    static void printJobStack(LinkedList list){
        System.out.println("Stack________________");
        System.out.println(list);
        System.out.println("Removed 1 item: "+list.removeFirst());
        System.out.println(list);
    }

    static void printJobQueue(LinkedList list){
        System.out.println("Queue________________");
        System.out.println(list);
        System.out.println("Dequeue 1 item: "+list.remove()); //dequeue
        System.out.println(list);
        System.out.println("Peek: "+list.getFirst()); //peek
    }

    private static LinkedList createStack(){
        /*LinkedList as a Stack*/
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(3);
        stack.addFirst(2);
        stack.addFirst(69);
        printJobStack(stack);
        return stack;
    }

    private static LinkedList createQueue(){
        /*LinkedList as a Queue*/
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);   //enqueue
        queue.add(2);
        queue.add(3);
        printJobQueue(queue);
        return queue;
    }

    private static Queue<Integer> createQueueOrig(){
        /*LinkedList as a Queue*/
        Queue<Integer> queue = new LinkedList<>();
        System.out.println("Queue1::________________");

        queue.add(1);
        System.out.println("Queue Size: "+queue.size());

        System.out.println(queue.remove()); //throws exception if queue empty
        System.out.println(queue.poll());

        //System.out.println("Element: "+queue.element());    //throws exception if queue empty
        System.out.println("Peek: "+queue.peek());

        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2);
        System.out.println("Queue2::________________");
        queue2.add(1);
        queue2.offer(2);

        //queue2.add(3);  //throws exception if queue full
        queue2.offer(3);

        return queue;
    }

    public static void main(String[] args) {

        //createStack();
        //createQueue();
        createQueueOrig();

    }
}
