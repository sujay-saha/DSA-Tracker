package QueueDemo;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequePrac {
    /*
    * Non-Blocking, thread-safe double-ended queue
    * CAS compare and swap
    *
    *
    * */
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        deque.add("Element1");
        deque.addFirst("Element0");
        deque.addLast("Element2");
        System.out.println(deque);

        String first = deque.removeFirst();
        String last = deque.removeLast();
        
    }
}
