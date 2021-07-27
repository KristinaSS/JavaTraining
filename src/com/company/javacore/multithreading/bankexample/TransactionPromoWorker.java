package com.company.javacore.multithreading.bankexample;

public class TransactionPromoWorker extends TransactionWorker{

    public TransactionPromoWorker(BankAccount account, char txType, int amt) {
        super(account, txType, amt);
    }

    @Override
    public void run() {
        if(txType == 'w'){
            account.withdrawal(amt);
        }else if(txType == 'd'){
            account.deposit(amt);
            if(account.getBalance() > 500){
                int bonus = (int) ((account.getBalance()-500)* 0.1);
                account.deposit(bonus);
            }
        }
    }
}
