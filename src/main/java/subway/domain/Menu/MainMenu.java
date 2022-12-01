package subway.domain.Menu;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MainMenu {
    STATION_MENU("1"),
    LINE_MENU("2"),
    SECTION_MENU("3"),
    PRINT_MAP("4"),
    QUIT("Q");

    private final String code;

    MainMenu(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static final Map<String, MainMenu> menus =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(MainMenu::getCode, Function.identity())));

    public static MainMenu of(String number) {
        return Optional.ofNullable(menus.get(number)).orElseThrow(
                () -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }
}
