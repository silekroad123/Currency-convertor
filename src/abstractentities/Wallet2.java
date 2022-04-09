package abstractentities;

import utility.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Wallet2 {

    public static double totalMoney2;
    public List<Currency> currencies2 = new ArrayList<>();

    public Wallet2(double totalMoney2){
        Wallet2.totalMoney2 = totalMoney2;
    }

    public void addCurrency2(Currency currency) {
        currencies2.add(currency);
    }

    public boolean isWalletBlocked() {
        return Terminal.generateRandomNumber() == 1;
    }
}
