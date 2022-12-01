package subway.controller;

import subway.domain.LineName;
import subway.domain.Menu.SectionMenu;
import subway.domain.Order;
import subway.domain.StationName;
import subway.service.SectionService;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.Menu.SectionMenu.*;

public class SectionController implements SubwayController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final SectionService sectionService = new SectionService();


    @Override
    public void start() {
        while (true) {
            try {
                SectionMenu sectionMenu = inputView.readSectionMenu();
                if (sectionMenu == BACK) {
                    break;
                }
                findMenu(sectionMenu);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void findMenu(SectionMenu sectionMenu) {
        if (sectionMenu == ADD_SECTION) {
            runAddSection();
        }
        if (sectionMenu == DELETE_SECTION) {
            runDeleteSection();
        }
    }

    private void runAddSection() {
        System.out.println("## 노선을 입력하세요.");
        LineName lineName = inputView.readLineName();
        System.out.println("## 역이름을 입력하세요.");
        StationName stationName = inputView.readStationName();
        System.out.println("## 순서를 입력하세요.");
        Order order = inputView.readSectionOrder();
        sectionService.addSection(lineName, stationName, order);
        outputView.printAddSectionMessage();
    }

    private void runDeleteSection() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        LineName lineName = inputView.readLineName();
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        StationName stationName = inputView.readStationName();
        sectionService.deleteSection(lineName, stationName);
        outputView.printDeleteSectionMessage();
    }
}
