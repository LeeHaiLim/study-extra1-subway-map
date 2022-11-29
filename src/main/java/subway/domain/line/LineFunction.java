package subway.domain.line;

import java.util.Arrays;

public enum LineFunction {
    BEFORE("B"),
    CREATE_LINE("1"),
    DELETE_LINE("2"),
    SHOW_LINE("3");

    private final String lineFunction;

    LineFunction(String lineFunction) {
        this.lineFunction = lineFunction;
    }

    public static LineFunction from(String lineFunction) {
        return Arrays.stream(LineFunction.values())
                .filter(function -> function.lineFunction.equals(lineFunction))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 선택할 수 없는 기능입니다."));
    }
}
