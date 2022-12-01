package subway.service;

import subway.domain.Station;
import subway.domain.StationName;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.List;

public class StationService {
    private final StationRepository stationRepository = StationRepository.getInstance();
    private final LineRepository lineRepository = LineRepository.getInstance();

    public void addStation(StationName stationName) {
        stationRepository.addStation(stationName);
    }

    public void deleteStation(StationName stationName) {
        Station station = stationRepository.findStationByName(stationName);
        if (lineRepository.isStationBelongToLine(station)) {
            throw new IllegalArgumentException("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
        }
        stationRepository.deleteStation(station);
    }
}