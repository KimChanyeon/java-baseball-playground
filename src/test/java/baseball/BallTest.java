package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
    @Test
    @DisplayName("1~9가 아닌 숫자로 생성자를 호출하면 예외가 발생한다.")
    void constructor() {
        // given

        // when

        // then
        assertThatThrownBy(() -> new Ball(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1~9 사이의 숫자여야 합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ball(10))
                .withMessage("숫자는 1~9 사이의 숫자여야 합니다.");

        assertThatCode(() -> new Ball(1))
                .doesNotThrowAnyException();

        assertThatCode(() -> new Ball(9))
                .doesNotThrowAnyException();
    }
}
