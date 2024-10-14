package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RefereeTest {

    Balls com = new Balls();

    @BeforeEach
    void setup() {
        List<Ball> ballList = com.getBallList();
        ballList.clear();
        ballList.add(new Ball(1));
        ballList.add(new Ball(2));
        ballList.add(new Ball(3));
    }

    @ParameterizedTest
    @CsvSource(value = {"123:3S","312:3B","456:NOTHING","132:1S2B"},delimiter = ':')
    @DisplayName("Referee 클래스가 com 과 user 입력을 받아 볼, 스트라이크 갯수를 판단한다.")
    void getResult(String input, String expected) {
        // given
        Referee referee = new Referee();
        Balls user = new Balls();
        user.initByInput(input);

        // when
        String result = referee.getResult(user, com);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
