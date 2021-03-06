package ru.job4j.calculator;
/**
 * Class класс для вычесления арифметических операций + - * / ^.
 * @author Daniil Loputevs
 * @version v1.0
 * @since 24.09.2019
 */
public class Calculator {
    /**
     * Сложение
     * @param first перывй аргумент
     * @param second второй аргумент
     * @return результат
     */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + "+" + second + " = " + result);
    }
    public static void add(double first, double second, double third) {
        double result =  first + second + third;
        System.out.println(first + "+" + second + "+" + third + " = " + result);
    }
    public static void add(double first, double second, double third, double fourth) {
        double result =  first + second + third;
        System.out.println(first + "+" + second +  "+"  + third + "+" + fourth + " = " + result);
    }
    /**
     * Деление
     * @param first перывй аргумент
     * @param second второй аргумент
     * @return результат
     */
    public static void div(double first, double second) {
        double result =  first / second;
        System.out.println(first + "/" + second + " = " + result);
    }
    /**
     * Умножение
     * @param first перывй аргумент
     * @param second второй аргумент
     * @return результат
     */
    public static void multiply(double first, double second) {
        double result =  first * second;
        System.out.println(first + "*" + second + " = " + result);
    }
    /**
     * Вычитание
     * @param first перывй аргумент
     * @param second второй аргумент
     * @return результат
     */
    public static void subtract(double first, double second) {
        double result =  first - second;
        System.out.println(first + "-" + second + " = " + result);
    }

    public static void main(String[] args) {
        add(1, 1);
        add(1, 2, 3);
        add(1, 2, 3, 4);
        div(4, 2);
        multiply(2, 1);
        subtract(10, 5);
    }
}