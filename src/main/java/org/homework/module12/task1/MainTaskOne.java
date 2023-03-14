package org.homework.module12.task1;

public class MainTaskOne {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();

        Thread showTimeEveryFiveSeconds = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread timer = new Thread(new Timer(startMillis));

        showTimeEveryFiveSeconds.start();
        timer.start();
    }
}


