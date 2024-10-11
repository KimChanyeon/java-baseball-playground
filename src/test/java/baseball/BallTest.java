package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1,4);
    }

    @Test
    @DisplayName("strike")
    void strike() {
        // given
        Ball user = new Ball(1,4);

        // when
        BallStatus status = com.play(user);

        // then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("ball")
    void ball() {
        // given
        Ball user = new Ball(2,4);

        // when
        BallStatus status = com.play(user);

        // then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("nothing")
    void nothing() {
        // given
        Ball user = new Ball(2,5);

        // when
        BallStatus status = com.play(user);

        // then
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
