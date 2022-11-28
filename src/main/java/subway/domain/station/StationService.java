package subway.domain.station;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;

import java.util.List;
import java.util.Optional;

public class StationService {
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    public StationService(StationRepository stationRepository, LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    public Station createStation(String stationName) {
        isUniqueName(stationName);
        Station station = new Station(stationName);
        return stationRepository.save(station);
    }

    public void deleteStation(String stationName) {
        isRegistered(stationName);
        isRegisteredInLine(stationName);
        Station station = stationRepository.findByName(stationName).get();
        stationRepository.delete(station);
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

    private void isRegistered(String stationName) {
        Station station = stationRepository.findByName(stationName)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력하신 역이 등록되어 있지 않습니다."));
    }

    private void isRegisteredInLine(String stationName) {
        Optional<Station> findByStationName = lineRepository.findAll().stream()
                .flatMap(lines -> lines.getStationsInLine().stream())
                .filter(station -> station.getName().equals(stationName))
                .findAny();
        if (findByStationName.isPresent()) {
            throw new IllegalArgumentException("[ERROR] 입력하신 역이 노선에 등록되어 있어 삭제가 불가능합니다.");
        }
    }
}
