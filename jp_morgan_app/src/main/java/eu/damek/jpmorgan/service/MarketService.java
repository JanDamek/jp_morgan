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

    private RankingService rankingService;
    private IncomService incomService;
    private OutgoingService outgoingService;

    public MarketService() {
        rankingService = new RankingService();
        incomService = new IncomService();
        outgoingService = new OutgoingService();
    }

    public void makeTrade(Instruction instruction) {
        final Date tradeDate = getNearestWorkingDate(instruction.getSettlementDate(), instruction.getCurrency());
        double amount = calcAmountUsd(instruction);
        if (instruction.getBuySell() == 'B') {
            outgoingService.addAmount(tradeDate, amount);
            rankingService.addOutcome(instruction.getEntity(), amount);
        } else {
            incomService.addAmount(tradeDate, amount);
            rankingService.addIncoming(instruction.getEntity(), amount);
        }
    }

    private double calcAmountUsd(Instruction instruction) {
        return instruction.getPriceOerUnit() * instruction.getUnits() * instruction.getAgreedFx();
    }

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

    private boolean currencyShift(String currency) {
        return currency.equalsIgnoreCase("AED") ||
               currency.equalsIgnoreCase("SAR");
    }

    public List<SettledIncoming> settledIncoming() {
        return incomService.getSettledIncomings();
    }

    public List<Ranking> entitiesRanking() {
        return rankingService.getRankings();
    }

    public List<SettledOutgoing> settledOutgoing() {
        return outgoingService.getSettledOutgoings();
    }
}
