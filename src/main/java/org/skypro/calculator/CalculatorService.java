package org.skypro.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double add(Double num1, Double num2) {
        return num1 + num2;
    }

    public double subtract(Double num1, Double num2) {
        return num1 - num2;
    }

    public double multiply(Double num1, Double num2) {
        return num1 * num2;
    }

    public double divide(Double num1, Double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Деление на ноль недопустимо.");
        }
        return num1 / num2;
    }
}
