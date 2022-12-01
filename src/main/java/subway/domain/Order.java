package subway.domain;

public class Order {
    private static final int INDEX_MIN_LIMIT = 1;
    private static final int INDEX_RESET = 1;
    private final int order;

    private Order(String order) {
        validIsNumber(order);
        validRange(order);
        this.order = Integer.parseInt(order) - INDEX_RESET;
    }

    public static Order of(String order) {
        return new Order(order);
    }

    private void validIsNumber(String order) {
        try {
            Integer.parseInt(order);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    private void validRange(String order) {
        int index = Integer.parseInt(order);
        if (index < INDEX_MIN_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 1이상의 숫자를 입력해야 합니다.");
        }
    }

    public int getOrder() {
        return order;
    }
}