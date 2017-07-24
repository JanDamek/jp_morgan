package eu.damek.jpmorgan.domain;

import java.util.Date;

public class InstructionBuilder {

    private String entity;
    private char buySell;
    private Double agreedFx;
    private String currency;
    private Date instructionDate;
    private Date settlementDate;
    private Integer units;
    private Double priceOerUnit;

    public InstructionBuilder setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    public InstructionBuilder setBuySell(char buySell) {
        this.buySell = buySell;
        return this;
    }

    public InstructionBuilder setAgreedFx(Double agreedFx) {
        this.agreedFx = agreedFx;
        return this;
    }

    public InstructionBuilder setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public InstructionBuilder setInstructionDate(Date instructionDate) {
        this.instructionDate = instructionDate;
        return this;
    }

    public InstructionBuilder setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
        return this;
    }

    public InstructionBuilder setUnits(Integer units) {
        this.units = units;
        return this;
    }

    public InstructionBuilder setPriceOerUnit(Double priceOerUnit) {
        this.priceOerUnit = priceOerUnit;
        return this;
    }

    public Instruction createInstruction() {
        return new Instruction(entity, buySell, agreedFx, currency, instructionDate, settlementDate, units,
                priceOerUnit);
    }
}