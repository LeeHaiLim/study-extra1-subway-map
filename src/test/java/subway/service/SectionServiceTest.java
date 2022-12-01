package subway.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.LineName;
import subway.domain.Order;
import subway.domain.StationName;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.HashMap;
import java.util.List;

class SectionServiceTest {
    StationService stationService = new StationService();
    SectionService sectionService = new SectionService();
    StationRepository stationRepository = StationRepository.getInstance();
    LineRepository lineRepository = LineRepository.getInstance();

    @AfterEach
    void init() {
        stationRepository.init();
        lineRepository.init();
    }

    @DisplayName("구간 등록 테스트")
    @Test
    void addSectionTest() {
        sectionService.addSection(LineName.of("2호선"), StationName.of("잠실역"), Order.of("2"));
        HashMap<String, List<String>> subwayMap = lineRepository.getSubwayMap();
        Assertions.assertThat(subwayMap.get("2호선").indexOf("잠실역")).isEqualTo(1);
    }

    @DisplayName("중복된 구간을 등록할 수 없습니다.")
    @Test
    void addSectionDuplicatedTest() {
        Assertions.assertThatThrownBy(() -> sectionService.addSection(LineName.of("2호선"), StationName.of("교대역"), Order.of("2")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이미 노선에 속해있는 역입니다.");
    }

    @DisplayName("구간 삭제 테스트")
    @Test
    void deleteSectionTest() {
        sectionService.deleteSection(LineName.of("신분당선"), StationName.of("양재시민의숲역"));
        HashMap<String, List<String>> subwayMap = lineRepository.getSubwayMap();
        Assertions.assertThat(subwayMap.get("신분당선")).doesNotContain("양재시민의숲역");
    }

    @DisplayName("노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.")
    @Test
    void deleteSectionExceptionTest() {
        sectionService.deleteSection(LineName.of("신분당선"), StationName.of("양재시민의숲역"));
        Assertions.assertThatThrownBy(() ->
                        sectionService.deleteSection(LineName.of("신분당선"), StationName.of("양재역")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.");
    }
}