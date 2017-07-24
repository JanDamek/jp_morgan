package eu.damek.jpmorgan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class SettledIncoming {

    private final Date date;

    private double incoming;

    public SettledIncoming(Date tradeDate) {
        this.date = tradeDate;
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
        if (!(o instanceof SettledIncoming)) {
            return false;
        }

        SettledIncoming that = (SettledIncoming) o;

        return getDate() != null ? getDate().equals(that.getDate()) : that.getDate() == null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("date", date)
                .append("incoming", incoming)
                .toString();
    }

    public Date getDate() {
        return date;
    }

    public double getIncoming() {
        return incoming;
    }

    public void setIncoming(double incoming) {
        this.incoming = incoming;
    }
}
