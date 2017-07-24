package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.SettledIncoming;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Project: jp_morgan
 * For: Service class of count and store incoming trades. It's package private. It's dedicated to use only with {@link MarketService}
 * Created by damekjan on 24/07/2017.
 */
class IncomingService {

    /**
     * list of all incoming trades
     */
    private final List<SettledIncoming> incoming;

    /**
     * constructor
     */
    IncomingService() {
        incoming = new ArrayList<>();
    }

    /**
     * getter of list of all incoming trades
     *
     * @return List of {@link SettledIncoming}
     */
    List<SettledIncoming> getSettledIncoming() {
        return incoming;
    }

    /**
     * Add to summary for trade date the amount of trade in USD
     *
     * @param tradeDate Date
     * @param amount    Double
     */
    void addAmount(Date tradeDate, double amount) {
        AtomicReference<SettledIncoming> incoming = new AtomicReference<>(getIncoming(tradeDate));
        incoming.get().setIncoming(incoming.get().getIncoming() + amount);
    }

    /**
     * getter from list a {@link SettledIncoming} for given trade date. If not exist create it and store on list of
     * incoming trades
     *
     * @param tradeDate Date
     * @return object of {@link SettledIncoming}
     */
    private SettledIncoming getIncoming(Date tradeDate) {
        final AtomicReference<SettledIncoming> incoming = new AtomicReference<>(this.incoming.stream()
                .filter(i -> filterIncomingByDate(i, tradeDate))
                .findFirst()
                .orElse(new SettledIncoming
                        (tradeDate)));
        if (!this.incoming.contains(incoming.get())) {
            this.incoming.add(incoming.get());
        }
        return incoming.get();
    }

    /**
     * method for filter on stream. Find the equal date on {@link SettledIncoming}
     *
     * @param incoming  object for test {@link SettledIncoming}
     * @param tradeDate date for find
     * @return true if is equal
     */
    private boolean filterIncomingByDate(SettledIncoming incoming, Date tradeDate) {
        return incoming.getDate().equals(tradeDate);
    }
}
