package com.thoughtworks.tdd;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingBoyTest {

    @Test
    public void  should_return_car_when_fetch_car_given_have_ticket_by_parking_the_car () {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car);

        //When
        FetchCarResult fetchCarResult = parkingBoy.fetchCar(parkingCarResult.getParkingTicket());

        // Then
        Assertions.assertSame(car, fetchCarResult.getCar());


    }

    @Test
    public void  should_return_null_when_fetch_car_given_have_no_ticket_to_fetch_the_car () {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car);

        //When
        FetchCarResult fetchCarResult = parkingBoy.fetchCar(null);

        // Then
        Assertions.assertSame(null, fetchCarResult.getCar());

    }

    @Test
    public void  should_return_car_when_fetch_car_given_ticket_to_fetch_the_car () {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
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
    public void  should_return_no_car_when_fetch_car_given_wrong_ticket_to_fetch_the_car () {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car1);

        //When
        FetchCarResult fetchCarResult = parkingBoy.fetchCar(new ParkingTicket());

        // Then
        Assertions.assertSame(null, fetchCarResult.getCar());

    }

    @Test
    public void  should_return_no_car_when_fetch_car_given_used_ticket_to_fetch_the_car () {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car);

        //When
        FetchCarResult fetchCarResult1 = parkingBoy.fetchCar(parkingCarResult.getParkingTicket());
        FetchCarResult fetchCarResult2 = parkingBoy.fetchCar(parkingCarResult.getParkingTicket());

        // Then
        Assertions.assertSame(null, fetchCarResult2.getCar());

    }

    @Test
    public void should_return_no_ticket_when_parking_car_given_more_then_limit_cars () {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        for (int i =0;i<=10;i++) {
            parkingBoy.parkCar(new Car());
        }

        //When
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(new Car());

        // Then
        Assertions.assertSame(null, parkingCarResult.getParkingTicket());
    }


    @Test
    public void should_return_no_ticket_when_parking_car_given_no_car () {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);

        //When
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(null);

        // Then
        Assertions.assertSame(null, parkingCarResult.getParkingTicket());
    }

    @Test
    public void should_return_message_about_unrecognized__ticket_when_fetch_car_given_wrong_ticket () {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car1);

        //When
        FetchCarResult fetchCarResult = parkingBoy.fetchCar(new ParkingTicket());

        // Then
        Assertions.assertSame("Unrecognized parking ticket", fetchCarResult.getResultMessage());
    }

    @Test
    public void should_return_message_about_provide_ticket_when_fetch_car_given_have_no_ticket () {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        ParkingCarResult parkingCarResult = parkingBoy.parkCar(car1);

        //When
        FetchCarResult fetchCarResult = parkingBoy.fetchCar(null);

        // Then
        Assertions.assertSame("Please provide your parking ticket", fetchCarResult.getResultMessage());
    }

    }
