package com.thoughtworks.tdd;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingCarResult parkCar(Car car) {
        if (null == car) return new ParkingCarResult();
        ParkingLot parkingLot = this.getParkingLots().stream().reduce((item, items) -> item.getParkingCarTicket().size() > items.getParkingCarTicket().size() ? items : item).orElse(null);
        if (parkingLot.getParkingCarTicket().size() < 10) {
            return parkingLot.park(car);
        }
        ParkingCarResult parkingCarResult = new ParkingCarResult();
        parkingCarResult.setResultMessage("Not enough position.");
        return parkingCarResult;
    }

}
