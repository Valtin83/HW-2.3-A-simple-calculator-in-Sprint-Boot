package org.skypro.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор!" +
                "  Используйте операции: plus, minus, multiply, divide. " +
                "  Например: /calculator/calculate?a=5&b=3&operation=plus ";
    }

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam
            double a,
            @RequestParam
            double b,
            @RequestParam
            String operation) {

        switch (operation.toLowerCase()) {
            case "plus":
                return a + " + " + b + " = " + (a + b);
            case "minus":
                return a + " - " + b + " = " + (a - b);
            case "multiply":
                return a + " * " + b + " = " + (a * b);
            case "divide":
                if (b == 0) {
                    return "Ошибка: Деление на ноль недопустимо.";
                }
                return a + " / " + b + " = " + (a / b);
            default:
                return "Ошибка: Неизвестная операция.";
        }
    }
}
