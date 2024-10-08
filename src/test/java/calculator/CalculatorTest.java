package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Queue;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();
    String str = "2 + 3 * 4 / 2";

    @Test
    @DisplayName("계산결과 확인하기")
    void process() {
        int process = calculator.process(str);

        assertThat(process).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:+:3:5", "2:-:3:-1", "2:*:3:6", "2:/:3:0"}, delimiter = ':')
    @DisplayName("사칙연산 확인하기")
    void calculate(int a, String symbol, int b, int expected) {
        int process = calculator.calculate(a, symbol, b);

        assertThat(process).isEqualTo(expected);
    }

    @DisplayName("연산 기호를 추출한다")
    @Test
    void getSymbolQueue() {
        Queue<String> symbolQueue = calculator.getSymbolQueue(str);

        assertThat(symbolQueue).containsExactly("+", "*", "/");
    }

    @DisplayName("숫자만 추출한다")
    @Test
    void getNumberQueue() {
        Queue<Integer> numberQueue = calculator.getNumberQueue(str);

        assertThat(numberQueue).containsExactly(2, 3, 4, 2);
    }
}