package QueueDemo;

import java.util.Comparator;
import java.util.concurrent.*;

class Producer implements Runnable {
    private BlockingQueue<Integer> queue;
    private int value = 0;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Producer produced: " + value);
                queue.offer(value++);
                Thread.sleep(1000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted");
            }

        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer value = queue.take();
                System.out.println("Consumer consumed: " + value);
                queue.put(value);
                Thread.sleep(2000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted");
            }

        }
    }
}

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
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        //A bounded(fixed capacity), blocking queue backed by a circular array
        //low memory overhead
        //uses a single lock for both enqueue and dequeue operations, ok to use for two threads, but if multiple threads use single lock it would be congested
        //more threads--> problem
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();

        //Second Implementation
        BlockingQueue<Integer> queue1 = new LinkedBlockingQueue<>();
        // Optionally bounded unbounded risk OutOfMemory Error, Always keep it bounded
        // Backed by LinkedList
        // Uses two separate locks for enqueue and dequeue operations
        // Higher concurrency between producers and consumers
        // Overall throughput increases, waiting decreases

        BlockingQueue<Integer> queue2 = new PriorityBlockingQueue<>();
        // unbounded
        // unordered except head
        // Binary Heap as array and can grow dynamically
        // Head is ordered based on their natural ordering or a provided Comparator lieke priority queue
        // put wont block
        BlockingQueue<String> queue3 = new PriorityBlockingQueue<>(1, Comparator.reverseOrder());
        queue3.add("apple");
        queue3.add("banana");
        queue3.add("cherry");
        System.out.println(queue3);
    }
}


