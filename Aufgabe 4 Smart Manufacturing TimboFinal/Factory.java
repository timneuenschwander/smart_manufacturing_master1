import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class Factory defines the framework for the factory that is embedded into our system
 * 
 * @author Gruppe 27
 * @version 31.12.2022
 */
public class Factory
{
    // instance variables - replace the example below with your own
    public ArrayList<Order> orders;
    public int orderNr;
    // Number to initiate the manu with all action Choices
    private final int ChoiceMenu = 0;
    // Number to create an order
    private final int CaseCreateOrder = 1;
    // Number to print orders
    private final int CasePrintOrders = 2;
    // Number to print specific order
    private final int CasePrintOrder = 3;
    // Number to fill Inventory
    private final int CaseFillInventory = 4;
    // Number to print inventory
    private final int CasePrintInventory = 5;
    // Number to end program
    private final int CaseEndProgramm = 6;
    // Scanner to read the inputs from the console
    private Scanner sc;
    // instance variables - initiate the inventory variable
    public Inventory inventory1;
    // instance variables - initiate the production manager variable
    public Produktions_Manager productionManager;

    /**
     * Constructor for objects of class Factory
     */
    public Factory()
    {
        // initialise instance variable - create the list that safes all customer orders
        orders = new ArrayList<Order>();
        this.sc = new Scanner(System.in);
        // initialise instance variable for inventory and production manager
        inventory1 = new Inventory();
        productionManager = new Produktions_Manager();
        productionManager.start();
        // initialise instance variable for orderNr
        orderNr = 0;
    }
    
    /**
     * @param Create an order including the desired amount of sofas, as well as the desired amount of chairs
     */
    public void createOrder(int newNumberSofas, int newNumberChairs)
    {
        // Control for positive order wuantities
        if(newNumberSofas < 0 || newNumberChairs < 0){System.out.println("Please enter a positive number for each order quantitiy.");}
        else{
        // Set the order number of the new order
        orderNr += 1;
        // Create the new order and add it to the list of orders
        Order newOrder = new Order(newNumberSofas, newNumberChairs, orderNr);
        orders.add(newOrder);
        // Set the lead time and delivery time variable
        int beschaffungsZeit = inventory1.calculateBeschaffungsZeit(newOrder);
        float timeSofas = (float)newNumberSofas/24/60*(Sofa.getSofaProduktionsZeit());
        float timeChairs = (float)newNumberChairs/24/60*(Chair.getChairProduktionsZeit());
        newOrder.setzeBeschaffungsZeit(beschaffungsZeit);
        newOrder.setzeLieferZeit(beschaffungsZeit+1+timeSofas+timeSofas);
        //put order in to do list of production
        productionManager.fuegeZuVerarbeitendeBestellungenHinzu(newOrder);
        // Direct Bestellbestätigung
        System.out.println("The order with the order number "+orderNr+" has been received sucessfully.");
        System.out.println("It contains the following information:");
        System.out.println("    Number of sofas ordered: "+newNumberSofas);
        System.out.println("    Number of chairs ordered: "+newNumberChairs);
        System.out.println("    Procurement time: "+beschaffungsZeit+" days");
        System.out.println("    Delivery time: "+newOrder.gibLieferZeit()+" days");
        newOrder.setzeBestellBestaetigung(true);
        };
    }
    
    /**
     * @param Print out all information associated to all orders
     */
    public void printOrders()
    {
        // Print a list of all orders collected (Their ID will appear!)
        System.out.println("These are all the orders received (memory address of orders):");
        System.out.println(orders);
        System.out.println("");
        // Print the content of each order in the order list
        System.out.println("This is the content of all the orders received:");
        System.out.println("------------------------------------------------------------");
        // For each order in the order list perform the following
        for (int i = 0; i < orders.size(); i++)
        {
            // With the get methods defined in other classes, print all information associated to each order object within the order list
            System.out.println("The order with the order number "+orders.get(i).gibOrderNr()+" contains the following information:");
            System.out.println("    Number of sofas ordered: "+orders.get(i).gibAnzahlSofas());
            System.out.println("    Number of chairs ordered: "+orders.get(i).gibAnzahlStuehle());
            System.out.println("    Procurement time: "+orders.get(i).gibBeschaffungsZeit()+" days");
            System.out.println("    Delivery time: "+orders.get(i).gibLieferZeit()+" days");
            if (orders.size() > 1 && (orders.size() - 1) != i)
            {System.out.println("------------------------------------------------------------");}
        }
    }
    
    /**
     * @param Print out all information associated to an order
     */
    public void printSpecificOrder(int orderNrDruck)
    {
        for (int i = 0; i < orders.size(); i++)
        {
            if (orders.get(i).gibOrderNr() == orderNrDruck)
            {
            System.out.println("The order with the order number "+orders.get(i).gibOrderNr()+" contains the following information:");
            System.out.println("    Number of sofas ordered: "+orders.get(i).gibAnzahlSofas());
            System.out.println("    Number of chairs ordered: "+orders.get(i).gibAnzahlStuehle());
            System.out.println("    Procurement time: "+orders.get(i).gibBeschaffungsZeit()+" days");
            System.out.println("    Delivery time: "+orders.get(i).gibLieferZeit()+" days");
            }
        }
    }
    
    /**
     * @return Receive the list of orders
     */
    public ArrayList<Order> gibOrders()
    {
        // put your code here
        return orders;
    }
    
    /** 
    * @main Main method as entry point of the java application
    */
    public static void main(String [] args)
    {
        //Factory factory1 = new Factory();
        //factory1.startUserInterface();
    }

    /* 
    * @param Method to start user interface. Only important for later exercises.
   
       public void startUserInterface()
    {
        System.out.println("The Smart Factory UX was started successfully.");
        int choice = 0;
        loop: while (choice<100)                
        {   
            switch(choice){
                // Presenting different choice actions
                case ChoiceMenu:
                    {                        
                        System.out.println("============================================================");
                        System.out.println("Please choose an action by inserting the corresponding number.");
                        System.out.println("1. Create order");
                        System.out.println("2. Print the information of all orders");
                        System.out.println("3. Print the information of one specific order");
                        System.out.println("4. Fill the inventory");
                        System.out.println("5. Print the inventory");
                        System.out.println("6. End program");
                        System.out.println("============================================================");
                        int caseNumber = sc.nextInt();
                        sc.nextLine();
                        choice = caseNumber;
                        break;
                    }
                // Create order command
                case CaseCreateOrder:
                    {
                        System.out.println("Enter the number of sofas you want to order: ");
                        int orderedqSofas = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the number of chairs you want to order: ");
                        int orderedqChairs = sc.nextInt();
                        createOrder(orderedqSofas, orderedqChairs);
                        sc.nextLine();
                        choice = 0;
                        break;
                    }
                // Print out orders command
                case CasePrintOrders:
                    {
                        printOrders();
                        choice = 0;
                        break;
                    }
                // Print out specific order command
                case CasePrintOrder:
                    {
                        System.out.println("Enter the order number of the order you want to look at: ");
                        int orderNRLook = sc.nextInt();
                        sc.nextLine();
                        printSpecificOrder(orderNRLook);
                        choice = 0;
                        break;
                    }
                // Fill inventory
                case CaseFillInventory:
                    {
                        inventory1.fillInventory();
                        choice = 0;
                        break;
                    }
                // Print inventory
                case CasePrintInventory:
                    {
                        inventory1.printCurrentInventory();
                        choice = 0;
                        break;
                    }
                // End the user interface
                case CaseEndProgramm:
                    {
                        System.out.println("The Smart Factory UX was stopped successfully.");
                        break loop;
                    }
                // Default case
                default:
                    {
                        System.out.println("No such choice!");
                    }
                }
            }
                 
        }*/
}
