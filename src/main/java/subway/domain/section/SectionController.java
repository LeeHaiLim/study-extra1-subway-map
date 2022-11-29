package subway.domain.section;

import subway.domain.line.LineFunction;
import subway.ui.input.InputView;
import subway.ui.output.LineOutputView;
import subway.ui.output.SectionOutputView;
import subway.ui.output.StationOutputView;

import static subway.domain.line.LineFunction.*;
import static subway.domain.section.SectionFunction.CREATE_SECTION;
import static subway.domain.section.SectionFunction.DELETE_SECTION;

public class SectionController {

    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    public void run() {
        SectionOutputView.printManagingPage();
        SectionFunction function = SectionFunction.from(InputView.readMain());
        navigate(function);
    }

    private void navigate(SectionFunction function) {
        if (function.equals(CREATE_SECTION)) {
            registerSection(getLineName(), getStationName(), getPosition());
        }
        if (function.equals(DELETE_SECTION)) {
            deleteSection(getLineName(),getStationName());
        }
    }

    public void registerSection(String lineName, String stationName, int potision) {
        sectionService.registerSection(lineName, stationName, potision);
    }

    public void deleteSection(String lineName,String stationName) {
        sectionService.deleteSection(lineName, stationName);
    }

    private int getPosition() {
        SectionOutputView.askPosition();
        return Integer.parseInt(InputView.readMain());
    }

    private String getStationName() {
        StationOutputView.askStationName();
        return InputView.readName();
    }

    private String getLineName() {
        LineOutputView.askLineName();
        return InputView.readName();
    }
}
