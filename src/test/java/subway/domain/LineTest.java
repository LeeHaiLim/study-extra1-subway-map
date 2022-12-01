package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LineTest {

    @DisplayName("노선 생성 테스트")
    @Test
    void createLine() {
        Station 강남역 = Station.of(StationName.of("강남역"));
        Station 양재시민의숲역 = Station.of(StationName.of("양재시민의숲역"));
        Line line = Line.of(LineName.of("신분당선"), 강남역, 양재시민의숲역);
        Assertions.assertThat(line).extracting("stations").isEqualTo(List.of(강남역, 양재시민의숲역));
    }
}