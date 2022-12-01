package subway.controller;

import subway.domain.Menu.StationMenu;
import subway.domain.StationName;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

import static subway.domain.Menu.StationMenu.*;

public class StationController implements SubwayController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final StationService stationService = new StationService();

    @Override
    public void start() {
        while (true) {
            try {
                StationMenu stationMenu = inputView.readStationMenu();
                if (stationMenu == BACK) {
                    break;
                }
                findMenu(stationMenu);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void findMenu(StationMenu stationMenu) {
        if (stationMenu == ADD_STATION) {
            runAddStation();
        }
        if (stationMenu == DELETE_STATION) {
            runDeleteStation();
        }
        if (stationMenu == STATION_LIST) {
            List<String> stationNames = stationService.getStationNames();
            outputView.printStations(stationNames);
        }
    }

    private void runAddStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        StationName stationName = inputView.readStationName();
        stationService.addStation(stationName);
        outputView.printAddStationMessage();
    }

    private void runDeleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        StationName stationName = inputView.readStationName();
        stationService.deleteStation(stationName);
        outputView.printDeleteStationMessage();
    }
}
