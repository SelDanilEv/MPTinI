package by.bstu.fit.poit.group4.selitsky.test;

import by.bstu.fit.poit.group4.selitsky.AbstractCar;
import by.bstu.fit.poit.group4.selitsky.Car;
import by.bstu.fit.poit.group4.selitsky.State;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Test
public class TryTest {
//    @Test
//    public void test(){
//        Assert.fail("Fail");
//    }

    Car TestCar = new Car("TestCar", "Descr", 100, State.normal, State.normal, 1500, 100);

    @Test
    public void testCarEngine(AbstractCar TestCar) {
        Assert.assertEquals(State.good, TestCar.CarEngine.EngineState, TestCar.Mark);
    }

    @Test
    public void testCarEngine() {
        Assert.assertEquals(State.normal, TestCar.CarEngine.EngineState, TestCar.Mark);
    }

    @AfterMethod
    @Test
    public void testCarIsAlive(AbstractCar car)
    {
        Assert.assertEquals(true,car.IsAlive,"Car don't alive");
    }
}
