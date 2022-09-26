package builder;

/**
 * @author Ruobing Shang 2022-09-26 14:11
 */
public class Car {
    private final String name;
    private final int seats;
    private final String engine;
    private final boolean sunroof;

    public Car() {
        this.name = "Default Name";
        this.seats = 4;
        this.engine = "Default Engine";
        this.sunroof = false;
    }

    public Car(String name, int seats, String engine, boolean sunroof) {
        this.name = name;
        this.seats = seats;
        this.engine = engine;
        this.sunroof = sunroof;
    }

    public String getName() {
        return name;
    }

    public int getSeats() {
        return seats;
    }

    public String getEngine() {
        return engine;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", seats=" + seats +
                ", engine='" + engine + '\'' +
                ", sunroof=" + sunroof +
                '}';
    }
}
