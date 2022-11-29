package subway.ui.input;

import java.util.Scanner;

public class InputView {
    private static final Scanner SC = new Scanner(System.in);
    private static final int VALID_MINIMUM_LENGTH = 2;

    public static String readMain() {
        return SC.nextLine();
    }

    public static String readName() {
        String name = SC.nextLine();
        if (name.length() < VALID_MINIMUM_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 2이상이여야 합니다.");
        }
        return name;
    }
}
