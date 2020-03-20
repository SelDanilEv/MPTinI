package by.bstu.fit.poit.group4.selitsky;

public class Truck extends AbstractCar {
    public Truck(String mark, String description, int power, State state, State engstate, int cost, int rentcost) {
        super(mark, description, power, state, engstate, cost, rentcost);
    }

    @Override
    public String toString() {
        return "\n\nType - Truck" +
                super.toString();
    }

    @Override
    public void Move() {
        if (IsAlive)
            System.out.println("Truck moves " + Mark);
        else
            System.out.println("Truck broke " + Mark);
    }
}
