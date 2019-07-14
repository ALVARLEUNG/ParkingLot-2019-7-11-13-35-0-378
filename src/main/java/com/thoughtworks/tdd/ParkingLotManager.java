package com.thoughtworks.tdd;

import java.util.List;

public class ParkingLotManager {

    private ParkingLot parkingLot;
    private List<ParkingBoy> parkingBoys;

    public ParkingLotManager(ParkingLot parkingLot, List<ParkingBoy> parkingBoys) {
        this.parkingLot = parkingLot;
        this.parkingBoys = parkingBoys;
    }

    public ParkingLotManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingCarResult parkingCar(Car car) {
        if (null != car) {
            if (parkingLot.getParkingCarTicket().size() < 10) {
                return parkingLot.park(car);
            } else {
                ParkingCarResult parkingCarResult = new ParkingCarResult();
                parkingCarResult.setResultMessage("Not enough position.");
                return parkingCarResult;
            }
        }
        return new ParkingCarResult();
    }

    public FetchCarResult fetchCar(ParkingTicket ticket) {
        FetchCarResult fetchCarResult = new FetchCarResult();
        if (ticket == null) {
            fetchCarResult.setResultMessage("Please provide your parking ticket");
            return fetchCarResult;
        } else {
            if (parkingLot.getParkingCarTicket().containsKey(ticket)) {
                return parkingLot.getCar(ticket);
            }
            fetchCarResult.setResultMessage("Unrecognized parking ticket");
            return fetchCarResult;
        }
    }

    public ParkingCarResult chooseParkingBoyToPark(ParkingBoy parkingBoy, Car car) {
        if (this.parkingBoys.contains(parkingBoy)) {
            return parkingBoy.parkCar(car);
        }
        return null;
    }

    public FetchCarResult chooseParkingBoyToFetch(ParkingBoy parkingBoy, ParkingTicket parkingTicket) {
        if (this.parkingBoys.contains(parkingBoy)) {
            return parkingBoy.fetchCar(parkingTicket);
        }
        return null;
    }
}
