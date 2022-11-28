package subway.domain.station;

import subway.domain.Repository;

import java.util.*;

public class StationRepository implements Repository<Station> {
    private static final List<Station> stations = new ArrayList<>();

    @Override
    public Station save(Station station) {
        return null;
    }

    @Override
    public List<Station> findAll() {
        return null;
    }

    @Override
    public void delete(Station station) {

    }

    @Override
    public Optional<Station> findByName(String name) {
        return Optional.empty();
    }
}
