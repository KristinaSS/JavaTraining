package com.company.javacore.multithreading.bankexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        /*
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(100);

        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker(account);
            executorService.submit(worker);
        }

        //don't forget shutdown
        try {
            executorService.shutdown();
            executorService.awaitTermination(60, TimeUnit.SECONDS);
            //main thread bocks waiting for work to be done

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        //Synchronization is used to solve multithreading problems

        //Another bank example - manual multithreading

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        TransactionWorker[] workers = new TransactionPromoWorker[3];

        for(TransactionWorker worker : workers){
            executorService.submit(worker);
        }

        try {
            executorService.shutdown();
            executorService.awaitTermination(60, TimeUnit.SECONDS);
            //main thread bocks waiting for work to be done

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
