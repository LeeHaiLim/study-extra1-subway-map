package subway.domain.Menu;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MainManagement implements MenuManagement{
    STATION_MANAGEMENT("1"),
    LINE_MANAGEMENT("2"),
    SECTION_MANAGEMENT("3"),
    QUIT("Q"),
    NONE("없음");

    private final String code;

    MainManagement(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static final Map<String, MainManagement> managementMenu =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(MainManagement::getCode, Function.identity())));

    @Override
    public MainManagement isExistsServiceNumber(String number) {
        return Optional.ofNullable(managementMenu.get(number)).orElse(NONE);
    }
}
