package lotto.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> values;

    private Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos auto(PositiveNumber count) {
        return new Lottos(
            IntStream.range(0, count.value())
                .mapToObj(i -> Lotto.auto())
                .collect(Collectors.toList())
        );
    }

    public static Lottos of(Amount amount) {
        return Lottos.auto(amount.divide(LOTTO_PRICE));
    }

    public static Lottos of(List<Lotto> values) {
        return new Lottos(values);
    }

    public Ranks ranks(Lotto lastLotto) {
        return Ranks.of(
            values.stream()
                .map(it -> Rank.valueOf(it.matchCount(lastLotto)))
                .collect(Collectors.toList())
        );
    }

    public BigDecimal rate(BigInteger totalPrize) {
        BigInteger totalPurchaseAmount = BigInteger.valueOf(values.size())
            .multiply(BigInteger.valueOf(LOTTO_PRICE));
        return new BigDecimal(totalPrize).divide(new BigDecimal(totalPurchaseAmount), 2,
            RoundingMode.HALF_UP);
    }

    public int size() {
        return values.size();
    }

    public List<Lotto> values() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos = (Lottos) o;
        return Objects.equals(values, lottos.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
