package eu.damek.jpmorgan.domain;

import java.util.Date;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class Instruction {

    /**
     * name of entity
     */
    private final String entity;
    /**
     * char for Sell or Buy
     */
    private final char buySell;
    /**
     * agreedFx exchange
     */
    private final Double agreedFx;
    /**
     * currency for make
     */
    private final String currency;
    /**
     * date of instruction
     */
    private final Date instructionDate;
    /**
     * date for settlement
     */
    private final Date settlementDate;
    /**
     * count of unit
     */
    private final Integer units;
    /**
     * price per unit
     */
    private final Double pricePerUnit;

    /**
     * Main constructor
     *
     * @param entity          String
     * @param buySell         Char
     * @param agreedFx        Double
     * @param currency        String
     * @param instructionDate Date
     * @param settlementDate  Date
     * @param units           Integer
     * @param pricePerUnit    Double
     */
    Instruction(String entity, char buySell, Double agreedFx, String currency, Date instructionDate,
                Date settlementDate, Integer units, Double pricePerUnit) {
        this.entity = entity;
        this.buySell = buySell;
        this.agreedFx = agreedFx;
        this.currency = currency;
        this.instructionDate = instructionDate;
        this.settlementDate = settlementDate;
        this.units = units;
        this.pricePerUnit = pricePerUnit;
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
                .append("pricePerUnit", pricePerUnit)
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
     * getter for Sell or Buy
     *
     * @return Char
     */
    public char getBuySell() {
        return buySell;
    }

    /**
     * getter for agree Fx
     *
     * @return Double
     */
    public Double getAgreedFx() {
        return agreedFx;
    }

    /**
     * getter for currency
     *
     * @return String
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * getter for instruction date. For now it's not used but in future can be
     *
     * @return Date
     */
    public Date getInstructionDate() {
        return instructionDate;
    }

    /**
     * getter for Settlement date
     *
     * @return Date
     */
    public Date getSettlementDate() {
        return settlementDate;
    }

    /**
     * getter for count of unit
     *
     * @return Integer
     */
    public Integer getUnits() {
        return units;
    }

    /**
     * getter for price of unit
     *
     * @return Double
     */
    public Double getPricePerUnit() {
        return pricePerUnit;
    }
}
