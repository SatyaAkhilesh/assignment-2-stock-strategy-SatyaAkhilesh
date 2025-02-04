package edu.neu.csye7374;

public class BullMarketStrategy implements StockStrategy {
    @Override
    public void adjustPrice(StockAPI stock) {
        double adjustmentFactor = Math.max(stock.getMetric() * 0.6, 5); // Ensure a meaningful change
        
        // Check last bid: If negative, decrease price instead
        if (((StockB) stock).getLastBid() < 0) {
            stock.setPrice(stock.getPrice() - adjustmentFactor); // Decrease price for sell orders
        } else {
            stock.setPrice(stock.getPrice() + adjustmentFactor); // Increase price for buy orders
        }
    }
}