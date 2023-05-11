package lotto.ui;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

public class Stage1Test {

    @Test
    void 스텝1_구입할_금액을_입력받는다() {
        Stage1 stage = new Stage1();

        Lottos actual = stage.run(() -> 3000);

        assertThat(actual.size()).isEqualTo(3);
    }

}
