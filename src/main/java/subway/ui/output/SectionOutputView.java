package subway.ui.output;

import subway.domain.section.SectionFunction;

import static subway.domain.section.SectionFunction.CREATE_SECTION;
import static subway.ui.output.OutputView.PRE_FIX;

public class SectionOutputView {
    public static void printManagingPage() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("3. 구간 조회");
        System.out.println("B. 돌아가기");
    }

    public static void askPosition() {
        System.out.println("## 순서를 입력하세요.");
    }

    public static void printSuccessMessage(SectionFunction sectionFunction) {
        if (sectionFunction.equals(CREATE_SECTION)) {
            System.out.println(PRE_FIX + "구간 등록이 완료되었습니다.");
        }
        if (sectionFunction.equals(CREATE_SECTION)) {
            System.out.println(PRE_FIX + "구간 삭제가 완료되었습니다.");
        }
        System.out.println(" ");
    }
}
