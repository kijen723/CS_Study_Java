package com.kijen.cs.math;

public class Factorial {
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Factorial fc = new Factorial();

        int n = 5;

        System.out.println("n = " + n + ", n! = " + fc.factorial(n));
    }
}
