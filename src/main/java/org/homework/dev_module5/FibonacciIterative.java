package org.homework.dev_module5;

/**
    Просторова складність O(1)
    Часова складність О(n)
 ________________________________________
|          FibonacciIterative            |
|________________________________________|
| + fibonacci(n: int): int               |
|________________________________________|

                   |
                   V
            [Початок методу]
                   |
                   V
          [Перевірка n <= 1]
          /            \
         / Так          \ Ні
         |               |
         V               V
   [Повернення n]  [Встановлення fib = 1 і prevFib = 1]
         |               |
         V               V
  [Цикл від i=2 до n-1]
         |               |
         V               V
   [Обчислення fib]  [Оновлення prevFib і fib]
         |               |
         V               V
   [Завершення циклу]    [Повернення fib]
         |               |
         V               V
      [Завершення методу]

 **/
public class FibonacciIterative {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int fib = 1;
        int prevFib = 1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }

        return fib;
    }
}
