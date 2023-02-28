
/**
 * The class Sofa defines the type of product a sofa resembles
 * 
 * @author Gruppe 27
 * @version 31.12.2022
 */
public class Sofa extends Product
{
    // instance variables - all the raw materials of a Sofa
    private static int holzeinheiten;
    private static int schrauben;
    private static int kissen;
    private static int farbeinheiten;
    private static int kartoneinheiten;
    private static int produktionsZeit;
    
    /**
     * Constructor for objects of class Sofa
     */
    public Sofa()
    {
        // initialise instance variables of a Sofa with the corresponding amount
        holzeinheiten = 4;
        schrauben = 5;
        kissen = 5;
        farbeinheiten = 1;
        kartoneinheiten = 5;
        produktionsZeit = 60; //in Realität 3'600'000
        // control print to check that the new Sofa object was created successfully
        //System.out.println("The product 'Sofa' was successfully created!");
    }

    /**
     * @return Receive the amount of "Holzeinheiten" of one specific Sofa object
     */
    public int getSofaHolzeinheiten()
    {
        // put your code here
        return holzeinheiten;
    }
    
    /**
     * @return Receive the amount of "Schrauben" of one specific Sofa object
     */
    public int getSofaSchrauben()
    {
        // put your code here
        return schrauben;
    }
    
    /**
     * @return Receive the amount of "Kissen" of one specific Sofa object
     */
    public int getSofaKissen()
    {
        // put your code here
        return kissen;
    }
    
    /**
     * @return Receive the amount of "Farbeinheiten" of one specific Sofa object
     */
    public int getSofaFarbeinheiten()
    {
        // put your code here
        return farbeinheiten;
    }
    
    /**
     * @return Receive the amount of "Kartoneinheiten" of one specific Sofa object
     */
    public int getSofaKartoneinheiten()
    {
        // put your code here
        return kartoneinheiten;
    }
    
    /**
     * @return Receive the "ProduktionsZeit" of one specific Sofa object
     */
    public static int getSofaProduktionsZeit()
    {
        // put your code here
        return produktionsZeit;
    }
}
