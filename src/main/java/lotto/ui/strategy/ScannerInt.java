package lotto.ui.strategy;

import java.util.Scanner;

public class ScannerInt implements ScannerStrategy<Integer> {

    @Override
    public Integer input() {
        return new Scanner(System.in).nextInt();
    }
}
