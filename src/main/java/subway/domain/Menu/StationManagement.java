package subway.domain.Menu;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum StationManagement implements MenuManagement {
    STATION_ADD("1"),
    STATION_DELETE("2"),
    STATION_LIST("3"),
    BACK("B"),
    NONE("없음");

    private final String code;

    StationManagement(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static final Map<String, StationManagement> managementMenu =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(StationManagement::getCode, Function.identity())));

    @Override
    public StationManagement isExistsServiceNumber(String number) {
        return Optional.ofNullable(managementMenu.get(number)).orElse(NONE);
    }
}
