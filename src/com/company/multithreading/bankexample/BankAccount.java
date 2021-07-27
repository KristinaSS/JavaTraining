package com.company.multithreading.bankexample;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    //if one thread is in deposit or getBalance no other thread can call it mark as synchronized
    // this way its not done explicitly (synchronized keyword)
    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int balance) {
        this.balance += balance;
    }

    public synchronized void withdrawal(int amount) {
        balance -= amount;
    }
}
