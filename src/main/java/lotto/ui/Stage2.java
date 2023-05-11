package lotto.ui;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.ui.strategy.ScannerStrategy;
import lotto.ui.strategy.Stage;

public class Stage2 extends Stage<Lotto, String> {

    @Override
    public Lotto run(ScannerStrategy<String> scannerStrategy) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scannerStrategy.input();

        int[] intArray = Arrays.stream(input.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        return Lotto.of(intArray);
    }
}
