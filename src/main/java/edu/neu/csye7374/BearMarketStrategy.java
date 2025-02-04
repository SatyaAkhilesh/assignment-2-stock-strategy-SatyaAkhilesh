package edu.neu.csye7374;

public class BearMarketStrategy implements StockStrategy {
    @Override
    public void adjustPrice(StockAPI stock) {
        double adjustmentFactor = Math.max(stock.getMetric() * 0.3, 3); // Ensure a minimum decrease
        stock.setPrice(stock.getPrice() - adjustmentFactor); // Price should only decrease in Bear Market
    }
}