package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.ui.Stage3;
import lotto.ui.strategy.ScannerInt;
import lotto.ui.strategy.ScannerString;
import lotto.ui.Stage1;
import lotto.ui.Stage2;

public class LottoApplication {

    public static void main(String[] args) {
        Lottos lottos = new Stage1().run(new ScannerInt());
        Lotto lastLotto = new Stage2().run(new ScannerString());

        Stage3.run(lottos, lastLotto);
    }
}
