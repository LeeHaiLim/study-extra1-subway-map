package subway.repository;

import subway.domain.*;

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

    public static void addLine(LineName lineName) {
        if (isExistsLine(lineName)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선입니다.");
        }
        lines.add(Line.of(lineName));
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

    public static Line findLineByName(LineName lineName) {
        return lines.stream().filter(line -> line.getName().equals(lineName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 노선입니다."));
    }

    public void init() {
        lines.clear();
        initLine2();
        initLine3();
        initLineBundang();
    }

    private void initLine2() {
        addLine(LineName.of("2호선"));
        Line line = findLineByName(LineName.of("2호선"));
        line.addStationToLine(Station.of(StationName.of("교대역")));
        line.addStationToLine(Station.of(StationName.of("강남역")));
        line.addStationToLine(Station.of(StationName.of("역삼역")));
        lines.add(line);
    }

    private void initLine3() {
        addLine(LineName.of("3호선"));
        Line line = findLineByName(LineName.of("3호선"));
        line.addStationToLine(Station.of(StationName.of("교대역")));
        line.addStationToLine(Station.of(StationName.of("남부터미널역")));
        line.addStationToLine(Station.of(StationName.of("양재역")));
        line.addStationToLine(Station.of(StationName.of("매봉역")));
        lines.add(line);
    }

    private void initLineBundang() {
        addLine(LineName.of("신분당선"));
        Line line = findLineByName(LineName.of("신분당선"));
        line.addStationToLine(Station.of(StationName.of("강남역")));
        line.addStationToLine(Station.of(StationName.of("양재역")));
        line.addStationToLine(Station.of(StationName.of("양재시민의숲역")));
        lines.add(line);
    }
}