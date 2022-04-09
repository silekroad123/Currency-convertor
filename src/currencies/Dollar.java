package currencies;

import abstractentities.Currency;

public class Dollar extends Currency {
    public Dollar(double value) {
        super("USD", value,  10);
    }
}
