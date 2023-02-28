import java.util.LinkedList;

/**
 * The class Produktions_Manager defines the framework for managing the production of products
 * 
 * @author Gruppe 27
 * @version 31.12.2022
 */
public class Produktions_Manager extends Thread
{
    // instance variables - initiate the variables for the 4 different robots
    private Roboter roboter;
    private Holzbearbeitungs_Roboter holzbearbeitungsRoboter;
    private Verpackungs_Roboter verpackungsRoboter;
    private Lackier_Roboter lackierRoboter;
    private Montage_Roboter montageRoboter;
    // instance variables - initiate the myFactory and myInventory variables
    private Factory myFactory;
    private Inventory myInventory;
    // instance variables - initiate the variables for the list of order to produce and orders in production
    private LinkedList<Order> zuVerarbeitendeBestellungen;
    private LinkedList<Order> bestellungenInProduktion;

    /**
     * Constructor for objects of class Produktions_Manager
     */
    public Produktions_Manager()
    {
        // initialise instance variables for the main and the 4 smaller robots
        roboter = new Roboter();
        roboter.start();
        
        holzbearbeitungsRoboter = new Holzbearbeitungs_Roboter();
        holzbearbeitungsRoboter.start();
        verpackungsRoboter = new Verpackungs_Roboter ();
        verpackungsRoboter.start();
        lackierRoboter = new Lackier_Roboter();
        lackierRoboter.start();
        montageRoboter = new Montage_Roboter();
        montageRoboter.start();
        // initialise the variables for the list of order to produce and orders in production
        zuVerarbeitendeBestellungen = new LinkedList<Order>();
        bestellungenInProduktion = new LinkedList<Order>();
    }
    
    /**
     * @param Check if there is an order in waiting list. If yes, put it in production list. 
     * If that worked, start production of ordered products.
     */
    public void run()
    {
        //System.out.println("The production manager was started.");
        while (true){
            Order orderToBeProduced = zuVerarbeitendeBestellungen.poll();
            if (orderToBeProduced != null){
                bestellungenInProduktion.add(orderToBeProduced);
                System.out.println("------------------------------------------------------------");
                ThreadClass.syncedPrintln("[Production Mananger] The order with the order number " + orderToBeProduced.gibOrderNr() + " entered the production process.");
                startProduction(orderToBeProduced);
            }
            for (Order orderInProduction : bestellungenInProduktion) {
                if (orderInProduction.getProductionStatus() == true){
                    bestellungenInProduktion.remove(orderInProduction);
                    System.out.println("------------------------------------------------------------");
                    ThreadClass.syncedPrintln("[Production Mananger] The order with the order number " + orderToBeProduced.gibOrderNr() + " is produced and ready for dispatch in the Inventory.");
                }
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
     * @param Put order on the waiting list for production
     * fuegeZuVerarbeitendeBestellungenHinzu(Order orderToBeProduced)
     */
    public void fuegeZuVerarbeitendeBestellungenHinzu(Order orderToBeProducedZV)
    {
        // put your code here
        zuVerarbeitendeBestellungen.add(orderToBeProducedZV);
    }

    /**
     * @param Put order on the waiting list for production in the roboter and change the product status
     * startProduction(Order orderToBeProduced)
     */
    public void startProduction(Order orderToBeProducedManager)
    {
        for (Product productToBeProducedManager : orderToBeProducedManager.gibBestellteProdukte()){
            productToBeProducedManager.zustandAendern(2);
            if(productToBeProducedManager instanceof Chair)
            {
                 productToBeProducedManager.setzeProduktionsAblauf(holzbearbeitungsRoboter,verpackungsRoboter,montageRoboter,lackierRoboter);
                 //for (int i = 0; i < 4; i++){
                 //    productToBeProduced.naechsteProduktionsStation();
                 //    //add product to waiting list of specific robto
                 //   }
                 roboter.addToWaitingList(productToBeProducedManager);
            }
            else if(productToBeProducedManager instanceof Sofa)
            {
                productToBeProducedManager.setzeProduktionsAblauf(lackierRoboter,montageRoboter,verpackungsRoboter,holzbearbeitungsRoboter);
                //for (int i = 0; i < 4; i++){
                //    productToBeProduced.naechsteProduktionsStation();
                //    //add product to waiting list of specific robto
                //   }
                roboter.addToWaitingList(productToBeProducedManager);
            };
        }
        orderToBeProducedManager.setzeAlleProdukteProduziert();
    }
}
