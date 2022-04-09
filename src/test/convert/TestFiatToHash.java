package test.convert;

import abstractentities.Currency;
import currencies.*;
import utility.Terminal;

public class TestFiatToHash {

    public static double dollarValue;
    public static double cadValue;
    public static double japValue;
    public static double chfValue;
    public static double btcValue;
    public static double ssbValue;
    public static double rtaValue;
    public static double qaqValue;
    public static double actualValue;

    public static String command;

    private static final String COMMAND_SELECT_USD = "USD";
    private static final String COMMAND_SELECT_CAD = "CAD";
    private static final String COMMAND_SELECT_JAP = "JAP";

    private static final String COMMAND_SELECT_BTC = "BTC";
    private static final String COMMAND_SELECT_SSB = "SSB";
    private static final String COMMAND_SELECT_RTA = "RTA";
    private static final String COMMAND_SELECT_QAQ = "QAQ";


    public static void initDialog() {

        System.out.println();
        System.out.println("Валута в хеш");
        System.out.println("Изберете валута, която ще изпращате");
        System.out.println("1. USD");
        System.out.println("2. CAD");
        System.out.println("3. JAP");
        System.out.println("4. CHF");

        command = Terminal.inputString();

        switch (command) {
            case COMMAND_SELECT_USD -> convertUsdToHash();
            case COMMAND_SELECT_CAD -> convertCadToHash();
            case COMMAND_SELECT_JAP -> convertJapToHash();
            default -> convertChfToHash();
        }

    }

    public static void convertUsdToHash(){

        dollarValue = Terminal.inputNumber("Въведете сума");
        chooseCurrency();
        command = Terminal.inputString();

        if(command.equals(COMMAND_SELECT_BTC)){

            Currency dollars = new Dollar(dollarValue);
            Currency btc = new Bitcoin(btcValue);

            actualValue = dollars.convert(btc);
        }

        if(command.equals(COMMAND_SELECT_SSB)){

            Currency dollars = new Dollar(dollarValue);
            Currency ssb = new SbbCurrency(ssbValue);

            actualValue = dollars.convert(ssb);
        }

        if(command.equals(COMMAND_SELECT_RTA)){

            Currency dollars = new Dollar(dollarValue);
            Currency rta = new RtaCurrency(rtaValue);

            actualValue = dollars.convert(rta);
        }

        if(command.equals(COMMAND_SELECT_QAQ)){

            Currency dollars = new Dollar(dollarValue);
            Currency qaq = new QaqCurrency(qaqValue);

            actualValue = dollars.convert(qaq);
        }
        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertCadToHash(){

        cadValue = Terminal.inputNumber("Въведете сума");
        chooseCurrency();
        command = Terminal.inputString();

        if(command.equals(COMMAND_SELECT_BTC)){

            Currency cad = new CanadianDollar(cadValue);
            Currency btc = new Bitcoin(btcValue);

            actualValue = cad.convert(btc);
        }

        if(command.equals(COMMAND_SELECT_SSB)){

            Currency cad = new CanadianDollar(cadValue);
            Currency ssb = new SbbCurrency(ssbValue);

            actualValue = cad.convert(ssb);
        }

        if(command.equals(COMMAND_SELECT_RTA)){

            Currency cad = new CanadianDollar(cadValue);
            Currency rta = new RtaCurrency(rtaValue);

            actualValue = cad.convert(rta);
        }

        if(command.equals(COMMAND_SELECT_QAQ)){

            Currency cad = new CanadianDollar(cadValue);
            Currency qaq = new QaqCurrency(qaqValue);

            actualValue = cad.convert(qaq);
        }
        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertJapToHash(){

        japValue = Terminal.inputNumber("Въведете сума");
        chooseCurrency();
        command = Terminal.inputString();

        if(command.equals(COMMAND_SELECT_BTC)){

            Currency jap = new JapaneseYen(japValue);
            Currency btc = new Bitcoin(btcValue);

            actualValue = jap.convert(btc);
        }

        if(command.equals(COMMAND_SELECT_SSB)){

            Currency jap = new JapaneseYen(japValue);
            Currency ssb = new SbbCurrency(ssbValue);

            actualValue = jap.convert(ssb);
        }

        if(command.equals(COMMAND_SELECT_RTA)){

            Currency jap = new JapaneseYen(japValue);
            Currency rta = new RtaCurrency(rtaValue);

            actualValue = jap.convert(rta);
        }

        if(command.equals(COMMAND_SELECT_QAQ)){

            Currency jap = new JapaneseYen(japValue);
            Currency qaq = new QaqCurrency(qaqValue);

            actualValue = jap.convert(qaq);
        }
        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertChfToHash(){

        chfValue = Terminal.inputNumber("Въведете сума");
        chooseCurrency();
        command = Terminal.inputString();

        if(command.equals(COMMAND_SELECT_BTC)){

            Currency chf = new SwissFranc(chfValue);
            Currency btc = new Bitcoin(btcValue);

            actualValue = chf.convert(btc);
        }

        if(command.equals(COMMAND_SELECT_SSB)){

            Currency chf = new SwissFranc(chfValue);
            Currency ssb = new SbbCurrency(ssbValue);

            actualValue = chf.convert(ssb);
        }

        if(command.equals(COMMAND_SELECT_RTA)){

            Currency chf = new SwissFranc(chfValue);
            Currency rta = new RtaCurrency(rtaValue);

            actualValue = chf.convert(rta);
        }

        if(command.equals(COMMAND_SELECT_QAQ)){

            Currency chf = new SwissFranc(chfValue);
            Currency qaq = new QaqCurrency(qaqValue);

            actualValue = chf.convert(qaq);
        }
        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    private static void chooseCurrency(){
        System.out.println("Изберете валута, в която искате да конвертирате");
        System.out.println("1. BTC");
        System.out.println("2. SSB");
        System.out.println("3. RTA");
        System.out.println("4. QAQ");
    }
}
