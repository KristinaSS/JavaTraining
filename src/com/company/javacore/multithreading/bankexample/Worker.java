package com.company.javacore.multithreading.bankexample;

public class Worker implements Runnable{
    private BankAccount account;

    public Worker(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i ++ ){
            //explicit synchronization
            //has to acquire a lock on an object
            //Blocks vs methods
            //blocks provide flexibility allow non thread safe classes in a thread safe way like in this example
            //easily protect complex blocks of code without an additional method
            synchronized (account) {
                int startBalance = account.getBalance();
                account.deposit(10);
                int endBalance = account.getBalance();
                System.out.println(endBalance);
            }
        }
    }
}
