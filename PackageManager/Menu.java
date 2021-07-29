package PackageManager;
import Manager.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;



    
public class Menu {
    
    Connection connection;
    StockManager stockmanager;
    CategotyManager categoryManager;
    Scanner sc = new Scanner (System.in);

    public Menu() throws ClassNotFoundException, SQLException {
        
        //Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Connect to database.
        String url = "jdbc:mysql://localhost/stockmanagementsystem?userTimeZone=UTC&serverTimeZone=UTC";
        Connection connection = DriverManager.getConnection(url, "root", "Tetfunds01.");

        
        stockmanager = new StockManager(connection);

        categoryManager = new CategotyManager(connection);
    }

    public void memumenu(){
        
        boolean running = true;
        do {
            System.out.println( "0 : Exit " );
            System.out.println( "1 : Show Category Menu" );
            System.out.println( "2 : Show Stock Menu \n\n" );

            System.out.println("Input your action");
            int action = sc.nextInt();
            switch (action) {
                case 0:
                    System.out.println("System Exited successfully");
                    running = false;
                    break;
                case 1:
                    categorymenu();
                    break;
                case 2:
                    stkmenu();
                    break;
        
                default:
                System.out.println("Invalid Inputs");
                    break;
            }
        }
        while (running);
    }

    

    public void categorymenu() { 
        cat_actions();
        int cataction = sc.nextInt();
        switch (cataction) {
            case 0:
                clearScreen();
               // memumenu();
                
                break;
            case 1:
                clearScreen();
                header();
                categoryManager.createCategory();
                System.out.println("Created successfully");
                
                holdScreen();
                clearScreen();
            
                break;
            case 2:
                clearScreen();
                header();
                categoryManager.listcategory();
                holdScreen();
                clearScreen();
            
                break;
            case 3:
                clearScreen();
                header();
                categoryManager.getCategory();
                holdScreen();
                clearScreen();
        
                break;
            case 4:
                clearScreen();
                header();
                categoryManager.updatecategory();
                System.out.println("Update successful");
                clearScreen();
                    break;
            case 5:
                clearScreen();
                header();
                categoryManager. deletecategory();
                System.out.println("Category deleted successfully");
                holdScreen();
                clearScreen();
            
                break;
            default:
                System.out.println("Invalid input");
                holdScreen();
                clearScreen();
                stk_actions();
                break;
        }
        if (cataction != 0) {
            categorymenu();
        }
    }
    public static void cat_actions() {
        System.out.println("0. Go Back To Main Menu.");
        System.out.println("1. Create Category.");
        System.out.println("2. List All Category.");
        System.out.println("3. Find Category By Id.");
        System.out.println("4. Update Category.");
        System.out.println("5. Delete Category.");
        }
    static void header() {
        System.out.println("=================================================================================");
        System.out.println("===================================              ================================");
        System.out.println("========================      STOCK MANAGEMENT SYSTEM       =====================");
        System.out.println("===================================              ================================");
        System.out.println("=================================================================================");
    }





                           // S T O C K S // // S T O C K S // // S T O C K S // // S T O C K S // // S T O C K S //
    
        
        
    public void stkmenu() { 
        stk_actions();
        int stkaction = sc.nextInt();
        switch (stkaction) {
            case 0:
                clearScreen();
                header();
                //memumenu();
                break;
            case 1:
                clearScreen();
                header();
                stockmanager.createStock();
                holdScreen();
                clearScreen();
            
                                
                break;
            case 2:
                clearScreen();
                header();
                stockmanager.listallstk();
                holdScreen();
                clearScreen();               
                break;
            case 3:
                clearScreen();
                header();
                stockmanager.findStockById();
                holdScreen(); 
                clearScreen();          
                break;
            case 4:
                clearScreen();
                header();
                stockmanager.Updatestk();
                holdScreen();
                clearScreen();
                    break;
            case 5:
                clearScreen();
                header();
                stockmanager.deletestk();
                System.out.println("Deleted Successfully");
                clearScreen();

                break;           
            default:
            System.out.println("Invalid input");
                holdScreen();
                clearScreen();
                stk_actions();
                break;
        }
        if (stkaction != 0) {
             stkmenu();  
        }
    }
    public void stk_actions() {
        System.out.println("0. Go Back To Main Menu.");
        System.out.println("1. Create Stock.");
        System.out.println("2. List All Stock.");
        System.out.println("3. Find Stock By Id.");
        System.out.println("4. Update Stock.");
        System.out.println("5. Delete Stock.");
        }
    // void stkheader() {
    //     System.out.println("=================================================================================");
    //     System.out.println("===================================              ================================");
    //     System.out.println("========================      STOCK MANAGEMENT SYSTEM       ====================");
    //     System.out.println("===================================              ================================");
    //     System.out.println("=================================================================================");
    // }
       public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
       }      
    public void holdScreen() {
        try {
            System.out.println("press enter Key to continue");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
                                     
    }
}
