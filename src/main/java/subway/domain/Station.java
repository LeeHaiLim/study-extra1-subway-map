package subway.domain;

import java.util.Objects;

public class Station {
    private final StationName name;

    private Station(StationName name) {
        this.name = name;
    }

    public static Station of(StationName name) {
        return new Station(name);
    }

    public StationName getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Station)) {
            return false;
        }
        if (this.getName().equals(((Station) obj).getName())) {
            return true;
        }
        return false;
    }
}