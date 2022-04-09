package test.convert;

import abstractentities.Currency;
import currencies.*;
import utility.Terminal;

public class TestFiatToGold {

    public static double dollarValue;
    public static double cadValue;
    public static double japValue;
    public static double chfValue;
    public static double goldValue;
    public static double actualValue;

    public static String command;

    private static final String COMMAND_SELECT_USD    = "USD";
    private static final String COMMAND_SELECT_CAD    = "CAD";
    private static final String COMMAND_SELECT_JAP    = "JAP";


    public static void initDialog() {

        System.out.println();
        System.out.println("Валута в злато");
        System.out.println("Изберете валута, която ще изпращате");
        System.out.println("1. USD");
        System.out.println("2. CAD");
        System.out.println("3. JAP");
        System.out.println("4. CHF");

        command = Terminal.inputString();

        switch (command) {
            case COMMAND_SELECT_USD -> convertUsdToGold();
            case COMMAND_SELECT_CAD -> convertCadToGold();
            case COMMAND_SELECT_JAP -> convertJapToGold();
            default -> convertChfToGold();
        }

    }

    public static void convertUsdToGold(){

        dollarValue = Terminal.inputNumber("Въведете сума");

        Currency dollars = new Dollar(dollarValue);
        Currency gold = new Gold(goldValue);

        actualValue = dollars.convert(gold);

        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertCadToGold() {

        cadValue = Terminal.inputNumber("Въведете сума");

        Currency cad = new CanadianDollar(cadValue);
        Currency gold = new Gold(goldValue);

        actualValue = cad.convert(gold);

        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertJapToGold() {

        japValue = Terminal.inputNumber("Въведете сума");

        Currency jap = new JapaneseYen(japValue);
        Currency gold = new Gold(goldValue);

        actualValue = jap.convert(gold);

        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertChfToGold() {

        chfValue = Terminal.inputNumber("Въведете сума");

        Currency chf = new SwissFranc(chfValue);
        Currency gold = new Gold(goldValue);

        actualValue = chf.convert(gold);

        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }
}
