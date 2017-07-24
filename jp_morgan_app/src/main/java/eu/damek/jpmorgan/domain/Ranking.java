package eu.damek.jpmorgan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class Ranking {

    /**
     * entity name
     */
    private final String entity;
    /**
     * sum of incoming for entity
     */
    private double incoming;
    /**
     * sum of outgoing for entity
     */
    private double outgoing;

    /**
     * constructor for {@link Ranking} with enity name
     *
     * @param entity String
     */
    public Ranking(String entity) {
        this.entity = entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return getEntity() != null ? getEntity().hashCode() : 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ranking)) {
            return false;
        }

        Ranking ranking = (Ranking) o;

        return getEntity() != null ? getEntity().equals(ranking.getEntity()) : ranking.getEntity() == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("entity", entity)
                .append("incoming", incoming)
                .append("outgoing", outgoing)
                .toString();
    }

    /**
     * getter for entity name
     *
     * @return String
     */
    public String getEntity() {
        return entity;
    }

    /**
     * calc of rang for entity. If outgoing is great like incomint then return 1 else 0
     *
     * @return Integer
     */
    public Integer ranking() {
        return outgoing > incoming ? 1 : 0;
    }

    /**
     * getter for incoming
     *
     * @return Double
     */
    public double getIncoming() {
        return incoming;
    }

    /**
     * setter for incoming
     *
     * @param incoming Double
     */
    public void setIncoming(double incoming) {
        this.incoming = incoming;
    }

    /**
     * getter for outgoing
     *
     * @return Double
     */
    public double getOutgoing() {
        return outgoing;
    }

    /**
     * setter for outgoing
     *
     * @param outgoing Double
     */
    public void setOutgoing(double outgoing) {
        this.outgoing = outgoing;
    }
}
