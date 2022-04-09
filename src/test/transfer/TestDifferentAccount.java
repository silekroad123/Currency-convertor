package test.transfer;

import abstractentities.Currency;
import abstractentities.Wallet;
import abstractentities.Wallet2;
import currencies.CanadianDollar;
import currencies.Dollar;
import currencies.Gold;
import currencies.Nft;
import utility.Terminal;

public class TestDifferentAccount {

    public static double dollarValue;
    public static double cadValue;
    public static double goldValue;
    public static double nftValue;
    public static double actualValue;

    public static double fee;
    public static double total;

    public static String command;
    public static double inputNumber;

    private static final String COMMAND_SELECT_USD  = "USD";
    private static final String COMMAND_SELECT_CAD  = "CAD";
    private static final String COMMAND_SELECT_GOLD = "GLD";
    private static final String COMMAND_SELECT_NFT  = "NFT";


    public static void initDialog() {

        System.out.println();
        System.out.println("Тест за трансфер между различни портфейли");
        System.out.println("Изберете портфейл, към който да бъдат изпратени пари");
        System.out.println("1. BG26STSA93005897165741");
        System.out.println("2. BG82IORT80944919959824");
        System.out.println("3. BG67RZBB91551583234321");

        inputNumber = Terminal.inputNumber();

        System.out.println("Изберете валутата, която ще изпращате");
        System.out.println("1. USD");
        System.out.println("2. GLD");

        command = Terminal.inputString();

        if(command.equals(COMMAND_SELECT_USD)){
            transferCurrencyUsd();
        }

        if(command.equals(COMMAND_SELECT_GOLD)){
            transferCurrencyGold();
        }
    }

    public static void transferCurrencyUsd() {

        dollarValue = Terminal.inputNumber("Въведете сума");

        System.out.println("Изберете валута, в която искате да конвертирате");
        System.out.println("1. CAD");
        System.out.println("2. NFT");

        command = Terminal.inputString();

        if (command.equals(COMMAND_SELECT_CAD)) {

            Currency dollars = new Dollar(dollarValue);
            Currency cad = new CanadianDollar(cadValue);

            Wallet wallet = new Wallet(3000);
            Wallet2 wallet2 = new Wallet2(5000);

            wallet.addCurrency(dollars);
            wallet2.addCurrency2(cad);

            actualValue = dollars.convert(cad);
            fee = actualValue * 0.03;
            total = actualValue + fee;

            if (total >= Wallet.totalMoney) {
                System.out.println("Недостатъчна наличност!");
                System.exit(0);
            }

            Wallet.totalMoney -= total;
            Wallet2.totalMoney2 += actualValue;

        }

        if (command.equals(COMMAND_SELECT_NFT)) {

            Currency dollar = new Dollar(dollarValue);
            Currency nft = new Nft(Terminal.inputString("Въведете наименование и стойност на NFT"), nftValue);

            Wallet wallet = new Wallet(2500);
            Wallet2 wallet2 = new Wallet2(3000);

            wallet.addCurrency(dollar);
            wallet2.addCurrency2(nft);

            actualValue = dollar.convert(nft);
            fee = actualValue * 0.03;
            total = actualValue + fee;

            if (total >= Wallet.totalMoney) {
                System.out.println("Недостатъчна наличност!");
                System.exit(0);
            }

            Wallet.totalMoney -= total;
            Wallet2.totalMoney2 += actualValue;

        }
        System.out.printf("Наличност на Портфейл 1 след транзакцията: %.2f" + " " +
                Currency.getSymbol() + "\n", Wallet.totalMoney);
        System.out.printf("Наличност на Портфейл 2 след транзакцията: %.2f" + " " +
                Currency.getSymbol() + "\n", Wallet2.totalMoney2);
    }


    public static void transferCurrencyGold() {

        goldValue = Terminal.inputNumber("Въведете сума");

        System.out.println("Изберете валута, в която искате да конвертирате");
        System.out.println("1. CAD");
        System.out.println("2. NFT");

        command = Terminal.inputString();

        if (command.equals(COMMAND_SELECT_CAD)) {

            Currency gold = new Gold(goldValue);
            Currency cad = new CanadianDollar(cadValue);

            Wallet wallet = new Wallet(3000);
            Wallet2 wallet2 = new Wallet2(5000);

            wallet.addCurrency(gold);
            wallet2.addCurrency2(cad);

            actualValue = gold.convert(cad);
            fee = actualValue * 0.03;
            total = actualValue + fee;

            if (total >= Wallet.totalMoney) {
                System.out.println("Недостатъчна наличност!");
                System.exit(0);
            }

            Wallet.totalMoney -= total;
            Wallet2.totalMoney2 += actualValue;

        }

        if (command.equals(COMMAND_SELECT_NFT)) {

            Currency gold = new Gold(goldValue);
            Currency nft = new Nft(Terminal.inputString("Въведете наименование и стойност на NFT"), nftValue);

            Wallet wallet = new Wallet(2500);
            Wallet2 wallet2 = new Wallet2(3000);

            wallet.addCurrency(gold);
            wallet2.addCurrency2(nft);

            actualValue = gold.convert(nft);
            fee = actualValue * 0.03;
            total = actualValue + fee;

            if (total >= Wallet.totalMoney) {
                System.out.println("Недостатъчна наличност!");
                System.exit(0);
            }

            Wallet.totalMoney -= total;
            Wallet2.totalMoney2 += actualValue;

        }
        System.out.printf("Наличност на Портфейл 1 след транзакцията: %.2f" + " " +
                Currency.getSymbol() + "\n", Wallet.totalMoney);
        System.out.printf("Наличност на Портфейл 2 след транзакцията: %.2f" + " " +
                Currency.getSymbol() + "\n", Wallet2.totalMoney2);
    }
}
