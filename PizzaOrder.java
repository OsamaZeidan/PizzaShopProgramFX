

 import java.util.Date;

 public class PizzaOrder implements Comparable<PizzaOrder> {
     static final int SMALL = 1, MEDIUM = 2, LARGE = 3;
     private String customerName;
     private Date dateOrdered;
     private int pizzaSize;
     private int numberOfToppings;
     private double toppingPrice;
 
     /*
      * default const
      */
     public PizzaOrder() {
 
     }// end const()
 
     /*
      * non-default const
      * 
      * @param customerName, pizzaSize, numberOfToppings, toppingPrice
      */
     public PizzaOrder(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
         this.customerName = customerName;
         this.pizzaSize = pizzaSize;
         this.numberOfToppings = numberOfToppings;
         this.toppingPrice = toppingPrice;
         dateOrdered = new Date();
     }// end const()
 
     /*
      * this method to calculate the order price by the formula inside it.
      * 
      * @return oederPrice
      */
     public double calculateOrderPrice() {
         return this.numberOfToppings * this.toppingPrice * this.pizzaSize;
     }// end calculateOrderPrice()
     /*
      * this method to compare the objects by order price
      * 
      * @param PizzaOrder object
      * 
      * @return int (-1, 0, 1)
      */
 
     @Override
     public int compareTo(PizzaOrder o) {
         if (this.calculateOrderPrice() > o.calculateOrderPrice()) {
             return 1;
         } else if (this.calculateOrderPrice() < o.calculateOrderPrice()) {
             return -1;
         } else {
             return 0;
         }
     }
 
     /*
      * this method to print the customer's name and the order price
      */
     public void printOrderInfo() {
         System.out
                 .println("Customer's Name: " + this.getCustomerName() + "\nOrder Price: " + this.calculateOrderPrice());
     }// end printInfo()
 
     /*
      * this method to print the customer's name, date ordered, pizza size, number of
      * toppings, topping price, trip rate, zone, and order price
      * 
      * @return "Customer's Name: " + this.getCustomerName() + "\nDate ordered: " +
      * this.getDateOrdered() + "\nPizza Size: " + size + "\nNumber Of Toppings: " +
      * this.getNumberOfToppings() + "\nTopping Price: " + this.getToppingPrice();
      */
     public String toString() {
         String size;
         if (pizzaSize == 1) {
             size = "Small";
         } else if (pizzaSize == 2) {
             size = "Medium";
         } else {
             size = "Large";
         }
         return "Customer's Name: " + this.getCustomerName() + "\nDate ordered: " + this.getDateOrdered()
                 + "\nPizza Size: " + size + "\nNumber Of Toppings: " + this.getNumberOfToppings() + "\nTopping Price: "
                 + this.getToppingPrice();
     }// end toString()
 
     /*
      * this method to get the customer name
      * 
      * @return customerName
      */
     public String getCustomerName() {
         return this.customerName;
     }// end getCustomerName()
 
     /*
      * this method to set the customer name
      * 
      * @param customerName
      */
     public void setCustomerName(String customerName) {
         this.customerName = customerName;
     }// end setCustomerName()
 
     /*
      * this method to get the date ordered
      * 
      * @return new Date()
      */
     public Date getDateOrdered() {
 
         return new Date(dateOrdered.getYear(), dateOrdered.getMonth(), dateOrdered.getDay());
     }// end getDateOrdered()
 
     /*
      * this method to set the date ordered
      * 
      * @param dateOrdered
      */
     public void setDateOrdered(Date dateOrdered) {
         this.dateOrdered = dateOrdered;
     }// end setDateOrdered()
 
     /*
      * this method to get the pizza size
      * 
      * @return pizzaSize
      */
     public int getPizzaSize() {
         return this.pizzaSize;
     }// end getPizzaSize()
 
     /*
      * this method to set the pizza size
      * 
      * @param pizzaSize
      */
     public void setPizzaSize(int pizzaSize) {
         this.pizzaSize = pizzaSize;
     }// end setPizzaSize()
 
     /*
      * this method to get the number of toppings
      * 
      * @return numberOfToppings
      */
     public int getNumberOfToppings() {
         return numberOfToppings;
     }// end getNumberOfToppings()
 
     /*
      * this method to set the number of toppings
      * 
      * @param numberOfToppings
      */
     public void setNumberOfToppings(int numberOfToppings) {
         this.numberOfToppings = numberOfToppings;
     }// end setNumberOfToppings()
 
     /*
      * this method to get the topping price
      * 
      * @return toppingPrice
      */
     public double getToppingPrice() {
         return toppingPrice;
     }// end getToppingPrice()
 
     /*
      * this method to set the topping price
      * 
      * @param toppingPrice
      */
     public void setToppingPrice(double toppingPrice) {
         this.toppingPrice = toppingPrice;
     }// end setToppingPrice()
 
 }// end class
 
