package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 일치_매칭_찾을수있다() {
        Rank rank = Rank.valueOf(3);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 일치_매칭_없으면_기본값을_반환() {
        Rank rank = Rank.valueOf(10);

        assertThat(rank).isEqualTo(Rank.DEFAULT);
    }

}
