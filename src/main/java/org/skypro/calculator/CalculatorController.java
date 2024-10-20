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
                "Используйте операции: plus, minus, multiply, divide. " + 
                "Например: /calculator/calculate?num1=5&num2=3&operation=plus";
    }

    @GetMapping(value = "/calculate")
    public String calculate(@RequestParam Double num1, @RequestParam Double num2,
            @RequestParam String operation) {

        switch (operation) {
            case "plus":
                return num1 + " + " + num2 + " = " + (num1 + num2);
            case "minus":
                return num1 + " - " + num2 + " = " + (num1 - num2);
            case "multiply":
                return num1 + " * " + num2 + " = " + (num1 * num2);
            case "divide":
                if (num2 == 0) {
                    return "Ошибка: Деление на ноль недопустимо.";
                }
                return num1 + " / " + num2 + " = " + (num1 / num2);
            default:
                return "Ошибка: Неизвестная операция.";
        }
    }
}
