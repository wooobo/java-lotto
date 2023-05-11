package lotto.domain;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

public class Ranks {

    private final HashMap<Rank, Integer> values;

    public Ranks(HashMap<Rank, Integer> values) {
        this.values = values;
    }

    public static Ranks of(List<Rank> values) {
        HashMap<Rank, Integer> ranks = new HashMap<>();

        values.forEach(rank -> ranks.compute(rank, (k, v) -> v == null ? 1 : v + 1));

        return new Ranks(ranks);
    }

    public boolean contain(Rank compare) {
        return values.containsKey(compare);
    }

    public Integer count(Rank other) {
        return values.getOrDefault(other, 0);
    }

    public BigInteger totalPrize() {
        return BigInteger.valueOf(values.entrySet()
            .stream()
            .filter(it -> it.getValue() > 0)
            .mapToInt(entry -> entry.getKey().prize() * entry.getValue())
            .sum());
    }
}
