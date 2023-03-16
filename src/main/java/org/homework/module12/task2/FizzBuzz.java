package org.homework.module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {
    private final int n;
    private final BlockingQueue<String> queue;

    public FizzBuzz(int n) {
        this.n = n;
        this.queue = new LinkedBlockingQueue<>();
    }


    public void fizz() throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                queue.put("fizz");
            }
        }
    }

    public void buzz() throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                queue.put("buzz");
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            queue.put("fizzbuzz");
        }
    }

    public void number() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                queue.take();
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0) {
                queue.take();
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                queue.take();
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
