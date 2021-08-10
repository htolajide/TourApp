/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hammed
 */
public class TourApp {

    /**
     * @param args the command line arguments
     */
    
    private static final String POUND = "\u00A3";

    public static String getPOUND() {
        return POUND;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<TourPackage> tourPackages = new ArrayList();
        CityTour cityTour = new CityTour(true, 4500.0, "A city tour in california", "California USA", 10000.0);
        SightseeingTour sightseeingTour = new SightseeingTour(5000.0, "A sightseeing tour in canada", "Montreal Canada", 12000.0);
        tourPackages.add(cityTour);
        tourPackages.add(sightseeingTour);
        Tourist tourist = new Tourist("Mark Joe", "USA", AudioLanguage.ENGLISH);
        Date bookingDate = new Date();
        Booking firstBooking = new Booking(tourist, sightseeingTour, bookingDate);
        TourPackage customCityTour = new CityTour(false, 3500.0, "A custom city tour with no guide in India", "Taj Mahal India", 20000.0);
        Booking secondBooking = new Booking(tourist, customCityTour, new Date());
        ArrayList<Booking> bookings = new ArrayList();
        bookings.add(firstBooking);
        bookings.add(secondBooking);
        String billInfo = "\n A tour package added to TourApp: " + tourPackages.get(0).getDescription() + " with total cost of " + 
                           tourPackages.get(0).getCost() + POUND +" including a personal guide";
        billInfo += "\n A tour package added to TourApp: " + tourPackages.get(1).getDescription() + " with total cost of " + 
                     tourPackages.get(1).getCost() + POUND + " including tickets";
        billInfo += "\n "+ tourPackages.size() + " are available in tour packages";
        billInfo += "\n Tourist " + tourist.getName() + " added to TourApp!";
        billInfo += "\n "+tourist.getName() + ", booked " + bookings.get(0).getTourPackage().getDescription() + " with a total cost of "+ 
                    bookings.get(0).getTourPackage().getCost() + POUND +" including ticket on" + bookings.get(0).getDateTimeAsString();
        billInfo += "\n A custom tour package created for "+ tourist.getName() +" without a guide: " +
                    customCityTour.getDescription() + " with a cost of " + customCityTour.getCost() + POUND;
        billInfo += "\n A booking is created, " + secondBooking.getTourist().getName() + " booked " + secondBooking.getTourPackage().getDescription() +
                    " with a total cost of " + secondBooking.getTourPackage().getCost() + POUND +", on " + secondBooking.getDateTimeAsString();
        BookingUtil bookingUtil = new BookingUtil();
        double[] bill = bookingUtil.calculateBill(bookings, tourist);
        billInfo += "\n Total bill for " + tourist.getName() + ": " + bill[0] + POUND;
        billInfo += "\n Discounted bill for " + tourist.getName() + ": " + bill[1] + POUND;
        customCityTour.UpdateTourCost(30000.0);
        billInfo += "\n A custom tour package cost updated: " + customCityTour.getDescription() + " with total cost of " + customCityTour.getCost() + POUND;
        double[] newbill = bookingUtil.calculateBill(bookings, tourist);
        billInfo += "\n Total bill for " + tourist.getName() + ": " + newbill[0] + POUND;
        billInfo += "\n Discounted bill for " + tourist.getName() + ": " + newbill[1] + POUND;
        System.out.print(billInfo);
    }  
    
}
