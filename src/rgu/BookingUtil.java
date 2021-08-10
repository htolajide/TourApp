/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Hammed
 */
public class BookingUtil {
    public double[] calculateBill(ArrayList<Booking> bookings, Tourist tourist){
        ArrayList<Booking> touristBookings = new ArrayList();
        for(Booking booking : bookings){
            if (booking.getTourist().equals(tourist)) touristBookings.add(booking);
        }
        Collections.sort(touristBookings);
        double totalBill = 0.0;
        double discountedBill = 0.0;
        for (Booking booking : touristBookings) {
            totalBill += booking.getTourPackage().getCost();
            if (touristBookings.size() > 10) discountedBill += booking.getTourPackage().getCost()*0.5;
            else {
                switch(touristBookings.indexOf(booking)){
                    case 0:
                        discountedBill += booking.getTourPackage().getCost();
                    break;
                    case 1:
                        discountedBill += booking.getTourPackage().getCost()*0.1;
                    break;
                    case 2:
                        discountedBill += booking.getTourPackage().getCost()*0.15;
                    break;
                    case 3:
                        discountedBill += booking.getTourPackage().getCost()*0.2;
                    break;
                    case 4:
                        discountedBill += booking.getTourPackage().getCost()*0.25;
                    break;
                    case 5:
                        discountedBill += booking.getTourPackage().getCost()*0.3;
                    break;
                    case 6:
                        discountedBill += booking.getTourPackage().getCost()*0.35;
                    break;
                    case 7:
                        discountedBill += booking.getTourPackage().getCost()*0.4;
                    break;
                    case 8:
                        discountedBill += booking.getTourPackage().getCost()*0.45;
                    break;
                    case 9:
                        discountedBill += booking.getTourPackage().getCost()*0.5;
                
                }
            }
        }
        double[] bill = {totalBill, discountedBill};
        return bill;
    }
}
