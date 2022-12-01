package subway.domain.Menu;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum SectionMenu {
    ADD_SECTION("1"),
    DELETE_SECTION("2"),
    BACK("B");
    private final String code;

    SectionMenu(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static final Map<String, SectionMenu> managementMenu =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(SectionMenu::getCode, Function.identity())));

    public static SectionMenu from(String number) {
        return Optional.ofNullable(managementMenu.get(number)).orElseThrow(
                () -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }
}