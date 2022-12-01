package subway.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.LineName;
import subway.domain.Station;
import subway.domain.StationName;

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
        LineName 신분당선 = LineName.from("신분당선");
        Line line = lineRepository.findLineByName(신분당선);
        Assertions.assertThat(line).extracting("name").isEqualTo(신분당선);
    }

    @DisplayName("존재하지 않는 노선 이름일 경우 예외처리한다.")
    @Test
    void findLineByNameException() {
        Assertions.assertThatThrownBy(() -> lineRepository.findLineByName(LineName.from("수인분당선")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 존재하지 않는 노선입니다.");
    }

    @DisplayName("노선에 속해 있는 역이라면 true를 반환한다.")
    @Test
    void isStationBelongToLineTestTrue() {
        Station 강남역 = stationRepository.findOrMakeStation(StationName.from("강남역"));
        Assertions.assertThat(lineRepository.isStationBelongToLine(강남역)).isTrue();
    }

    @DisplayName("노선에 속해 있는 역이 아니면 false를 반환한다.")
    @Test
    void isStationBelongToLineTestFalse() {
        Station 잠실역 = stationRepository.findOrMakeStation(StationName.from("잠실역"));
        Assertions.assertThat(lineRepository.isStationBelongToLine(잠실역)).isFalse();
    }
}