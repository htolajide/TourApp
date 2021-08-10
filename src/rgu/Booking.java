/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Comparable;

/**
 *
 * @author Hammed
 */
public class Booking implements Comparable {
    private Tourist tourist;
    private TourPackage tourPackage;
    private Date dateTime;

    public Booking(Tourist tourist, TourPackage tourPackage, Date dateTime) {
        this.tourist = tourist;
        this.tourPackage = tourPackage;
        this.dateTime = dateTime;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public String getDateTimeAsString() {
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String stringDateTime = dateTimeFormatter.format(this.dateTime);
        return stringDateTime;
    }
    
    @Override
    public String toString() {
        return tourist.getName() + ", booked " + tourPackage.toString();
    }
    
    @Override
    public int compareTo(Object o) {
        if (((Booking) o).dateTime.before(this.dateTime)) return -1;
        else return 1;
        
    }
}
