package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    @DisplayName("로또 번호 범위에서 벗어나면 에러가 발생한다")
    void 벗어난_범위_예외_검증(int value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new LottoNumber(value);
            });
    }

    @Test
    void 동등성_검증() {
        LottoNumber expected = new LottoNumber(1);

        LottoNumber actual = new LottoNumber(1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 동일한_번호_true() {
        LottoNumber lotto = new LottoNumber(1);

        LottoNumber actual = new LottoNumber(1);

        assertThat(actual.same(lotto)).isTrue();
    }

    @Test
    void 다른_번호_false() {
        LottoNumber lotto = new LottoNumber(1);

        LottoNumber actual = new LottoNumber(2);

        assertThat(actual.same(lotto)).isFalse();
    }
}
