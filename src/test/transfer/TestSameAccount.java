package test.transfer;

import abstractentities.Currency;
import abstractentities.Wallet;
import abstractentities.Wallet2;
import currencies.JapaneseYen;
import currencies.RtaCurrency;
import currencies.SwissFranc;
import utility.Terminal;

public class TestSameAccount {

    public static double chfValue;
    public static double japValue;
    public static double rtaValue;
    public static double actualValue;

    public static double fee = 1;

    public static String command;
    public static double inputNumber;

    private static final String COMMAND_SELECT_JAP  = "JAP";
    private static final String COMMAND_SELECT_RTA  = "RTA";


    public static void initDialog() {

        System.out.println();
        System.out.println("Тест за трансфер между портфейли в една и съща банка");
        System.out.println("Изберете портфейл, към който да бъдат изпратени пари");
        System.out.println("1. BG26STSA93005897165741");
        System.out.println("2. BG82IORT80944919959824");
        System.out.println("3. BG67RZBB91551583234321");

        inputNumber = Terminal.inputNumber();

        System.out.println("Изберете валутата, която ще изпращате");
        System.out.println("1. CHF");

        command = Terminal.inputString();

        transferCurrency();
    }

    public static void transferCurrency() {

        chfValue = Terminal.inputNumber("Въведете сума");

        System.out.println("Изберете валута, в която искате да конвертирате");
        System.out.println("1. JAP");
        System.out.println("2. RTA");

        command = Terminal.inputString();

        if (command.equals(COMMAND_SELECT_JAP)) {

            Currency chf = new SwissFranc(chfValue);
            Currency jap = new JapaneseYen(japValue);

            Wallet wallet = new Wallet(4000);
            Wallet2 wallet2 = new Wallet2(5500);

            wallet.addCurrency(chf);
            wallet2.addCurrency2(jap);

            actualValue = chf.convert(jap) + fee;

            if (actualValue >= Wallet.totalMoney) {
                System.out.println("Недостатъчна наличност!");
                System.exit(0);
            }

            Wallet.totalMoney -= actualValue - fee;
            Wallet2.totalMoney2 += actualValue;

        }

        if (command.equals(COMMAND_SELECT_RTA)) {

            Currency cfh = new SwissFranc(chfValue);
            Currency rta = new RtaCurrency(rtaValue);

            Wallet wallet = new Wallet(2500);
            Wallet2 wallet2 = new Wallet2(3000);

            wallet.addCurrency(cfh);
            wallet2.addCurrency2(rta);

            actualValue = cfh.convert(rta) + fee;

            if (actualValue >= Wallet.totalMoney) {
                System.out.println("Недостатъчна наличност!");
                System.exit(0);
            }

            Wallet.totalMoney -= actualValue - fee;
            Wallet2.totalMoney2 += actualValue;
        }
        System.out.printf("Наличност на Портфейл 1 след транзакцията: %.2f" + " " +
                Currency.getSymbol() + "\n", Wallet.totalMoney);
        System.out.printf("Наличност на Портфейл 2 след транзакцията: %.2f" + " " +
                Currency.getSymbol() + "\n", Wallet2.totalMoney2);
    }
}
