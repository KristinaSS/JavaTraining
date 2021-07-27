package com.company.javacore.multithreading.generalexample;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        String[] inFiles = {"src/com/company/Multithreading/Files/file1", "src/com/company/Multithreading/Files/file2",
                "src/com/company/Multithreading/Files/file3", "src/com/company/Multithreading/Files/file4",
                "src/com/company/Multithreading/Files/file5", "src/com/company/Multithreading/Files/file6"};
        String[] outFiles = {"src/com/company/Multithreading/Files/file1.out", "src/com/company/Multithreading/Files/file2.out",
                "src/com/company/Multithreading/Files/file3.out", "src/com/company/Multithreading/Files/file4.out",
                "src/com/company/Multithreading/Files/file5.out", "src/com/company/Multithreading/Files/file6.out"};

        //Bad example if we are using a lot of big files using Runnable
       /*
       Thread[] threads = new Thread[inFiles.length];

        for(int i = 0; i<inFiles.length; i++){
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }

        //Main thread doesn't stop until all thread processes are executed
        for (Thread thread: threads){
            try {
                thread.join(); //Blocks waiting for thread completion
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        //using thread pools and Callable

        //No more than 3 running threads at once
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //Works with Callable interface
        Future<Integer> [] results = new Future[inFiles.length];

        for(int i = 0; i<inFiles.length; i++){
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            results[i] = executorService.submit(adder);
        }

        try {
            executorService.shutdown();
            executorService.awaitTermination(60, TimeUnit.SECONDS);
            //main thread bocks waiting for work to be done

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Future<Integer> res : results){
            try {

                int value = res.get(); // blocks until return value is available
                System.out.println("Total: " + value );

            }catch (ExecutionException e){
                Throwable adderEx = e.getCause();
                adderEx.printStackTrace();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
