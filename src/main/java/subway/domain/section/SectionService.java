package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.Optional;

public class SectionService {
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    public SectionService(StationRepository stationRepository, LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    public void registerSection(String lineName, String stationName, int position) {
        Line line = lineRepository.findByName(lineName)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 등록되지 않은 노선입니다."));
        Optional<Station> station = stationRepository.findByName(stationName);
        if (station.isEmpty()) {
            stationRepository.save(new Station(stationName));
        }
        line.getStationsInLine().add(position - 1, station.get());
    }

    public void deleteSection(String lineName, String stationName) {
        Line line = lineRepository.findByName(lineName)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 등록되지 않은 노선입니다."));
        Station station = stationRepository.findByName(stationName)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 등록되지 않은 역 이름입니다."));

        line.getStationsInLine().remove(station);
    }
}
