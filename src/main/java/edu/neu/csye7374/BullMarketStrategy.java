package edu.neu.csye7374;

public class BullMarketStrategy implements StockStrategy {
    @Override
    public void adjustPrice(StockAPI stock) {
        double adjustmentFactor = (stock.getMetric() * 0.6); // More aggressive increase
        stock.setPrice(stock.getPrice() + adjustmentFactor);
    }
}