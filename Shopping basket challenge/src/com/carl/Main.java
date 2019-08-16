package com.carl;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s: stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket timsBasket = new Basket("Tim");
        reserveItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        reserveItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        if(reserveItem(timsBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }

        reserveItem(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        reserveItem(timsBasket, "juice", 4);
        reserveItem(timsBasket,"juice",50);
        reserveItem(timsBasket,"juice",32);
        reserveItem(timsBasket, "cup", 12);
        reserveItem(timsBasket, "bread", 1);
        unReserveItem(timsBasket,"juice",10);
        unReserveItem(timsBasket,"juice",25);
        System.out.println(timsBasket);
        System.out.println(" ");
        checkOut(timsBasket);

//        System.out.println(stockList);
//
//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);
//        stockList.Items().get("car").adjustStock(2000);
//        stockList.get("car").adjustStock(-1000);
//        System.out.println(stockList);
//        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }


    }

    public static int reserveItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We do not sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    public static boolean unReserveItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We do not sell " + item);
            return true;
        }
        if (stockList.unReserveStock(item,quantity)){
            System.out.println(quantity + " of " + stockItem.getName() + " unreserved");
            if (basket.removeFromBasket(stockItem)){
                System.out.println(stockItem.getName() + " removed from basket");
            }
        }
        return false;
    }

    public static void checkOut(Basket basket){
        for (StockItem item : basket.Items().keySet()){
            item.checkOutItem();
            System.out.println(item.getReserved() + " " + item.getName() + " sold.");
            System.out.println("New " + item.getName() + " stock level is: " + item.quantityInStock());
        }
        System.out.println(basket.getName() + "'s basket checked out.");
        basket = null;
    }
}
