package baseball;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Ball {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    int number;

    public Ball(int number) {
        if (valid(number)) {
            throw new IllegalArgumentException("숫자는 1~9 사이의 숫자여야 합니다.");
        }
        this.number = number;
    }

    private static boolean valid(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    public int getNumber() {
        return number;
    }
}
