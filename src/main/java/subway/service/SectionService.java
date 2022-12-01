package subway.service;

import subway.domain.*;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionService {
    private static final int LIMIT_NUMBER_OF_STATION = 2;
    private final StationRepository stationRepository = StationRepository.getInstance();
    private final LineRepository lineRepository = LineRepository.getInstance();

    public void addSection(LineName lineName, StationName stationName, Order order) {
        Line line = lineRepository.findLineByName(lineName);
        Station station = stationRepository.findOrMakeStation(stationName);
        validStationBelongToLine(station);
        line.addStationToLineByOrder(order, station);
    }

    private void validStationBelongToLine(Station station) {
        if (lineRepository.isStationBelongToLine(station)) {
            throw new IllegalArgumentException("[ERROR] 이미 노선에 속해있는 역입니다.");
        }
    }

    public void deleteSection(LineName lineName, StationName stationName) {
        Line line = lineRepository.findLineByName(lineName);
        Station station = stationRepository.findStationByName(stationName);
        checkLineContainOverTwoStation(line);
        line.deleteStation(station);
    }

    private void checkLineContainOverTwoStation(Line line) {
        if (line.numberOfStationsInLine() <= LIMIT_NUMBER_OF_STATION) {
            throw new IllegalArgumentException("[ERROR] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.");
        }
    }
}