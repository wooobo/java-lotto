package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int BUNDLE_COUNT = 6;

    private final Set<LottoNumber> values;

    private Lotto(Set<LottoNumber> values) {
        validateLottoBundle(values);

        this.values = values;
    }

    private Lotto(Set<LottoNumber> values, int originValuesSize) {
        this(values);

        validateNonDuplicate(values, originValuesSize);
    }

    public static Lotto of(int[] numbers) {
        Set<LottoNumber> values = Arrays.stream(numbers)
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toSet());

        return new Lotto(values, numbers.length);
    }

    private void validateNonDuplicate(Set<LottoNumber> values, int validSize) {
        if (values.size() != validSize) {
            throw new IllegalArgumentException("중복 숫자를 입력 할 수 없습니다.");
        }
    }

    private void validateLottoBundle(Set<LottoNumber> values) {
        if (values.size() != BUNDLE_COUNT) {
            throw new IllegalArgumentException(
                String.format("로또 묶음은 %d개 입니다. 현재값 : %d", BUNDLE_COUNT, values.size()));
        }
    }

    @Override
    public String toString() {
        List<LottoNumber> sortedNumbers = values.stream()
            .sorted(Comparator.comparingInt(LottoNumber::value))
            .collect(Collectors.toList());

        String numbers = sortedNumbers.stream()
            .map(LottoNumber::value)
            .map(String::valueOf)
            .collect(Collectors.joining(", "));

        return "[" + numbers + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(values, lotto.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
