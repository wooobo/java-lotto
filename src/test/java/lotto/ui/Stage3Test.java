package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

public class Stage3Test {

    @Test
    void test() {
        Lotto firstLotto = Lotto.of(new int[]{1, 2, 3, 4, 5, 6});
        List<Lotto> values = new ArrayList<>(Arrays.asList(
            firstLotto,
            Lotto.of(new int[]{10, 12, 13, 14, 15, 16})
        ));
        Lottos lottos = Lottos.of(values);
        Stage3 stage = new Stage3(lottos, firstLotto);

        stage.run();
    }

}
