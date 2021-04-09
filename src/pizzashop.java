import java.util.*;

public class pizzashop {

    public static void main(String[] args) {
        int[] pizzas = {800, 800, 800, 800};
        int[] toppings = {100};
        System.out.print(pizzashop(pizzas, toppings, 1000));
    }
    /*A pizza shop offers n pizzas along with m toppings. A customer plans to spend around x coins. The customer should order exactly one pizza,
      and may order zero, one or two toppings.
      Each topping may be order only once. Given the lists of prices of available pizzas and toppings, what is the price closest
      to x of possible orders? Here, a price said closer to x when the difference from x is the smaller.
      Note the customer is allowed to make an order that costs more than x.
     */

    //Brute force
    static int pizzashop(int[] pizzas, int[] toppings, int x) {
        int dist = x;
        int output = pizzas[0];

        for (int i = 0; i < pizzas.length; i++) {
            //distances.add(pizzas[i]);
            if (Math.abs(pizzas[i] - x) <= dist) {
                if (pizzas[i] > output) {
                    dist = Math.abs(pizzas[i] - x);
                } else {
                    dist = Math.abs(pizzas[i] - x);
                    output = pizzas[i];
                }
            }
            for (int j = 0; j < toppings.length; j++) {
                if (Math.abs(pizzas[i] + toppings[j] - x) <= dist) {
                    if (pizzas[i] + toppings[j] > output) {
                        dist = Math.abs(pizzas[i] + toppings[j] - x);
                    } else {
                        dist = Math.abs(pizzas[i] + toppings[j] - x);
                        output = pizzas[i] + toppings[j];
                    }
                }
                //distances.add(pizzas[i]+toppings[j]-x);
            }
        }

        return output;
    }

    static int pizzashop2(int[] pizzas, int[] toppings, int x) {
        HashMap<Integer, LinkedList<Integer>> hmap = new HashMap<>();
        int max = 0;

        for (int i = 0; i < pizzas.length; i++) { //go through pizzas
            hmap.put(pizzas[i], new LinkedList<>());
            for (int k = 0; k < toppings.length; k++) {


            }
            return 0;
        }
        return 0;

}
}

