package org.example;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Calculator {
    private final Scanner scanner;

    public Calculator() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        char operator = calculator.getOperator();
        int firstOperand = calculator.getOperand();
        int secondOperand = calculator.getOperand();

        int result;
        result = calculator.calculation(firstOperand, secondOperand, operator);
        System.out.println("Result: " + result);

        // Пример вызова метода calculatingDiscount
        double purchaseAmount = 100.0;
        int discountAmount = 10;
        double discountedAmount = calculator.calculatingDiscount(purchaseAmount, discountAmount);
        System.out.println("Discounted Amount: " + discountedAmount);
    }

    public char getOperator() {
        System.out.println("Enter operation: ");
        char operation = scanner.next().charAt(0);
        return operation;
    }

    public int getOperand() {
        System.out.println("Enter operand: ");
        int operand;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("You have mistaken, try again");
            if (!scanner.hasNext()) {
                throw new IllegalStateException("Input error");
            }

            scanner.next();
            operand = getOperand();
        }

        return operand;
    }

    public int calculation(int firstOperand, int secondOperand, char operator) throws IllegalStateException {
        int result;
        switch (operator) {
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '+':
                result = firstOperand + secondOperand;
                break;
            case ',':
            case '.':
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '/':
                if (secondOperand == 0) {
                    throw new ArithmeticException("Division by zero is not possible");
                }

                result = firstOperand / secondOperand;
        }

        return result;
    }

    public double squareRootExtraction(double number) {
        double squareRoot = number / 2.0;

        double t;
        do {
            t = squareRoot;
            squareRoot = (squareRoot + number / squareRoot) / 2.0;
        } while(t - squareRoot != 0.0);

        return squareRoot;
    }

    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        double discountedAmount = 0.0;
        if (purchaseAmount >= 0.0) {
            if (discountAmount >= 0 && discountAmount <= 100) {
                discountedAmount = purchaseAmount - purchaseAmount * (double)discountAmount / 100.0;
                return discountedAmount;
            } else {
                throw new ArithmeticException("The discount should be in the range of 0 to 100%");
            }
        } else {
            throw new ArithmeticException("The purchase amount cannot be negative");
        }
    }

    public int pow(int value, int powValue) {
        int result = 1;

        for(int a = 1; a <= powValue; ++a) {
            if (a == 0) {
                return 1;
            }

            result *= value;
        }

        return result;
    }

    public double computeAreaCircle(double radius) {
        return Math.PI * radius * radius;
    }

    public double computeLengthCircle(int r) {
        return 6.283185307179586 * (double)r;
    }
}

