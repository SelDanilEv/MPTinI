package by.bstu.fit.poit.group4.selitsky;

import by.bstu.fit.poit.group4.selitsky.AbstractCar;
import by.bstu.fit.poit.group4.selitsky.Car;
import by.bstu.fit.poit.group4.selitsky.State;
import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class TryTest {

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("@BeforeMethod – аннотированный метод будет выполняться перед каждым тестовым методом.");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("@AfterMethod – аннотированный метод будет запускаться после каждого тестового метода.");
    }

    @BeforeGroups
    public void beforeGroups() throws Exception {
        System.out.println("BeforeGroups – аннотирует методы, которые будут выполняться перед первым методом в любой из указанных групп.");
    }

    @AfterGroups
    public void afterGroups() throws Exception {
        System.out.println("@AfterGroups – аннотируется методы, которые будут выполняться после всех методом в любом из указанных групп.");
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        System.out.println("@BeforeClass – указывает, что метод будет выполнен до всех тестовых методов тестового класса.");
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        System.out.println("@BeforeTest - аннотированный метод будет запускаться до всех тестовых методов.");
    }

    @AfterTest
    public void afterTest() throws Exception {
        System.out.println("@AfterTest – аннотированный метод будет запущен после всех тестовых методов, принадлежащих классам внутри тега <test>.");
    }

    @AfterClass
    public void afterClass() throws Exception {
        System.out.println("@AfterClass  – аннотированный метод будет запущен после всех тестовых методов в текущем классе.");
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
        System.out.println("@BeforeSuite – указывает, что данный метод будет запускаться перед любым методом тестового класса.");
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        System.out.println("@AfterSuite – указывает, что данный метод, будет запускаться после всех методов тестового класса.");
    }

//    @Test
//    public void test(){
//        Assert.fail("Fail");
//    }

    Car TestCar = new Car("TestCar", "Descr", 100, State.normal, State.normal, 1500, 100);

    @Test(enabled = false)
    public void testCarEngine(AbstractCar TestCar) {
        Assert.assertEquals(State.good, TestCar.CarEngine.EngineState, TestCar.Mark);
    }


    @Test
    public void testCarEngine() {
        Assert.assertEquals(State.normal, TestCar.CarEngine.EngineState, TestCar.Mark);
    }


    @Test
    public void testCarIsAlive() {
        Assert.assertEquals(true, TestCar.IsAlive, "Car don't alive");
    }

    @Test
    public void testCarIsAliveBeforeBroke() {
        TestCar.Break();
        TestCar.Break();
        Assert.assertEquals(false, TestCar.IsAlive, "Car don't alive");
    }

    @Test
    @BeforeClass
    public void testCarSetEngine() {
        Engine myEngine = new Engine(3500, State.normal);
        TestCar.setEngine(myEngine);

        Assert.assertEquals(TestCar.CarEngine.power, myEngine.power, "Different");
        Assert.assertTrue(TestCar.CarEngine.EngineState == myEngine.EngineState, "Different");
    }

    @Test
    public void testManagment() {
        CarPark park = new CarPark();
        park.add(TestCar);

        Assert.assertNotNull(park.carList.get(0), "Is null");
        Assert.assertSame(park.carList.get(0), TestCar, "Not same");
    }


    @Test(groups = {"unit1"})
    public void testFindByPower() throws Exception {
        CarPark park = new CarPark();
        Car R = new Car("TestCar", "Descr", 100, State.normal, State.normal, 1500, 100);
        Car RR = new Car("TestCar", "Descr", 150, State.normal, State.normal, 1500, 100);
        park.add(R);
        park.add(RR);
        CarParkManager manager = new CarParkManager();
        manager.setCarPark(park);
        CarPark rcPark = new CarPark(manager.findByPower(99, 101));
        Assert.assertNotNull(rcPark.carList.get(0));
        Assert.assertSame(rcPark.carList.get(0),R);
        Assert.assertNotSame(rcPark.carList.get(0),RR);
    }

    @Test(timeOut = 5000)
    public void testCompareCarListInPark() throws Exception {
        CarPark park = new CarPark();
        Car R = new Car("TestCar", "Descr", 100, State.normal, State.normal, 1500, 100);
        Car RR = new Car("TestCar", "Descr", 150, State.normal, State.normal, 1500, 100);
        park.add(R);
        park.add(RR);
        CarParkManager manager = new CarParkManager();
        manager.setCarPark(park);
        Assert.assertEquals(park.carList, manager.carPark.getCarList());
    }

    @Test(groups = {"unit1"})
    public void testSetCarPark() throws NullPointerException {
        CarPark park = new CarPark();
        Car R = new Car("TestCar", "Descr", 100, State.normal, State.normal, 1500, 100);
        Car RR = new Car("TestCar", "Descr", 150, State.normal, State.normal, 1500, 100);
        park.add(R);
        park.add(RR);
        CarParkManager manager = new CarParkManager();
        manager.setCarPark(park);

        Assert.assertEquals(park, manager.carPark);
    }

    @Test(enabled = false)
    public void testFail() throws Exception {
        Assert.fail("Fail but enable = false");
    }
}
