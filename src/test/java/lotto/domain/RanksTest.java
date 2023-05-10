package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RanksTest {

    @Test
    void 랭킹_포함_확인할수있다() {
        List<Rank> values = new ArrayList<>(Arrays.asList(Rank.FIRST, Rank.SECOND));
        Ranks ranks = Ranks.of(values);

        assertAll(
            () -> assertThat(ranks.contain(Rank.FIRST)).isTrue(),
            () -> assertThat(ranks.contain(Rank.SECOND)).isTrue()
        );
    }

    @Test
    void 등수_매칭_갯수를_반환받을수있다() {
        List<Rank> values = new ArrayList<>(Arrays.asList(Rank.FIRST, Rank.SECOND));
        Ranks ranks = Ranks.of(values);

        assertAll(
            () -> assertThat(ranks.count(Rank.FIRST)).isEqualTo(1),
            () -> assertThat(ranks.count(Rank.SECOND)).isEqualTo(1),
            () -> assertThat(ranks.count(Rank.THIRD)).isEqualTo(0)
        );
    }

    @Test
    void 총상금_알수있다() {
        List<Rank> values = new ArrayList<>(Arrays.asList(Rank.FIRST, Rank.SECOND));

        Ranks ranks = Ranks.of(values);
        BigInteger expected = BigInteger.valueOf(2_001_500_000L);
        BigInteger actual = ranks.totalPrize();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 총상금_알수있다_한개당첨() {
        List<Rank> values = new ArrayList<>(List.of(Rank.FIRST));

        Ranks ranks = Ranks.of(values);
        BigInteger expected = BigInteger.valueOf(2_000_000_000L);
        BigInteger actual = ranks.totalPrize();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 총상금_없음() {
        List<Rank> values = new ArrayList<>();

        Ranks ranks = Ranks.of(values);
        BigInteger expected = BigInteger.valueOf(0L);
        BigInteger actual = ranks.totalPrize();

        assertThat(actual).isEqualTo(expected);
    }
}
