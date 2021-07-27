package com.company.multithreading.bankexample;

public class TransactionWorker implements Runnable{
    protected BankAccount account;
    protected char txType; // w(withdraw)/d(deposit)
    protected int amt;

    public TransactionWorker(BankAccount account, char txType, int amt) {
        this.account = account;
        this.txType = txType;
        this.amt = amt;
    }


    @Override
    public void run() {
        if(txType == 'w'){
            account.withdrawal(amt);
        }else if(txType == 'd'){
            account.deposit(amt);
        }
    }
}
