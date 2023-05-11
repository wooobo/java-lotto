package lotto.ui.strategy;

import java.util.Scanner;

public class ScannerString implements ScannerStrategy<String> {

    @Override
    public String input() {
        return new Scanner(System.in).next();
    }
}
