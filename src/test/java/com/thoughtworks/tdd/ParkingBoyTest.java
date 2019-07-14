package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingBoyTest {

    @Test
    public void should_return_car_when_fetch_car_given_have_ticket_by_parking_the_car() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car);

        //When
        FetchCarResult fetchCarResult = parkingBoy.fetchCar(parkingCarResult.getParkingTicket());

        // Then
        Assertions.assertSame(car, fetchCarResult.getCar());
    }

    @Test
    public void should_return_null_when_fetch_car_given_have_no_ticket_to_fetch_the_car() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car);

        //When
        FetchCarResult fetchCarResult = parkingBoy.fetchCar(null);

        // Then
        Assertions.assertSame(null, fetchCarResult.getCar());

    }

    @Test
    public void should_return_car_when_fetch_car_given_ticket_to_fetch_the_car() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingCarResult parkingCarResult1 = parkingBoy.parkCar(car1);
        ParkingCarResult parkingCarResult2 = parkingBoy.parkCar(car2);

        //When
        FetchCarResult fetchCarResult1 = parkingBoy.fetchCar(parkingCarResult1.getParkingTicket());
        FetchCarResult fetchCarResult2 = parkingBoy.fetchCar(parkingCarResult2.getParkingTicket());


//        // Then
        Assertions.assertSame(car1, fetchCarResult1.getCar());
        Assertions.assertSame(car2, fetchCarResult2.getCar());

    }

    @Test
    public void should_return_no_car_when_fetch_car_given_wrong_ticket_to_fetch_the_car() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        Car car1 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car1);

        //When
        FetchCarResult fetchCarResult = parkingBoy.fetchCar(new ParkingTicket());

        // Then
        Assertions.assertSame(null, fetchCarResult.getCar());

    }

    @Test
    public void should_return_no_car_when_fetch_car_given_used_ticket_to_fetch_the_car() {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car);

        //When
        FetchCarResult fetchCarResult1 = parkingBoy.fetchCar(parkingCarResult.getParkingTicket());
        FetchCarResult fetchCarResult2 = parkingBoy.fetchCar(parkingCarResult.getParkingTicket());

        // Then
        Assertions.assertSame(null, fetchCarResult2.getCar());

    }

    @Test
    public void should_return_no_ticket_when_parking_car_given_more_then_limit_cars() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            parkingBoy.parkCar(new Car());
        }

        //When
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(new Car());

        // Then
        Assertions.assertSame(null, parkingCarResult.getParkingTicket());
    }


    @Test
    public void should_return_no_ticket_when_parking_car_given_no_car() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        //When
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(null);

        // Then
        Assertions.assertSame(null, parkingCarResult.getParkingTicket());
    }

    @Test
    public void should_return_message_about_unrecognized_ticket_when_fetch_car_given_wrong_ticket() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        Car car1 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car1);

        //When
        FetchCarResult fetchCarResult = parkingBoy.fetchCar(new ParkingTicket());

        // Then
        Assertions.assertSame("Unrecognized parking ticket", fetchCarResult.getResultMessage());
    }


    @Test
    public void should_return_message_about_provide_ticket_when_fetch_car_given_have_no_ticket() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        Car car1 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car1);

        //When
        FetchCarResult fetchCarResult = parkingBoy.fetchCar(null);

        // Then
        Assertions.assertSame("Please provide your parking ticket", fetchCarResult.getResultMessage());
    }

    @Test
    public void should_return_message_about_not_enough_position_when_parking_car_given_no_position() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            parkingBoy.parkCar(new Car());
        }

        //When
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(new Car());

        // Then
        Assertions.assertSame("Not enough position.", parkingCarResult.getResultMessage());
    }

    @Test
    public void should_return_ticket_when_parking_car_given_11_cars() {
        //Given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            parkingBoy.parkCar(new Car());
        }
        Car car = new Car();

        //When
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car);

        // Then
        Assertions.assertNotNull(parkingCarResult.getParkingTicket());
    }

    @Test
    public void should_return_ticket_and_park_the_car_in_first_lot_when_parking_car_by_smart_boy_given_first_lot_more_empty_then_second_lot() {
        //Given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);


        Car car1 = new Car();
        HashMap<ParkingTicket, Car> parkingCarTicket = new HashMap<>();
        parkingCarTicket.put(new ParkingTicket(), car1);
        parkingLot2.setParkingCarTicket(parkingCarTicket);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);


        //When
        Car car2 = new Car();
        ParkingCarResult parkingCarResult = smartParkingBoy.parkCar(car2);

        // Then
        Assertions.assertTrue(parkingLot1.getParkingCarTicket().containsKey(parkingCarResult.getParkingTicket()));
    }


    @Test
    public void should_park_the_car_in_second_lot_when_parking_car_by_super_smart_boy_given_first_larger_available_position_rate_then_second_lot() {
        //Given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        Car car1 = new Car();
        HashMap<ParkingTicket, Car> parkingCarTicket = new HashMap<>();
        parkingCarTicket.put(new ParkingTicket(), car1);
        parkingCarTicket.put(new ParkingTicket(), new Car());
        parkingLot1.setParkingCarTicket(parkingCarTicket);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //When
        Car car2 = new Car();
        ParkingCarResult parkingCarResult = superSmartParkingBoy.parkCar(car2);

        // Then
        Assertions.assertTrue(parkingLot2.getParkingCarTicket().containsKey(parkingCarResult.getParkingTicket()));
    }


    //    @Ignore
    @Test
    public void should_return_ticket_when_manage1_add_parking_boy_to_park_car_given_2_parking_lot_and_have_ticket_by_parking_the_car() {

        // given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots1 = new ArrayList<>();
        List<ParkingLot> parkingLots2 = new ArrayList<>();
        parkingLots1.add(parkingLot1);

        Car car = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots1);


        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot1, parkingBoys);

        // when
        ParkingCarResult parkingCarResult = parkingLotManager.chooseParkingBoyToPark(parkingBoy, car);

        //then
        Assertions.assertTrue(parkingLot1.getParkingCarTicket().containsKey(parkingCarResult.getParkingTicket()));

    }

    @Test
    public void should_return_car_when_manage1_add_parking_boy_to_fetch_car_given_2_parking_lot_and_have_ticket_by_parking_the_car() {

        // given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots1 = new ArrayList<>();
        List<ParkingLot> parkingLots2 = new ArrayList<>();
        parkingLots1.add(parkingLot1);

        Car car = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots1);


        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot1, parkingBoys);

        // when
        ParkingCarResult parkingCarResult = parkingLotManager.chooseParkingBoyToPark(parkingBoy, car);

        //then
        FetchCarResult fetchCarResult = parkingLotManager.chooseParkingBoyToFetch(parkingBoy, parkingCarResult.getParkingTicket());

        Assertions.assertSame(car, fetchCarResult.getCar());

    }

    @Test
    public void should_return_car_when_manage_parking_car_fetch_car_given_2_parking_lot_and_have_ticket_by_parking_the_car() {

        // given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots1 = new ArrayList<>();
        List<ParkingLot> parkingLots2 = new ArrayList<>();
        parkingLots1.add(parkingLot1);

        Car car = new Car();

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot1);

        // when
        ParkingCarResult parkingCarResult = parkingLotManager.parkingCar(car);

        //then
        FetchCarResult fetchCarResult = parkingLotManager.fetchCar(parkingCarResult.getParkingTicket());

        Assertions.assertSame(car, fetchCarResult.getCar());
    }

}
