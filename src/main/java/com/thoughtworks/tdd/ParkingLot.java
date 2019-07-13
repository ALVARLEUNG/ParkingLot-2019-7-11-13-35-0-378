package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<ParkingTicket, Car> parkingCarTicket;

    public ParkingLot() {
        this.parkingCarTicket = new HashMap<>();
    }

    public Car getCar(ParkingTicket ticket) {
    return parkingCarTicket.get(ticket);
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingCarTicket.put(parkingTicket, car);
        return parkingTicket;
    }

}
