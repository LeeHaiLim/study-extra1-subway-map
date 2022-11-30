package subway.domain;

import subway.domain.line.Line;
import subway.domain.line.LineController;
import subway.domain.section.SectionController;
import subway.domain.station.Station;
import subway.domain.station.StationController;
import subway.ui.input.InputView;
import subway.ui.output.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class SubwayController {
    private final LineController lineController;
    private final StationController stationController;
    private final SectionController sectionController;

    public SubwayController(
            LineController lineController,
            StationController stationController,
            SectionController sectionController
    ) {
        this.lineController = lineController;
        this.stationController = stationController;
        this.sectionController = sectionController;
    }

    public void run() {
        init();
        Main from = Main.BEFORE;
        while(!from.equals(Main.QUIT)) {
            try {
                from = start();
                navigate(from);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Main start() {
        OutputView.printStart();
        OutputView.askFunction();
        return Main.from(InputView.readMain());
    }


    private void navigate(Main from) {
        if (from.equals(Main.MANAGE_LINE)) {
            manageLine();
        }
        if (from.equals(Main.MANAGE_SECTION)) {
            manageSection();
        }
        if (from.equals(Main.MANAGE_STATION)) {
            manageStation();
        }
        if (from.equals(Main.PRINT_ALL_LINE)) {
            printAllLine();
        }
    }

    private void manageLine() {
        lineController.run();
    }

    private void manageSection() {
        sectionController.run();
    }

    private void manageStation() {
        stationController.run();
    }

    private void printAllLine() {
        List<Line> lines = lineController.getLines();
        lines.forEach(line -> {
            String lineName = line.getName();
            List<String> stationNames = line.getStationsInLine().stream().
                    map(Station::getName)
                    .collect(Collectors.toList());
            OutputView.printAll(lineName,stationNames);
        });
    }

    private void init() {
        initStation();
        initLine();
        initSection();
    }

    private void initStation() {
        stationController.createStation("교대역");
        stationController.createStation("강남역");
        stationController.createStation("역삼역");
        stationController.createStation("남부터미널역");
        stationController.createStation("양재역");
        stationController.createStation("양재시민의숲역");
        stationController.createStation("매봉역");
    }

    private void initLine() {
        lineController.createLine("2호선", "교대역", "역삼역");
        lineController.createLine("3호선", "교대역", "매봉역");
        lineController.createLine("신분당선", "강남역", "양재시민의숲역");
    }

    private void initSection() {
        sectionController.registerSection("2호선", "강남역", 2);
        sectionController.registerSection("3호선", "남부터미널역", 2);
        sectionController.registerSection("3호선", "양재역", 3);
        sectionController.registerSection("신분당선", "양재역", 2);

    }
}
