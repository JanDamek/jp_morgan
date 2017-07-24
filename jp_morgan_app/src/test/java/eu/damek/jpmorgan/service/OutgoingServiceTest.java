package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.SettledOutgoing;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class OutgoingServiceTest {

    private OutgoingService outgoingService;

    @Before
    public void setUp() {
        outgoingService = new OutgoingService();
    }

    @Test
    public void addAmount() {
        outgoingService.addAmount(new Date(2016, 1, 5), 1000);
        outgoingService.addAmount(new Date(2016, 1, 5), 1000);
        outgoingService.addAmount(new Date(2016, 1, 5), 1000);
        outgoingService.addAmount(new Date(2016, 1, 5), 1000);
        outgoingService.addAmount(new Date(2016, 1, 5), 1000);
        final List<SettledOutgoing> incoms = outgoingService.getOutgoings();
        assertEquals(incoms.size(), 1);
        assertEquals(incoms.get(0).getOutcome(), 5000, 0.001);

        outgoingService.addAmount(new Date(2016, 1, 6), 1000);
        outgoingService.addAmount(new Date(2016, 1, 7), 1000);
        outgoingService.addAmount(new Date(2016, 1, 8), 1000);
        outgoingService.addAmount(new Date(2016, 1, 9), 1000);
        outgoingService.addAmount(new Date(2016, 1, 10), 1000);
        final List<SettledOutgoing> incoms1 = outgoingService.getOutgoings();
        assertEquals(incoms1.size(), 6);
        assertEquals(incoms1.get(1).getOutcome(), 1000, 0.001);
        assertEquals(incoms1.get(2).getOutcome(), 1000, 0.001);
        assertEquals(incoms1.get(3).getOutcome(), 1000, 0.001);
        assertEquals(incoms1.get(4).getOutcome(), 1000, 0.001);
        assertEquals(incoms1.get(5).getOutcome(), 1000, 0.001);
    }

}