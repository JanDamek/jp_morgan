package eu.damek.jpmorgan.util;

import eu.damek.jpmorgan.domain.Instruction;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class InstructionGenerator {

    public List<Instruction> getInstrunctions() {
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction(
                "foo",
                'B',
                0.5D,
                "SGP",
                Utils.date(1, 1, 2016),
                Utils.date(2, 1, 2016),
                200,
                100.25D));
        instructions.add(new Instruction(
                "foo",
                'B',
                0.5D,
                "SGP",
                Utils.date(1, 1, 2016),
                Utils.date(5, 1, 2016),
                200,
                100.25D));
        instructions.add(new Instruction(
                "foo",
                'S',
                0.5D,
                "SGP",
                Utils.date(1, 1, 2016),
                Utils.date(6, 1, 2016),
                200,
                100.25D));
        instructions.add(new Instruction(
                "foo",
                'S',
                0.5D,
                "SGP",
                Utils.date(1, 1, 2016),
                Utils.date(7, 1, 2016),
                200,
                100.25D));
        instructions.add(new Instruction(
                "foo",
                'B',
                0.5D,
                "SGP",
                Utils.date(1, 1, 2016),
                Utils.date(8, 1, 2016),
                200,
                100.25D));
        instructions.add(new Instruction(
                "foo",
                'S',
                0.5D,
                "SGP",
                Utils.date(1, 1, 2016),
                Utils.date(9, 1, 2016),
                200,
                100.25D));
        instructions.add(new Instruction(
                "foo",
                'B',
                0.5D,
                "SGP",
                Utils.date(1, 1, 2016),
                Utils.date(10, 1, 2016),
                200,
                100.25D));
        instructions.add(new Instruction(
                "foo",
                'B',
                0.5D,
                "SGP",
                Utils.date(1, 1, 2016),
                Utils.date(11, 1, 2016),
                200,
                100.25D));
        instructions.add(new Instruction(
                "foo",
                'S',
                0.5D,
                "SGP",
                Utils.date(1, 1, 2016),
                Utils.date(10, 1, 2016),
                200,
                100.25D));
        instructions.add(new Instruction(
                "bar",
                'S',
                0.22D,
                "AED",
                Utils.date(5, 1, 2016),
                Utils.date(7, 1, 2016),
                450,
                150.5D));
        instructions.add(new Instruction(
                "bar",
                'S',
                0.22D,
                "AED",
                Utils.date(5, 1, 2016),
                Utils.date(12, 1, 2016),
                450,
                150.5D));
        instructions.add(new Instruction(
                "bar",
                'B',
                0.22D,
                "AED",
                Utils.date(5, 1, 2016),
                Utils.date(11, 1, 2016),
                450,
                150.5D));
        instructions.add(new Instruction(
                "bar",
                'S',
                0.22D,
                "AED",
                Utils.date(5, 1, 2016),
                Utils.date(10, 1, 2016),
                450,
                150.5D));
        instructions.add(new Instruction(
                "bar",
                'S',
                0.22D,
                "AED",
                Utils.date(5, 1, 2016),
                Utils.date(9, 1, 2016),
                450,
                150.5D));
        instructions.add(new Instruction(
                "bar",
                'B',
                0.22D,
                "AED",
                Utils.date(5, 1, 2016),
                Utils.date(8, 1, 2016),
                450,
                150.5D));
        return instructions;
    }
}
