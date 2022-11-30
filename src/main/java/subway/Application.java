package subway;

import subway.domain.SubwayController;
import subway.domain.line.LineController;
import subway.domain.line.LineRepository;
import subway.domain.line.LineService;
import subway.domain.section.SectionController;
import subway.domain.section.SectionService;
import subway.domain.station.StationController;
import subway.domain.station.StationRepository;
import subway.domain.station.StationService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        LineRepository lineRepository = new LineRepository();
        StationRepository stationRepository = new StationRepository();

        LineService lineService = new LineService(lineRepository, stationRepository);
        StationService stationService = new StationService(stationRepository, lineRepository);
        SectionService sectionService = new SectionService(stationRepository, lineRepository);

        LineController lineController = new LineController(lineService);
        StationController stationController = new StationController(stationService);
        SectionController sectionController = new SectionController(sectionService);
        SubwayController subwayController = new SubwayController(lineController,stationController,sectionController);
        subwayController.run();
    }
}
