package eu.damek.jpmorgan.domain;

import java.util.Date;

/**
 * Instruction builder
 */
public class InstructionBuilder {

    /**
     * entity
     */
    private String entity;
    /**
     * buy or sell
     */
    private char buySell;
    /**
     * agree fx
     */
    private Double agreedFx;
    /**
     * currency
     */
    private String currency;
    /**
     * instruction date
     */
    private Date instructionDate;
    /**
     * settlement date
     */
    private Date settlementDate;
    /**
     * units
     */
    private Integer units;
    /**
     * price per unit
     */
    private Double pricePerUnit;

    /**
     * builder pattern setter for entity
     *
     * @param entity String
     * @return self
     */
    public InstructionBuilder setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    /**
     * builder pattern setter for
     *
     * @param buySell char
     * @return self
     */
    public InstructionBuilder setBuySell(char buySell) {
        this.buySell = buySell;
        return this;
    }

    /**
     * builder pattern setter for
     *
     * @param agreedFx Double
     * @return self
     */
    public InstructionBuilder setAgreedFx(Double agreedFx) {
        this.agreedFx = agreedFx;
        return this;
    }

    /**
     * builder pattern setter for
     *
     * @param currency String
     * @return self
     */
    public InstructionBuilder setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * builder pattern setter for
     *
     * @param instructionDate Date
     * @return self
     */
    public InstructionBuilder setInstructionDate(Date instructionDate) {
        this.instructionDate = instructionDate;
        return this;
    }

    /**
     * builder pattern setter for
     *
     * @param settlementDate Date
     * @return self
     */
    public InstructionBuilder setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
        return this;
    }

    /**
     * builder pattern setter for
     *
     * @param units Integer
     * @return self
     */
    public InstructionBuilder setUnits(Integer units) {
        this.units = units;
        return this;
    }

    /**
     * builder pattern setter for
     *
     * @param pricePerUnit Double
     * @return self
     */
    public InstructionBuilder setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        return this;
    }

    /**
     * builder pattern for create {@link Instruction}
     *
     * @return Instruction created by builder
     */
    public Instruction createInstruction() {
        return new Instruction(entity, buySell, agreedFx, currency, instructionDate, settlementDate, units,
                pricePerUnit);
    }
}