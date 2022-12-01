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
        Station station = stationRepository.findStationByName(stationName);
        line.addStationToLineByOrder(order.getOrder(), station);
    }
}