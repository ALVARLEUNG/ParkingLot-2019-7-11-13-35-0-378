package com.thoughtworks.tdd;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingCarResult parkCar(Car car) {
        if (null == car) return new ParkingCarResult();
        ParkingLot parkingLot = this.getParkingLots().stream().reduce((item, items) -> (1-item.getParkingCarTicket().size()/10) > (1-items.getParkingCarTicket().size()/10) ? item : items).orElse(null);
        if (parkingLot.getParkingCarTicket().size() < 10) {
            return parkingLot.park(car);
        }
        ParkingCarResult parkingCarResult = new ParkingCarResult();
        parkingCarResult.setResultMessage("Not enough position.");
        return parkingCarResult;
    }
}
