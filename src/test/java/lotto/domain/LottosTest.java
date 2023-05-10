package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 갯수만큼_로또_자동생성() {
        Lottos lottos = Lottos.auto(PositiveNumber.of(3));

        assertThat(lottos.size()).isEqualTo(3);
    }

}
