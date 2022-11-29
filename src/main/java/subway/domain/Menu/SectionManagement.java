package subway.domain.Menu;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum SectionManagement implements MenuManagement{
    SECTION_ADD("1"),
    SECTION_DELETE("2"),
    BACK("B"),
    NONE("없음");
    private final String code;

    SectionManagement(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static final Map<String, SectionManagement> managementMenu =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(SectionManagement::getCode, Function.identity())));

    @Override
    public SectionManagement isExistsServiceNumber(String number) {
        return Optional.ofNullable(managementMenu.get(number)).orElse(NONE);
    }
}
