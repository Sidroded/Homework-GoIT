package org.homework.module12.task2.threads;

import org.homework.module12.task2.MainTaskTwo;

public class B implements Runnable {
    @Override
    public void run() {
        buzz();
    }

    private void buzz() {
        while (true) {
            synchronized (MainTaskTwo.class) {
                if (MainTaskTwo.isCountGreaterThanNum()) {
                    return;
                } else if (MainTaskTwo.count % 3 != 0 && MainTaskTwo.count % 5 == 0) {
                    MainTaskTwo.addToBuzzQueue("buzz");
                    MainTaskTwo.count++;
                }
            }
        }
    }
}
