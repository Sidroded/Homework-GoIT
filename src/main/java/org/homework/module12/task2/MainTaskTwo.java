package org.homework.module12.task2;

import org.homework.module12.task2.threads.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainTaskTwo {
    public static int count = 1;
    public static int num;
    public static BlockingQueue<String> fizzQueue = new LinkedBlockingQueue<>();
    public static BlockingQueue<String> buzzQueue = new LinkedBlockingQueue<>();
    public static BlockingQueue<String> fizzBuzzQueue  = new LinkedBlockingQueue<>();


    public static void main(String[] args) throws InterruptedException {
        num = TaskUtils.getNum();

        Thread a = new Thread(new A());
        Thread b = new Thread(new B());
        Thread c = new Thread(new C());
        Thread d = new Thread(new D(num));

        a.start();
        b.start();
        c.start();
        d.start();

        a.join();
        b.join();
        c.join();
        d.join();
    }

    public static synchronized void addToFizzQueue(String item) {
        fizzQueue.add(item);
    }

    public static synchronized void addToBuzzQueue(String item) {
        buzzQueue.add(item);
    }

    public static synchronized void addToFizzBuzzQueue(String item) {
        fizzBuzzQueue.add(item);
    }

    public static synchronized boolean isCountGreaterThanNum() {
        return count > num;
    }
}
