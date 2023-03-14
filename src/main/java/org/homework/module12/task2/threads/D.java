package org.homework.module12.task2.threads;

import org.homework.module12.task2.MainTaskTwo;

public class D implements Runnable {
    private int n;

    public D(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        number();
    }

    private void number() {
        StringBuilder stringBuffer = new StringBuilder();

        synchronized (MainTaskTwo.class) {
            while (true) {
                if (MainTaskTwo.isCountGreaterThanNum()) {
                    System.out.println(stringBuffer);
                    return;
                } else if (!MainTaskTwo.fizzQueue.isEmpty()) {
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
    }
}
