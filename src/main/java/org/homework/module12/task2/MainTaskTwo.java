package org.homework.module12.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

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
                        try {
                            queue.put("fizz");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
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
                        try {
                            queue.put("buzz");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
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
                        try {
                            queue.put("fizzbuzz");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        count++;
                    }
                }
            }
        });

        Thread d = new Thread(() -> {
            List<String> list = new ArrayList<>();

            while (true) {
                synchronized (MONITOR) {
                    if (count == num) {
                        System.out.println(String.join(", ", list));
                        return;
                    } else if (!queue.isEmpty()) {
                        try {
                            list.add(queue.take());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        synchronized (MONITOR) {
                            try {
                                queue.put(String.valueOf(count));
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            count++;
                        }
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
        return count >= num;
    }
}
