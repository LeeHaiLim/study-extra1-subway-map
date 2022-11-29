package subway.domain.Menu;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LineManagement implements MenuManagement {
    LINE_ADD("1"),
    LINE_DELETE("2"),
    LINE_LIST("3"),
    BACK("B"),
    NONE("없음");

    private final String code;

    LineManagement(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static final Map<String, LineManagement> managementMenu =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(LineManagement::getCode, Function.identity())));

    @Override
    public LineManagement isExistsServiceNumber(String number) {
        return Optional.ofNullable(managementMenu.get(number)).orElse(NONE);
    }
}
