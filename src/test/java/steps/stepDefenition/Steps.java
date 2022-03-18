package stepDefenition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

public class Steps {
    int a;
    int b;
    double result;
    String action;

    @Дано("^два числа (.*) и (.*)$")
    public void given(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Тогда("^находим (.*) двух чисел$")
    public void result(String action) {
        switch (action) {
            case "сложение":
                this.action = "Сложение";
                this.result = a + b;
                break;
            case "вычитание":
                this.action = "Вычитание";
                this.result = a - b;
                break;
            case "умножение":
                this.action = "Умножение";
                this.result = a * b;
                break;
            case "деление":
                this.action = "Деление";
                this.result = (float) a / b;
                break;
        }
    }

    @И("^выводим результат на экран$")
    public void printResult() {
        System.out.println(action + " чисел " + a + " и " + b + " равняется " + result);
    }
}
