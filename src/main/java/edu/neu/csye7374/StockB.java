package edu.neu.csye7374;

public class StockB extends StockAPI implements Tradable {
    private int metric;
    private int buyCount;
    private int sellCount;
    private StockStrategy strategy;

    public StockB(String id, double price, String description) {
        super(id, price, description);
        this.metric = 5;  // Default metric value
        this.buyCount = 0;
        this.sellCount = 0;
        this.strategy = new BearMarketStrategy(); // Default to Bear Market
    }

    public void setStrategy(StockStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void setBid(String bid) {
        double bidPrice = Double.parseDouble(bid);
        
        if (bidPrice > 0) {
            buyCount++;
            metric += 3; // Increase metric for positive bids
        } else {
            sellCount++;
            metric = Math.max(1, metric - 1); // Prevent metric from becoming zero or negative
        }
        
        adjustPrice();
    }

    private void adjustPrice() {
        if (strategy != null) {
            strategy.adjustPrice(this);
        }
    }

    @Override
    public int getMetric() {
        int tempDiff = buyCount - sellCount;
        
        if (tempDiff == 0) {
            return metric; // Instead of returning 0, keep the existing metric
        }
        
        return Math.max(1, metric / Math.abs(tempDiff)); // Prevent division by zero or extreme drops
    }
}