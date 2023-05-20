
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
 public class Main extends Application{
    ArrayList<PizzaOrder> orders = new ArrayList<PizzaOrder>();
    int size = 1;
    int toppingsPrice = 10;
    int toppingsNo = 0;
    int noOfPeople = 0;
    double serviceCharge = 0;
    double tripRate = 0;
    int zone = 0;
     public static void main(String[] args) {
         launch(args);
     }// end main()
     
 
     @Override
     public void start(Stage window) throws Exception {
        Image img = new Image("pizza.png");
      ImageView imgView = new ImageView(img);
        
        //Style & Design:
       

        //Order Layout:
        Stage window2 = new Stage();
        window2.setTitle("Orders");
        StackPane ordersPane = new StackPane();
        Scene scene2 = new Scene(ordersPane, 500, 500);
        TextArea ordersList = new TextArea();
        ordersList.setEditable(false);
        ordersList.setPrefSize(500, 500);
        ordersPane.getChildren().add(ordersList);
        window2.initModality(javafx.stage.Modality.APPLICATION_MODAL);

        //layout
        BorderPane bigLayout = new BorderPane();
        GridPane innerLayout = new GridPane();
        innerLayout.setStyle("-fx-background-color: #f85d7d");
        bigLayout.setCenter(innerLayout);
        BorderPane.setAlignment(innerLayout, Pos.CENTER);
        innerLayout.setAlignment(Pos.CENTER);
        Label title = new Label("Osama's Pizza Shop", imgView);
        title.setAlignment(Pos.CENTER);
        title.setFont(Font.font("cambria", 30));
        title.setPadding(new Insets(0, 0, 10, 0));
        BorderPane.setAlignment(title, Pos.CENTER);
        bigLayout.setTop(title);
        bigLayout.setStyle("-fx-background-color: #fef98f");
        bigLayout.setMinWidth(1050);
        bigLayout.setMinHeight(400);

        
        //Scene
        Scene scene = new Scene(bigLayout, 1050, 550);

        //First Scene:
        GridPane firstLayout = new GridPane();
        Scene firstScene = new Scene(firstLayout, 400, 200);
        Button next = new Button("Next");
        Label firstTitle = new Label("Osama's Pizza Shop", imgView);
        firstTitle.setAlignment(Pos.CENTER);
        firstTitle.setFont(Font.font("cambria", 30));
        firstTitle.setPadding(new Insets(0, 0, 10, 0));
        firstLayout.add(firstTitle, 0, 0);
        firstLayout.add(next, 0, 1);
        firstLayout.setAlignment(Pos.CENTER);
        next.setOnAction(e ->{
            window.setScene(scene);
            window.setFullScreen(true);
        });

        //Customer Name
        HBox nameBox = new HBox(30);
        HBox.setMargin(nameBox, new Insets(10, 10, 10, 10));
        nameBox.setAlignment(Pos.CENTER);
        Label nameLbl = new Label("Customer Name:");
        nameLbl.setFont(Font.font("cambria", 15));
        TextField nameTxt = new TextField();
        nameTxt.setPrefWidth(185);
        nameTxt.setPromptText("Customer Name:");
        nameBox.getChildren().addAll(nameLbl, nameTxt);

        //Delivery
        HBox deliveryBox = new HBox(10);
        Label tripRateLbl = new Label("Trip Rate:");
        tripRateLbl.setFont(Font.font("cambria", 15));
        TextField tripRateTxt = new TextField();
        tripRateTxt.setPromptText("Trip Rate:");
        Label zoneLbl = new Label("Zone:");
        zoneLbl.setFont(Font.font("cambria", 15));
        TextField zoneTxt = new TextField();
        zoneTxt.setPromptText("Zone:");
       // ComboBox<String> zoneBox = new ComboBox<String>();
        //zoneBox.getItems().addAll("1", "2", "3", "4");
        //zoneBox.setPromptText("Zone:");
        deliveryBox.getChildren().addAll(tripRateLbl, tripRateTxt, zoneLbl, zoneTxt);
        deliveryBox.setPadding(new Insets(10, 10, 10, 250));
        deliveryBox.setVisible(false);
        deliveryBox.setManaged(true);

        //Seated:
        HBox seatedBox = new HBox(10);
        Label noOfPeopleLbl = new Label("Number of People:");
        noOfPeopleLbl.setFont(Font.font("cambria", 15));
        TextField noOfPeopleTxt = new TextField();
        noOfPeopleTxt.setPrefWidth(120);
        noOfPeopleTxt.setPromptText("Number of People:");
        Label serviceChargeLbl = new Label("Service Charge:");
        serviceChargeLbl.setFont(Font.font("cambria", 15));
        TextField serviceChargeTxt = new TextField();
        serviceChargeTxt.setPrefWidth(120);
        serviceChargeTxt.setPromptText("Service Charge:");
        seatedBox.getChildren().addAll(noOfPeopleLbl, noOfPeopleTxt, serviceChargeLbl, serviceChargeTxt);
        seatedBox.setPadding(new Insets(10, 10, 10, 0));
        seatedBox.setAlignment(Pos.CENTER);
        seatedBox.setVisible(false);
        seatedBox.setManaged(true);

        //Order Type
        HBox orderTypeHBox = new HBox(30);
        orderTypeHBox.setPadding(new Insets(10, 10, 10, 250));
        orderTypeHBox.setAlignment(Pos.CENTER);
        Label orderTypeLbl = new Label("Order Type:");
        orderTypeLbl.setFont(Font.font("cambria", 15));
        ComboBox<String> orderTypeBox = new ComboBox<String>();
        orderTypeBox.getItems().addAll("To Go", "Seated", "Delivery");
        orderTypeBox.getSelectionModel().selectFirst();
        
        
        //Pizza Size
        HBox pizzaSizeBox = new HBox(30);
        pizzaSizeBox.setPadding(new Insets(5, 10, 30, 10));
        pizzaSizeBox.setAlignment(Pos.CENTER);
        ToggleGroup pizzaSizeBtnGroup = new ToggleGroup();
        Label pizzaSizeLbl = new Label("Pizza Size:");
        pizzaSizeLbl.setFont(Font.font("cambria", 15));
        RadioButton smallBtn, mediumBtn, largeBtn;
        smallBtn = new RadioButton("Small");
        mediumBtn = new RadioButton("Medium");
        largeBtn = new RadioButton("Large");
        smallBtn.setFont(Font.font("cambria", 15));
        mediumBtn.setFont(Font.font("cambria", 15));
        largeBtn.setFont(Font.font("cambria", 15));
        smallBtn.setToggleGroup(pizzaSizeBtnGroup);
        mediumBtn.setToggleGroup(pizzaSizeBtnGroup);
        largeBtn.setToggleGroup(pizzaSizeBtnGroup);
        smallBtn.setSelected(true);
        Separator s = new Separator();
        s.setOrientation(Orientation.HORIZONTAL);
        s.setPadding(new Insets(0, 10, 10, 10));
        pizzaSizeBox.getChildren().addAll(pizzaSizeLbl, smallBtn, mediumBtn, largeBtn);

        //Toppings
        HBox toppingsBox = new HBox(30);
        toppingsBox.setPadding(new Insets(10, 10, 10, 0));
        toppingsBox.setAlignment(Pos.CENTER);
        RadioButton addToppings = new RadioButton("Add Toppings");
        addToppings.setFont(Font.font("cambria", 15));
        ListView<CheckBox> toppingsList = new ListView<CheckBox>();
        toppingsList.setPrefWidth(200);
        toppingsList.setPrefHeight(100);
         CheckBox onions, olives, greenPeppers, cheese, mashroom, fries;
        onions = new CheckBox("Onions");
        olives = new CheckBox("Olives");
        greenPeppers = new CheckBox("Green Peppers");
        cheese = new CheckBox("Cheese");
        mashroom = new CheckBox("Mashroom");
        fries = new CheckBox("Fries");
        toppingsList.getItems().addAll(onions, olives, greenPeppers, cheese, mashroom, fries);
        toppingsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        toppingsList.setVisible(false);
        toppingsBox.getChildren().addAll(addToppings, toppingsList);
        orderTypeHBox.getChildren().addAll(orderTypeLbl, orderTypeBox, toppingsBox);


        //Buttons
        HBox btnsBox = new HBox(30);
        btnsBox.setPadding(new Insets(15, 10, 15, 10));
        btnsBox.setAlignment(Pos.CENTER);
        Button proccessOrder = new Button("Proccess Order");
        proccessOrder.setFont(Font.font("cambria", 15));
        Button printOrders = new Button("Print Orders");
        printOrders.setFont(Font.font("cambria", 15));
        Button reset = new Button("Reset");
        reset.setFont(Font.font("cambria", 15));
        reset.setPrefWidth(80);
        btnsBox.getChildren().addAll(proccessOrder, printOrders, reset);

        //Prices
        HBox pricesBox = new HBox(30);
        pricesBox.setPadding(new Insets(10, 10, 10, 10));
        pricesBox.setAlignment(Pos.CENTER);
        Label toppingPriceLbl = new Label("Toppings Price:");
        toppingPriceLbl.setFont(Font.font("cambria", 15));
        Label orderPriceLbl = new Label("Order Price:");
        orderPriceLbl.setFont(Font.font("cambria", 15));
        TextField toppingPriceTxt = new TextField();
        TextField orderPriceTxt = new TextField();
        toppingPriceTxt.setPromptText("Toppings Price: ");
        toppingPriceTxt.setText("10");
        orderPriceTxt.setPromptText("Order Price: ");
        orderPriceTxt.setEditable(false);
        pricesBox.getChildren().addAll(toppingPriceLbl, toppingPriceTxt, orderPriceLbl, orderPriceTxt);

        //Functionality:

        //Size Btns:
        smallBtn.setOnAction(e -> {
            if (smallBtn.isSelected()) {
                size = 1;                
            }
        });
        mediumBtn.setOnAction(e -> {
            if (mediumBtn.isSelected()) {
                size = 2;
            }
        });
        largeBtn.setOnAction(e -> {
            if (largeBtn.isSelected()) {
                size = 3;
            }
        });

        //Toppings Btns:
        onions.setOnAction(e ->{
            if(onions.isSelected()){
                toppingsNo++;
            }
            else{
               toppingsNo++;
            }
            });
             
            olives.setOnAction(e->{
                if(olives.isSelected()){
                    toppingsNo++;
                }
                else{
                    toppingsNo--;
                }
            });
            greenPeppers.setOnAction(e->{
                if(greenPeppers.isSelected()){
                    toppingsNo++;
                }
                else{
                    toppingsNo--;
                }
            });
            cheese.setOnAction(e->{
                if(cheese.isSelected()){
                    toppingsNo++;
                }
                else{
                    toppingsNo--;
                }
            });
            mashroom.setOnAction(e->{
                if(mashroom.isSelected()){
                    toppingsNo++;
                }
                else{
                    toppingsNo--;
                }
            });
            fries.setOnAction(e->{
                if(fries.isSelected()){
                    toppingsNo++;
                }
                else{
                    toppingsNo--;
                }
            });
            


        //Add Toppings Btn
        addToppings.setOnAction(e->{
            if(addToppings.isSelected()){
                toppingsList.setVisible(true);
            }
            else{
                toppingsList.setVisible(false);
                onions.setSelected(false);
                olives.setSelected(false);
                greenPeppers.setSelected(false);
                cheese.setSelected(false);
                mashroom.setSelected(false);
                fries.setSelected(false);
                toppingsNo = 0 ;
                
            }
        });

        //Order Type Box
        orderTypeBox.setOnAction(e ->{

            switch(orderTypeBox.getValue()){
                case "Delivery":
                    deliveryBox.setVisible(true);
                    seatedBox.setVisible(false);
                    tripRateTxt.setText("");
                    zoneTxt.setText("");
                    break;
                case "Seated":
                    deliveryBox.setVisible(false);
                    seatedBox.setVisible(true);
                    serviceChargeTxt.setText("");
                    noOfPeopleTxt.setText("");

                    break;
                default:
                    deliveryBox.setVisible(false);
                    seatedBox.setVisible(false);
                    break;
            }
           
        });
       
        //Buttons:
        //Reset:
        reset.setOnAction(e ->{
            nameTxt.clear();
            smallBtn.setSelected(false);
            mediumBtn.setSelected(false);
            largeBtn.setSelected(false);
            addToppings.setSelected(false);
            onions.setSelected(false);
            olives.setSelected(false);
            greenPeppers.setSelected(false);
            cheese.setSelected(false);
            mashroom.setSelected(false);
            fries.setSelected(false);
            toppingsList.setVisible(false);
            toppingsNo = 1;
            orderTypeBox.setValue("To Go");
            noOfPeopleTxt.clear();
            serviceChargeTxt.clear();
            tripRateTxt.clear();
            orderPriceTxt.clear();
            orders.removeAll(orders);
            ordersList.setText("");
           zoneTxt.setText("");
            deliveryBox.setVisible(false);
            seatedBox.setVisible(false);
            smallBtn.setSelected(true);
            toppingPriceTxt.setText("10");
        });

        //Proccess Order
        proccessOrder.setOnAction(e ->{
            toppingsPrice = Integer.parseInt(toppingPriceTxt.getText());
            if(orderTypeBox.getValue().equals("To Go")){
                ToGo toGoOrder = new ToGo(nameTxt.getText(), size, toppingsNo, toppingsPrice);
                orders.add(toGoOrder);
                orderPriceTxt.setText(Double.toString(toGoOrder.calculateOrderPrice()));
            }
            else if(orderTypeBox.getValue().equals("Seated")){
                noOfPeople = Integer.parseInt(noOfPeopleTxt.getText());
                serviceCharge = Double.parseDouble(serviceChargeTxt.getText());
                Seated seatedOrder = new Seated(nameTxt.getText(), size, toppingsNo, toppingsPrice, serviceCharge, noOfPeople);
                orders.add(seatedOrder);
                orderPriceTxt.setText(Double.toString(seatedOrder.calculateOrderPrice()));
            }
            else{
                zone = Integer.parseInt(zoneTxt.getText());
                tripRate = Double.parseDouble(tripRateTxt.getText());
                Delivery deliveryOrder = new Delivery(nameTxt.getText(), size, toppingsNo, toppingsPrice, tripRate, zone);
                orders.add(deliveryOrder);
                orderPriceTxt.setText(Double.toString(deliveryOrder.calculateOrderPrice()));
            }
            size = 1;
             toppingsPrice = 10;
             toppingsNo = 0;
             noOfPeople = 0;
             serviceCharge = 0;
             tripRate = 0;
             zone = 0;
                nameTxt.setText("");
                onions.setSelected(false);
                olives.setSelected(false);
                greenPeppers.setSelected(false);
                cheese.setSelected(false);
                mashroom.setSelected(false);
                fries.setSelected(false);
                addToppings.setSelected(false);
                toppingsList.setVisible(false);
                noOfPeopleTxt.setText("");
                serviceChargeTxt.setText("");
                tripRateTxt.setText("");
                zoneTxt.setText("");
                smallBtn.setSelected(true);
                Window2.display();

        });

        //Print Orders
        printOrders.setOnAction(e ->{
            ordersList.setText("");
            sortOrders(orders);
          
                        for(int i = 0; i < orders.size(); i++){
                ordersList.appendText("Customer Name: " + orders.get(i).getCustomerName() + "\n" + "Order Price: " + orders.get(i).calculateOrderPrice() + "\n_________________________________________________________\n");
            }
            window2.setScene(scene2);
            window2.showAndWait();
        });
        //Showing:
        s.setPrefWidth(200);
        innerLayout.add(nameBox, 0, 0);
        innerLayout.add(orderTypeHBox, 0, 1);
        innerLayout.add(pizzaSizeBox, 0, 2);
        innerLayout.add(s, 0, 4);
        innerLayout.add(deliveryBox, 0, 3);
        innerLayout.add(seatedBox, 0, 3);
        innerLayout.add(btnsBox, 0, 5);
        bigLayout.setBottom(pricesBox);
        window.setScene(firstScene);
        window.show();
     }
 
 
     /*
      * this method to sort the orders by the order price
      * 
      * @param list
      */
     public static void sortOrders(ArrayList<PizzaOrder> list) {
         Collections.sort(list);
     }// end sortOrders()
 
     /*
      * this method to calculate the total price of all orders
      * 
      * @param list
      * 
      * @return sum of order prices
      */
     public double calculateTotalPrices(ArrayList<PizzaOrder> list) {
         double sum = 0;
         for (PizzaOrder pizzaOrder : list) {
             sum += pizzaOrder.calculateOrderPrice();
         }
         return sum;
     }// end calculateOrderPrice()
 }// end class
 



 
 
