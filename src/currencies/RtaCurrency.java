package currencies;

import abstractentities.Currency;

public class RtaCurrency extends Currency {
    public RtaCurrency(double value) {
        super("RTA",value, 0.5);
    }
}
