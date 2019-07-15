package com.thoughtworks.tdd;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingCarResult parkCar(Car car) {
        if (null == car) return new ParkingCarResult();
        ParkingLot parkingLot = this.getParkingLots().stream().reduce((item, items) -> (double)(1-item.getParkingCarTicket().size()/item.getLimit()) > (double) (1-items.getParkingCarTicket().size()/items.getLimit()) ? item : items).orElse(null);
        if (parkingLot.getParkingCarTicket().size() < 10) {
            return parkingLot.park(car);
        }
        ParkingCarResult parkingCarResult = new ParkingCarResult();
        parkingCarResult.setResultMessage("Not enough position.");
        return parkingCarResult;
    }
}
