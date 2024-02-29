package flyweight;

import java.util.HashMap;

/**
 * @author Ruobing Shang 2022-10-04 16:35
 */
public class Restaurant {
    private static final HashMap<String, Food> foodMap = new HashMap<>();

    public static Food serve(String name) {
        if (foodMap.containsKey(name)) {
            System.out.print("Already owned ");
            return foodMap.get(name);
        }
        System.out.print("Making ");
        Food food = new Food(name);
        foodMap.put(name, food);
        return food;
    }
}
