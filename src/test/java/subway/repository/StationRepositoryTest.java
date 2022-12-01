package subway.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.domain.StationName;
import subway.service.StationService;

import static org.junit.jupiter.api.Assertions.*;

class StationRepositoryTest {
    StationRepository stationRepository = StationRepository.getInstance();
    LineRepository lineRepository = LineRepository.getInstance();

    @AfterEach
    void init() {
        stationRepository.init();
        lineRepository.init();
    }

    @DisplayName("역 이름을 입력하면 역 객체를 반환한다.")
    @Test
    void findStationByName() {
        StationName 교대역 = StationName.of("교대역");
        Station result = stationRepository.findStationByName(교대역);
        Assertions.assertThat(result).extracting("name").isEqualTo(교대역);
    }

    @DisplayName("존재하지 않는 역 이름일 경우 예외처리 한다.")
    @Test
    void findStationByNameException() {
        Assertions.assertThatThrownBy(() -> stationRepository.findStationByName(StationName.of("잠실역")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 존재하지 않는 역입니다.");
    }
}