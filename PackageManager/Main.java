package PackageManager;

import Manager.CategotyManager;
import java.sql.*;

public class Main {

    static CategotyManager categoryManager;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Menu menu = new Menu();
        Menu.header();
        menu.memumenu();

    }
    
}
