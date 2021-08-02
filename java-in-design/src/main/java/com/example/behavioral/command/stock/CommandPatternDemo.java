package com.example.behavioral.command.stock;

import com.example.behavioral.command.stock.broker.Broker;
import com.example.behavioral.command.stock.order.BuyStock;
import com.example.behavioral.command.stock.order.SellStock;
import com.example.behavioral.command.stock.order.Stock;

public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
