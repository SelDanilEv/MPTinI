package by.bstu.fit.poit.group4.selitsky;

import java.io.Serializable;
import java.util.Comparator;

;

public abstract class AbstractCar implements IBreakable, IMovable, Serializable {
    private String Description;
    public String Mark;
    public int cost;
    public int rentcost;
    public State CarState;
    public Engine CarEngine;
    public boolean IsAlive = true;


    public class Engine implements IBreakable, Serializable {
        public State EngineState;
        public int power;
        public boolean IsAlive = true;

        public Engine(int power, State state) {
            this.power = power;
            EngineState = state;
        }

        public Engine(Engine eng) {
            this.EngineState = eng.EngineState;
            this.power = eng.power;
            this.IsAlive = eng.IsAlive;
        }

        @Override
        public void Break() {
            switch (EngineState) {
                case bad:
                    IsAlive = false;
                    break;
                case normal:
                    EngineState = State.bad;
                    break;
                case good:
                    EngineState = State.normal;
                    break;
            }
        }
    }

    public AbstractCar(String mark, String description, int power, State state, State engstate, int cost, int rentcost) {
        Mark = mark;
        Description = description;
        CarState = state;
        CarEngine = new Engine(power, engstate);
        this.cost = cost;
        this.rentcost = rentcost;
    }

    @Override
    public void Break() {
        switch (CarState) {
            case bad:
                IsAlive = false;
                break;
            case normal:
                CarState = State.bad;
                break;
            case good:
                CarState = State.normal;
                break;
        }
    }

    @Override
    public void Move() {
        if (IsAlive && CarEngine.IsAlive)
            System.out.println("Transport moves " + Mark);
        else
            System.out.println("Transport broke " + Mark);
    }

    @Override
    public String toString() {
        StringBuilder outtxt = new StringBuilder();
        outtxt.append("\nMark - ").append(Mark);
        outtxt.append("\nDescription - ").append(getDescription());
        outtxt.append("\nCost - ").append(cost);
        outtxt.append("\nRentCost - ").append(rentcost);
        outtxt.append("\nState - ").append(CarState);
        outtxt.append("\nAlive - ").append(IsAlive);
        outtxt.append("\nEngine info:");
        outtxt.append("\nState - ").append(CarEngine.EngineState);
        outtxt.append("\nPower - ").append(CarEngine.power);
        outtxt.append("\nAlive - ").append(CarEngine.IsAlive);

        return outtxt.toString();
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public static final Comparator<AbstractCar> COMPARE_BY_POWER = new Comparator<AbstractCar>() {
        @Override
        public int compare(AbstractCar o1, AbstractCar o2) {
            return o1.CarEngine.power - o2.CarEngine.power;
        }
    };

    public void setEngine(Engine eng) {
        this.CarEngine = new Engine(eng);
        this.IsAlive = true;
    }
}
