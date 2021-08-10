/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

/**
 *
 * @author Hammed
 */
public class CityTour extends TourPackage {
    private boolean withGuide;
    private double guideCost;
    private final String POUND = "\u00A3";

    public CityTour(boolean withGuide, double guideCost, String description, String location, double tourCost) {
        super(description, location, tourCost);
        this.withGuide = withGuide;
        this.guideCost = guideCost;
    }
    
    public double getGuideCost() {
        return guideCost;
    }
    
    public void updateGuideCost(double amount){
        if(amount > this.guideCost) {
            this.guideCost = amount;
        }
    }

    public boolean isWithGuide() {
        return withGuide;
    }

    @Override
    public String toString() {
        if(withGuide) return "A city tour in " + super.getLocation() +" with a total cost of "+ this.getCost() + POUND + " including a personal guide";
        return "A city tour in " + super.getLocation() +" with a total cost of "+ this.getCost() + POUND;
    }
    
    @Override
    public double getCost () {
        double cost = 0.0;
        if(withGuide){
            cost = super.getTourCost() + guideCost;
        }else {
            cost = super.getTourCost();
        }
        return cost;
    }
    
    
}
