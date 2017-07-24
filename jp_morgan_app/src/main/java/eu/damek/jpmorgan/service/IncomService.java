package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.SettledIncoming;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class IncomService {

    private final List<SettledIncoming> settledIncomings;

    public IncomService() {
        settledIncomings = new ArrayList<>();
    }

    public List<SettledIncoming> getSettledIncomings() {
        return settledIncomings;
    }

    public void addAmount(Date tradeDate, double amount) {
        SettledIncoming incom = getIncom(tradeDate);
        incom.setIncoming(incom.getIncoming() + amount);
    }

    private SettledIncoming getIncom(Date tradeDate) {
        final SettledIncoming incom =
                settledIncomings.stream().filter(i -> filterIncomByDate(i, tradeDate)).findFirst().orElse(new SettledIncoming
                        (tradeDate));
        if (!settledIncomings.contains(incom)) {
            settledIncomings.add(incom);
        }
        return incom;
    }

    private boolean filterIncomByDate(SettledIncoming incom, Date tradeDate) {
        return incom.getDate().equals(tradeDate);
    }
}
