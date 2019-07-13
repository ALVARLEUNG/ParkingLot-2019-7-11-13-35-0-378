package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingBoyTest {

    @Test
    public void  should_return_car_when_fetch_car_given_have_ticket_by_parking_the_car () {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        ParkingTicket ticket = parkingBoy.parkCar(car);

        //When
        Car fetchCar = parkingBoy.fetchCar(ticket);

        // Then
        Assertions.assertSame(car, fetchCar);

    }

    @Test
    public void  should_return_null_when_fetch_car_given_have_no_ticket_to_fetch_the_car () {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        ParkingTicket ticket = parkingBoy.parkCar(car);

        //When
        Car fetchCar = parkingBoy.fetchCar(null);

        // Then
        Assertions.assertSame(null, fetchCar);

    }

    @Test
    public void  should_return_car_when_fetch_car_given_ticket_to_fetch_the_car () {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        ParkingTicket ticket1 = parkingBoy.parkCar(car1);
        ParkingTicket ticket2 = parkingBoy.parkCar(car2);

        //When
        Car fetchCar1 = parkingBoy.fetchCar(ticket1);
        Car fetchCar2 = parkingBoy.fetchCar(ticket2);


        // Then
        Assertions.assertSame(car1, fetchCar1);
        Assertions.assertSame(car2, fetchCar2);

    }

    @Test
    public void  should_return_no_car_when_fetch_car_given_wrong_ticket_to_fetch_the_car () {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        ParkingTicket ticket1 = parkingBoy.parkCar(car1);

        //When
        Car fetchCar1 = parkingBoy.fetchCar(new ParkingTicket());

        // Then
        Assertions.assertSame(null, fetchCar1);

    }

    @Test
    public void  should_return_no_car_when_fetch_car_given_used_ticket_to_fetch_the_car () {

        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);
        ParkingTicket ticket = parkingBoy.parkCar(car);

        //When
        Car fetchCar1 = parkingBoy.fetchCar(ticket);
        Car fetchCar2 = parkingBoy.fetchCar(ticket);

        // Then
        Assertions.assertSame(null, fetchCar2);

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
        ParkingTicket ticket = parkingBoy.parkCar(new Car());

        // Then
        Assertions.assertSame(null, ticket);
    }

    @Test
    public void should_return_no_ticket_when_parking_car_given_no_car () {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy (parkingLot);

        //When
        ParkingTicket ticket = parkingBoy.parkCar(null);

        // Then
        Assertions.assertSame(null, ticket);
    }


    }
