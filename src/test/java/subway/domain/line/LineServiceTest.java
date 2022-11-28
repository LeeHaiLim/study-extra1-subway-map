package subway.domain.line;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.station.StationService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineServiceTest {
    LineService lineService;
    StationService stationService;

    @BeforeEach
    void setUp() {
        LineRepository lineRepository = new LineRepository();
        StationRepository stationRepository = new StationRepository();
        lineService = new LineService(lineRepository, stationRepository);
        stationService = new StationService(stationRepository, lineRepository);
    }

    @DisplayName("노선 생성 기능 테스트")
    @Test
    void createLineTest() {
        stationService.createStation("길음역");
        stationService.createStation("성신여대입구역");

        List<String> stationNames = Arrays.asList("길음역", "성신여대입구역");

        lineService.createLine("2호선", stationNames);
        Assertions.assertThat(lineService.getLineByName("2호선").getStationsInLine().size()).isEqualTo(2);
    }

    @DisplayName("노선 생성 시 등록되지 않은 역을 입력하는 경우 역 등록 후 노선 생성")
    @Test
    void insertNotRegisteredStationTest() {
        List<String> stationNames = Arrays.asList("길음역", "성신여대입구역");

        lineService.createLine("4호선", stationNames);
        Assertions.assertThat(lineService.getLineByName("4호선").getStationsInLine().size())
                .isEqualTo(2);
    }

    @DisplayName("등록되지 않은 노선 검색시 예외를 발생")
    @Test
    void insertNotRegisteredLineTest() {
        Assertions.assertThatThrownBy(() -> lineService.getLineByName("2호선"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 등록되지 않은 역은 노선이름입니다.");
    }

    @DisplayName("노선 삭제 기능 테스트")
    @Test
    void deleteLineTest() {
        stationService.createStation("길음역");
        stationService.createStation("성신여대입구역");

        List<String> stationNames = Arrays.asList("길음역", "성신여대입구역");
        lineService.createLine("2호선", stationNames);
        lineService.deleteLine("2호선");

        Assertions.assertThat(lineService.getLines().size()).isEqualTo(0);
    }

    @DisplayName("전체 노선 조회 기능 테스트")
    @Test
    void getLinesTest() {
        stationService.createStation("길음역");
        stationService.createStation("성신여대입구역");

        List<String> stationNames1 = Arrays.asList("길음역", "성신여대입구역");
        lineService.createLine("2호선", stationNames1);

        stationService.createStation("종각역");
        stationService.createStation("종로3가역");

        List<String> stationNames2 = Arrays.asList("종각역", "종로3가역");
        lineService.createLine("1호선", stationNames2);

        Assertions.assertThat(lineService.getLines().size()).isEqualTo(2);
    }

}
