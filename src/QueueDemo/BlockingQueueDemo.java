package QueueDemo;

public class BlockingQueueDemo {
    /*Queue, LinkedList, PriorityQueue, Deque->{LinkedList, ArrayDequeue} are not thread safe*/
    /* -----------------------
     * BLOCKINGQUEUE::
     * -----------------------
     * +Thread Safe Queue
     * +Wait for queue to become non-empty / wait for space
     * +Simplifies concurrency problems like producer-consumer
     * #Standard Queue--> immediately operation performed
     *   -empty --> remove(no waiting)
     *   -full --> add(no waiting)
     * #BlockingQueue
     *   -put --> Blocks if the queue is full until space becomes available
     *   -take --> Blocks if the queue is empty until an element becomes available
     *   -offer --> Waits for space to become available, up to the specified timeout
     * */

    public static void main(String[] args) {

    }
}
