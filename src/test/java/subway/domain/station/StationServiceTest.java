package subway.domain.station;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.LineRepository;

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

    @DisplayName("역 생성 시 이름이 2글자 이상이 아닌경우 오류를 발생")
    @Test
    void insertInvalidLengthNameTest() {
        String stationName = "역";

        Assertions.assertThatThrownBy(() -> stationService.createStation(stationName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("역의 이름은 2글자 이상이여야 합니다.");
    }
}
