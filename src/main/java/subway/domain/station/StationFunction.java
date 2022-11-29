package subway.domain.station;

import java.util.Arrays;

public enum StationFunction {
    BEFORE("B"),
    CREATE_STATION("1"),
    DELETE_STATION("2"),
    SHOW_STATION("3");

    private final String stationFunction;

    StationFunction(String stationFunction) {
        this.stationFunction = stationFunction;
    }

    public static StationFunction from(String stationFunction) {
        return Arrays.stream(StationFunction.values())
                .filter(function -> function.stationFunction.equals(stationFunction))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 선택할 수 없는 기능입니다."));
    }
}
