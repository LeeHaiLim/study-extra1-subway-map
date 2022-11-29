package subway.domain;

import java.util.Objects;

public class LineName {
    private static final int LINE_NAME_LENGTH_LIMIT = 2;
    private static final String LINE_NAME_SUFFIX = "선";
    private static final String BLANK = " ";
    private final String name;

    private LineName(String name) {
        validLineName(name);
        this.name = name;
    }

    public static LineName of(String name) {
        return new LineName(name);
    }

    private void validLineName(String name) {
        validIncludeBlank(name);
        validSuffixLineNameName(name);
        validLineNameLength(name);
    }

    private void validIncludeBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 노선 이름에는 공백이 들어갈 수 없습니다.");
        }
    }

    private void validSuffixLineNameName(String name) {
        if (!name.endsWith(LINE_NAME_SUFFIX)) {
            throw new IllegalArgumentException("[ERROR] 노선 이름은 '선'으로 끝나야 합니다.");
        }
    }

    private void validLineNameLength(String name) {
        if (name.length() <= LINE_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 노선 이름은 두 글자 이상이어야 합니다.");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LineName)) {
            return false;
        }
        if (((LineName) obj).name.equals(this.name)) {
            return true;
        }
        return false;
    }
}
