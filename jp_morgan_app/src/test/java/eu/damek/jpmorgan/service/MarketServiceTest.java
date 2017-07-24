package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class MarketServiceTest {

    private MarketService marketService;

    @Before
    public void setUp() {
        marketService = new MarketService();
    }

    @Test
    public void makeTradeShiftToMonday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 0, 1, 0, 0, 0);
        Date instructionDate = calendar.getTime();
        calendar.set(2016, 0, 2, 0, 0, 0);
        Date settlementDate = calendar.getTime();
        calendar.set(2016, 0, 4, 0, 0, 0);
        Date nextForkingDay = calendar.getTime();

        Instruction instruction = new InstructionBuilder()
                .setEntity("foo")
                .setBuySell('B')
                .setAgreedFx(0.5)
                .setCurrency("SGP")
                .setInstructionDate(instructionDate)
                .setSettlementDate(settlementDate)
                .setUnits(200)
                .setPricePerUnit(100.25)
                .createInstruction();

        marketService.makeTrade(instruction);
        List<Ranking> rankings = marketService.getEntitiesRanking();
        List<SettledIncoming> settledIncomings = marketService.getSettledIncoming();
        List<SettledOutgoing> settledOutgoings = marketService.getSettledOutgoing();

        assertEquals(settledIncomings.size(), 0);

        assertEquals(rankings.size(), 1);
        assertEquals(rankings.get(0).ranking(), 1, 0.000001);

        assertEquals(settledOutgoings.size(), 1);
        assertEquals(settledOutgoings.get(0).getDate(), nextForkingDay);
        assertEquals(settledOutgoings.get(0).getOutcome(), 100.25 * 200 * 0.5, 0.001);
    }

    @Test
    public void makeTradeWorkOnSunday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 0, 5, 0, 0, 0);
        Date instructionDate = calendar.getTime();
        calendar.set(2016, 0, 7, 0, 0, 0);
        Date settlementDate = calendar.getTime();
        calendar.set(2016, 0, 7, 0, 0, 0);
        Date nextForkingDay = calendar.getTime();

        Instruction instruction = new InstructionBuilder()
                .setEntity("bar")
                .setBuySell('S')
                .setAgreedFx(0.22)
                .setCurrency("AED")
                .setInstructionDate(instructionDate)
                .setSettlementDate(settlementDate)
                .setUnits(450)
                .setPricePerUnit(150.5)
                .createInstruction();

        marketService.makeTrade(instruction);
        List<Ranking> rankings = marketService.getEntitiesRanking();
        List<SettledIncoming> settledIncomings = marketService.getSettledIncoming();
        List<SettledOutgoing> settledOutgoings = marketService.getSettledOutgoing();

        assertEquals(settledOutgoings.size(), 0);

        assertEquals(rankings.size(), 1);
        assertEquals(rankings.get(0).ranking(), 0, 0.000001);

        assertEquals(settledIncomings.size(), 1);
        assertEquals(settledIncomings.get(0).getDate(), nextForkingDay);
        assertEquals(settledIncomings.get(0).getIncoming(), 150.5 * 450 * 0.22, 0.001);
    }

}