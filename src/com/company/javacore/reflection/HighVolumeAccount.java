package com.company.javacore.reflection;

public class HighVolumeAccount extends BankAccount implements Runnable{

    public HighVolumeAccount(String id) {
        super(id);
    }

    public HighVolumeAccount(String id, int balance) {
        super(id, balance);
    }

    private int [] readDailyDeposits(){
        return new int[3];
    }

    private int [] readDailyWithdrawals(){
        return new int[3];
    }

    @Override
    public void run() {
        for (int depAmt : readDailyDeposits()){
            deposit(depAmt);
        }

        for (int withAmt : readDailyWithdrawals()){
            withdrawal(withAmt);
        }
    }
}
