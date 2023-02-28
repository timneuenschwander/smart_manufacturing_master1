import java.util.LinkedList;

/**
 * The class Roboter defines the framework for producing products
 *
 * @author Gruppe 27
 * @version 04.12.2022
 */
public class Roboter extends Thread
{
    // instance variables - replace the example below with your own
    public LinkedList<Product> warteschlange;
    private String name;
    private int produktionsZeit;

    /**
     * Constructor for objects of class Roboter
     */
    public Roboter()
    {
        // initialise instance variables - create an a empty list in which all products waiting to be produced are stored
        name = "Roboter Main";
        warteschlange = new LinkedList<Product>();
    }
    
    /**
     * @param Check if there is an order in waiting list. If yes, forward it to the specific production roboter. 
     * If that worked, start production of ordered products.
     */
    public void run()
    {   
        // System.out.println("The Roboter was started.");
        while (true){
            Product productToBeProduced = warteschlange.poll();
            if (productToBeProduced != null){
                produziereProdukt(productToBeProduced);
            }
            ThreadClass.sleep(500);
            try{
                Thread.sleep(500);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
    
    /**
     * @param Produce product & print the statement
     */
    public void produziereProdukt(Product productToBeProducedRoboter)
    {
        // Here the naechsteProduktionsStation() function will later be implemented
        // With this the produce product function will always follow the next step in the produktionsAblauf
        
        if(productToBeProducedRoboter instanceof Chair){
            produktionsZeit = ((Chair) productToBeProducedRoboter).getChairProduktionsZeit();}
        else if(productToBeProducedRoboter instanceof Sofa){
            produktionsZeit = ((Sofa) productToBeProducedRoboter).getSofaProduktionsZeit();}
        
        System.out.println("------------------------------------------------------------");
        ThreadClass.syncedPrintln("[Roboter] The product " + productToBeProducedRoboter + " will be processed for " + produktionsZeit + " ms.");
        ThreadClass.sleep(produktionsZeit);
        ThreadClass.syncedPrintln("[Roboter] The product " + productToBeProducedRoboter + " is finished.");
        productToBeProducedRoboter.zustandAendern(3);
    }
        
    /**
     * @param Put product in Roboter's waiting list & print the statement
     */
    public void addToWaitingList(Product productToBeProducedWL)
    {
        warteschlange.add(productToBeProducedWL);
        System.out.println("------------------------------------------------------------");
        System.out.println("The Roboter received a production command for product : " + productToBeProducedWL);
    }
    
    /**
     * @param Set the production time
     */
    public void setProductionTime(int time){
        this.produktionsZeit = time;
    }
    
    /**
     * @return Receive the name of the roboter
     */
    public String giveName()
    {
        return this.name;
    }
}
