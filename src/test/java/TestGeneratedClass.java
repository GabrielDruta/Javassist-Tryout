import Interface.Service;
import generation.ServiceImplementationFactory;
import org.junit.Assert;
import org.junit.Test;

import static generation.ServiceImplementationFactory.createServiceImplementation;

public class TestGeneratedClass {

    @Test
    public void testGenerationatRuntimeofServiceImplementation(){

        //create implementation
        Service service=createServiceImplementation();
        Assert.assertNotNull(service);
        Assert.assertEquals("my.generated.class.GeneratedServiceImplementation", service.getClass().getCanonicalName());
        System.out.println( service.getClass().getCanonicalName());

        Assert.assertEquals(8, service.sumOfTwoNumbers(2,4));
        // try to create again the generated class
        {
            try {
                ServiceImplementationFactory.createServiceImplementation();
            } catch (RuntimeException e) {
                Assert.assertEquals("java.lang.RuntimeException: my.generated.class.GeneratedServiceImplementation: frozen class (cannot edit)", e.getMessage());
                return;
            }
            Assert.fail("expect exception");
        }
    }


}
