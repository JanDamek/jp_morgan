package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.SettledOutgoing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class OutgoingService {

    private final List<SettledOutgoing> settledOutgoings;

    public OutgoingService() {
        settledOutgoings = new ArrayList<>();
    }

    public List<SettledOutgoing> getSettledOutgoings() {
        return settledOutgoings;
    }

    public void addAmount(Date tradeDate, double amount) {
        SettledOutgoing outgoing = getOutgoing(tradeDate);
        outgoing.setOutcome(outgoing.getOutcome() + amount);
    }

    private SettledOutgoing getOutgoing(Date tradeDate) {
        final SettledOutgoing outgoing =
                settledOutgoings.stream().filter(o -> filterOutcomeByDate(o, tradeDate)).findFirst().orElse(new
                        SettledOutgoing(tradeDate));
        if (!settledOutgoings.contains(outgoing)){
            settledOutgoings.add(outgoing);
        }
        return outgoing;
    }

    private boolean filterOutcomeByDate(SettledOutgoing o, Date tradeDate) {
        return o.getDate().equals(tradeDate);
    }
}
