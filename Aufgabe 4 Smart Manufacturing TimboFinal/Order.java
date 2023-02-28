import java.util.ArrayList;

/**
 * The class Order defines the framework for orders that are embedded into our system
 * 
 * @author Gruppe 27
 * @version 31.12.2022
 */
public class Order
{
    // instance variable - a list within the order that holds the ordered amount of Sofas and Chairs
    private ArrayList<Product> bestellteProdukte;
    // instance variable - true/false boolean value that decides whether an order confirmation shall be sent or not
    private boolean bestellBestaetigung;
    // instance variable - how long it takes to have the ordered products ready
    private int beschaffungsZeit;
    //  instance variable - number of ordered Chairs
    public int anzahlStuehle;
    //  instance variable - number of ordered Sofas
    public int anzahlSofas;
    //  instance variable - this is the order number
    private int bestellungsNr;
    //  instance variable - this is the delivery time
    private float lieferZeit;
    //  instance variable - this is the boolean to set alle products to produce
    private boolean alleProdukteProduziert;

    /**
     * Constructor for objects of class Order
     */
    public Order(int anzahlSofas, int anzahlStuehle, int bestellungsNr)
    {
        // initialise instance variables - set the confirmation variable and the production status to false
        this.bestellBestaetigung = false;
        this.alleProdukteProduziert = false;
        // initialise instance variables - the varibles of this specific order are set equal to the user's input values
        this.bestellungsNr = bestellungsNr;
        this.anzahlSofas = anzahlSofas;
        this.anzahlStuehle = anzahlStuehle;
        //
        this.beschaffungsZeit = 0;
        this.lieferZeit = 0;
        // initialise instance variables - create an a empty list in which all ordered products are stored
        bestellteProdukte = new ArrayList<Product>();
        // initialise instance variables - equal to the amount of ordered amount of Sofas/Chairs, a number of new Sofa/Chair object are created and directly safed in the order's central list
        for (int i = 0; i < anzahlSofas; i++){bestellteProdukte.add(new Sofa());}
        for (int i = 0; i < anzahlStuehle; i++){bestellteProdukte.add(new Chair());}
        // control print to check that the order object was created successfully
        System.out.println("The order with the order number "+bestellungsNr+" was successfully created!");
    }
    
    /**
     * @param Set the order confirmation value of one specific Order object
     */
    public void setzeBestellBestaetigung(boolean newBestellBestaetigung)
    {
        // put your code here
        this.bestellBestaetigung = newBestellBestaetigung;
    }
    
    /**
     * @return Receive the order confirmation value of one specific Order object
     */
    public boolean gibBestellBestaetigung()
    {
        // put your code here
        return bestellBestaetigung;
    }
    
    /**
     * Set the lead time of one specific Order object
     * @param Beschaffungszeit, die Zeit die man benätigt um die Bestellung auszuführe
     */
    public void setzeBeschaffungsZeit(int newBeschaffungsZeit)
    {
        // put your code here
        this.beschaffungsZeit = newBeschaffungsZeit;
    }
    
    /**
     * @return Receive the lead time of one specific Order object
     */
    public int gibBeschaffungsZeit()
    {
        // put your code here
        return beschaffungsZeit;
    }
    
    /**
     * @return Receive the order number of one specific Order object
     */
    public int gibOrderNr()
    {
        // put your code here
        return bestellungsNr;
    }
    
    /**
     * @return Receive the number of Chairs of one specific Order object
     */
    public int gibAnzahlStuehle()
    {
        // put your code here
        return anzahlStuehle;
    }
    
    /**
     * @return Receive the number of Sofas of one specific Order object
     */
    public int gibAnzahlSofas()
    {
        // put your code here
        return anzahlSofas;
    }
    
    /**
     * @param Set the time to deliver an order
     */
    public void setzeLieferZeit(float lieferZeitNeu)
    {
        // put your code here
        this.lieferZeit = lieferZeitNeu;
    }
    
    /**
     * @return Receive the time to deliver an order
     */
    public float gibLieferZeit()
    {
        // put your code here
        return lieferZeit;
    }
    
    /**
     * @return Receive the list of products ordered
     */
    public ArrayList<Product> gibBestellteProdukte()
    {
        // put your code here
        return bestellteProdukte;
    }
    
    /**
     * @param Set the the production status of one specific Order object
     */
    public void setzeAlleProdukteProduziert()
    {
        // put your code here
        this.alleProdukteProduziert = true;
    }
    
    /**
     * @return Receive the production status of one specific Order object
     */
    public boolean getProductionStatus()
    {
        // put your code here
        return this.alleProdukteProduziert;
    }
}
