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
    public int hashCode() {
        int result = getEntity() != null ? getEntity().hashCode() : 0;
        result = 31 * result + (int) getBuySell();
        result = 31 * result + (getAgreedFx() != null ? getAgreedFx().hashCode() : 0);
        result = 31 * result + (getCurrency() != null ? getCurrency().hashCode() : 0);
        result = 31 * result + (getInstructionDate() != null ? getInstructionDate().hashCode() : 0);
        result = 31 * result + (getSettlementDate() != null ? getSettlementDate().hashCode() : 0);
        result = 31 * result + (getUnits() != null ? getUnits().hashCode() : 0);
        result = 31 * result + (getPriceOerUnit() != null ? getPriceOerUnit().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Instruction)) {
            return false;
        }

        Instruction that = (Instruction) o;

        if (getBuySell() != that.getBuySell()) {
            return false;
        }
        if (getEntity() != null ? !getEntity().equals(that.getEntity()) : that.getEntity() != null) {
            return false;
        }
        if (getAgreedFx() != null ? !getAgreedFx().equals(that.getAgreedFx()) : that.getAgreedFx() != null) {
            return false;
        }
        if (getCurrency() != null ? !getCurrency().equals(that.getCurrency()) : that.getCurrency() != null) {
            return false;
        }
        if (getInstructionDate() != null ? !getInstructionDate().equals(that.getInstructionDate()) :
                that.getInstructionDate() != null) {
            return false;
        }
        if (getSettlementDate() != null ? !getSettlementDate().equals(that.getSettlementDate()) :
                that.getSettlementDate() != null) {
            return false;
        }
        if (getUnits() != null ? !getUnits().equals(that.getUnits()) : that.getUnits() != null) {
            return false;
        }
        return getPriceOerUnit() != null ? getPriceOerUnit().equals(that.getPriceOerUnit()) :
                that.getPriceOerUnit() == null;
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
