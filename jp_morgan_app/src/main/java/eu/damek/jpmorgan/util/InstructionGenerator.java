package eu.damek.jpmorgan.util;

import eu.damek.jpmorgan.domain.Instruction;
import eu.damek.jpmorgan.domain.InstructionBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class InstructionGenerator {

    /**
     * Instruction generatro for test application
     *
     * @return list of {@link Instruction}
     */
    public List<Instruction> getInstrunctions() {
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new InstructionBuilder()
                .setEntity("foo")
                .setBuySell('B')
                .setAgreedFx(0.5D)
                .setCurrency("SGP")
                .setInstructionDate(Utils.date(1, 1, 2016))
                .setSettlementDate(Utils.date(2, 1, 2016))
                .setUnits(200)
                .setPricePerUnit(100.25D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("foo")
                .setBuySell('B')
                .setAgreedFx(0.5D)
                .setCurrency("SGP")
                .setInstructionDate(Utils.date(1, 1, 2016))
                .setSettlementDate(Utils.date(5, 1, 2016))
                .setUnits(200)
                .setPricePerUnit(100.25D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("foo")
                .setBuySell('S')
                .setAgreedFx(0.5D)
                .setCurrency("SGP")
                .setInstructionDate(Utils.date(1, 1, 2016))
                .setSettlementDate(Utils.date(6, 1, 2016))
                .setUnits(200)
                .setPricePerUnit(100.25D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("foo")
                .setBuySell('S')
                .setAgreedFx(0.5D)
                .setCurrency("SGP")
                .setInstructionDate(Utils.date(1, 1, 2016))
                .setSettlementDate(Utils.date(7, 1, 2016))
                .setUnits(200)
                .setPricePerUnit(100.25D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("foo")
                .setBuySell('B')
                .setAgreedFx(0.5D)
                .setCurrency("SGP")
                .setInstructionDate(Utils.date(1, 1, 2016))
                .setSettlementDate(Utils.date(8, 1, 2016))
                .setUnits(200)
                .setPricePerUnit(100.25D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("foo")
                .setBuySell('S')
                .setAgreedFx(0.5D)
                .setCurrency("SGP")
                .setInstructionDate(Utils.date(1, 1, 2016))
                .setSettlementDate(Utils.date(9, 1, 2016))
                .setUnits(200)
                .setPricePerUnit(100.25D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("foo")
                .setBuySell('B')
                .setAgreedFx(0.5D)
                .setCurrency("SGP")
                .setInstructionDate(Utils.date(1, 1, 2016))
                .setSettlementDate(Utils.date(10, 1, 2016))
                .setUnits(200)
                .setPricePerUnit(100.25D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("foo")
                .setBuySell('B')
                .setAgreedFx(0.5D)
                .setCurrency("SGP")
                .setInstructionDate(Utils.date(1, 1, 2016))
                .setSettlementDate(Utils.date(11, 1, 2016))
                .setUnits(200)
                .setPricePerUnit(100.25D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("foo")
                .setBuySell('S')
                .setAgreedFx(0.5D)
                .setCurrency("SGP")
                .setInstructionDate(Utils.date(1, 1, 2016))
                .setSettlementDate(Utils.date(10, 1, 2016))
                .setUnits(200)
                .setPricePerUnit(100.25D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("bar")
                .setBuySell('S')
                .setAgreedFx(0.22D)
                .setCurrency("AED")
                .setInstructionDate(Utils.date(5, 1, 2016))
                .setSettlementDate(Utils.date(7, 1, 2016))
                .setUnits(450)
                .setPricePerUnit(150.5D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("bar")
                .setBuySell('S')
                .setAgreedFx(0.22D)
                .setCurrency("AED")
                .setInstructionDate(Utils.date(5, 1, 2016))
                .setSettlementDate(Utils.date(12, 1, 2016))
                .setUnits(450)
                .setPricePerUnit(150.5D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("bar")
                .setBuySell('B')
                .setAgreedFx(0.22D)
                .setCurrency("AED")
                .setInstructionDate(Utils.date(5, 1, 2016))
                .setSettlementDate(Utils.date(11, 1, 2016))
                .setUnits(450)
                .setPricePerUnit(150.5D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("bar")
                .setBuySell('S')
                .setAgreedFx(0.22D)
                .setCurrency("AED")
                .setInstructionDate(Utils.date(5, 1, 2016))
                .setSettlementDate(Utils.date(10, 1, 2016))
                .setUnits(450)
                .setPricePerUnit(150.5D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("bar")
                .setBuySell('S')
                .setAgreedFx(0.22D)
                .setCurrency("AED")
                .setInstructionDate(Utils.date(5, 1, 2016))
                .setSettlementDate(Utils.date(9, 1, 2016))
                .setUnits(450)
                .setPricePerUnit(150.5D)
                .createInstruction());
        instructions.add(new InstructionBuilder()
                .setEntity("bar")
                .setBuySell('B')
                .setAgreedFx(0.22D)
                .setCurrency("AED")
                .setInstructionDate(Utils.date(5, 1, 2016))
                .setSettlementDate(Utils.date(8, 1, 2016))
                .setUnits(450)
                .setPricePerUnit(150.5D)
                .createInstruction());
        return instructions;
    }
}
