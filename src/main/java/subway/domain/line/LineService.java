package subway.domain.line;

import subway.domain.station.Station;

import java.util.List;

public class LineService {
    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public Station createLine(String lineName) {
        return null;
    }

    public void deleteLine(String lineName) {

    }

    public List<Station> getLines() {
        return null;
    }

    public Station findByStationName() {
        return null;
    }

    private void isUniqueName(String lineName) {

    }

    private void isValidNameLength(String lineName) {

    }
}
