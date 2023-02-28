
/**
 * The class Chair defines the type of product a chair resembles
 * 
 * @author Gruppe 27
 * @version 31.12.2022
 */
public class Chair extends Product
{
    // instance variables - all the raw materials of a Chair
    private static int holzeinheiten;
    private static int schrauben;
    private static int farbeinheiten;
    private static int kartoneinheiten;
    private static int produktionsZeit;
    
    /**
     * Constructor for objects of class Chair
     */
    public Chair()
    {
        // initialise instance variables of a Chair with the corresponding amount
        holzeinheiten = 2;
        schrauben = 10;
        farbeinheiten = 2;
        kartoneinheiten = 1;
        produktionsZeit = 22; //in Realität 1'320'000
        // control print to check that the new Chair object was created successfully
        //System.out.println("The product 'Chair' was successfully created!");
    }

    /**
     * @return Receive the amount of "Holzeinheiten" of one specific Chair object
     */
    public int getChairHolzeinheiten()
    {
        // put your code here
        return holzeinheiten;
    }
    
    /**
     * @return Receive the amount of "Schrauben" of one specific Chair object
     */
    public int getChairSchrauben()
    {
        // put your code here
        return schrauben;
    }
    
    /**
     * @return Receive the amount of "Farbeinheiten" of one specific Chair object
     */
    public int getChairFarbeinheiten()
    {
        // put your code here
        return farbeinheiten;
    }
    
    /**
     * @return Receive the amount of "Kartoneinheiten" of one specific Chair object
     */
    public int getChairKartoneinheiten()
    {
        // put your code here
        return kartoneinheiten;
    }
    
    /**
     * @return Receive the "ProduktionsZeit" of one specific Chair object
     */
    public static int getChairProduktionsZeit()
    {
        // put your code here
        return produktionsZeit;
    }
}
