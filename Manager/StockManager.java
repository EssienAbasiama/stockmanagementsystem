package Manager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Stock;

public class StockManager {
    
    Scanner sc = new Scanner(System.in);
    int correct = 0;

    Connection connection;

    public StockManager(Connection connection){
        this.connection = connection;
    }

    public void createStock() {
        try{
            System.out.println ("Input name");
            String name = sc.nextLine();

            System.out.println ("Input CostPrice");
            Double costPrice = sc.nextDouble();

            System.out.println("Input SellingPrice");
            Double sellingPrice = sc.nextDouble();

            System.out.println ("Input Quantity Purchased");
            int quantity = sc.nextInt();

            Date created_Time = new Date(System.currentTimeMillis());

            //Create statement
            Statement statement = connection.createStatement();

            //Execute a statement
            int count = statement.executeUpdate("insert into Stock(name, costPrice,sellingPrice, quantity,created_Time) values('"+name+"', '"+costPrice+"', '"+sellingPrice+"','"+quantity+"','"+created_Time+"')");
            if (count > 0) {
                System.out.println ("Stocks created successfully");
            }  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void listallstk() {
        List<Stock> arrstocks = new ArrayList<Stock>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from stock"); 
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Double costPrice = resultSet.getDouble(3);
                Double sellingPrice = resultSet.getDouble(4);
                int quantity = resultSet.getInt(5);
                Date created_Time = resultSet.getDate(6);

                Stock stock = new Stock(id, name, costPrice, sellingPrice,quantity, created_Time);
                arrstocks.add(stock);
            }   
            for (Stock stock : arrstocks) {
                printStock(stock);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void printStock(Stock stk) {
        String x = stk.getId() + "\t\t\t" + stk.getName() + "\t\t\t " + stk.getCostPrice() + "\t\t\t " + stk.getSellingPrice() + "\t\t\t" + stk.getCreated_Time();
        System.out.println (x);
    }

    public Stock find(int id) {
            
        Stock stock = null;
        try {
            //Create the statement.
            Statement statement = connection.createStatement();

            //Execute the statement.
            ResultSet resultSet = statement.executeQuery("select * from stock where id = '"+id+"' ");

            while(resultSet.next()) {
                String name = resultSet.getString(2);
                Double costPrice = resultSet.getDouble(3);
                Double sellingPrice = resultSet.getDouble(4);
                int quantity = resultSet.getInt(5);
                Date created_Time = resultSet.getDate(6);
                stock = new Stock(id, name, costPrice, sellingPrice,quantity, created_Time);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stock;
    }
    public void findStockById() {
        System.out.println("Input your Id");
        int id = sc.nextInt();

        Stock stock = find(id);
        if(stock == null){
            System.out.println(" The category with the id does not exist.");
        }else{
            printStock(stock);
        }
    }
    public void Updatestk() {
        try{
            System.out.println("Input Id to be updated");
            int id = sc.nextInt();
            
            Statement statement = connection.createStatement();
            System.out.println ("Input name");
            String name = sc.nextLine();sc.nextLine();

            System.out.println ("Input CostPrice");
            Double costPrice = sc.nextDouble();

            System.out.println("Input SellingPrice");
            Double sellingPrice = sc.nextDouble();

            System.out.println ("Input Quantity Purchased");
            int quantity = sc.nextInt();

            //Date created_Time = new Date(System.currentTimeMillis());
            int count = statement.executeUpdate("update stock set name = '"+name+"', costPrice = '"+costPrice+"', costPrice = '"+costPrice+"', sellingPrice = '"+sellingPrice+"', quantity = '"+quantity+"', sellingPrice = '"+sellingPrice+"'  where id = '"+id+"' ");
            if (count > 0) {
                System.out.println("Update Successful");
            }
        }catch (Exception e) {
            e.getMessage();
        }
    }
    public void deletestk() {
        try {
            System.out.println("Input Id of Stock to be deleted ");
            int id = sc.nextInt();

            Stock stocks = find(id);
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate("Delete from Stock where id = '"+id+"'");
            if (count > 0) {
                System.out.println("Delete Successful");
            }

            printStock(stocks);
        }catch( Exception e) {
            e.getMessage();
        }
    }
}
