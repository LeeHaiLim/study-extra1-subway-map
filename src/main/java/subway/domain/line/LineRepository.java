package subway.domain.line;

import subway.domain.Repository;
import subway.domain.line.Line;

import java.util.*;

public class LineRepository implements Repository<Line> {
    private static final List<Line> lines = new ArrayList<>();

    @Override
    public Line save(Line line) {
        lines.add(line);
        return line;
    }

    @Override
    public List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public void delete(Line line) {

    }

    @Override
    public Optional<Line> findByName(String name) {
        return Optional.empty();
    }
}
