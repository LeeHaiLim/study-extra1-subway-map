package subway.ui.output;

import subway.domain.station.StationFunction;

import java.util.List;

import static subway.domain.station.StationFunction.CREATE_STATION;
import static subway.domain.station.StationFunction.DELETE_STATION;
import static subway.ui.output.OutputView.PRE_FIX;

public class StationOutputView {
    public static void printManagingPage() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
    }

    public static void askStationName() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
    }

    public static void printSuccessMessage(StationFunction stationFunction) {
        if (stationFunction.equals(CREATE_STATION)) {
            System.out.println(PRE_FIX + "역 등록이 완료되었습니다.");
        }
        if (stationFunction.equals(DELETE_STATION)) {
            System.out.println(PRE_FIX + "역 삭제가 완료되었습니다.");
        }
        System.out.println(" ");
    }

    public static void printStations(List<String> stationNames) {
        System.out.println("## 역목록");
        stationNames.forEach(stationName -> System.out.println(PRE_FIX + stationName));
    }
}
