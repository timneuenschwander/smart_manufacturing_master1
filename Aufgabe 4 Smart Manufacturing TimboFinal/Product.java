import java.util.LinkedList;

/**
 * The class Product defines the framework for products that are embedded into our system
 * 
 * @author Gruppe 27
 * @version 31.12.2022
 */
public class Product
{
    // instance variables - the characteristics of a Product in general
    private int zustand;
    // instance variables - initiate the list for the individual production steps
    private LinkedList<Roboter> produktionsAblauf;

    /**
     * Constructor for objects of class Product
     */
    public Product()
    {
        // initialise instance variable - the initial product status is 1
        zustand = 1;
    }

    /**
     * @param Change the status of one specific product
     * 1 = Order received
     * 2 = In production
     * 3 = Delivered
     */
    public void zustandAendern(int newZustand)
    {
        // put your code here
        this.zustand = newZustand;
    }
    
    /**
     * @param Print the status of one specific product
     */
    public void gibZustand()
    {
        // put your code here
        if (this.zustand == 1)
        {System.out.println("Status = Order received by Aeki");}
        else if (this.zustand == 2)
        {System.out.println("Status = The ordered product is in production at the moment");}
        else if (this.zustand == 3)
        {System.out.println("Status = The ordered product is finished and ready for dispatch.");}
        else if (this.zustand == 4)
        {System.out.println("Status = The ordered product is being delivered.");}
        else
        {System.out.println("No status set at the moment!");}
    }
    
    /**
     * @return Receive the status number of one specific product
     */
    public int gibZustandNr()
    {
        // put your code here
        return this.zustand;
    }
    
    /**
     * @param The production process order is set
     */
    public void setzeProduktionsAblauf(Roboter robo1, Roboter robo2, Roboter robo3, Roboter robo4)
    {
        produktionsAblauf = new LinkedList<>();
        produktionsAblauf.add(robo1);
        produktionsAblauf.add(robo2);
        produktionsAblauf.add(robo3);
        produktionsAblauf.add(robo4);
    }
    
    /**
     * @return The product is forwarded to the next production robot. The first robot in the linked list is deleted.
     */
    public Roboter naechsteProduktionsStation()
    {
        return produktionsAblauf.poll();
    }
}
