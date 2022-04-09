package abstractentities;

public class Currency {

    protected static String symbol;
    protected double value;
    protected double valueInApolo;

    public Currency(String symbol, double value, double valueInApolo) {
        Currency.symbol = symbol;
        this.value = value;
        this.valueInApolo = valueInApolo;
    }

    public static String getSymbol() {
        return symbol;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Double convert(Currency currency) {
        return value * (this.valueInApolo / currency.valueInApolo);
    }
}
