package subway.ui.input;

import java.util.Scanner;

public class InputView {
    private static final Scanner SC = new Scanner(System.in);
    private static final int VALID_MINIMUM_LENGTH = 2;

    public int readInteger() {
        String integerInput = SC.nextLine();
        isNumeral(integerInput);
        return Integer.parseInt(integerInput);
    }

    public String readName() {
        String name = SC.nextLine();
        if (name.length() < VALID_MINIMUM_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 2이상이여야 합니다.");
        }
        return SC.nextLine();
    }

    private void isNumeral(String integerInput) {
        try {
            Integer.parseInt(integerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }
}
