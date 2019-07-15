package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {

    private int limit;
    private HashMap<ParkingTicket, Car> parkingCarTicket;

    public ParkingLot() {
        this.parkingCarTicket = new HashMap<>();
    }

    public ParkingLot(int limit) {
        this.limit = limit;
        this.parkingCarTicket = new HashMap<>();
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

    public int getLimit() {
        return limit;
    }
}
