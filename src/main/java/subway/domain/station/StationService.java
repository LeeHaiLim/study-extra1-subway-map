package subway.domain.station;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;

import java.util.List;
import java.util.Optional;

public class StationService {
    private static final int VALID_NAME_MINIMUM_LENGTH = 2;
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    public StationService(StationRepository stationRepository, LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    public Station createStation(String stationName) {
        isValidNameLength(stationName);
        isUniqueName(stationName);
        Station station = new Station(stationName);
        return stationRepository.save(station);
    }

    public void deleteStation(String stationName) {

    }

    public List<Station> getStations() {
        return stationRepository.findAll();
    }

    private void isUniqueName(String stationName) {
        Optional<Station> station = stationRepository.findByName(stationName);
        if (station.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 역 이름입니다.");
        }
    }

    private void isValidNameLength(String stationName) {
        if (stationName.length() < VALID_NAME_MINIMUM_LENGTH) {
            throw new IllegalArgumentException("역의 이름은 2글자 이상이여야 합니다.");
        }
    }
}
