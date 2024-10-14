package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class ValidationUtilTest {
    @Test
    @DisplayName("사용자가 서로다른 3자리 숫자로 이루어진 문자를 입력하면 유효성 검사를 통과한다")
    void 유효성_검사_통과() {
        // given
        String input = "123";

        // when
        boolean valid = ValidationUtil.validInput(input);

        // then
        assertThat(valid).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"113,11,abc"})
    @DisplayName("사용자가 서로다른 3자리 숫자가 아닌 문자를 입력하면 유효성 검사에 실패한다")
    void 유효성_검사_실패(String input) {
        // given

        // when
        boolean valid = ValidationUtil.validInput(input);

        // then
        assertThat(valid).isFalse();
    }
}
