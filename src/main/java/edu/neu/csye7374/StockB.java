package edu.neu.csye7374;

public class StockB extends StockAPI implements Tradable {
    private int metric;
    private int buyCount;
    private int sellCount;
    private StockStrategy strategy;
    private double lastBid; // Track last bid value

    public StockB(String id, double price, String description) {
        super(id, price, description);
        this.metric = 5;  // Default metric value
        this.buyCount = 0;
        this.sellCount = 0;
        this.strategy = new BearMarketStrategy(); // Default strategy
        this.lastBid = 0.0;
    }

    public void setStrategy(StockStrategy strategy) {
        this.strategy = strategy;
    }

    public double getLastBid() {
        return lastBid;
    }

    @Override
    public void setBid(String bid) {
        double bidPrice = Double.parseDouble(bid);
        lastBid = bidPrice; // Store last bid value

        if (bidPrice > 0) {
            buyCount++;
            metric += 3; // Increase metric for buy bids
        } else {
            sellCount++;
            metric = Math.max(1, metric - 1); // Prevent metric from going below 1
        }
        
        adjustPrice(); // Ensure strategy is only applied once
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
            return metric; // Keep metric unchanged if buyCount == sellCount
        }
        return Math.max(1, metric + tempDiff); // Prevent division issues
    }
}