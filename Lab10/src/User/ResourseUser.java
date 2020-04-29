package User;

public class ResourseUser {
    String name;
    double cost;

    public ResourseUser(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name + ' ' + cost;
    }
}
