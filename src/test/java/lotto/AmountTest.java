package lotto;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.Amount;
import org.junit.jupiter.api.Test;

public class AmountTest {

    @Test
    void 최저가격보다_낮으면_예외가_발생한다() {
        int exceptionValue = 999;

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Amount.of(exceptionValue);
            });
    }

}
