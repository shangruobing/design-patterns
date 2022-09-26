package builder;

/**
 * @author Ruobing Shang 2022-09-26 14:36
 */
public class MainApp {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();

        director.constructSportsCar(carBuilder);
        Car car = carBuilder.getProduct();
        System.out.println(car);

        director.constructCar(carBuilder);
        car = carBuilder.getProduct();
        System.out.println(car);

        carBuilder.setName("Ruobing").setSunroof(true).setSeats(8);
        car = carBuilder.getProduct();
        System.out.println(car);
    }
}
