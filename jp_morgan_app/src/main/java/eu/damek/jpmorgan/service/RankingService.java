package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.Ranking;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class RankingService {

    private final List<Ranking> rankings;

    public RankingService() {
        rankings = new ArrayList<>();

    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void addOutcome(String entity, double amount) {
        final Ranking ranking = getRanking(entity);
        ranking.setOutgoing(ranking.getOutgoing() + amount);
    }

    private Ranking getRanking(String entity) {
        final Ranking ranking =
                rankings.stream().filter(r -> rankingFilter(r, entity)).findFirst().orElse(new Ranking(entity));
        if (!rankings.contains(ranking)) {
            rankings.add(ranking);
        }
        return ranking;
    }

    private boolean rankingFilter(Ranking ranking, String entity) {
        return ranking.getEntity().equalsIgnoreCase(entity);
    }

    public void addIncoming(String entity, double amount) {
        final Ranking ranking = getRanking(entity);
        ranking.setIncoming(ranking.getIncoming() + amount);
    }
}
