package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<ParkingTicket, Car> parkingCarTicket;

    public ParkingLot() {
        this.parkingCarTicket = new HashMap<>(10);
    }

    public Car getCar(ParkingTicket ticket) {
    return parkingCarTicket.remove(ticket);
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        if(parkingCarTicket.size()>10) return null;
        parkingCarTicket.put(parkingTicket, car);
        return parkingTicket;
    }

}
