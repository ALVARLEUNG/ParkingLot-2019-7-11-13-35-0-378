package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }


    public ParkingCarResult parkCar(Car car) {
        return this.parkingLot.park(car);
    }

    public FetchCarResult fetchCar(ParkingTicket ticket) {
        if (ticket == null){
            FetchCarResult fetchCarResult = new FetchCarResult();
            fetchCarResult.setResultMessage("Please provide your parking ticket");
            return fetchCarResult;
        }
        return parkingLot.getCar(ticket);
    }
}
