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

    public static Line of(LineName name, Station firstStation, Station lastStation) {
        Line line = new Line(name);
        line.initLine(firstStation, lastStation);
        return line;
    }

    private void initLine(Station firstStation, Station lastStation) {
        stations.add(firstStation);
        stations.add(lastStation);
    }

    public void addStationToLineByOrder(int index, Station station) {
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
}