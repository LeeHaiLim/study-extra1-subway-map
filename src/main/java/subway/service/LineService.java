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
        lineRepository.addLine(lineName);
        Line line = lineRepository.findLineByName(lineName);
        addStationToLine(line, firstStationName, lastStationName);
    }

    private void addStationToLine(Line line, StationName firstStationName, StationName lastStationName) {
        validFirstAndLastStation(firstStationName, lastStationName);
        Station firstStation = stationRepository.findOrMakeStation(firstStationName);
        Station lastStation = stationRepository.findOrMakeStation(lastStationName);
        line.addStationToLine(firstStation);
        line.addStationToLine(lastStation);
    }
    private void validFirstAndLastStation(StationName firstStationName, StationName lastStationName) {
        if (firstStationName.equals(lastStationName)) {
            throw new IllegalArgumentException("[ERROR] 상행 종점 역과 하행 종점 역은 같을 수 없습니다.");
        }
    }

    public void deleteLine(LineName lineName) {
        Line line = lineRepository.findLineByName(lineName);
        lineRepository.deleteLine(line);
    }

    public List<String> getLineNames() {
        return lineRepository.getLineNames();
    }
}