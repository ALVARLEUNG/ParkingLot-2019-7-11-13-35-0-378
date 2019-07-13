package com.thoughtworks.tdd;

public class ParkingLot {
    private Car car;
    private ParkingTicket parkingTicket;


    public Car getCar(ParkingTicket ticket) {
        return (ticket == this.parkingTicket) ? this.car : null;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ParkingTicket park(Car car) {
        this.setCar(car);
        return new ParkingTicket();
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }
}
