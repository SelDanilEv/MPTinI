package by.bstu.fit.poit.group4.selitsky;

import java.io.Serializable;
import java.util.*;

public class CarPark implements Serializable {
    public ArrayList<AbstractCar> carList;

    public ArrayList<AbstractCar> getCarList() {
        return carList;
    }

    public CarPark() {
        carList = new ArrayList<AbstractCar>();
    }

    public CarPark(ArrayList<AbstractCar> carList) {
        this.carList = carList;
    }

    public boolean add(AbstractCar car) {
        try {
            carList.add(car);
        } catch (Exception e) {
            System.out.println("Add Error\n");
            return false;
        }
        System.out.println("Car was added " + car.Mark + '\n');
        return true;
    }

    public boolean remove(AbstractCar car) {
        try {
            carList.remove(car);
        } catch (Exception e) {
            System.out.println("Remove Error\n");
            return false;
        }
        System.out.println("Car was removed " + car.Mark + '\n');
        return true;
    }

    @Override
    public String toString() {
        StringBuilder txtout = new StringBuilder("------------\nCar park:");
        for(AbstractCar car : carList) {
            txtout.append(car.toString());
        }
        txtout.append("\n------------");
        return txtout.toString();
    }
}
