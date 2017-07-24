package eu.damek.jpmorgan.domain;

import java.util.Date;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class Instruction {

    private final String entity;
    private final char buySell;
    private final Double agreedFx;
    private final String currency;
    private final Date instructionDate;
    private final Date settlementDate;
    private final Integer units;
    private final Double priceOerUnit;

    public Instruction(String entity, char buySell, Double agreedFx, String currency, Date instructionDate,
                       Date settlementDate, Integer units, Double priceOerUnit) {
        this.entity = entity;
        this.buySell = buySell;
        this.agreedFx = agreedFx;
        this.currency = currency;
        this.instructionDate = instructionDate;
        this.settlementDate = settlementDate;
        this.units = units;
        this.priceOerUnit = priceOerUnit;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("entity", entity)
                .append("buySell", buySell)
                .append("agreedFx", agreedFx)
                .append("currency", currency)
                .append("instructionDate", instructionDate)
                .append("settlementDate", settlementDate)
                .append("units", units)
                .append("priceOerUnit", priceOerUnit)
                .toString();
    }

    public String getEntity() {
        return entity;
    }

    public char getBuySell() {
        return buySell;
    }

    public Double getAgreedFx() {
        return agreedFx;
    }

    public String getCurrency() {
        return currency;
    }

    public Date getInstructionDate() {
        return instructionDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public Integer getUnits() {
        return units;
    }

    public Double getPriceOerUnit() {
        return priceOerUnit;
    }
}
