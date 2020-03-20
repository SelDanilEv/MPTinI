package by.bstu.fit.poit.group4.selitsky;

public class Pickup extends AbstractCar {
    public Pickup(String mark, String description, int power, State state, State engstate, int cost, int rentcost) {
        super(mark, description, power, state, engstate, cost, rentcost);
    }

    @Override
    public String toString() {
        return "\n\nType - Pickup" +
                super.toString();
    }

    @Override
    public void Move() {
        if (IsAlive)
            System.out.println("Pickup moves " + Mark);
        else
            System.out.println("Pickup broke " + Mark);
    }
}
