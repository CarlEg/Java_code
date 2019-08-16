package com.carl;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dev on 16/02/2016.
 */
public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock = 0;
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;  // or here (but you wouldn't normally do both).
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
        this.reserved = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getReserved() {
        return reserved;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public int checkOutItem(){
        this.quantityStock = this.quantityStock - this.reserved;
        return this.quantityStock;
    }

    public void setPrice(double price) {
        if(price > 0.0) {
            this.price = price;
        }
    }

    public int reserveItem(int quantity){
        if (this.quantityStock - quantity <0){
            System.out.println("There are " + this.quantityStock + " in stock please try again");
            return 0;
        }
        this.reserved +=quantity;
        System.out.println(this.reserved + " " + this.name + " reserved");
        System.out.println(this.quantityStock +" "+ this.name + " in stock");
        return this.reserved;
    }

    public boolean unReserveItem(int quantity){
        if (this.reserved<quantity){
            System.out.println("There are " + this.reserved + " reserved, please try again");
            return false;
        }
        this.reserved -=quantity;
        System.out.println(this.reserved + " left in reserved");
        return true;
    }

    public boolean checkReserves(int quantity){
        if (this.reserved + quantity<= this.quantityInStock()){
            return true;
        }
        System.out.println("Can not reserve ("+this.name+") more than is in stock\n" +
                "Stock: " + this.quantityStock + "\n" +
                "Reserved: " + this.reserved + "\n" +
                "Requested: " + quantity);
        System.out.println(" ");
        return false;
    }

    public boolean checkReturns(int quantity){
        if (this.reserved - quantity >=0){
            return true;
        }
        System.out.println("Can not unreserve " + quantity + " of " + this.name+"\n" +
                "Reserved: " + this.reserved + "\n" +
                "Requested: " + quantity);
        System.out.println(" ");
        return false;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if(newQuantity >=0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
       // System.out.println("Entering StockItem.equals");
        if(obj == this) {
            return true;
        }

        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
       // System.out.println("Entering StockItem.compareTo");
        if(this == o) {
            return 0;
        }

        if(o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
