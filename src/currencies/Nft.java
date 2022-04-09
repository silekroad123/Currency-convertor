package currencies;

import abstractentities.Currency;
import utility.Terminal;

public class Nft extends Currency {

    protected static String name;

    public Nft(String name, double value) {
        super("NFT", value, Terminal.inputNumber());
        Nft.name = name;
    }

}
