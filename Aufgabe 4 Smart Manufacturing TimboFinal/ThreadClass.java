/**
 * The class Supplier defines the framework for the Thread class.
 *
 * @author Gruppe 27
 * @version 31.12.2022
 */

public class ThreadClass {

    public static void sleep(int time){
        try {Thread.sleep(time);}
        catch (InterruptedException e){e.printStackTrace();}
    }

    public static void syncedPrintln(String message){
        synchronized (System.out){System.out.println(message);}
    }
}
