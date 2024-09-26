package com.cs.dsa;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit a task for execution
        Future<String> futureResult = executorService.submit(() -> {
            Thread.sleep(5000); // Simulating some time-consuming task
            return "Task completed!";
        });

        // Perform other operations while the task is running

        try {
            // Retrieve the result of the task (blocks until the task is complete)
            String result = futureResult.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown the ExecutorService
        executorService.shutdown();
    }
}
