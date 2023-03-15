package org.homework.module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainTaskTwo {
    public static volatile int count = 1;
    public static int num;
    public static final Object MONITOR = new Object();
    public static BlockingQueue<String> queue = new LinkedBlockingQueue<>();


    public static void main(String[] args) throws InterruptedException {
        num = TaskUtils.getNum();

        Thread a = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    if (isCountGreaterThanNum()) {
                        return;
                    } else if (count % 3 == 0 && count % 5 != 0) {
                        queue.add("fizz");
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
                        queue.add("buzz");
                        count++;
                    }
                }
            }
        });
        Thread c = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    if (isCountGreaterThanNum()) {
                        return;
                    } else if (count % 3 == 0 && count % 5 == 0) {
                        queue.add("fizzbuzz");
                        count++;
                    }
                }
            }
        });
        Thread d = new Thread(() -> {
            StringBuilder sb = new StringBuilder();

            while (true) {
                synchronized (MONITOR) {
                    if (isCountGreaterThanNum()) {
                        for (String str : queue) {
                            sb.append(str).append(", ");
                        }

                        System.out.println(sb);
                        return;
                    } else {
                        queue.add(String.valueOf(queue));
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
