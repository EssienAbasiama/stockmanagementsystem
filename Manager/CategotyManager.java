package Manager;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Scanner;

import Models.Category;

public class CategotyManager {
    
        Scanner sc = new Scanner(System.in);
        int correct = 0;

        Connection connection;

        public CategotyManager(Connection connection){
           this.connection = connection;
        }
        
        public void createCategory(){
    
            try{
                
                System.out.print("Enter category name: ");
                String name = sc.nextLine();
        
                System.out.print("Enter description: ");
                String description = sc.nextLine();

                Date createdTime = new Date(System.currentTimeMillis());

                //Create statement
                Statement statement = connection.createStatement();

                //Execute a statement
                int count = statement.executeUpdate("insert into category(name, description, created_time) values('"+name+"', '"+description+"', '"+createdTime+"')");

                if(count > 0){
                    System.out.println("Category created successfully.");
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        
        }

        public List<Category> getAll(){

            List<Category> categories = new ArrayList<>();
            try {
                //Create the statement.
                Statement statement = connection.createStatement();

                //Execute the statement.
                ResultSet resultSet = statement.executeQuery("select * from category");

                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    Date createdTime = resultSet.getDate(4);
                    Category category = new Category(id, name, description, createdTime);
                    categories.add(category);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return categories;
        }

        public void listcategory() {
            System.out.println("Heres your category listing");

            List<Category> categories = getAll();
            for (Category category : categories) { 
                printCategory(category);
            }

        }

        public void getCategory() {
            System.out.println("Input your Id");
            int id = sc.nextInt();

            Category category = find(id);
            if(category == null){
                System.out.println(" The category with the id does not exist.");
            }else{
                printCategory(category);
            }
        }

        public void printCategory(Category c) {
            System.out.println (c.getId() + "\t\t\t\t\t\t " + c.getName() + "\t\t\t\t\t\t " + c.getDescription() + "\t\t\t\t\t\t " + c.getCreated_Time());
        }

        public Category find(int id) {
            
            Category category = null;
            try {
                //Create the statement.
                Statement statement = connection.createStatement();

                //Execute the statement.
                ResultSet resultSet = statement.executeQuery("select * from category where id = '"+id+"' ");

                while(resultSet.next()){
                    String name = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    Date createdTime = resultSet.getDate(4);
                    category = new Category(id, name, description, createdTime);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return category;
        }

        public void deletecategory() {
            System.out.println("Input your Id");
           
            int id = sc.nextInt();

            try {
                //Create statement
                Statement statement = connection.createStatement();

                //Execute a statement
                int count = statement.executeUpdate("delete from category where id = '"+id+"' ");

                if(count > 0){
                    System.out.println("Category deleted successfully.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }

        public void updatecategory() {
            System.out.println("Input Id of category to update: ");
            int id = sc.nextInt();
            Category category = find(id);
            if(category == null){
                System.out.println("Category with the id does not exist.");
            }
            else{
                try {
                    System.out.print("Input name of category: ");
                    String name = sc.nextLine();
                    System.out.print("Input description of category: ");
                    String description = sc.nextLine();

                    //Create statement
                    Statement statement = connection.createStatement();
    
                    //Execute a statement
                    int count = statement.executeUpdate("update category set name = '"+name+"', description = '"+description+"'  where id = '"+id+"' ");
    
                    if(count > 0){
                        System.out.println("Category udated successfully.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
            
        
    
}
