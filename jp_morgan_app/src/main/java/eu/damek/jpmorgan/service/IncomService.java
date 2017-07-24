package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.SettledIncoming;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project: jp_morgan
 * For: Service class of count and store incoming trades
 * Created by damekjan on 24/07/2017.
 */
public class IncomService {

    /**
     * list of all incoming trades
     */
    private final List<SettledIncoming> settledIncomings;

    /**
     * constructor
     */
    public IncomService() {
        settledIncomings = new ArrayList<>();
    }

    /**
     * getter of list of all incoming trades
     *
     * @return List of {@link SettledIncoming}
     */
    public List<SettledIncoming> getSettledIncomings() {
        return settledIncomings;
    }

    /**
     * Add to summ for trade date the amount of trade in USD
     *
     * @param tradeDate Date
     * @param amount    Double
     */
    public void addAmount(Date tradeDate, double amount) {
        SettledIncoming incom = getIncom(tradeDate);
        incom.setIncoming(incom.getIncoming() + amount);
    }

    /**
     * getter from list a {@link SettledIncoming} for given trade date. If not exist create it and store on list of
     * incoming trades
     *
     * @param tradeDate Date
     * @return object of {@link SettledIncoming}
     */
    private SettledIncoming getIncom(Date tradeDate) {
        final SettledIncoming incom =
                settledIncomings.stream()
                        .filter(i -> filterIncomByDate(i, tradeDate))
                        .findFirst()
                        .orElse(new SettledIncoming
                                (tradeDate));
        if (!settledIncomings.contains(incom)) {
            settledIncomings.add(incom);
        }
        return incom;
    }

    /**
     * method for filter on stream. Find the equal date on {@link SettledIncoming}
     *
     * @param incom     object for test {@link SettledIncoming}
     * @param tradeDate date for find
     * @return true if is equal
     */
    private boolean filterIncomByDate(SettledIncoming incom, Date tradeDate) {
        return incom.getDate().equals(tradeDate);
    }
}
