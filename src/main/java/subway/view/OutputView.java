package subway.view;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String INFO_TAG = "[INFO] ";

    public void printStations(List<String> stationNames) {
        System.out.println("\n## 역 목록");
        stationNames.stream().forEach(name -> System.out.println(INFO_TAG + name));
    }

    public void printLines(List<String> lineNames) {
        System.out.println("\n## 노선 목록");
        lineNames.stream().forEach(name -> System.out.println(INFO_TAG + name));
    }

    public void printSubwayMap(HashMap<String, List<String>> subwayMap) {
        System.out.println("\n## 지하철 노선도");
        for (String lineName : subwayMap.keySet()) {
            System.out.println(INFO_TAG + lineName);
            System.out.println(INFO_TAG + "---");
            subwayMap.get(lineName).stream()
                    .forEach(name -> System.out.println(INFO_TAG + name));
            System.out.println();
        }
    }

    public void printAddStationMessage() {
        System.out.println(INFO_TAG + "지하철 역이 등록되었습니다.");

    }

    public void printDeleteStationMessage() {
        System.out.println(INFO_TAG + "지하철 역이 삭제되었습니다.");
    }

    public void printAddLineMessage() {
        System.out.println(INFO_TAG + "지하철 노선이 등록되었습니다.");
    }

    public void printDeleteLineMessage() {
        System.out.println(INFO_TAG + "지하철 노선이 삭제되었습니다.");
    }

    public void printAddSectionMessage() {
        System.out.println(INFO_TAG + "구간이 등록되었습니다.");
    }

    public void printDeleteSectionMessage() {
        System.out.println(INFO_TAG + "구간이 삭제되었습니다.");
    }
}