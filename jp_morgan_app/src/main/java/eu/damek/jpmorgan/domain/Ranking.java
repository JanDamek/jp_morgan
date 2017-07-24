package eu.damek.jpmorgan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class Ranking {

    private final String entity;
    private double incoming;
    private double outgoing;

    public Ranking(String entity) {
        this.entity = entity;
    }

    @Override
    public int hashCode() {
        return getEntity() != null ? getEntity().hashCode() : 0;
    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("entity", entity)
                .append("incoming", incoming)
                .append("outgoing", outgoing)
                .toString();
    }

    public String getEntity() {
        return entity;
    }

    public Integer ranking() {
        return outgoing > incoming ? 1 : 0;
    }

    public double getIncoming() {
        return incoming;
    }

    public void setIncoming(double incoming) {
        this.incoming = incoming;
    }

    public double getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(double outgoing) {
        this.outgoing = outgoing;
    }
}
