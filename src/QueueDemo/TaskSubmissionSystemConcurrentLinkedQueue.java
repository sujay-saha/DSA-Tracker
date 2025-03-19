package QueueDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskSubmissionSystemConcurrentLinkedQueue {
    /*
    * An implementation of the queue interface that supports lock-free,
    * thread-safe operations
    * High throughput
    */

    private static ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>();
    public static void main(String[] args) {
        Thread producer = new Thread(()->{
            int taskId=0;
            while(true) {
                try {
//                    taskQueue.put("Task#"+ taskId++ + ":  " + System.currentTimeMillis()); //Adds task (will use locks internally)
                    taskQueue.add("Task#"+ taskId++ + ":  " + System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(()->{
            while(true) {
                try {
//                    String message = taskQueue.take(); //Takes task (will use locks internally)
                    String message = taskQueue.poll();
                    System.out.println("Processing: " + message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
