package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class RefereeTest {

    @Test
    @DisplayName("Referee 클래스는 1~9중 서로다른 세가지 수를 인스턴스 변수로 가진다.")
    void init() {
        // given
        Referee referee = new Referee();
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        // when
        referee.init(random);
        System.out.println(referee);

        referee.init(random);
        System.out.println(referee);

        referee.init(random);
        System.out.println(referee);

        // then
        assertThat(referee.getNumber1())
                .isNotEqualTo(referee.getNumber2())
                .isNotEqualTo(referee.getNumber3());

        assertThat(referee.getNumber2()).isNotEqualTo(referee.getNumber3());
    }

    @ParameterizedTest
    @CsvSource(value = {"145:1S", "321:1S2B", "142:1S1B", "123:3S"}, delimiter = ':')
    @DisplayName("숫자로 이루어진 문자를 받아서 결과를 반환한다")
    void getResult(String input, String output) {
        // given
        Referee referee = new Referee();
        referee.setNumber1(1);
        referee.setNumber2(2);
        referee.setNumber3(3);

        // when
        String result = referee.getResult(input);

        // then
        assertThat(result).isEqualTo(output);
    }

}