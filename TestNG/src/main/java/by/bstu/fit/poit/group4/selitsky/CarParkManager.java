package by.bstu.fit.poit.group4.selitsky;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class CarParkManager implements Serializable {
    public CarPark carPark;

    public CarParkManager() {
        carPark = new CarPark();
    }

    public CarParkManager(ArrayList<AbstractCar> cars) {
        carPark = new CarPark(cars);
    }

    public CarParkManager(CarPark park) {
        carPark = park;
    }

    public void setCarPark(CarPark carPark) {
        this.carPark = carPark;
    }

    public int getCost() {
        int rc = 0;
        for (AbstractCar car : carPark.carList) {
            rc += car.cost;
        }
        return rc;
    }

    public ArrayList<AbstractCar> findByPower(int min,int max){
        ArrayList<AbstractCar> rc = new ArrayList<AbstractCar>();
        for (AbstractCar car : carPark.carList){
            if(car.CarEngine.power>=min&&car.CarEngine.power<=max)
                rc.add(car);
        }
        return rc;
    }

    public ArrayList<AbstractCar> sortCarsByPower(){
        ArrayList<AbstractCar> rc = carPark.carList;
        Collections.sort(rc,AbstractCar.COMPARE_BY_POWER);
        return rc;
    }

}
