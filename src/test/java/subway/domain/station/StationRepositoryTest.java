package subway.domain.station;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationRepositoryTest {

    StationRepository stationRepository = new StationRepository();

    @DisplayName("역 조회 테스트")
    @Test
    void findByNameTest() {
        Station station = new Station("길음역");
        stationRepository.save(station);

        Assertions.assertThat(stationRepository.findByName("길음역").get()).isEqualTo(station);
    }
}
