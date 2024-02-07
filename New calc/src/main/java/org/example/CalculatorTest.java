package org.example;

import org.assertj.core.api.Assertions;
import org.example.Calculator;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testValidDiscountCalculation() {
        // тест на расчет скидки
        double result = Calculator.calculatingDiscount(100.0, 10);
        Assertions.assertThat(result).isEqualTo(90.0);
    }

    @Test
    public void testInvalidDiscountRange() {
        // тест на диапазон скидки
        Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(100.0, 120))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The discount should be in the range of 0 to 100%");
    }

    @Test
    public void testNegativePurchaseAmount() {
        // тест на отрицательную сумму
        Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(-50.0, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The purchase amount cannot be negative");
    }
}
