package lotto.domain;

import java.util.Objects;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(int value) {
        validRange(value);

        this.value = value;
    }

    public static PositiveNumber of(int value) {
        return new PositiveNumber(value);
    }

    public boolean isLessThan(PositiveNumber other) {
        return this.value > other.value;
    }

    private void validRange(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("음수를 가질수 없습니다. 값: %d", value));
        }
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public PositiveNumber divide(PositiveNumber other) {
        return new PositiveNumber(value / other.value);
    }
}
