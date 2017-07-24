package eu.damek.jpmorgan.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class InstructionBuilderTest {

    @Test
    public void setEntity() throws Exception {
        Assert.assertEquals(new InstructionBuilder().setEntity("foo").createInstruction().getEntity(), "foo");
    }

    @Test
    public void setBuySell() throws Exception {
        Assert.assertEquals(new InstructionBuilder().setBuySell('B').createInstruction().getBuySell(), 'B');
    }

    @Test
    public void setAgreedFx() throws Exception {
        Assert.assertEquals(new InstructionBuilder().setAgreedFx(0.5).createInstruction().getAgreedFx(), 0.5, 0.0001);
    }

    @Test
    public void setCurrency() throws Exception {
        Assert.assertEquals(new InstructionBuilder().setCurrency("AED").createInstruction().getCurrency(), "AED");
    }

    @Test
    public void setInstructionDate() throws Exception {
        Date d = new Date();
        Assert.assertEquals(new InstructionBuilder().setInstructionDate(d).createInstruction().getInstructionDate(), d);
    }

    @Test
    public void setSettlementDate() throws Exception {
        Date d = new Date();
        Assert.assertEquals(new InstructionBuilder().setSettlementDate(d).createInstruction().getSettlementDate(), d);
    }

    @Test
    public void setUnits() throws Exception {
        Assert.assertEquals(new InstructionBuilder().setUnits(100).createInstruction().getUnits(), 100, 0.00001);
    }

    @Test
    public void setPricePerUnit() throws Exception {
        Assert.assertEquals(new InstructionBuilder().setPricePerUnit(100.2).createInstruction().getPricePerUnit(),
                100.2,
                0.00001);
    }

    @Test
    public void createInstruction() throws Exception {
        Assert.assertNotNull(new InstructionBuilder().setUnits(100).createInstruction());
    }

}