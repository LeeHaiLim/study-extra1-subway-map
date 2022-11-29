package subway.repository;

import subway.domain.Line;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (isExistsLine(line)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선입니다.");
        }
        lines.add(line);
    }
    public static boolean isExistsLine(Line line) {
        if (lines.contains(line)) {
            return true;
        }
        return false;
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}