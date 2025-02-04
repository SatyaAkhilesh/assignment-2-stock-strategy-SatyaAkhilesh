package edu.neu.csye7374;

public class PlayStockMarket {
    public static void simulateMarket() {
        StockMarket market = StockMarket.getInstance();

        StockFactory stockAFactory = StockAFactory.getInstance();
        StockFactory stockBFactory = StockBFactory.getInstance();
        StockA amazon = (StockA) stockAFactory.createStock("Amazon", 150.0, "Amazon Stock");
        StockB nvidia = (StockB) stockBFactory.createStock("NVIDIA", 100.0, "NVIDIA Stock");

        // Apply Bull Market to Amazon and Bear Market to Nvidia
        amazon.setStrategy(new BullMarketStrategy());
        nvidia.setStrategy(new BearMarketStrategy());

        // Bids
        String[] amazonBids = {"160.00", "-160.00", "140.00", "-150.00"};
        String[] nvidiaBids = {"105.00", "-95.00", "90.00", "100.00"};

        // Amazon Market Trends
        System.out.println("\n=== Amazon Market Trends (Bull Market) ===");
        for (String bid : amazonBids) {
            amazon.setBid(bid);
            market.addBid("Amazon: " + bid);
            System.out.println("Bid: " + bid + " | Price: " + amazon.getPrice());
        }

        // Nvidia Market Trends
        System.out.println("\n=== NVIDIA Market Trends (Bear Market) ===");
        for (String bid : nvidiaBids) {
            nvidia.setBid(bid);
            market.addBid("NVIDIA: " + bid);
            System.out.println("Bid: " + bid + " | Price: " + nvidia.getPrice());
        }
    }
}