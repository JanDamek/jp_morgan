package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.Ranking;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class RankingServiceTest {

    private RankingService rankingService;

    @Before
    public void setUp() {
        rankingService = new RankingService();
    }

    @Test
    public void getRankings() throws Exception {
        List<Ranking> rankings = rankingService.getRankings();
        Assert.assertEquals(rankings.size(), 0);
    }

    @Test
    public void addOutcome() throws Exception {
        rankingService.addOutcome("foo", 100);
        List<Ranking> rankings = rankingService.getRankings();
        Assert.assertEquals(rankings.size(), 1);
        Assert.assertEquals(rankings.get(0).getOutgoing(), 100, 0.001);

        rankingService.addOutcome("foo", 100);
        rankings = rankingService.getRankings();
        Assert.assertEquals(rankings.size(), 1);
        Assert.assertEquals(rankings.get(0).getOutgoing(), 200, 0.001);

        rankingService.addOutcome("bar", 100);
        rankings = rankingService.getRankings();
        Assert.assertEquals(rankings.size(), 2);
        Assert.assertEquals(rankings.get(0).getOutgoing(), 200, 0.001);
        Assert.assertEquals(rankings.get(1).getOutgoing(), 100, 0.001);
    }

    @Test
    public void addIncoming() throws Exception {
        rankingService.addIncoming("foo", 100);
        List<Ranking> rankings = rankingService.getRankings();
        Assert.assertEquals(rankings.size(), 1);
        Assert.assertEquals(rankings.get(0).getIncoming(), 100, 0.001);

        rankingService.addIncoming("foo", 100);
        rankings = rankingService.getRankings();
        Assert.assertEquals(rankings.size(), 1);
        Assert.assertEquals(rankings.get(0).getIncoming(), 200, 0.001);

        rankingService.addIncoming("bar", 100);
        rankings = rankingService.getRankings();
        Assert.assertEquals(rankings.size(), 2);
        Assert.assertEquals(rankings.get(0).getIncoming(), 200, 0.001);
        Assert.assertEquals(rankings.get(1).getIncoming(), 100, 0.001);
    }

}