package subway.domain.station;

import subway.domain.Repository;

import java.util.*;

public class StationRepository implements Repository<Station> {
    private static final List<Station> stations = new ArrayList<>();

    @Override
    public Station save(Station station) {
        stations.add(station);
        return station;
    }

    @Override
    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    @Override
    public void delete(Station station) {

    }

    @Override
    public Optional<Station> findByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny();
    }
}
