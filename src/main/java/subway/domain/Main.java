package subway.domain;

import java.util.Arrays;

public enum Main {
    BEFORE(""),
    MANAGE_STATION("1"),
    MANAGE_LINE("2"),
    MANAGE_SECTION("3"),
    PRINT_ALL_LINE("4"),
    QUIT("Q");

    private final String mainFunction;

    Main(String mainFunction) {
        this.mainFunction = mainFunction;
    }

    public static Main from(String mainFunction) {
        return Arrays.stream(Main.values())
                .filter(mainInput -> mainInput.mainFunction.equals(mainFunction))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }
}
