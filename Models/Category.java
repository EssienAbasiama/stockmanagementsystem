package Models;
import java.util.Date;
//import java.text.SimpleDateFormat;

public class Category extends Base {
    private String name;
    private String description;

    public String getName(){
        return name;
    }
    public void setName(String Name){
        this.name = Name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String Description){
        this.description = Description;
    }
    public Category(int id, String name, String description, Date Created_Time){

        this.id = id;
        this.name = name;
        this.description = description;
        this.created_Time = Created_Time;
            
    }

    public Category(){
        
    }

    @Override
    public String toString(){
        return id + "\t" + name + "\t" + description + "\t" + created_Time;
    }

    // public static Category toCategory(String categoryStr) throws Exception {
    //     String[] props = categoryStr.split("\t");
    //     int id = Integer.parseInt(props[0]);
    //     Date created_Time = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(props[3]);

    //     return new Category(id, props[1], props[2], created_Time);

    // }
}
