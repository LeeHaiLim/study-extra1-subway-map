package subway.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import subway.controller.MainController;
import subway.domain.LineName;
import subway.domain.StationName;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.HashMap;
import java.util.List;

class LineServiceTest {
    LineService lineService = new LineService();
    StationRepository stationRepository = StationRepository.getInstance();
    LineRepository lineRepository = LineRepository.getInstance();

    @AfterEach
    void init() {
        stationRepository.init();
        lineRepository.init();
    }

    @DisplayName("노선 등록 테스트")
    @Test
    void addLineTest() {
        lineService.addLine(LineName.of("1호선"), StationName.of("강남역"), StationName.of("잠실역"));
        List<String> lineNames = lineService.getLineNames();
        Assertions.assertThat(lineNames.contains("1호선")).isTrue();
    }

    @DisplayName("같은 이름의 노선은 등록할 수 없습니다.")
    @Test
    void addLineDuplicatedTest() {
        Assertions.assertThatThrownBy(() ->
                        lineService.addLine(LineName.of("2호선"), StationName.of("교대역"), StationName.of("양재시민의숲역")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이미 존재하는 노선입니다.");
    }

    @DisplayName("노선 삭제 테스트")
    @Test
    void deleteLine() {
        lineService.addLine(LineName.of("1호선"), StationName.of("강남역"), StationName.of("잠실역"));
        lineService.deleteLine(LineName.of("1호선"));
        List<String> lineNames = lineService.getLineNames();
        Assertions.assertThat(lineNames.contains("1호선")).isFalse();
    }

    @DisplayName("노선 이름 조회 테스트")
    @Test
    void getLineNames() {
        List<String> lineNames = lineService.getLineNames();
        Assertions.assertThat(lineNames).contains("2호선", "3호선", "신분당선");
    }
}