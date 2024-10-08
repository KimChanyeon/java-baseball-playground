package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("\"1,2\" 를 , 로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void split1() {
        String[] split = "1,2".split(",");
        assertThat(split).containsExactly("1", "2");
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @Test
    void split2() {
        String[] split = "1".split(",");
        assertThat(split).containsExactly("1");
    }

    @DisplayName("문자열의 괄호를 제거한다")
    @Test
    void substring() {
        String str = "(1,2)";
        assertThat(str.substring(str.indexOf("(") + 1, str.indexOf(")"))).isEqualTo("1,2");
    }

    @DisplayName("위치값을 벗어났을때 IndexOutOfBoundsException 예외가 발생한다")
    @Test
    void indexOutOfBounds() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(str.length()))
                .isInstanceOf(IndexOutOfBoundsException.class);

    }
}
