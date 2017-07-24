package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.Ranking;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: jp_morgan
 * For: service for cal incoming and outgoing trade for entity
 * Created by damekjan on 24/07/2017.
 */
public class RankingService {

    /**
     * list of rankings by entity
     */
    private final List<Ranking> rankings;

    /**
     * constructor
     */
    public RankingService() {
        rankings = new ArrayList<>();

    }

    /**
     * getter for list all {@link Ranking}
     *
     * @return list of {@link Ranking}
     */
    public List<Ranking> getRankings() {
        return rankings;
    }

    /**
     * count of sum of outcoming trades on entity name
     *
     * @param entity String
     * @param amount Double
     */
    public void addOutcome(String entity, double amount) {
        final Ranking ranking = getRanking(entity);
        ranking.setOutgoing(ranking.getOutgoing() + amount);
    }

    /**
     * get one {@link Ranking} by given entyity name. If not exist is created an stored on list
     *
     * @param entity Strign name of entity
     * @return object of {@link Ranking}
     */
    private Ranking getRanking(String entity) {
        final Ranking ranking =
                rankings.stream().filter(r -> rankingFilter(r, entity)).findFirst().orElse(new Ranking(entity));
        if (!rankings.contains(ranking)) {
            rankings.add(ranking);
        }
        return ranking;
    }

    /**
     * filter method for find {@link Ranking} by entity name
     *
     * @param ranking object of {@link Ranking} for compare
     * @param entity  name of entity to find
     * @return true if is equal
     */
    private boolean rankingFilter(Ranking ranking, String entity) {
        return ranking.getEntity().equalsIgnoreCase(entity);
    }

    /**
     * count of sum of incoming trades on entity
     *
     * @param entity String
     * @param amount Double
     */
    public void addIncoming(String entity, double amount) {
        final Ranking ranking = getRanking(entity);
        ranking.setIncoming(ranking.getIncoming() + amount);
    }
}
