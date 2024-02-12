package org.homework.dev_module5;

/**
    Просторова складність O(n)
    Часова складність О(2^n)
 ________________________________________
|             FibonacciRecursive         |
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
  [Повернення n]  [Рекурсивний виклик fibonacci(n-1)]
                             |
                             V
                  [Рекурсивний виклик fibonacci(n-2)]
                             |
                             V
                   [Повернення fibonacci(n-1) + fibonacci(n-2)]
                             |
                             V
                       [Повернення результату]

 **/
public class FibonacciRecursive {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}