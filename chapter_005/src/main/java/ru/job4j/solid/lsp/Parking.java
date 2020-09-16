package ru.job4j.solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Parking implements Park {

    private int carIndex = 0;
    private int truckIndex = 0;

    private Machine[] cars;

    private Machine[] trucks;

    public Parking(int carPlace, int truckPlace) {
        cars = new Machine[carPlace];
        trucks = new Machine[truckPlace];
    }

    public Machine[] getCars() {
        return cars;
    }

    public Machine[] getTrucks() {
        return trucks;
    }

    @Override
    public boolean accept(Machine machine) {
        boolean result = false;
        if (machine.getSize() == 1 && carIndex < cars.length) {
            result = true;
        }
        if (machine.getSize() > 1 && (truckIndex < trucks.length || cars.length - carIndex >= machine.getSize())) {
            result = true;
        }
        return result;
    }

    @Override
    public void park(Machine machine) {
        if (accept(machine)) {
            if (machine.getSize() == 1 || truckIndex >= trucks.length) {
                for (int i = machine.getSize(); i > 0; i--) {
                    cars[carIndex] = machine;
                    carIndex++;
                }
            } else if (truckIndex < trucks.length) {
                trucks[truckIndex] = machine;
                truckIndex++;
            }
        } else {
            System.out.print("No place!");
        }
    }
}
