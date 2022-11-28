package subway.domain.station;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StationServiceTest {

    StationService stationService;

    @BeforeEach
    void setUp() {
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();
        stationService = new StationService(stationRepository, lineRepository);
    }

    @DisplayName("역 생성 기능 테스트")
    @Test
    void createStationTest() {
        String stationName = "길음역";
        Station station = stationService.createStation(stationName);

        Assertions.assertThat(station.getName()).isEqualTo(stationName);
    }

    @DisplayName("역 생성 시 저장된 이름의 역을 생성하면 오류를 발생")
    @Test
    void insertDuplicateNameTest() {
        String stationName = "길음역";
        stationService.createStation(stationName);

        Assertions.assertThatThrownBy(() -> stationService.createStation(stationName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 존재하는 역 이름입니다.");
    }

    @DisplayName("역 삭제 기능 테스트")
    @Test
    void deleteStationTest() {
        String stationName = "길음역";
        stationService.createStation(stationName);

        stationService.deleteStation(stationName);
        Assertions.assertThat(stationService.getStations().size()).isEqualTo(0);
    }

    @DisplayName("역 삭제시 등록되지 않은 역의 이름을 입력하면 예외를 발생")
    @Test
    void insertNotRegisteredStationTest() {
        String stationName = "길음역";

        Assertions.assertThatThrownBy(() -> stationService.deleteStation(stationName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력하신 역이 등록되어 있지 않습니다.");
    }

    @DisplayName("역 삭제시 노선에 등록되어 있는 역을 삭제하면 예외를 발생")
    @Test
    void insertRegisteredInLineTest() {
        String stationName1 = "길음역";
        String stationName2 = "성신여대입구역";
        Station station1 = stationService.createStation(stationName1);
        Station station2 = stationService.createStation(stationName2);
        List<Station> stations = List.of(station1, station2);

        Line line = new Line("4호선", stations);
        LineRepository lineRepository = new LineRepository();
        lineRepository.save(line);
        Assertions.assertThatThrownBy(() -> stationService.deleteStation("길음역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력하신 역이 노선에 등록되어 있어 삭제가 불가능합니다.");
    }
}
