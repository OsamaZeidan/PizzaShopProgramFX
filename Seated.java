

 public class Seated extends PizzaOrder {
    private double serviceCharge;
    private int numOfPeople;

    /*
     * default const
     */
    public Seated() {

    }

    /*
     * non-default const
     */
    public Seated(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge,
            int numOfPeople) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
        this.serviceCharge = serviceCharge;
        this.numOfPeople = numOfPeople;
    }

    /*
     * this method to calculate the order price by the formula inside it.
     * 
     * @return super.calculateOrderPrice() +
     * (this.getServiceCharge()*this.getNumOfPeople())
     */
    @Override
    public double calculateOrderPrice() {

        return super.calculateOrderPrice() + (this.getServiceCharge() * this.getNumOfPeople());
    }

    /*
     * this method to return the customer's name and the order price
     * 
     * @return super.toString() + "\nThe number of People is " +
     * this.getNumOfPeople() + "\nThe service Charge is " + this.getServiceCharge()
     * + "\nOrder Price: " + this.calculateOrderPrice()
     */
    @Override
    public String toString() {

        return super.toString() + "\nThe number of People is " + this.getNumOfPeople() + "\nThe service Charge is "
                + this.getServiceCharge() + "\nOrder Price: " + this.calculateOrderPrice();
    }

    /*
     * this method to get service charge
     * 
     * @return this.serviceCharge
     */
    public double getServiceCharge() {
        return this.serviceCharge;
    }

    /*
     * this method to set service charge
     * 
     * @param serviceCharge
     */
    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    /*
     * this method to get number of people
     * 
     * @return this.numOfPeople
     */
    public int getNumOfPeople() {
        return this.numOfPeople;
    }

    /*
     * this method to set number of people
     * 
     * @param numOfPeople
     */
    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

}
