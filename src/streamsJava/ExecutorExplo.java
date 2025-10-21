package streamsJava;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExplo {
    public static void main(String[] args) throws InterruptedException {


        //threadExecute();
        executorService();
    }

    private static void executorService() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            executorService.submit(
                    () -> {
                        long result = factorial(finalI);
                        System.out.println(result);
                    });

        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("Total Time Taken:" + (System.currentTimeMillis() - startTime));
    }

    private static void threadExecute() {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            threads[i - 1] = new Thread(
                    () -> {
                        long result = factorial(finalI);
                        System.out.println(result);
                    }
            );
            threads[i - 1].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Total Time Taken:" + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int number) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
