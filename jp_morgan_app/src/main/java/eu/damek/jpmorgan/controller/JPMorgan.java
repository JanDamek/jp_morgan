package eu.damek.jpmorgan.controller;

import eu.damek.jpmorgan.domain.*;
import eu.damek.jpmorgan.service.MarketService;
import eu.damek.jpmorgan.util.InstructionGenerator;
import eu.damek.jpmorgan.util.Utils;

import java.util.Date;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class JPMorgan {

    /**
     * point for {@link MarketService} tu run mail bossiness logic
     */
    private MarketService marketService;
    /**
     * state of quit or run application
     */
    private boolean runApplication;

    /**
     * construcotr for main class
     */
    public JPMorgan() {
        marketService = new MarketService();
        initData();
        Utils.printLn("JP Morgan Test");
    }

    /**
     * initialization of all data for run appliaction
     */
    private void initData() {
        runApplication = true;
    }

    /**
     * run of appliation, main loop
     */
    public void run() {
        processMessagesOfInstructions();
        makeDailyReport();

        Utils.printLn("");
        do {
            printChoiceInfo();
            char choice = Utils.readKeybordChar();
            processUserChoice(choice);
        } while (runApplication);
    }

    /**
     * make all instructiones to sell or buy on market
     */
    private void processMessagesOfInstructions() {
        for (Instruction instruction : new InstructionGenerator().getInstrunctions()) {
            marketService.makeTrade(instruction);
        }
    }

    /**
     * chois the next step on appliation
     *
     * @param choice Chat inputet by terminal
     */
    private void processUserChoice(char choice) {
        switch (choice) {
            case '0':
                runApplication = false;
                break;
            case '1':
                readUserInstruction();
                break;
            case '2':
                makeDailyReport();
                break;
            default:
                Utils.printLn(String.format("'%s' is invalid input.", (char) choice));
        }
    }

    /**
     * create new instruction inputed from terminal and run it on {@link MarketService}
     */
    private void readUserInstruction() {
        try {
            Utils.print("Entity:");
            String entity = Utils.readLine();

            String buySell;
            do {
                Utils.print("B/S (Buy/Sell):");
                buySell = Utils.readLine();
                if (buySell.length() > 1) {
                    buySell = buySell.substring(0, 1);
                }
            } while (!(buySell.equalsIgnoreCase("B") ||
                       buySell.equalsIgnoreCase("S")) &&
                     (buySell != ""));

            Utils.print("AgreedFx:");
            double agreedFx = Utils.readLineDouble();

            Utils.print("Currency (SGP/AED/...):");
            String currency = Utils.readLine();

            Utils.print("InstructionDate (YYYY.MM.DD):");
            Date instructionDate = Utils.readLineDate();

            Utils.print("SettlementDate (YYYY.MM.DD):");
            Date settlementDate = Utils.readLineDate();

            Utils.print("Units:");
            int units = Utils.readLineInteger();

            Utils.print("Price per unit:");
            double pricePerUnit = Utils.readLineDouble();

            marketService.makeTrade(new InstructionBuilder().setEntity(entity)
                    .setBuySell(buySell.charAt(0))
                    .setAgreedFx(agreedFx)
                    .setCurrency(currency)
                    .setInstructionDate(instructionDate)
                    .setSettlementDate(settlementDate)
                    .setUnits(units)
                    .setPricePerUnit(pricePerUnit)
                    .createInstruction());
        } catch (Exception e) {
            Utils.printLn("Error on input: " + e.getMessage());
        }
    }

    /**
     * print on console the report
     */
    private void makeDailyReport() {
        Utils.printLn("USD settled incoming.");
        Utils.printLn("Date             incoming amount");
        for (SettledIncoming item : marketService.getSettledIncoming()) {
            Utils.printLn(String.format("%3ta %4tY.%2tm.%2td     %10.2f", item.getDate(), item.getDate(), item
                            .getDate(),
                    item.getDate(),
                    item.getIncoming()));
        }
        Utils.printLn("");
        Utils.printLn("USD settled outgoing.");
        Utils.printLn("Date             incoming amount");
        for (SettledOutgoing item : marketService.getSettledOutgoing()) {
            Utils.printLn(String.format("%3ta %2tY.%2tm.%2td     %10.2f", item.getDate(), item.getDate(), item
                            .getDate(),
                    item.getDate(),
                    item.getOutcome()));
        }
        Utils.printLn("");
        Utils.printLn("Ranking of entities.");
        Utils.printLn("Entity          incoming      outcoming   ranking");
        for (Ranking item : marketService.getEntitiesRanking()) {
            Utils.printLn(String.format("%-10s    %10.2f     %10.2f     %1d", item.getEntity(), item.getIncoming(), item
                    .getOutgoing(), item.ranking()));
        }
        Utils.printLn("");
        Utils.printLn(" - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * -");
        Utils.printLn("");
    }

    /**
     * print the menu for choice
     */
    private void printChoiceInfo() {
        Utils.printLn("1 - input instruction");
        Utils.printLn("2 - print daily report");
        Utils.printLn("0 - quit");
    }
}
