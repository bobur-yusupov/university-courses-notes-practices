package cakeshop;

import java.util.List;
import java.util.ArrayList;

public class CakeShop {
    private List<Cake> cakes = new ArrayList<>();
    private int totalSold = 0;
    
    public int countByColor(String color) {
        int totalCakes = 0;
        for (Cake cake : cakes) {
            if (cake.color.equals(color)) {
                totalCakes++;
            }
        }
        
        return totalCakes;
    }
    
    public double totalWorth() {
        double totalWorth = 0.0;
        
        for (Cake cake : cakes) {
            totalWorth += cake.cost;
        }
        
        return totalWorth;
    }
    
    public void registerNewCake(Cake newCake) {
        cakes.add(newCake);
    }
    
    public void sellCake(int index) {
        try {
            cakes.remove(index);
            totalSold ++;
        } catch (NullPointerException e) {
            System.out.printf("Could not remove the cake");
        }
    }
    
    public int getTotalSold() {
        return this.totalSold;
    }
    
}
