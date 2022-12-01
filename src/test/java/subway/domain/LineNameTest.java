package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineNameTest {

    @DisplayName("올바른 노선이름 생성 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1호선", "수인분당선"})
    void stationNameTest(String input) {
        LineName lineName = LineName.of(input);
        Assertions.assertThat(lineName).extracting("name").isEqualTo(input);

    }

    @DisplayName("노선 이름에는 공백이 들어갈 수 없습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"수인 분당선"})
    void validBlankTest(String input) {
        Assertions.assertThatThrownBy(() -> LineName.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 노선 이름에는 공백이 들어갈 수 없습니다.");
    }

    @DisplayName("노선 이름은 '선'으로 끝나야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1호"})
    void validSuffixTest(String input) {
        Assertions.assertThatThrownBy(() -> LineName.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 노선 이름은 '선'으로 끝나야 합니다.");
    }

    @DisplayName("노선 이름은 두 글자 이상이어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"호선", "선"})
    void validLengthTest(String input) {
        Assertions.assertThatThrownBy(() -> LineName.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 노선 이름은 두 글자 이상이어야 합니다.");
    }
}