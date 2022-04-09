package test.convert;

import abstractentities.Currency;
import currencies.CanadianDollar;
import currencies.Dollar;
import currencies.JapaneseYen;
import currencies.SwissFranc;
import utility.Terminal;

public class TestFiatToFiat {

    public static double dollarValue;
    public static double cadValue;
    public static double japValue;
    public static double chfValue;
    public static double actualValue;

    public static String command;

    private static final String COMMAND_SELECT_USD    = "USD";
    private static final String COMMAND_SELECT_CAD    = "CAD";
    private static final String COMMAND_SELECT_JAP    = "JAP";
    private static final String COMMAND_SELECT_CHF    = "CHF";


    public static void initDialog() {
        System.out.println("Валута във валута");
        System.out.println("Изберете валута, която ще изпращате");
        System.out.println("1. USD");
        System.out.println("2. CAD");
        System.out.println("3. JAP");
        System.out.println("4. CHF");

        command = Terminal.inputString();

        switch (command) {
            case COMMAND_SELECT_USD -> convertUsdToFiat();
            case COMMAND_SELECT_CAD -> convertCadToFiat();
            case COMMAND_SELECT_JAP -> convertJapToFiat();
            default -> convertChfToFiat();
        }

    }

    public static void convertUsdToFiat(){

        dollarValue = Terminal.inputNumber("Въведете сума");

        System.out.println("Изберете валута, в която искате да конвертирате");
        System.out.println("1. CAD");
        System.out.println("2. JAP");
        System.out.println("3. CHF");

        command = Terminal.inputString();

        if(command.equals(COMMAND_SELECT_CAD)){

            Currency dollars = new Dollar(dollarValue);
            Currency cad = new CanadianDollar(cadValue);

            actualValue = dollars.convert(cad);
        }

        if(command.equals(COMMAND_SELECT_JAP)){

            Currency dollars = new Dollar(dollarValue);
            Currency jap = new JapaneseYen(japValue);

            actualValue = dollars.convert(jap);
        }

        if(command.equals(COMMAND_SELECT_CHF)){

            Currency dollars = new Dollar(dollarValue);
            Currency chf = new SwissFranc(chfValue);

            actualValue = dollars.convert(chf);
        }
        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertCadToFiat() {

        cadValue = Terminal.inputNumber("Въведете сума");

        System.out.println("Изберете валута, в която искате да конвертирате");
        System.out.println("1. USD");
        System.out.println("2. JAP");
        System.out.println("3. CHF");

        command = Terminal.inputString();

        if(command.equals(COMMAND_SELECT_USD)) {

            Currency cad = new CanadianDollar(cadValue);
            Currency dollars = new Dollar(dollarValue);

            actualValue = cad.convert(dollars);
        }

        if(command.equals(COMMAND_SELECT_JAP)) {

            Currency cad = new CanadianDollar(cadValue);
            Currency jap = new JapaneseYen(japValue);

            actualValue = cad.convert(jap);
        }

        if(command.equals(COMMAND_SELECT_CHF)) {

            Currency cad = new CanadianDollar(cadValue);
            Currency chf = new SwissFranc(chfValue);

            actualValue = cad.convert(chf);
        }
        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertJapToFiat() {

        japValue = Terminal.inputNumber("Въведете сума");

        System.out.println("Изберете валута, в която искате да конвертирате");
        System.out.println("1. USD");
        System.out.println("2. CAD");
        System.out.println("3. CHF");

        command = Terminal.inputString();

        if (command.equals(COMMAND_SELECT_USD)) {

            Currency jap = new JapaneseYen(japValue);
            Currency dollars = new Dollar(dollarValue);

            actualValue = jap.convert(dollars);
        }

        if (command.equals(COMMAND_SELECT_CAD)) {

            Currency jap = new JapaneseYen(japValue);
            Currency cad = new CanadianDollar(cadValue);

            actualValue = jap.convert(cad);
        }

        if (command.equals(COMMAND_SELECT_CHF)) {

            Currency jap = new JapaneseYen(japValue);
            Currency chf = new SwissFranc(chfValue);

            actualValue = jap.convert(chf);
        }
        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertChfToFiat() {
        
        chfValue = Terminal.inputNumber("Въведете сума");

        System.out.println("Изберете валута, в която искате да конвертирате");
        System.out.println("1. USD");
        System.out.println("2. CAD");
        System.out.println("3. JAP");

        command = Terminal.inputString();

        if (command.equals(COMMAND_SELECT_USD)) {

            Currency chf = new SwissFranc(chfValue);
            Currency dollars = new Dollar(dollarValue);

            actualValue = chf.convert(dollars);
        }

        if (command.equals(COMMAND_SELECT_CAD)) {

            Currency chf = new SwissFranc(chfValue);
            Currency cad = new CanadianDollar(cadValue);

            actualValue = chf.convert(cad);
        }

        if (command.equals(COMMAND_SELECT_JAP)) {

            Currency chf = new SwissFranc(chfValue);
            Currency jap = new JapaneseYen(japValue);

            actualValue = chf.convert(jap);
        }
        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }
}