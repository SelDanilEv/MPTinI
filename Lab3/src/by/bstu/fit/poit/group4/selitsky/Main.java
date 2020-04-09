package by.bstu.fit.poit.group4.selitsky;

import by.bstu.fit.poit.group4.selitsky.test.TryTest;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //-----------------
        TryTest test = new TryTest();
        test.testCarEngine();
        //------------------
        AbstractCar SimpleCar = new Car("BMW", "Не плохое авто", 300, State.normal, State.good, 3000, 100);
        AbstractCar TruckCar = new Truck("Volvo", "Плохое состояние, мертвый двигатель", 40, State.bad, State.bad, 500, 10);
        AbstractCar PickupCar = new Pickup("Tesla", "Отличный авто", 400, State.good, State.good, 7000, 500);
        CarPark park = new CarPark();
        park.add(SimpleCar);
        park.add(TruckCar);
        park.add(PickupCar);

        CarParkManager manager = new CarParkManager();
        manager.setCarPark(park);

//        System.out.println(park.toString());

        manager.carPark.carList = manager.sortCarsByPower();

        System.out.println(manager.carPark.toString());

        CarPark rcPark = new CarPark(manager.findByPower(400,5000));

        System.out.println(rcPark.toString());

        System.out.println("   <<<test-drive>>>");
        for(AbstractCar car :manager.carPark.carList){
            for(int i=0;car.IsAlive;i++) {
                System.out.println("   try "+(i+1));
                car.CarEngine.Break();
                car.Break();
                car.Move();
            }
        }
        System.out.println("   >>>test-drive<<<");

//        StringWriter writer = new StringWriter();
//        ObjectOutputStream objectOS = new ObjectOutputStream(
//                new FileOutputStream("cars.xml"));
//        objectOS.writeObject(SimpleCar);
//        objectOS.writeObject(TruckCar);
//        objectOS.writeObject(PickupCar);
//        objectOS.close();
//
//        ObjectInputStream objectIS = new ObjectInputStream(
//                new FileInputStream("cars.xml"));
//        AbstractCar SimpleRestored = (AbstractCar) objectIS.readObject();
//        AbstractCar TruckRestored = (AbstractCar) objectIS.readObject();
//        AbstractCar PickupRestored = (AbstractCar) objectIS.readObject();
//        objectIS.close();
//
//        System.out.println(SimpleRestored);
//        System.out.println(TruckRestored);
//        System.out.println(PickupRestored);
    }
}
