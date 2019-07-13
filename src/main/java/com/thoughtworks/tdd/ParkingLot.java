package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<ParkingTicket, Car> parkingCarTicket;

    public ParkingLot() {
        this.parkingCarTicket = new HashMap<>(10);
    }

    public FetchCarResult getCar(ParkingTicket ticket) {
        FetchCarResult fetchCarResult = new FetchCarResult();
        if (parkingCarTicket.get(ticket)==null) {
            fetchCarResult.setResultMessage("Unrecognized parking ticket");
            return fetchCarResult;
        } else {
            fetchCarResult.setCar(parkingCarTicket.remove(ticket));
            return fetchCarResult;
        }
    }

    public ParkingCarResult park(Car car) {
        ParkingCarResult parkingCarResult = new ParkingCarResult();
        if(parkingCarTicket.size()>10 || car == null) {
            parkingCarResult.setResultMessage("Not enough position.");
            return parkingCarResult;
        }else {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkingCarTicket.put(parkingTicket, car);
            parkingCarResult.setParkingTicket(parkingTicket);
            return parkingCarResult;
        }
    }

}
