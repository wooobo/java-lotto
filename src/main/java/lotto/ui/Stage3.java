package lotto.ui;

import java.math.BigDecimal;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Ranks;

public class Stage3 {

    private final Lottos lottos;
    private final Lotto lastLotto;

    public Stage3(Lottos lottos, Lotto lastLotto) {
        this.lottos = lottos;
        this.lastLotto = lastLotto;
    }

    public void run() {
        Ranks ranks = lottos.ranks(lastLotto);

        System.out.println("당첨 통계\n---------");
        Rank.prizeRanks()
            .forEach(
                it -> System.out.printf("%d개 일치 (%d원)- %d개%n", it.matchCount(), it.prize(),
                    ranks.count(it)));

        BigDecimal rate = lottos.rate(ranks.totalPrize());
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", rate);

    }
}
