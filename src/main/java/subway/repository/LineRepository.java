package subway.repository;

import subway.domain.Line;
import subway.domain.LineName;
import subway.domain.Station;
import subway.domain.StationName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LineRepository {
    private static LineRepository lineRepository;
    private static final List<Line> lines = new ArrayList<>();

    private LineRepository() {
        init();
    }

    public static LineRepository getInstance() {
        if (lineRepository == null) {
            lineRepository = new LineRepository();
        }
        return lineRepository;
    }

    public static void addLine(LineName lineName, Station firstStation, Station lastStation) {
        if (isExistsLine(lineName)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선입니다.");
        }
        lines.add(Line.of(lineName, firstStation, lastStation));
    }

    public static boolean isExistsLine(LineName lineName) {
        return lines.stream()
                .anyMatch(line -> line.getName().equals(lineName));
    }

    public static void deleteLine(Line line) {
        lines.remove(line);
    }

    public static boolean isStationBelongToLine(Station station) {
        return lines.stream()
                .anyMatch(line -> line.isStationBelongToLine(station));
    }

    public List<String> getLineNames() {
        return lines.stream()
                .map(Line::getName)
                .map(LineName::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public HashMap<String, List<String>> getSubwayMap() {
        HashMap<String, List<String>> subwayMap = new HashMap<>();
        lines.stream()
                .forEach(line -> subwayMap.put(line.getName().toString(),
                        line.findStationNamesByLine()));
        return subwayMap;
    }
    }
}