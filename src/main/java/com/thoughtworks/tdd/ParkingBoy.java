package com.thoughtworks.tdd;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLots = parkingLot;
    }


    public ParkingCarResult parkCar(Car car) {
        if (null == car) return new ParkingCarResult();
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getParkingCarTicket().size() < 10) {
                return parkingLot.park(car);
            }
        }
        ParkingCarResult parkingCarResult = new ParkingCarResult();
        parkingCarResult.setResultMessage("Not enough position.");
        return parkingCarResult;
    }

    public FetchCarResult fetchCar(ParkingTicket ticket) {
        FetchCarResult fetchCarResult = new FetchCarResult();
        if (ticket == null) {
            fetchCarResult.setResultMessage("Please provide your parking ticket");
            return fetchCarResult;
        } else {
            for (ParkingLot parkingLot : parkingLots) {
                if (parkingLot.getParkingCarTicket().containsKey(ticket)) {
                    return parkingLot.getCar(ticket);
                }
            }
            fetchCarResult.setResultMessage("Unrecognized parking ticket");
            return fetchCarResult;
        }
    }
}
