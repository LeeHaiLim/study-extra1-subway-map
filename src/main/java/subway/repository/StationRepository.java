package subway.repository;

import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (isExistsStation(station)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 역입니다.");
        }
        stations.add(station);
    }

    public static boolean isExistsStation(Station station) {
        if (stations.contains(station)) {
            return true;
        }
        return false;
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
