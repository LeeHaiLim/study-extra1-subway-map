package subway.service;

import subway.domain.Line;
import subway.domain.LineName;
import subway.domain.Station;
import subway.domain.StationName;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.List;

public class LineService {
    private final StationRepository stationRepository = StationRepository.getInstance();
    private final LineRepository lineRepository = LineRepository.getInstance();

    public void addLine(LineName lineName, StationName firstStationName, StationName lastStationName) {
        Station firstStation = findOrMakeStation(firstStationName);
        Station lastStation = findOrMakeStation(lastStationName);
        lineRepository.addLine(lineName, firstStation, lastStation);
    }

    private Station findOrMakeStation(StationName stationName) {
        if (!stationRepository.isExistsStation(stationName)) {
            stationRepository.addStation(stationName);
        }
        return stationRepository.findStationByName(stationName);
    }

    public void deleteLine(LineName lineName) {
        Line line = lineRepository.findLineByName(lineName);
        lineRepository.deleteLine(line);
    }

    public List<String> getLineNames() {
        return lineRepository.getLineNames();
    }
}