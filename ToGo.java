
 
 public class ToGo extends PizzaOrder {

    /*
     * default const
     */
    public ToGo() {

    }

    /*
     * non-default const
     * 
     * @param customerName, pizzaSize, numberOfToppings, toppingPrice
     */
    public ToGo(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
    }
}
