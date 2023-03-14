package org.homework.module12.task2.threads;

import org.homework.module12.task2.MainTaskTwo;

public class C implements Runnable {
    @Override
    public void run() {
        fizzbuzz();
    }

    private void fizzbuzz() {
        while (true){
            synchronized (MainTaskTwo.class) {
                if (MainTaskTwo.isCountGreaterThanNum()) {
                    return;
                } else if (MainTaskTwo.count % 3 == 0 && MainTaskTwo.count % 5 == 0) {
                    MainTaskTwo.addToFizzBuzzQueue("fizzbuzz");
                    MainTaskTwo.count++;
                }
            }
        }
    }
}
