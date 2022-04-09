package currencies;

import abstractentities.Currency;

public class Gold extends Currency {
    public Gold(double value) {
        super("GLD",value, 1000);
    }
}
