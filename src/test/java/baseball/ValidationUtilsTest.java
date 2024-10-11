package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidationUtilsTest {
    @Test
    @DisplayName("야구_숫자_1_9_검증")
    void 야구_숫자_1_9_검증() {
        // given

        // when

        // then
        assertThat(ValidationUtils.validNo(9)).isTrue();
        assertThat(ValidationUtils.validNo(1)).isTrue();
        assertThat(ValidationUtils.validNo(0)).isFalse();
        assertThat(ValidationUtils.validNo(10)).isFalse();
    }

    @Test
    @DisplayName("야구_숫자_중복_검증")
    void 야구_숫자_중복_검증() {
        // given

        // when

        // then
        assertThat(ValidationUtils.isDuplicate(1,2,3)).isTrue();
        assertThat(ValidationUtils.isDuplicate(1,1,2)).isFalse();
    }
}
