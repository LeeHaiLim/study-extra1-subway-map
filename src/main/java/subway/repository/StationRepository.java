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
        stations.add(Station.from(stationName));
    }

    public static boolean isExistsStation(StationName stationName) {
        return stations.stream()
                .anyMatch(station -> station.getName().equals(stationName));
    }

    public static void deleteStation(Station station) {
        stations.remove(station);
    }

    public static List<String> getStationsName() {
        return stations.stream()
                .map(Station::getName)
                .map(StationName::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Station findStationByName(StationName stationName) {
        return stations.stream().filter(station -> station.getName().equals(stationName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다."));
    }

    public Station findOrMakeStation(StationName stationName) {
        if (!isExistsStation(stationName)) {
            addStation(stationName);
        }
        return findStationByName(stationName);
    }

    public void init() {
        stations.clear();
        addStation(StationName.from("교대역"));
        addStation(StationName.from("강남역"));
        addStation(StationName.from("역삼역"));
        addStation(StationName.from("남부터미널역"));
        addStation(StationName.from("양재역"));
        addStation(StationName.from("양재시민의숲역"));
        addStation(StationName.from("매봉역"));
    }
}