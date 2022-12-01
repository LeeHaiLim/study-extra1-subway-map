package subway.repository;

import subway.domain.Station;
import subway.domain.StationName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StationRepository {
    private static StationRepository stationRepository;
    private static final List<Station> stations = new ArrayList<>();

    private StationRepository() {
        init();
    }

    public static StationRepository getInstance() {
        if (stationRepository == null) {
            stationRepository = new StationRepository();
        }
        return stationRepository;
    }

    public static void addStation(StationName stationName) {
        if (isExistsStation(stationName)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 역입니다.");
        }
        stations.add(Station.of(stationName));
    }

    public static boolean isExistsStation(StationName stationName) {
        return stations.stream()
                .anyMatch(station -> station.getName().equals(stationName));
    }

    public static void deleteStation(Station station) {
        stations.remove(station);
    }

    public static Station findStationByName(StationName stationName) {
        return stations.stream().filter(station -> station.getName().equals(stationName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다."));
    }

    }
}