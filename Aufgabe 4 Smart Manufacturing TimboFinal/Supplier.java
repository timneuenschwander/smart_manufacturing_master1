
/**
 * The class Supplier defines the framework for supplying raw material.
 *
 * @author Gruppe 27
 * @version 31.12.2022
 */
public class Supplier
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Supplier
     */
    public Supplier()
    {
        // initialise instance variables
    }

    /**
     * @param Print Supplier order method
     */
    public void run()
    {
        // put your code here
        System.out.println("------------------------------------------------------------");
        System.out.println("The raw material order was successfully received by the supplier1.");
        System.out.println("The demanded raw material will be delivered in 2 days.");
        // 48000 milliseconds = 48 seconds
        ThreadClass.sleep(48000);
    }
}
