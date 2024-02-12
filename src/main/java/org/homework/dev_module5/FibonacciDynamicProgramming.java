package org.homework.dev_module5;

/**
    Просторова складність O(n)
    Часова складність О(n)

 ________________________________________
|  FibonacciDynamicProgramming           |
|________________________________________|
| + fibonacci(n: int): int               |
|________________________________________|

                   |
                   V
            [Початок методу]
                   |
                   V
    [Створення масиву fib розміром n+1]
                   |
                   V
[Ініціалізація fib[0] і fib[1] = 0 і 1]
                   |
                   V
            [Цикл від i=2 до n]
                   |
                   V
[Обчислення fib[i] = fib[i-1] + fib[i-2]]
                   |
                   V
              [Завершення циклу]
                   |
                   V
           [Повернення fib[n]]
                   |
                   V
         [Завершення методу]

 **/
public class FibonacciDynamicProgramming {
    public static int fibonacci(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }
}