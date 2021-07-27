package com.company.javacore.reflection;

public class BankAccount {
    private final String id;
    private int balance = 0;

    public BankAccount(String id) {
        this.id = id;
    }

    public BankAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

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
