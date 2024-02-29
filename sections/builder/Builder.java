package builder;

/**
 * @author Ruobing Shang 2022-09-26 14:12
 */
public interface Builder {
    /**
     * reset
     */
    void reset();

    /**
     * product name
     *
     * @param name name
     * @return current calling object
     */
    Builder setName(String name);

    /**
     * set seats
     *
     * @param quantity quantity
     * @return current calling object
     */
    Builder setSeats(int quantity);

    /**
     * set engine
     *
     * @param name name
     * @return current calling object
     */
    Builder setEngine(String name);

    /**
     * set sunroof
     *
     * @param install Install?
     * @return current calling object
     */
    Builder setSunroof(boolean install);
}
