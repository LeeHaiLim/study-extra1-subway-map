package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private StationName name;
    private List<Line> linesBelongTo = new ArrayList<>();

    private Station(StationName name) {
        this.name = name;
    }

    public static Station of(StationName name) {
        return new Station(name);
    }

    public StationName getName() {
        return name;
    }

    public void addLineBelongToStation(Line line) {
        validLineDuplicate(line);
        linesBelongTo.add(line);
    }

    private void validLineDuplicate(Line line) {
        if (linesBelongTo.contains(line)) {
            throw new IllegalArgumentException("[ERROR] 이미 속해있는 노선입니다.");
        }
    }
}