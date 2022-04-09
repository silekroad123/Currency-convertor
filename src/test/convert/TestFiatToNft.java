package test.convert;

import abstractentities.Currency;
import currencies.*;
import utility.Terminal;

public class TestFiatToNft {

    public static double dollarValue;
    public static double cadValue;
    public static double japValue;
    public static double chfValue;
    public static double nftValue;
    public static double actualValue;

    public static String command;

    private static final String COMMAND_SELECT_USD    = "USD";
    private static final String COMMAND_SELECT_CAD    = "CAD";
    private static final String COMMAND_SELECT_JAP    = "JAP";


    public static void initDialog() {

        System.out.println();
        System.out.println("Валута в NFT");
        System.out.println("Изберете валута, която ще изпращате");
        System.out.println("1. USD");
        System.out.println("2. CAD");
        System.out.println("3. JAP");
        System.out.println("4. CHF");

        command = Terminal.inputString();

        switch (command) {
            case COMMAND_SELECT_USD -> convertUsdToNft();
            case COMMAND_SELECT_CAD -> convertCadToNft();
            case COMMAND_SELECT_JAP -> convertJapToNft();
            default -> convertChfToNft();
        }

    }

    public static void convertUsdToNft(){

        dollarValue = Terminal.inputNumber("Въведете сума");

        Currency dollars = new Dollar(dollarValue);
        Currency nft = new Nft(Terminal.inputString("Въведете наименование и стойност на NFT"), nftValue);

        actualValue = dollars.convert(nft);

        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertCadToNft() {

        cadValue = Terminal.inputNumber("Въведете сума:");

        Currency cad = new CanadianDollar(cadValue);
        Currency nft = new Nft(Terminal.inputString("Въведете наименование и стойност на NFT"), nftValue);

        actualValue = cad.convert(nft);

        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertJapToNft() {

        japValue = Terminal.inputNumber("Въведете сума");

        Currency jap = new JapaneseYen(japValue);
        Currency nft = new Nft(Terminal.inputString("Въведете наименование и стойност на NFT"), nftValue);

        actualValue = jap.convert(nft);

        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }

    public static void convertChfToNft() {

        chfValue = Terminal.inputNumber("Въведете сума");

        Currency chf = new SwissFranc(chfValue);
        Currency nft = new Nft(Terminal.inputString("Въведете наименование и стойност на NFT"), nftValue);

        actualValue = chf.convert(nft);

        System.out.printf("%.2f" + " " + Currency.getSymbol() + "\n", actualValue);
    }
}
