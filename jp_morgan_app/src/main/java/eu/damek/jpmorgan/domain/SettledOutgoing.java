package eu.damek.jpmorgan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class SettledOutgoing {

    /**
     * settled date for outgoing
     */
    private final Date date;

    /**
     * sum of outgoing on date
     */
    private double outcome;

    /**
     * constructor with date of trade
     *
     * @param tradeDate Date
     */
    public SettledOutgoing(Date tradeDate) {
        this.date = tradeDate;
    }

    /**
     * getter of outgoing
     *
     * @return Double
     */
    public double getOutcome() {
        return outcome;
    }

    /**
     * setter of outgoing
     *
     * @param outcome Double
     */
    public void setOutcome(double outcome) {
        this.outcome = outcome;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return getDate() != null ? getDate().hashCode() : 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SettledOutgoing)) {
            return false;
        }

        SettledOutgoing that = (SettledOutgoing) o;

        return getDate() != null ? getDate().equals(that.getDate()) : that.getDate() == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("date", date)
                .append("outcome", outcome)
                .toString();
    }

    /**
     * getter of date
     *
     * @return Date
     */
    public Date getDate() {
        return date;
    }
}
