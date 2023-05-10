package lotto;


import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또_생성_갯수_보다_적으면_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Lotto.of(new int[]{1, 2, 3, 4, 5});
        });
    }

    @Test
    void 로또_생성_갯수_보다_많으면_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Lotto.of(new int[]{1, 2, 3, 4, 5, 6, 7});
        });
    }

    @Test
    void 로또_중복_번호_존재시_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Lotto.of(new int[]{1, 2, 3, 4, 5, 5});
        });
    }
}
