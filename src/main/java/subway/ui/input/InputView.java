package subway.ui.input;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public int readInteger() {
        String integerInput = sc.nextLine();
        isNumeral(integerInput);
        return Integer.parseInt(integerInput);
    }

    public String readName() {
        return null;
    }

    private void isNumeral(String integerInput) {
        try {
            Integer.parseInt(integerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }
}
