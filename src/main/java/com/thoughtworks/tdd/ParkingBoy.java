package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }


    public ParkingTicket parkCar(Car car) {
        this.parkingLot.setParkingTicket(this.parkingLot.park(car));
        return this.parkingLot.getParkingTicket();
    }

    public Car fetchCar(ParkingTicket ticket) {
        return parkingLot.getCar(ticket);
    }
}
