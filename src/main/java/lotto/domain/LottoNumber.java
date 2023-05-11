package lotto.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int MIN = 1;
    private static final int MAX = 45;
    public static final Integer[] RANGE_NUMBERS = IntStream.rangeClosed(MIN, MAX)
        .boxed()
        .toArray(Integer[]::new);

    private final int value;


    public LottoNumber(int value) {
        validRange(value);

        this.value = value;
    }

    public static LottoNumber of(int value) {
        return new LottoNumber(value);
    }

    public boolean same(LottoNumber other) {
        return this.equals(other);
    }

    public int value() {
        return value;
    }

    private void validRange(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException(
                String.format("로또 범위에서 벗어났습니다. %d 부터 %d까지", MIN, MAX));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
