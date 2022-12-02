package subway.controller;

import subway.repository.LineRepository;
import subway.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class MapController implements SubwayController {
    private final OutputView outputView = new OutputView();
    private final LineRepository lineRepository = LineRepository.getInstance();

    @Override
    public void start() {
        HashMap<String, List<String>> subwayMap =
                lineRepository.getSubwayMap();
        outputView.printSubwayMap(subwayMap);
    }
}
