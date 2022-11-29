package subway.ui.output;

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

    public static void printSuccessMessage() {
        System.out.println("성공하였습니다.");
    }
}
