package lotto.ui;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

public class Stage2Test {

    @Test
    void 스텝2_지난주_번호를_입력받는다() {
        Stage2 stage = new Stage2();
        Lotto expected = Lotto.of(new int[]{1, 2, 3, 4, 5, 6});

        Lotto actual = stage.run(() -> "1,2,3,4,5,6");

        assertThat(actual).isEqualTo(expected);
    }

}
