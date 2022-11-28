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
        lineService = new LineService(lineRepository,stationRepository);
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

    @DisplayName("노선 생성 시 등록되지 않은 역을 입력하는 경우 예외를 발생")
    @Test
    void insertNotRegisteredStationTest() {
        List<String> stationNames = Arrays.asList("길음역", "성신여대입구역");


        Assertions.assertThatThrownBy(() -> lineService.createLine("2호선", stationNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 등록되지 않은 역은 노선에 등록할 수 없습니다.");
    }
}
