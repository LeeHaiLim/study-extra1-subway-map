package subway.domain.station;

import subway.domain.line.LineFunction;
import subway.ui.input.InputView;
import subway.ui.output.LineOutputView;
import subway.ui.output.StationOutputView;

import java.util.List;
import java.util.stream.Collectors;

import static subway.domain.line.LineFunction.*;
import static subway.domain.station.StationFunction.*;

public class StationController {
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    public void run() {
        while (true) {
            try {
                StationOutputView.printManagingPage();
                StationFunction function = getStationFunction();
                navigate(function);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private StationFunction getStationFunction() {
        while (true) {
            try {
                return  StationFunction.from(InputView.readMain());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void navigate(StationFunction function) {
        if (function.equals(CREATE_STATION)) {
            createStation(getStationName());
        }
        if (function.equals(DELETE_STATION)) {
            deleteStation(getStationName());
        }
        if (function.equals(SHOW_STATION)) {
            List<Station> stations = getStations();
            StationOutputView.printStations(stations.stream().map(Station::getName).collect(Collectors.toList()));
        }
    }

    public Station createStation(String stationName) {
        Station station = stationService.createStation(stationName);
        StationOutputView.printSuccessMessage(CREATE_STATION);
        return station;
    }

    public void deleteStation(String stationName) {
        stationService.deleteStation(stationName);
        StationOutputView.printSuccessMessage(DELETE_STATION);
    }

    public List<Station> getStations() {
        return stationService.getStations();
    }

    public String getStationName() {
        StationOutputView.askStationName();
        return InputView.readName();
    }
}
