
 public class Delivery extends PizzaOrder {
    private double tripRate;
    private int zone;

    /*
     * default const
     */
    public Delivery() {

    }// end const()

    /*
     * non-default const
     * 
     * @param customerName, pizzaSize, numberOfToppings, toppingPrice, tripRate,
     * zone
     */
    public Delivery(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double tripRate,
            int zone) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
        this.tripRate = tripRate;
        this.zone = zone;
    }// end const()

    /*
     * this method to calculate the order price by the formula inside it.
     * 
     * @return super.calculateOrderPrice() +
     * this.getTripRate()/100*super.calculateOrderPrice()*this.getZone()
     */
    @Override
    public double calculateOrderPrice() {

        return super.calculateOrderPrice() + this.getTripRate() / 100 * super.calculateOrderPrice() * this.getZone();
    }

    /*
     * this method to return the customer's name and the order price
     * 
     * @return super.toString() + "\nTrip rate: " + this.getTripRate() + "\nZone: "
     * + this.getZone() + "\nOrder Price: " + this.calculateOrderPrice()
     */
    @Override
    public String toString() {

        return super.toString() + "\nTrip rate: " + this.getTripRate() + "\nZone: " + this.getZone() + "\nOrder Price: "
                + this.calculateOrderPrice();
    }

    /*
     * this method to get trip price
     * 
     * @return tripPrice
     */
    public double getTripRate() {
        return tripRate;
    }// end getTripRate()

    /*
     * this method to set trip price
     * 
     * @param tripPrice
     */
    public void setTripRate(double tripRate) {
        this.tripRate = tripRate;
    }// end setTripRate()

    /*
     * this method to get zone
     * 
     * @return zone
     */
    public int getZone() {
        return zone;
    }// end getZone()

    /*
     * this method to set zone
     * 
     * @param zone
     */
    public void setZone(int zone) {
        this.zone = zone;
    }// end setZone()

}// end Driver class
