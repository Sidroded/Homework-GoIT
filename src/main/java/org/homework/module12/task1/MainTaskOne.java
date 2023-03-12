package org.homework.module12.task1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainTaskOne {
    public static void main(String[] args) {
        Thread soutTime = new Thread(new SOUTTime());

        System.out.println("Start");

        Calendar timeWhenProgramStarted = Calendar.getInstance();
        long millis = timeWhenProgramStarted.get(Calendar.MILLISECOND);

        System.out.println(millis);

        soutTime.start();
    }


}

class SOUTTime implements Runnable {
    @Override
    public void run() {
        printTimeEveryFiveSeconds();
    }

    private void printTimeEveryFiveSeconds() {
        while (true) {
            try {
                Thread.sleep(5000);
                System.out.println("Минуло 5 секунд");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
