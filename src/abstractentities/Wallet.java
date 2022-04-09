package abstractentities;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    public static double totalMoney;
    public List<Currency> currencies = new ArrayList<>();

    public Wallet(double totalMoney){
        Wallet.totalMoney = totalMoney;
    }

    public void addCurrency(Currency currency) {
        currencies.add(currency);
    }

}

