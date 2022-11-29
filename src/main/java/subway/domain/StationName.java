package subway.domain;

import java.util.Objects;

public class StationName {
    private static final int STATION_NAME_LENGTH_LIMIT = 2;
    private static final String STATION_NAME_SUFFIX = "역";
    private static final String BLANK = " ";
    private final String name;

    private StationName(String name) {
        validStationName(name);
        this.name = name;
    }

    public static StationName of(String name) {
        return new StationName(name);
    }

    private void validStationName(String name) {
        validIncludeBlank(name);
        validSuffixStationName(name);
        validStationNameLength(name);
    }

    private void validIncludeBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 역 이름에는 공백이 들어갈 수 없습니다.");
        }
    }

    private void validSuffixStationName(String name) {
        if (!name.endsWith(STATION_NAME_SUFFIX)) {
            throw new IllegalArgumentException("[ERROR] 역 이름은 '역'으로 끝나야 합니다.");
        }
    }

    private void validStationNameLength(String name) {
        if (name.length() <= STATION_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 역 이름은 두 글자 이상이어야 합니다.");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StationName)) {
            return false;
        }
        if (((StationName) obj).name.equals(this.name)) {
            return true;
        }
        return false;
    }
}
