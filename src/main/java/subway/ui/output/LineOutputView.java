package subway.ui.output;

import subway.domain.line.LineFunction;

import java.util.List;

import static subway.domain.line.LineFunction.CREATE_LINE;
import static subway.domain.line.LineFunction.DELETE_LINE;
import static subway.ui.output.OutputView.PRE_FIX;

public class LineOutputView {
    public static void printManagingPage() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
    }

    public static void askLineName() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
    }

    public static void askLineStart() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        printEmptyLine();
    }

    public static void askLineEnd() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        printEmptyLine();
    }

    public static void printSuccessMessage(LineFunction lineFunction) {
        if (lineFunction.equals(CREATE_LINE)) {
            System.out.println(PRE_FIX + "지하철 노선이 등록되었습니다.");
        }
        if (lineFunction.equals(DELETE_LINE)) {
            System.out.println(PRE_FIX + "지하철 노선이 삭제되었습니다.");
        }
        printEmptyLine();
    }

    public static void printLines(List<String> lineNames) {
        System.out.println("## 노선 목록");
        lineNames.forEach(lineName -> System.out.println(PRE_FIX + lineName));
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println(" ");
    }
}
