package org.homework.module12.task1;

public class Timer implements Runnable {
    long startMillis;
    public Timer(long startMillis) {
        this.startMillis = startMillis;
    }

    @Override
    public void run() {
        while (true) {
            try {
                long currentTime = System.currentTimeMillis();
                System.out.println("Із моменту запуску программи пройшло - " + (currentTime - startMillis) + " мілісекунд.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
