package eu.damek.jpmorgan.service;

import eu.damek.jpmorgan.domain.Ranking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Project: jp_morgan
 * For: service for cal incoming and outgoing trade for entity. It's package private because it's used only on {@link MarketService}
 * Created by damekjan on 24/07/2017.
 */
class RankingService {

    /**
     * list of rankings by entity
     */
    private final List<Ranking> rankings;

    /**
     * constructor
     */
    RankingService() {
        rankings = new ArrayList<>();

    }

    /**
     * getter for list all {@link Ranking}
     *
     * @return list of {@link Ranking}
     */
    List<Ranking> getRankings() {
        return rankings;
    }

    /**
     * count of sum of outgoing trades on entity name
     *
     * @param entity String
     * @param amount Double
     */
    void addOutcome(String entity, double amount) {
        final Ranking ranking = getRanking(entity);
        ranking.setOutgoing(ranking.getOutgoing() + amount);
    }

    /**
     * get one {@link Ranking} by given entity name. If not exist is created an stored on list
     *
     * @param entity String name of entity
     * @return object of {@link Ranking}
     */
    private Ranking getRanking(String entity) {
        final AtomicReference<Ranking> atomicReference =
                new AtomicReference<>(rankings.stream()
                        .filter(r -> rankingFilter(r, entity))
                        .findFirst()
                        .orElse(new Ranking(entity)));
        if (!rankings.contains(atomicReference.get())) {
            rankings.add(atomicReference.get());
        }
        return atomicReference.get();
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
    void addIncoming(String entity, double amount) {
        final Ranking ranking = getRanking(entity);
        ranking.setIncoming(ranking.getIncoming() + amount);
    }
}
