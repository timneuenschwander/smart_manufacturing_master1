
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class FactoryTest.
 * 
 * @author Gruppe 27
 * @version 04.12.2022
 */
public class FactoryTest
{
    /**
     * Default constructor for test class FactoryTest
     */
    public FactoryTest()
    {
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    
    /**
     * Test order which is placed during the test and all related checks to it.
     */
    @Test
    public void testBestellung()
    {
        Factory Aeki = new Factory();
        // first number = Sofas, second number = Chairs
        Aeki.createOrder(2,1);
        Aeki.createOrder(1,2);
        Aeki.createOrder(3,4);
        Aeki.createOrder(20,20);
        Aeki.printOrders();
        // initiate the control variable for the sum of sofas and chairs ordered
        int sumSofa = 0;
        int sumChair = 0;
        // check all orders and fill the sum variables with the ordered products
        for(Order o : Aeki.orders)
        {
            sumSofa = sumSofa + o.gibAnzahlSofas();
            sumChair = sumChair + o.gibAnzahlStuehle();
        }
        // check wehther the product objects orderd and created are correct or not
        assertEquals(26, sumSofa);
        assertEquals(27, sumChair);
        // check if for all orders an order confirmation was issued
        for(Order o : Aeki.orders)
        {
            boolean b = o.gibBestellBestaetigung();
            assertEquals(true, b);
        }
        // check if a procurement order can be sent from the inventory to the supplier
        // + check if the time delay for delivery is correct
        long start = System.currentTimeMillis();
        Aeki.inventory1.fillInventory();
        long end = System.currentTimeMillis();
        assertTrue(end - start <= 50000 || end - start >= 46000);
        // check if all products are finished
        ThreadClass.sleep(100000);
        for(Order o : Aeki.orders)
        {
            for (Product p : o.gibBestellteProdukte()) {
                assertEquals(3, p.gibZustandNr());
            }
        }
    }
}
