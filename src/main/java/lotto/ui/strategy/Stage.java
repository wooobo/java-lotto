package lotto.ui.strategy;

public abstract class Stage<T, INPUT> {

    public abstract T run(ScannerStrategy<INPUT> scannerStrategy);
}
