package subway.view;

import subway.domain.LineName;
import subway.domain.Menu.LineMenu;
import subway.domain.Menu.MainMenu;
import subway.domain.Menu.SectionMenu;
import subway.domain.Menu.StationMenu;
import subway.domain.Order;
import subway.domain.StationName;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public MainMenu readMainMenu() {
        showMainMenu();
        while (true) {
            try {
                System.out.println("\n## 원하는 기능을 선택하세요.");
                return MainMenu.from(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n## 메인 화면");
        System.out.println("1. 역관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
    }

    public StationMenu readStationMenu() {
        showStationMenu();
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return StationMenu.from(scanner.nextLine());
    }

    private void showStationMenu() {
        System.out.println("\n## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
    }

    public LineMenu readLineMenu() {
        showLineMenu();
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return LineMenu.from(scanner.nextLine());
    }

    private void showLineMenu() {
        System.out.println("\n## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
    }

    public SectionMenu readSectionMenu() {
        showSectionMenu();
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return SectionMenu.from(scanner.nextLine());
    }

    private void showSectionMenu() {
        System.out.println("\n## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
    }

    public StationName readStationName() {
        return StationName.from(scanner.nextLine());
    }

    public LineName readLineName() {
        return LineName.from(scanner.nextLine());
    }

    public Order readSectionOrder() {
        return Order.from(scanner.nextLine());
    }
}