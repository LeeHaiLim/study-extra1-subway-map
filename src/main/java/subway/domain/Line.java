package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private LineName name;
    private List<Station> stations = new ArrayList<>();

    private Line(LineName name) {
        this.name = name;
    }

    public static Line of(LineName name) {
        Line line = new Line(name);
        return line;
    }

    public void addStationToLine(Station station) {
        validStationDuplicate(station);
        stations.add(station);
    }

    public void addStationToLineByOrder(Order order, Station station) {
        int index = order.getOrder();
        validStationDuplicate(station);
        validSectionIndex(index);
        stations.add(index, station);
    }

    private void validStationDuplicate(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 이미 속해있는 역입니다.");
        }
    }

    private void validSectionIndex(int index) {
        if (index > stations.size()) {
            throw new IllegalArgumentException("[ERROR] 올바른 순서를 입력해주세요.");
        }
    }

    public boolean isStationBelongToLine(Station findStation) {
        return stations.stream()
                .anyMatch(station -> station.equals(findStation));
    }

    public void deleteStation(Station deleteStation) {
        if (!stations.removeIf(station -> station.equals(deleteStation))) {
            throw new IllegalArgumentException("[ERROR] 해당 노선에 존재하지 않는 역입니다.");
        }
    }

    public int numberOfStationsInLine() {
        return this.stations.size();
    }

    public LineName getName() {
        return name;
    }

    public List<String> findStationNamesByLine() {
        return stations.stream()
                .map(Station::getName)
                .map(StationName::toString)
                .collect(Collectors.toList());
    }
}