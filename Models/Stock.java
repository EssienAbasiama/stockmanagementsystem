package Models;

import java.sql.Date;

public class Stock extends Base {
    private String name;
    private Double costPrice;
    private Double sellingPrice;
    private int quantity;


    public String getName(){
        return name;
    }
    public void setName(String Name){
        this.name = Name;
    }

    public Double getCostPrice(){
        return costPrice;
    }

    public void setCostPrice(Double CostPrice) {
        this.costPrice = CostPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double SellingPrice) {
        this.sellingPrice = SellingPrice;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int Quantity) {
        this.quantity = Quantity;
    }
    
    public Stock(int id, String name, Double costPrice, Double sellingPrice, int quantity2, Date created_Time){

        this.id = id;
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity2;
        this.created_Time = created_Time;
 

    }
    public Stock(int id, String name2, Double costPrice2, Double sellingPrice2, Date created_Time) {
    }
    @Override
    public String toString() {
        return id + "\t" + name + "\t" + costPrice + "\t" + sellingPrice + "\t" + quantity;
    }
    // public static Stock toStock(String strArray) throws Exception {
    //     String[] props = strArray.split("\t");
    //     int id = Integer.parseInt(props[0]);
    //     Double costPrice = Double.parseDouble(props[2]);
    //     Double sellingPrice = Double.parseDouble(props[3]);
    //     int quantity = Integer.parseInt(props[4]);
        
    //     return new Stock(id, props[1], costPrice ,sellingPrice , quantity );

    // }
    

}
