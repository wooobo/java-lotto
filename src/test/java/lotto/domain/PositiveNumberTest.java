package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.PositiveNumber;
import org.junit.jupiter.api.Test;

class PositiveNumberTest {

    @Test
    void 음수를_가질수_없다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new PositiveNumber(-1);
            });
    }

    @Test
    void 전달_인자가_미만이면_false() {
        PositiveNumber big = new PositiveNumber(1);
        PositiveNumber small = new PositiveNumber(2);

        boolean actual = big.isLessThan(small);

        assertThat(actual).isFalse();
    }

    @Test
    void 전달_인자가_크면_true() {
        PositiveNumber big = new PositiveNumber(1);
        PositiveNumber small = new PositiveNumber(2);

        boolean actual = small.isLessThan(big);

        assertThat(actual).isTrue();
    }

    @Test
    void 몫을_구할수_있다() {
        PositiveNumber amount = new PositiveNumber(1000);
        PositiveNumber expected = new PositiveNumber(1);

        PositiveNumber actual = amount.divide(new PositiveNumber(1000));

        assertThat(actual).isEqualTo(expected);
    }
}
