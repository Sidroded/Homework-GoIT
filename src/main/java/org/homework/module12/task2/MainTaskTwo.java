package org.homework.module12.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MainTaskTwo {
    public static AtomicInteger count = new AtomicInteger(1);
    public static int num;
    public static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        int n = TaskUtils.getNum();

        new Thread(() -> {
            try {
                fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fizzbuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public static void fizz() throws InterruptedException {
        while (true) {
            synchronized (queue) {
                if (count.get() % 3 == 0 && count.get() % 5 != 0) {
                    queue.add("fizz");
                    count.incrementAndGet();
                    queue.notifyAll();
                } else {
                    try {
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            Thread.sleep(10);
        }
    }

    public static void buzz() throws InterruptedException {
        while (true) {
            synchronized (queue) {
                if (isCountGreaterThanNum()) {
                    return;
                } else if (count.get() % 3 != 0 && count.get() % 5 == 0) {
                    queue.add("buzz");
                    count.incrementAndGet();
                    queue.notifyAll();
                } else {
                    try {
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            Thread.sleep(10);
        }
    }

    public static void fizzbuzz() throws InterruptedException {
        while (true) {
            synchronized (queue) {
                if (isCountGreaterThanNum()) {
                    return;
                } else if (count.get() % 3 == 0 && count.get() % 5 == 0) {
                    queue.add("fizzbuzz");
                    count.incrementAndGet();
                    queue.notifyAll();
                } else {
                    try {
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            Thread.sleep(10);
        }
    }

    public static void number() throws InterruptedException {
        List<String> list = new ArrayList<>();

        while (true) {
            synchronized (queue) {
                if (isCountGreaterThanNum()) {
                    System.out.println(String.join(", ", list));
                    return;
                } else if (!queue.isEmpty()) {
                    try {
                        list.add(queue.take());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    synchronized (queue) {
                        queue.add(String.valueOf(count));
                        count.incrementAndGet();
                        queue.notifyAll();
                    }
                }
            }
            Thread.sleep(10);
        }
    }


    public static synchronized boolean isCountGreaterThanNum() {
        return count.get() > num;
      }
}
