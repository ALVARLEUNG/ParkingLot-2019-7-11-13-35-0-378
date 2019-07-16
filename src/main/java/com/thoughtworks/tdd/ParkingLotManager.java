package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager extends ParkingBoy{

    private ParkingLot parkingLot;
    private List<ParkingBoy> parkingBoys;

    public ParkingLotManager(ParkingLot parkingLot, List<ParkingBoy> parkingBoys) {
        super(new ArrayList<ParkingLot>());
        this.parkingLot = parkingLot;
        this.parkingBoys = parkingBoys;
    }

    public ParkingLotManager(ParkingLot parkingLot) {
        super(new ArrayList<ParkingLot>());
        this.parkingLot = parkingLot;
    }

    @Override
    public ParkingCarResult parkCarInTheLot(Car car) {
        if (null != car) {
            if (parkingLot.getParkingCarTicket().size() < parkingLot.getLimit()) {
                return parkingLot.park(car);
            } else {
                ParkingCarResult parkingCarResult = new ParkingCarResult();
                parkingCarResult.setResultMessage("Not enough position.");
                return parkingCarResult;
            }
        }
        return new ParkingCarResult();
    }

    @Override
    public FetchCarResult fetchCarInTheLot(ParkingTicket ticket) {
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
            return parkingBoy.parkCarInTheLot(car);
        }
        return null;
    }

    public FetchCarResult chooseParkingBoyToFetch(ParkingBoy parkingBoy, ParkingTicket parkingTicket) {
        if (this.parkingBoys.contains(parkingBoy)) {
            return parkingBoy.fetchCarInTheLot(parkingTicket);
        }
        return null;
    }
}
