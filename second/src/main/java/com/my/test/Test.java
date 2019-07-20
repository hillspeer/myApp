package com.my.test;

import java.util.concurrent.CountDownLatch;

class A {

    //CountDownLatch latch = new CountDownLatch(1);
    //Object lock = new Object();

    public synchronized void foo() {
        try {
            System.out.println("insie foo " + Thread.currentThread().getName());
            Thread.sleep(4000);
            //latch.await();
            
            //this.wait();
            
            System.out.println(" foo wait lapsed " + Thread.currentThread().getName());
            //Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public synchronized void bar() {
        try {
            System.out.println("insie bar " + Thread.currentThread().getName());

            
                //Thread.sleep(2000);
                //this.notify();
                //latch.countDown();
            

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        A a = new A();

        Runnable r1 = ()->{
            a.foo();
        };
        new Thread(r1,"t1").start();

        Runnable r2 = ()->{
            a.bar();
        };
        new Thread(r2,"t2").start();
        
        // Runnable r3 = ()->{
        //     a.bar();
        // };
        // new Thread(r3,"t3").start();

    }
    
}