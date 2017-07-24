package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.SettledIncoming;
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
public class IncomingServiceTest {

    private IncomingService incomingService;

    @Before
    public void setUp() throws Exception {
        incomingService = new IncomingService();
    }

    @Test
    public void addAmount() throws Exception {
        incomingService.addAmount(new Date(2016, 1, 5), 1000);
        incomingService.addAmount(new Date(2016, 1, 5), 1000);
        incomingService.addAmount(new Date(2016, 1, 5), 1000);
        incomingService.addAmount(new Date(2016, 1, 5), 1000);
        incomingService.addAmount(new Date(2016, 1, 5), 1000);
        final List<SettledIncoming> incoms = incomingService.getSettledIncoming();
        assertEquals(incoms.size(), 1);
        assertEquals(incoms.get(0).getIncoming(), 5000,0.001);

        incomingService.addAmount(new Date(2016, 1, 6), 1000);
        incomingService.addAmount(new Date(2016, 1, 7), 1000);
        incomingService.addAmount(new Date(2016, 1, 8), 1000);
        incomingService.addAmount(new Date(2016, 1, 9), 1000);
        incomingService.addAmount(new Date(2016, 1, 10), 1000);
        final List<SettledIncoming> incoms1 = incomingService.getSettledIncoming();
        assertEquals(incoms1.size(), 6);
        assertEquals(incoms1.get(1).getIncoming(), 1000,0.001);
        assertEquals(incoms1.get(2).getIncoming(), 1000,0.001);
        assertEquals(incoms1.get(3).getIncoming(), 1000,0.001);
        assertEquals(incoms1.get(4).getIncoming(), 1000,0.001);
        assertEquals(incoms1.get(5).getIncoming(), 1000,0.001);
    }

}
