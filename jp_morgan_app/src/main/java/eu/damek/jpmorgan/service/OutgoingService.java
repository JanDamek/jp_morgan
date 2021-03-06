package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.SettledOutgoing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Project: jp_morgan
 * For: Service for count of outgoing trades on market. It's package private because is used only for {@link MarketService}
 * Created by damekjan on 24/07/2017.
 */
class OutgoingService {

    /**
     * list of all outgoing trades
     */
    private final List<SettledOutgoing> outgoings;

    /**
     * constructor
     */
    OutgoingService() {
        outgoings = new ArrayList<>();
    }

    /**
     * getter of {@link OutgoingService} list
     *
     * @return List of {@link OutgoingService}
     */
    List<SettledOutgoing> getOutgoings() {
        return outgoings;
    }

    /**
     * add to sum of outgoing by trade date
     *
     * @param tradeDate date of trade
     * @param amount    calculated amount in USD of trade
     */
    void addAmount(Date tradeDate, double amount) {
        AtomicReference<SettledOutgoing> atomicReference = new AtomicReference<>(getOutgoing(tradeDate));
        atomicReference.get().setOutcome(atomicReference.get().getOutcome() + amount);
    }

    /**
     * getter of outgoing trades by trade date. If not exist is created and stored on list
     *
     * @param tradeDate date of trade
     * @return object of {@link SettledOutgoing} for trade date
     */
    private SettledOutgoing getOutgoing(Date tradeDate) {
        final AtomicReference<SettledOutgoing> atomicReference =
                new AtomicReference<>(
                        outgoings.stream().filter(o -> filterOutcomeByDate(o, tradeDate)).findFirst().orElse(new
                                SettledOutgoing(tradeDate)));
        if (!outgoings.contains(atomicReference.get())) {
            outgoings.add(atomicReference.get());
        }
        return atomicReference.get();
    }

    /**
     * filter method for find correct {@link OutgoingService} by date
     *
     * @param o         object of {@link SettledOutgoing}
     * @param tradeDate date of trade
     * @return tru if is equal
     */
    private boolean filterOutcomeByDate(SettledOutgoing o, Date tradeDate) {
        return o.getDate().equals(tradeDate);
    }
}
