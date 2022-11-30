package subway.ui.output;

import java.util.List;

public class OutputView {

    public static final String PRE_FIX = "[INFO]";

    public static void printStart() {
        System.out.println("## 메인화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
    }

    public static void askFunction() {
        System.out.println(" ");
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void printAll(String lineName, List<String> stationNames) {
        System.out.println(PRE_FIX + lineName);
        System.out.println("---");
        stationNames.forEach(stationName -> System.out.println(PRE_FIX + stationName));
        System.out.println(" ");
    }
}
