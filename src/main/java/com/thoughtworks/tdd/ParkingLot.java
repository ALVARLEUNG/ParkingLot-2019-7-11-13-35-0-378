package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {

    private HashMap<ParkingTicket, Car> parkingCarTicket;

    public ParkingLot() {
        this.parkingCarTicket = new HashMap<>(10);
    }

    public FetchCarResult getCar(ParkingTicket ticket) {
        FetchCarResult fetchCarResult = new FetchCarResult();
        fetchCarResult.setCar(parkingCarTicket.remove(ticket));
        return fetchCarResult;

    }

    public ParkingCarResult park(Car car) {
        ParkingCarResult parkingCarResult = new ParkingCarResult();
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingCarTicket.put(parkingTicket, car);
        parkingCarResult.setParkingTicket(parkingTicket);
        return parkingCarResult;
    }

    public HashMap<ParkingTicket, Car> getParkingCarTicket() {
        return parkingCarTicket;
    }

    public void setParkingCarTicket(HashMap<ParkingTicket, Car> parkingCarTicket) {
        this.parkingCarTicket = parkingCarTicket;
    }
}
