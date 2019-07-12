package com.thoughtworks.tdd;

public class ParkingLot {
    private Car car;


    public Car getCar(ParkingTicket ticket) {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ParkingTicket park(Car car) {
        this.setCar(car);
        return null;
    }
}
