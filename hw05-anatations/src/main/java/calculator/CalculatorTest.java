package calculator;

import ru.otus.anatations.AfterEach;
import ru.otus.anatations.BeforeEach;
import ru.otus.anatations.Test;


public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
        System.out.println("test");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        int x = 2;
        int y = 3;
        int result = calculator.add(x, y);
        assert 5 == result;
    }

    @Test
    void div() {
        int x = 6;
        double y = 3;
        double result = calculator.div(x, y);
        assert 2 == result;
    }

}