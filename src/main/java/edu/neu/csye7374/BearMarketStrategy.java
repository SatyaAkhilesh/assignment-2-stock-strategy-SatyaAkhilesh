package edu.neu.csye7374;

public class BearMarketStrategy implements StockStrategy {
    @Override
    public void adjustPrice(StockAPI stock) {
        double adjustmentFactor = (stock.getMetric() * 0.3); // Less aggressive increase
        stock.setPrice(stock.getPrice() - adjustmentFactor);
    }
}