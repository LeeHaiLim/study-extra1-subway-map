package subway.domain.line;

import subway.domain.station.StationFunction;
import subway.ui.input.InputView;
import subway.ui.output.LineOutputView;
import subway.ui.output.StationOutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static subway.domain.line.LineFunction.*;

public class LineController {
    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    public void run() {
        while(true) {
            try {
                LineOutputView.printManagingPage();
                LineFunction function = getLineFunction();
                navigate(function);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LineFunction getLineFunction() {
        while (true) {
            try {
                return  LineFunction.from(InputView.readMain());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void navigate(LineFunction function) {
        if (function.equals(CREATE_LINE)) {
            createLine(getLineName(), getLineStart(), getLineEnd());
        }
        if (function.equals(DELETE_LINE)) {
            deleteLine(getLineName());
        }
        if (function.equals(SHOW_LINE)) {
            LineOutputView.printLines(getLines().stream().map(Line::getName).collect(Collectors.toList()));
        }
    }

    public Line createLine(String lineName, String lineStart, String lineEnd) {
        List<String> stationNames = new ArrayList<>();
        stationNames.add(lineStart);
        stationNames.add(lineEnd);
        return lineService.createLine(lineName, stationNames);
    }

    public void deleteLine(String lineName) {
        lineService.deleteLine(lineName);
    }

    public List<Line> getLines() {
        return lineService.getLines();
    }

    private String getLineStart() {
        LineOutputView.askLineStart();
        return InputView.readName();
    }

    private String getLineEnd() {
        LineOutputView.askLineEnd();
        return InputView.readName();
    }

    private String getLineName() {
        LineOutputView.askLineName();
        return InputView.readName();
    }

}
