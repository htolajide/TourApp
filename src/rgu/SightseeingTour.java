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
public class SightseeingTour extends TourPackage {
    private double ticketCost;
    private final String POUND = "\u00A3";

    public SightseeingTour(double ticketCost, String description, String location, double tourCost) {
        super(description, location, tourCost);
        this.ticketCost = ticketCost;
    }

    public double getTicketCost() {
        return ticketCost;
    }
    
    public void updateTicketCost(double amount) {
        if(amount > this.ticketCost){
            this.ticketCost = amount;
        }
    }

    @Override
    public String toString() {
        return "A sightseeing tour in and around " + super.getLocation() +" with a total cost of "+ this.getCost() + POUND + " including tickets";
    }
    
    @Override
    public double getCost(){
        return super.getTourCost() + this.ticketCost;
    }
}
