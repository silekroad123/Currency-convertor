package currencies;

import abstractentities.Currency;

public class Bitcoin extends Currency {
    public Bitcoin(double value) {
        super("BTC",value, 1054);
    }
}
