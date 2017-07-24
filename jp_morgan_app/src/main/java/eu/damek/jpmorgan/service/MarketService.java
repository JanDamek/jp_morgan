package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.Instruction;
import eu.damek.jpmorgan.domain.Ranking;
import eu.damek.jpmorgan.domain.SettledIncoming;
import eu.damek.jpmorgan.domain.SettledOutgoing;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class MarketService {

    /**
     * store on {@link RankingService}
     */
    private RankingService rankingService;
    /**
     * store on {@link IncomingService}
     */
    private IncomingService incomingService;
    /**
     * store of {@link OutgoingService}
     */
    private OutgoingService outgoingService;

    /**
     * constructor
     */
    public MarketService() {
        rankingService = new RankingService();
        incomingService = new IncomingService();
        outgoingService = new OutgoingService();
    }

    /**
     * make the trade based on {@link Instruction}
     *
     * @param instruction input object to market
     */
    public void makeTrade(Instruction instruction) {
        final Date tradeDate = getNearestWorkingDate(instruction.getSettlementDate(), instruction.getCurrency());
        double amount = calcAmountUsd(instruction);
        if (instruction.getBuySell() == 'B') {
            outgoingService.addAmount(tradeDate, amount);
            rankingService.addOutcome(instruction.getEntity(), amount);
        } else {
            incomingService.addAmount(tradeDate, amount);
            rankingService.addIncoming(instruction.getEntity(), amount);
        }
    }

    /**
     * calc the amount of USD of trade
     *
     * @param instruction inpuit {@link Instruction}
     * @return Double as result of calc
     */
    private double calcAmountUsd(Instruction instruction) {
        return instruction.getPricePerUnit() * instruction.getUnits() * instruction.getAgreedFx();
    }

    /**
     * get the nearest working day of settlement date. The date is based on currency.
     *
     * @param settlementDate date of settlement
     * @param currency       on with currenct is the trade
     * @return date of working date
     */
    private Date getNearestWorkingDate(Date settlementDate, String currency) {
        final Calendar calendar = Calendar.getInstance();
        final boolean currencyShift = currencyShift(currency);

        calendar.setTime(settlementDate);
        final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SUNDAY || (currencyShift && dayOfWeek == Calendar.SATURDAY)) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        } else if (dayOfWeek == Calendar.SATURDAY || (currencyShift && dayOfWeek == Calendar.FRIDAY)) {
            calendar.add(Calendar.DAY_OF_MONTH, 2);
        }
        return calendar.getTime();
    }

    /**
     * test if the market based by currency is shifted
     *
     * @param currency String of currency
     * @return boolean
     */
    private boolean currencyShift(String currency) {
        return currency.equalsIgnoreCase("AED") ||
               currency.equalsIgnoreCase("SAR");
    }

    /**
     * getter for {@link SettledIncoming}
     *
     * @return list of {@link SettledIncoming}
     */
    public List<SettledIncoming> getSettledIncoming() {
        return incomingService.getSettledIncoming();
    }

    /**
     * getter of ranging by entity
     *
     * @return list of {@link Ranking}
     */
    public List<Ranking> getEntitiesRanking() {
        return rankingService.getRankings();
    }

    /**
     * getter of {@link SettledOutgoing}
     *
     * @return list of {@link SettledOutgoing}
     */
    public List<SettledOutgoing> getSettledOutgoing() {
        return outgoingService.getOutgoings();
    }
}
