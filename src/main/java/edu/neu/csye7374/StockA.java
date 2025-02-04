package edu.neu.csye7374;

public class StockA extends StockAPI implements Tradable {
    private int metric;
    private int buyCount;
    private int sellCount;
    private StockStrategy strategy;

    public StockA(String id, double price, String description) {
        super(id, price, description);
        this.metric = 10;
        this.buyCount = 0;
        this.sellCount = 0;
        this.strategy = new BullMarketStrategy(); // Default to Bull Market
    }

    public void setStrategy(StockStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void setBid(String bid) {
        double bidPrice = Double.parseDouble(bid);
        if (bidPrice > 0) {
            buyCount++;
        } else {
            sellCount++;
        }
        adjustPrice();
    }

    private void adjustPrice() {
        strategy.adjustPrice(this);
    }

    @Override
    public int getMetric() {
        int tempDiff = buyCount - sellCount;
        metric = metric + tempDiff;
        return (tempDiff > 0 && metric > 0) ? metric : -metric;
    }
}