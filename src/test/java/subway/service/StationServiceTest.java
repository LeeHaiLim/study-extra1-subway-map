package subway.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import subway.controller.MainController;
import subway.domain.StationName;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.HashMap;
import java.util.List;

class StationServiceTest {
    StationService stationService = new StationService();
    StationRepository stationRepository = StationRepository.getInstance();
    LineRepository lineRepository = LineRepository.getInstance();

    @AfterEach
    void init() {
        stationRepository.init();
        lineRepository.init();
    }

    @DisplayName("역 등록 테스트")
    @Test
    void addStationTest() {
        stationService.addStation(StationName.of("잠실역"));
        List<String> stationNames = stationService.getStationNames();
        Assertions.assertThat(stationNames.contains("잠실역")).isTrue();
    }

    @DisplayName("같은 이름의 역은 등록할 수 없습니다.")
    @Test
    void addStationDuplicatedTest() {
        stationService.addStation(StationName.of("잠실역"));
        Assertions.assertThatThrownBy(() -> stationService.addStation(StationName.of("잠실역")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이미 존재하는 역입니다.");
    }

    @DisplayName("역 삭제 테스트")
    @Test
    void deleteStationTest() {
        stationService.addStation(StationName.of("잠실역"));
        stationService.deleteStation(StationName.of("잠실역"));
        List<String> stationNames = stationService.getStationNames();
        Assertions.assertThat(stationNames.contains("잠실역")).isFalse();
    }

    @DisplayName("역이름조회 테스트")
    @Test
    void getStationNamesTest() {
        List<String> stationNames = stationService.getStationNames();
        Assertions.assertThat(stationNames).contains("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    }
}