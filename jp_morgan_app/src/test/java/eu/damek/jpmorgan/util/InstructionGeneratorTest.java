package eu.damek.jpmorgan.util;

import eu.damek.jpmorgan.domain.Instruction;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class InstructionGeneratorTest {

    @Test
    public void getInstructions() throws Exception {
        List<Instruction> instructions = new InstructionGenerator().getInstructions();
        Assert.assertEquals(instructions.size(), 15);
    }

}