package edu.neu.csye7374;

public class PlayStockMarket {
    
    public static void simulateMarket() {
        System.out.println("Starting Stock Market Simulation...");

        // Creating Amazon stock in a Bull Market
        StockB amazonStock = new StockB("AMZN", 150.0, "Amazon Inc.");
        amazonStock.setStrategy(new BullMarketStrategy());

        System.out.println("\n=== Amazon Market Trends (Bull Market) ===");
        amazonStock.setBid("160.00");
        System.out.println("Bid: 160.00 | Price: " + amazonStock.getPrice());
        amazonStock.setBid("-160.00");
        System.out.println("Bid: -160.00 | Price: " + amazonStock.getPrice());
        amazonStock.setBid("150.00");
        System.out.println("Bid: 150.00 | Price: " + amazonStock.getPrice());
        amazonStock.setBid("-150.00");
        System.out.println("Bid: -150.00 | Price: " + amazonStock.getPrice());

        // Creating NVIDIA stock in a Bear Market
        StockB nvidiaStock = new StockB("NVDA", 100.0, "NVIDIA Corporation");
        nvidiaStock.setStrategy(new BearMarketStrategy());

        System.out.println("\n=== NVIDIA Market Trends (Bear Market) ===");
        nvidiaStock.setBid("105.00");
        System.out.println("Bid: 105.00 | Price: " + nvidiaStock.getPrice());
        nvidiaStock.setBid("-95.00");
        System.out.println("Bid: -95.00 | Price: " + nvidiaStock.getPrice());
        nvidiaStock.setBid("90.00");
        System.out.println("Bid: 90.00 | Price: " + nvidiaStock.getPrice());
        nvidiaStock.setBid("100.00");
        System.out.println("Bid: 100.00 | Price: " + nvidiaStock.getPrice());
    }
}