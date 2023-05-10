package lotto.domain;

import java.util.Objects;

public class Amount {

    private final PositiveNumber value;

    private Amount(PositiveNumber value) {
        validRange(value);

        this.value = value;
    }

    public static Amount of(int value) {
        return new Amount(new PositiveNumber(value));
    }

    private void validRange(PositiveNumber value) {
        PositiveNumber MIN = new PositiveNumber(1000);

        if (MIN.isLessThan(value)) {
            throw new IllegalArgumentException(
                String.format("최저가격 보다 커야합니다. 최저가격: %d, 시도가격: %d", MIN, value));
        }
    }

    public PositiveNumber divide(PositiveNumber other) {
        return this.value.divide(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Amount amount = (Amount) o;
        return Objects.equals(value, amount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
