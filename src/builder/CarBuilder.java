package builder;

/**
 * @author Ruobing Shang 2022-09-26 14:18
 */
public class CarBuilder implements Builder {
    private String name;
    private int seats;
    private String engine;
    private boolean sunroof;

    public Car getProduct() {
        Car car = new Car(this.name, this.seats, this.engine, this.sunroof);
        this.reset();
        return car;
    }

    @Override
    public void reset() {
        Car car = new Car();
        this.name = car.getName();
        this.seats = car.getSeats();
        this.engine = car.getEngine();
        this.sunroof = car.isSunroof();
    }

    @Override
    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Builder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public Builder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public Builder setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
        return this;
    }

}
