package eu.damek.jpmorgan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class SettledIncoming {

    /**
     * date of incoming
     */
    private final Date date;

    /**
     * total of incoming on date
     */
    private double incoming;

    /**
     * construcotr with Date of settled
     *
     * @param tradeDate Date
     */
    public SettledIncoming(Date tradeDate) {
        this.date = tradeDate;
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
        if (!(o instanceof SettledIncoming)) {
            return false;
        }

        SettledIncoming that = (SettledIncoming) o;

        return getDate() != null ? getDate().equals(that.getDate()) : that.getDate() == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("date", date)
                .append("incoming", incoming)
                .toString();
    }

    /**
     * getter for date
     *
     * @return Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * getter of incoming
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
}
