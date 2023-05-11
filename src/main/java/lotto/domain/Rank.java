package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    DEFAULT(0, 0);

    private final int matchCount;
    private final int amount;

    Rank(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static Rank valueOf(int matchCount) {
        return Arrays.stream(values())
            .filter(it -> it.matchCount == matchCount)
            .findFirst()
            .orElse(DEFAULT);
    }

    public static List<Rank> prizeRanks() {
        return Arrays.stream(values())
            .filter(it -> it.amount > 0)
            .collect(Collectors.toList());
    }

    public int matchCount() {
        return matchCount;
    }

    public int prize() {
        return amount;
    }
}
