package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    @Test
    @DisplayName("서로다른 숫자를 가진 Ball List 유효성 검사 성공")
    void validTrue() {
        // given
        Balls balls = new Balls();
        List<Ball> ballList = balls.getBallList();
        ballList.add(new Ball(1));
        ballList.add(new Ball(2));
        ballList.add(new Ball(3));

        // when

        // then
        assertThat(balls.valid()).isEqualTo(true);
    }

    @Test
    @DisplayName("서로다른 숫자를 가진 Ball List 유효성 검사 실패")
    void validFalse() {
        // given
        Balls balls = new Balls();
        List<Ball> ballList = balls.getBallList();
        ballList.add(new Ball(1));
        ballList.add(new Ball(1));
        ballList.add(new Ball(2));

        // when

        // then
        assertThat(balls.valid()).isEqualTo(false);
    }
}
