package subway.domain.line;

import subway.domain.station.Station;

import java.util.List;
import java.util.Optional;

public class LineService {
    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public Line createLine(String lineName, List<Station> stations) {
        isUniqueName(lineName);
        Line line = new Line(lineName, stations);
        return lineRepository.save(line);
    }

    public void deleteLine(String lineName) {

    }

    public List<Station> getLines() {
        return null;
    }

    private void isUniqueName(String lineName) {
        Optional<Line> line = lineRepository.findByName(lineName);
        if (line.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 노선 이름입니다.");
        }
    }
}
