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
}