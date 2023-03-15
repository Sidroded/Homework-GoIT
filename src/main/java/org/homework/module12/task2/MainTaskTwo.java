package org.homework.module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainTaskTwo {
    public static volatile int count = 1;
    public static int num;
    public static final Object MONITOR = new Object();
    public static BlockingQueue<String> fizzQueue = new LinkedBlockingQueue<>();
    public static BlockingQueue<String> buzzQueue = new LinkedBlockingQueue<>();
    public static BlockingQueue<String> fizzBuzzQueue  = new LinkedBlockingQueue<>();


    public static void main(String[] args) throws InterruptedException {
        num = TaskUtils.getNum();

        Thread a = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    if (isCountGreaterThanNum()) {
                        return;
                    } else if (count % 3 == 0 && count % 5 != 0) {
                        fizzQueue.add("fizz");
                        count++;
                    }
                }
            }
        });

        Thread b = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    if (isCountGreaterThanNum()) {
                        return;
                    } else if (count % 3 != 0 && count % 5 == 0) {
                        buzzQueue.add("buzz");
                        count++;
                    }
                }
            }
        });
        Thread c = new Thread(() -> {
            while (true){
                synchronized (MONITOR) {
                    if (isCountGreaterThanNum()) {
                        return;
                    } else if (count % 3 == 0 && count % 5 == 0) {
                        fizzBuzzQueue.add("fizzbuzz");
                        count++;
                    }
                }
            }
        });
        Thread d = new Thread(() -> {
            StringBuilder stringBuffer = new StringBuilder();

            synchronized (MONITOR) {
                while (true) {
                    if (isCountGreaterThanNum()) {
                        System.out.println(stringBuffer);
                        return;
                    } else if (!fizzQueue.isEmpty()) {
                        stringBuffer.append("fizz, ");
                        MainTaskTwo.fizzQueue.remove();
                    } else if (!MainTaskTwo.buzzQueue.isEmpty()) {
                        stringBuffer.append("buzz, ");
                        MainTaskTwo.buzzQueue.remove();
                    } else if (!MainTaskTwo.fizzBuzzQueue.isEmpty()) {
                        stringBuffer.append("fizzbuzz, ");
                        MainTaskTwo.fizzBuzzQueue.remove();
                    } else {
                        stringBuffer.append(MainTaskTwo.count).append(", ");
                        MainTaskTwo.count++;
                    }
                }
            }
        });

        a.start();
        b.start();
        c.start();
        d.start();

        a.join();
        b.join();
        c.join();
        d.join();
    }


    public static synchronized boolean isCountGreaterThanNum() {
        return count > num;
    }
}
