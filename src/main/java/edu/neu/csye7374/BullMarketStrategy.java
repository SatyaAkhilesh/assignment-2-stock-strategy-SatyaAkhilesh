package edu.neu.csye7374;

public class BullMarketStrategy implements StockStrategy {
    @Override
    public void adjustPrice(StockAPI stock) {
        double adjustmentFactor = Math.max(stock.getMetric() * 0.6, 5); //
        
        
        if (((StockB) stock).getLastBid() < 0) {
            stock.setPrice(stock.getPrice() - adjustmentFactor); 
        } else {
            stock.setPrice(stock.getPrice() + adjustmentFactor); 
    }
}