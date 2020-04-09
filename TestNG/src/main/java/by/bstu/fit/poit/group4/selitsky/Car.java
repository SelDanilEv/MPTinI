package by.bstu.fit.poit.group4.selitsky;

public class Car extends AbstractCar {

    public Car(String mark, String description, int power, State state, State engstate, int cost, int rentcost) {
        super(mark, description, power, state, engstate, cost, rentcost);
    }

    @Override
    public String toString() {
        return "\n\nType - Car" +
                super.toString();
    }

    @Override
    public void Move() {
        if (IsAlive)
            System.out.println("Car moves " + Mark);
        else
            System.out.println("Car broke " + Mark);
    }
}
