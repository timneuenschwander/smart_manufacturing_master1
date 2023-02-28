import java.util.ArrayList;

/**
 * The class Inventory defines the framework for managing raw material
 *
 * @author Gruppe 27
 * @version 04.12.2022
 */
public class Inventory
{
    // instance variables - initialsie the max amount of a material stored in the inventory
    private static final int maxHolzeinheiten = 1000;
    private static final int maxSchrauben = 5000;
    private static final int maxKissen = 100;
    private static final int maxFarbeinheiten = 1000;
    private static final int maxKartoneinheiten = 1000;
    // instance variables - the current amount of a material stored in the inventory
    private int availableHolzeinheiten = 1000;
    private int availableSchrauben = 5000;
    private int availableKissen = 100;
    private int availableFarbeinheiten = 1000;
    private int availableKartoneinheiten = 1000;
    // instance variables - initiate the supplier variable
    private int deliveredHolzeinheiten = 0;
    private int deliveredSchrauben = 0;
    private int deliveredKissen = 0;
    private int deliveredFarbeinheiten = 0;
    private int deliveredKartoneinheiten = 0;
    // instance variables - initiate the supplier variable
    public Supplier supplier1;
    
    /**
     * Constructor for objects of class Inventory
     */
    public Inventory()
    {
        // initialise instance variable for supplier
        supplier1 = new Supplier();
    }

    /**
     * @param Calculate the BeschaffungsZeit of the empty raw materials
     */
    public int calculateBeschaffungsZeit(Order customerOrder)
    {
        // put your code here
        int requiredHolzeinheiten = 0; 
        int requiredSchrauben = 0;
        int requiredKissen = 0;
        int requiredFarbeinheiten = 0; 
        int requiredKartoneinheiten = 0;
        
        for (Product product : customerOrder.gibBestellteProdukte())
        {
            if(product instanceof Chair)
            {
                requiredHolzeinheiten += ((Chair) product).getChairHolzeinheiten();;
                requiredSchrauben += ((Chair) product).getChairSchrauben();;
                requiredFarbeinheiten += ((Chair) product).getChairFarbeinheiten();;
                requiredKartoneinheiten += ((Chair) product).getChairKartoneinheiten();
            }
            else if(product instanceof Sofa)
            {
                requiredHolzeinheiten += ((Sofa) product).getSofaHolzeinheiten();;
                requiredSchrauben += ((Sofa) product).getSofaSchrauben();;
                requiredKissen += ((Sofa) product).getSofaKissen();;
                requiredFarbeinheiten += ((Sofa) product).getSofaFarbeinheiten();;
                requiredKartoneinheiten += ((Sofa) product).getSofaKartoneinheiten();
            };
        }
        
        if (requiredHolzeinheiten <= availableHolzeinheiten && requiredSchrauben <= availableSchrauben && requiredKissen <= availableKissen && requiredFarbeinheiten <= availableFarbeinheiten && requiredKartoneinheiten <= availableKartoneinheiten)
            {availableHolzeinheiten -= requiredHolzeinheiten; 
            availableSchrauben -= requiredSchrauben; 
            availableKissen -= requiredKissen; 
            availableFarbeinheiten -= requiredFarbeinheiten; 
            availableKartoneinheiten -= requiredKartoneinheiten;
            return 0;
        }
        else
            {fillInventory(); 
            availableHolzeinheiten -= requiredHolzeinheiten; 
            availableSchrauben -= requiredSchrauben; 
            availableKissen -= requiredKissen; 
            availableFarbeinheiten -= requiredFarbeinheiten; 
            availableKartoneinheiten -= requiredKartoneinheiten;
            return 2;
        }   
    }
    
    /** 
     * @param Print that the ordered raw materials have been delivered & fill the inventory to his maximum
     */
    public void fillInventory()
    {
        // run procurement process with supplier
        supplier1.run();
        System.out.println("------------------------------------------------------------"); 
        System.out.println("The ordered raw materials have been successfully delivered"); 
        // fill the lager to the max
        this.availableHolzeinheiten = maxHolzeinheiten;
        this.availableSchrauben = maxSchrauben;
        this.availableKissen = maxKissen;
        this.availableFarbeinheiten = maxFarbeinheiten;
        this.availableKartoneinheiten = maxKartoneinheiten;
        // Control step
        printCurrentInventory();
    }
    
    /** 
     * @param deliver ordered raw materials, same as fill inventory
     */
    public void deliverRawMaterials()
    {
        // run procurement process with supplier
        supplier1.run();
        System.out.println("------------------------------------------------------------"); 
        System.out.println("The ordered raw materials have been successfully delivered"); 
        // fill the lager to the max
        this.availableHolzeinheiten = maxHolzeinheiten;
        this.availableSchrauben = maxSchrauben;
        this.availableKissen = maxKissen;
        this.availableFarbeinheiten = maxFarbeinheiten;
        this.availableKartoneinheiten = maxKartoneinheiten;
        // Control step
        printCurrentInventory();
    }
    
    /**
     * @param Print the current inventory levels of Aeki.
     */
    public void printCurrentInventory()
    {
        // put your code here
        System.out.println("These are the current inventory levels:");
        System.out.println("This is the current amount of Holzeinheiten in storage: " + this.availableHolzeinheiten);
        System.out.println("This is the current amount of Schrauben in storage: " + this.availableSchrauben);
        System.out.println("This is the current amount of Kissen in storage: " + this.availableKissen);
        System.out.println("This is the current amount of Farbeinheiten in storage: " + this.availableFarbeinheiten);
        System.out.println("This is the current amount of Kartoneinheiten in storage: " + this.availableKartoneinheiten);
    }
}
