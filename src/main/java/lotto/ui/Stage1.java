package lotto.ui;

import lotto.domain.Amount;
import lotto.domain.Lottos;
import lotto.ui.strategy.ScannerStrategy;
import lotto.ui.strategy.Stage;

public class Stage1 extends Stage<Lottos, Integer> {

    @Override
    public Lottos run(ScannerStrategy<Integer> scannerStrategy) {
        System.out.println("구입금액을 입력해 주세요.");
        Amount amount = Amount.of(scannerStrategy.input());
        Lottos lottos = Lottos.of(amount);
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());

        lottos.values().forEach(System.out::println);

        return lottos;
    }
}
