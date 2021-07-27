package com.company.reflection;

import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        BankAccount bankAccount = new BankAccount("1234");
        BankAccount bankAccount1 = new BankAccount("5678", 100);

        //System.out.println(bankAccount.getClass().getSimpleName());
/*        System.out.println(bankAccount.getClass().getFields());
        System.out.println(bankAccount.getClass().getConstructors());
        System.out.println(bankAccount.getClass().getMethods());*/
        //System.out.println(BankAccount.class);

        doWork(bankAccount);
        doWork(BankAccount.class);
    }

    private static void showName(Class<?> theClass) {
        System.out.println(theClass.getSimpleName());
    }

    private static void doWork(Object ob){
        Class<?> c = ob.getClass();
        showName(c);
    }

    private void classInfo(Object obj){
        Class<?> theClass = obj.getClass();
        System.out.println(theClass.getSimpleName());

        Class<?> supClass = theClass.getSuperclass();
        System.out.println(supClass.getSimpleName());

        Class<?> [] interfaces = theClass.getInterfaces();

        for(Class<?> i: interfaces){
            System.out.println(i.getSimpleName());
        }

    }

    private void typeModifier(Object obj){
        Class<?> theClass = obj.getClass();

        int modifiers  = theClass.getModifiers();

        if ((modifiers & Modifier.FINAL) > 0) {
            System.out.println("bitwise check - final");
        }

        if(Modifier.isFinal(modifiers)){
            System.out.println("method check - final");
        }
        if(Modifier.isPrivate(modifiers)){
            System.out.println("method check - private");
        }
        if(Modifier.isPublic(modifiers)){
            System.out.println("method check - public");
        }
        //more modifiers
    }
}
