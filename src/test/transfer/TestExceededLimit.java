package test.transfer;

import abstractentities.Currency;
import abstractentities.Wallet;
import abstractentities.Wallet2;
import currencies.CanadianDollar;
import currencies.Dollar;
import currencies.Gold;
import currencies.RtaCurrency;
import utility.Terminal;

public class TestExceededLimit {

    public static double dollarValue;
    public static double cadValue;
    public static double goldValue;
    public static double rtaValue;
    public static double actualValue;

    public static String command;
    public static double inputNumber;

    public static final int fee = 1;

    private static final String COMMAND_SELECT_CAD     = "CAD";
    private static final String COMMAND_SELECT_GOLD    = "GLD";
    private static final String COMMAND_SELECT_RTA     = "RTA";

    public static void initDialog() {

        System.out.println();
        System.out.println("Тест за надвишена стойност");
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
        System.out.println("2. GLD");
        System.out.println("3. RTA");

        command = Terminal.inputString();

        if(command.equals(COMMAND_SELECT_CAD)){

            Currency dollars = new Dollar(dollarValue);
            Currency cad = new CanadianDollar(cadValue);

            Wallet wallet = new Wallet(1000);
            Wallet2 wallet2 = new Wallet2(2000);

            wallet.addCurrency(dollars);
            wallet2.addCurrency2(dollars);

            actualValue = dollars.convert(cad) + fee;

            if(actualValue >= Wallet.totalMoney) {
                System.out.println("Недостатъчна наличност!");
                System.exit(0);
            }

            Wallet.totalMoney -= actualValue;
            Wallet2.totalMoney2 += actualValue - fee;

        }

        if(command.equals(COMMAND_SELECT_GOLD)){

            Currency dollars = new Dollar(dollarValue);
            Currency gold = new Gold(goldValue);

            Wallet wallet = new Wallet(2000);
            Wallet2 wallet2 = new Wallet2(4500);

            wallet.addCurrency(dollars);
            wallet2.addCurrency2(dollars);

            actualValue = dollars.convert(gold) + fee;

            if(actualValue > Wallet.totalMoney) {
                System.out.println("Недостатъчна наличност!");
                System.exit(0);
            }

            Wallet.totalMoney -= actualValue;
            Wallet2.totalMoney2 += actualValue - fee;

        }

        if(command.equals(COMMAND_SELECT_RTA)) {

            Currency dollars = new Dollar(dollarValue);
            Currency rta = new RtaCurrency(rtaValue);

            Wallet wallet = new Wallet(4000);
            Wallet2 wallet2 = new Wallet2(7000);

            wallet.addCurrency(dollars);
            wallet2.addCurrency2(dollars);

            actualValue = dollars.convert(rta) + fee;

            if (actualValue >= Wallet.totalMoney) {
                System.out.println("Недостатъчна наличност!");
                System.exit(0);
            }

            Wallet.totalMoney -= actualValue;
            Wallet2.totalMoney2 += actualValue - fee;
        }
        System.out.printf("Наличност на Портфейл 1 след транзакцията: %.2f" + " " +
                Currency.getSymbol() + "\n", Wallet.totalMoney);
        System.out.printf("Наличност на Портфейл 2 след транзакцията: %.2f" + " " +
                Currency.getSymbol() + "\n", Wallet2.totalMoney2);
    }
}
