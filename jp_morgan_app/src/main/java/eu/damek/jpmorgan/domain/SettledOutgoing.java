package eu.damek.jpmorgan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class SettledOutgoing {

    private final Date date;

    private double outcome;

    public SettledOutgoing(Date tradeDate) {
        this.date = tradeDate;
    }

    public double getOutcome() {
        return outcome;
    }

    public void setOutcome(double outcome) {
        this.outcome = outcome;
    }

    @Override
    public int hashCode() {
        return getDate() != null ? getDate().hashCode() : 0;
    }

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

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("date", date)
                .append("outcome", outcome)
                .toString();
    }
}
