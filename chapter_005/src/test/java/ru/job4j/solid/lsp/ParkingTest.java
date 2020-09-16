package ru.job4j.solid.lsp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingTest {

    protected final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void whenNoFreePlaceForTruckThanParkIntoCarPlace() {
        Parking parking = new Parking(5, 1);
        Truck truck0 = new Truck("Toyota Dyna", "t000", 2);
        Truck truck1 = new Truck("Toyota Hiace", "t001", 2);
        parking.park(truck0);
        assertThat(parking.getTrucks()[0].getNumber(), is("t000"));
        parking.park(truck1);
        assertThat(parking.getCars()[0].getNumber(), is("t001"));
        assertThat(parking.getCars()[1].getNumber(), is("t001"));
    }

    @Test
    public void whenParkCarAndNoPlaceForTruck() {
        Parking parking = new Parking(1, 0);
        Truck truck0 = new Truck("Toyota Dyna", "t000", 2);
        Car car0 = new Car("Toyota Vista", "c000", 1);
        parking.park(car0);
        assertThat(parking.getCars()[0].getNumber(), is("c000"));
        parking.park(truck0);
        assertThat(output.toString(), is("No place!"));

    }

    @Test
    public void whenPlaceForTruckIntoCarPlaces() {
        Parking parking = new Parking(4, 0);
        Truck truck0 = new Truck("Toyota Dyna", "t000", 3);
        Car car0 = new Car("Toyota Vista", "c000", 1);
        parking.park(car0);
        parking.park(truck0);
        assertThat(parking.getCars()[0].getNumber(), is("c000"));
        assertThat(parking.getCars()[1].getNumber(), is("t000"));
        assertThat(parking.getCars()[2].getNumber(), is("t000"));
        assertThat(parking.getCars()[3].getNumber(), is("t000"));
    }

    @Test
    public void whenNoPlaceForCarIntoCarPlaces() {
        Parking parking = new Parking(3, 0);
        Truck truck0 = new Truck("Toyota Dyna", "t000", 3);
        Car car0 = new Car("Toyota Vista", "c000", 1);
        parking.park(truck0);
        parking.park(car0);
        assertThat(output.toString(), is("No place!"));
    }
}