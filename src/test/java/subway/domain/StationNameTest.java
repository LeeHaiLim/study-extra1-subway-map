package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StationNameTest {

    @DisplayName("올바른 역이름 생성 확인")
    @ParameterizedTest
    @ValueSource(strings = {"잠실역", "고속터미널역"})
    void stationNameTest(String input) {
        StationName stationName = StationName.from(input);
        Assertions.assertThat(stationName).extracting("name").isEqualTo(input);

    }

    @DisplayName("역 이름에는 공백이 들어갈 수 없습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"잠실 역"})
    void validBlankTest(String input) {
        Assertions.assertThatThrownBy(() -> StationName.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 역 이름에는 공백이 들어갈 수 없습니다.");
    }

    @DisplayName("역 이름은 '역'으로 끝나야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"잠실"})
    void validSuffixTest(String input) {
        Assertions.assertThatThrownBy(() -> StationName.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 역 이름은 '역'으로 끝나야 합니다.");
    }

    @DisplayName("역 이름은 두 글자 이상이어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"잠역", "역"})
    void validLengthTest(String input) {
        Assertions.assertThatThrownBy(() -> StationName.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 역 이름은 두 글자 이상이어야 합니다.");
    }
}