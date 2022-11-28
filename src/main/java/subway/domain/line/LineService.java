package subway.domain.line;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LineService {
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public LineService(LineRepository lineRepository, StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public Line createLine(String lineName, List<String> stationNames) {
        isUniqueName(lineName);
        isRegisteredStation(stationNames);
        List<Station> stations = convertForm(stationNames);
        Line line = new Line(lineName, stations);
        return lineRepository.save(line);
    }

    public void deleteLine(String lineName) {
        Line line = getLineByName(lineName);
        lineRepository.delete(line);
    }

    public List<Line> getLines() {
        return lineRepository.findAll();
    }

    public Line getLineByName(String lineName) {
        return lineRepository.findByName(lineName)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 등록되지 않은 역은 노선이름입니다."));
    }

    private void isUniqueName(String lineName) {
        Optional<Line> line = lineRepository.findByName(lineName);
        if (line.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 노선 이름입니다.");
        }
    }

    private void isRegisteredStation(List<String> stationNames) {
        Optional<String> station = stationNames.stream()
                .filter(stationName -> stationRepository.findByName(stationName).isEmpty())
                .findAny();
        if (station.isPresent()) {
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 역은 노선에 등록할 수 없습니다.");
        }
    }

    private List<Station> convertForm(List<String> stationNames) {
        return stationNames.stream()
                .map(stationName -> stationRepository.findByName(stationName).get())
                .collect(Collectors.toList());
    }
}
