package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LineTest {

    @DisplayName("노선 생성 테스트")
    @Test
    void createLine() {
        Station 강남역 = Station.from(StationName.from("강남역"));
        Station 잠실역 = Station.from(StationName.from("잠실역"));
        Line line = Line.from(LineName.from("1호선"));
        line.addStationToLine(강남역);
        line.addStationToLine(잠실역);
        Assertions.assertThat(line).extracting("stations").isEqualTo(List.of(강남역, 잠실역));
    }
}