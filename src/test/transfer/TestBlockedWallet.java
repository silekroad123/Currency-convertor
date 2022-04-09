package test.transfer;

import abstractentities.Currency;
import abstractentities.Wallet;
import abstractentities.Wallet2;
import currencies.CanadianDollar;
import currencies.Dollar;
import utility.Terminal;

public class TestBlockedWallet {

    public static double dollarValue;
    public static double cadValue;
    public static double actualValue;

    public static String command;
    public static double inputNumber;

    private static final String COMMAND_SELECT_CAD = "CAD";

    public static void initDialog() {

        System.out.println();
        System.out.println("Тест за блокиран портфейл");
        System.out.println("Изберете портфейл, към който да бъдат изпратени пари");
        System.out.println("1. BG26STSA93005897165741");
        System.out.println("2. BG82IORT80944919959824");
        System.out.println("3. BG67RZBB91551583234321");

        inputNumber = Terminal.inputNumber();

        System.out.println("Изберете валутата, която ще изпращате");
        System.out.println("1. USD");

        command = Terminal.inputString();

        transferCurrency();
    }

    public static void transferCurrency() {

        dollarValue = Terminal.inputNumber("Въведете сума");

        System.out.println("Изберете валута, в която искате да конвертирате");
        System.out.println("1. CAD");

        command = Terminal.inputString();

        if (command.equals(COMMAND_SELECT_CAD)) {

            Currency dollars = new Dollar(dollarValue);
            Currency cad = new CanadianDollar(cadValue);

            Wallet wallet = new Wallet(1500);
            Wallet2 wallet2 = new Wallet2(2500);

            wallet.addCurrency(dollars);
            wallet2.addCurrency2(dollars);

            actualValue = dollars.convert(cad);

            if(wallet2.isWalletBlocked()){
                System.out.println("Блокиран портфейл!");
                System.exit(0);
            }

            if (actualValue >= Wallet.totalMoney) {
                System.out.println("Недостатъчна наличност!");
                System.exit(0);
            }

            Wallet.totalMoney -= actualValue;
            Wallet2.totalMoney2 += actualValue;

        }
        System.out.printf("Наличност на Портфейл 1 след транзакцията: %.2f" + " " +
                Currency.getSymbol() + "\n", Wallet.totalMoney);
        System.out.printf("Наличност на Портфейл 2 след транзакцията: %.2f" + " " +
                Currency.getSymbol() + "\n", Wallet2.totalMoney2);
    }
}

