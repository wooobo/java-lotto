package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 갯수만큼_로또_자동생성() {
        Lottos lottos = Lottos.auto(PositiveNumber.of(3));

        assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    void 랭킹구하기() {
        List<Lotto> input = new ArrayList<>();
        input.add(Lotto.of(new int[]{1, 2, 3, 4, 5, 6}));
        input.add(Lotto.of(new int[]{10, 11, 13, 14, 15, 16}));
        Lotto lastLotto = Lotto.of(new int[]{1, 2, 3, 4, 5, 6});
        Lottos lottos = Lottos.of(input);

        Ranks ranks = lottos.ranks(lastLotto);

        assertAll(
            () -> assertThat(ranks.contain(Rank.FIRST)).isTrue(),
            () -> assertThat(ranks.contain(Rank.DEFAULT)).isTrue(),
            () -> assertThat(ranks.contain(Rank.SECOND)).isFalse()
        );
    }

    @Test
    void 수익률() {
        Lottos lottos = Lottos.auto(PositiveNumber.of(3));

        assertThat(lottos.rate(BigInteger.valueOf(3000L)))
            .isEqualTo(BigDecimal.valueOf(1.0).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void 수익률_1이하() {
        Lottos lottos = Lottos.auto(PositiveNumber.of(3));

        assertThat(lottos.rate(BigInteger.valueOf(1000L)))
            .isEqualTo(BigDecimal.valueOf(0.33));
    }

    @Test
    void 수익률_1이상() {
        Lottos lottos = Lottos.auto(PositiveNumber.of(1));

        assertThat(lottos.rate(BigInteger.valueOf(10000L)))
            .isEqualTo(BigDecimal.valueOf(10.00f).setScale(2, RoundingMode.HALF_UP));
    }

}
