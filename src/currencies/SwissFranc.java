package currencies;

import abstractentities.Currency;

public class SwissFranc extends Currency {
    public SwissFranc(double value) {
        super("CHF", value, 20);
    }
}
