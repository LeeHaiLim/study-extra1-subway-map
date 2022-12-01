package subway.domain.Menu;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LineMenu {
    ADD_LINE("1"),
    DELETE_LINE("2"),
    LINE_LIST("3"),
    BACK("B");

    private final String code;

    LineMenu(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static final Map<String, LineMenu> menus =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(LineMenu::getCode, Function.identity())));

    public static LineMenu of(String number) {
        return Optional.ofNullable(menus.get(number)).orElseThrow(
                () -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }
}
