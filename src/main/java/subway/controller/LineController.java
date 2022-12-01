package subway.controller;

import subway.domain.LineName;
import subway.domain.Menu.LineMenu;
import subway.domain.StationName;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

import static subway.domain.Menu.LineMenu.*;

public class LineController implements SubwayController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LineService lineService = new LineService();


    @Override
    public void start() {
        boolean isContinue = true;
        while (isContinue) {
            try {
                LineMenu number = inputView.readLineMenu();
                if (number == BACK) {
                    break;
                }
                findMenu(number);
                isContinue = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void findMenu(LineMenu number) {
        if (number == ADD_LINE) {
            runAddLine();
        }
        if (number == DELETE_LINE) {
            runDeleteLine();
        }
        if (number == LINE_LIST) {
            List<String> lineNames = lineService.getLineNames();
            outputView.printLines(lineNames);
        }
    }

    private void runAddLine() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        LineName lineName = inputView.readLineName();
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        StationName firstStationName = inputView.readStationName();
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        StationName lastStationName = inputView.readStationName();
        lineService.addLine(lineName, firstStationName, lastStationName);
        outputView.printAddLineMessage();
    }

    private void runDeleteLine() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        LineName lineName = inputView.readLineName();
        lineService.deleteLine(lineName);
        outputView.printDeleteLineMessage();
    }
}