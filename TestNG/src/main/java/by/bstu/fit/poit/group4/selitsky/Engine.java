package by.bstu.fit.poit.group4.selitsky;

import java.io.Serializable;

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
