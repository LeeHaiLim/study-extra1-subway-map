package subway.domain.section;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SectionServiceTest {

    SectionService sectionService;
    LineRepository lineRepository;
    StationRepository stationRepository;

    @BeforeEach
    void beforeEach() {
        stationRepository = new StationRepository();
        lineRepository = new LineRepository();
        sectionService = new SectionService(stationRepository, lineRepository);
    }

    @DisplayName("구간 생성 테스트")
    @Test
    void createSectionTest() {
        List<Station> stations = new ArrayList<>();
        stations.add(new Station("성신여대입구역"));
        stations.add(new Station("미아역"));
        Line line = new Line("4호선", stations);
        lineRepository.save(line);
        sectionService.registerSection("4호선", "길음역", 2);

        Assertions.assertThat(lineRepository.findByName("4호선").get().getStationsInLine().get(1).getName())
                .isEqualTo("길음역");
    }

    @DisplayName("구간 생성 시 등록되지 않은 노선 이름을 입력하면 예외를 발생")
    @Test
    void insertNotRegisteredLineNameTest() {
        Assertions.assertThatThrownBy(() -> sectionService.registerSection("4호선", "길음역", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 등록되지 않은 노선입니다.");
    }

    @DisplayName("구간 삭제 테스트")
    @Test
    void deleteSectionTest() {
        List<Station> stations = new ArrayList<>();
        stations.add(stationRepository.save(new Station("성신여대입구역")));
        stations.add(stationRepository.save(new Station("미아역")));
        stations.add(stationRepository.save(new Station("길음역")));
        Line line = new Line("4호선", stations);
        lineRepository.save(line);
        sectionService.deleteSection("4호선", "미아역");

        Assertions.assertThat(lineRepository.findByName("4호선").get().getStationsInLine()
                .stream()
                .anyMatch(station -> station.getName().equals("미아역"))).isFalse();
    }

    @DisplayName("구간 삭제시 등록되지 않은 역을 입력하면 오류를 발생")
    @Test
    void insertNotRegisteredStationTest() {
        List<Station> stations = new ArrayList<>();
        stations.add(stationRepository.save(new Station("성신여대입구역")));
        stations.add(stationRepository.save(new Station("미아역")));
        stations.add(stationRepository.save(new Station("길음역")));
        Line line = new Line("4호선", stations);
        lineRepository.save(line);
        Assertions.assertThatThrownBy(() -> sectionService.deleteSection("4호선", "수유역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 등록되지 않은 역 이름입니다.");
    }
}
