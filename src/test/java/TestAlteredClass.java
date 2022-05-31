import Interface.Impl.ServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class TestAlteredClass {

    @Test
    public void testAlteredServiceImplementation(){


// test service
        Assert.assertEquals("5", new ServiceImpl().sumOfTwoNumbers(3,1));


    }
}
