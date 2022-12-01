package subway.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.LineName;

import static org.junit.jupiter.api.Assertions.*;

class LineRepositoryTest {
    StationRepository stationRepository = StationRepository.getInstance();
    LineRepository lineRepository = LineRepository.getInstance();

    @AfterEach
    void init() {
        stationRepository.init();
        lineRepository.init();
    }

    @Test
    void getSubwayMap() {
    }

    @DisplayName("노선 이름을 입력하면 노선 객체를 반환한다.")
    @Test
    void findLineByName() {
        LineName 신분당선 = LineName.of("신분당선");
        Line line = lineRepository.findLineByName(신분당선);
        Assertions.assertThat(line).extracting("name").isEqualTo(신분당선);
    }

    @DisplayName("존재하지 않는 노선 이름일 경우 예외처리한다.")
    @Test
    void findLineByNameException() {
        Assertions.assertThatThrownBy(() -> lineRepository.findLineByName(LineName.of("수인분당선")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 존재하지 않는 노선입니다.");
    }
}
