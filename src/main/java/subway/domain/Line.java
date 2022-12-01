package subway.domain;

import java.util.ArrayList;
import java.util.List;

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
        stationsBelongTo.add(index + 1, station);
    }

    private void validStationDuplicate(Station station) {
        if (stationsBelongTo.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 이미 속해있는 역입니다.");
        }
    }
}