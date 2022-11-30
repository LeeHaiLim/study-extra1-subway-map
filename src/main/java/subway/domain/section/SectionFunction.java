package subway.domain.section;

import java.util.Arrays;

public enum SectionFunction {
    BEFORE("B"),
    CREATE_SECTION("1"),
    DELETE_SECTION("2");

    private final String sectionFunction;

    SectionFunction(String sectionFunction) {
        this.sectionFunction = sectionFunction;
    }

    public static SectionFunction from(String sectionFunction) {
        return Arrays.stream(SectionFunction.values())
                .filter(function -> function.sectionFunction.equals(sectionFunction))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }
}
