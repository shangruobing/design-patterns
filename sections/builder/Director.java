package builder;

/**
 * @author Ruobing Shang 2022-09-26 14:27
 */
public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setName("Sports Car")
                .setSeats(2)
                .setEngine("Engine A")
                .setSunroof(true);
    }

    public void constructCar(Builder builder) {
        builder.setName("Car")
                .setSeats(4)
                .setEngine("Common Engine")
                .setSunroof(false);
    }
}
