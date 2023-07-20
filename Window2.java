import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Window2{
    public static void display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Alert");
        Label lbl1 = new Label("The Order Proccessed Successfully");
        GridPane layout = new GridPane();
        Scene scene = new Scene(layout, 250, 100);
        Button ok;
        ok = new Button("OK");
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #FFFFFF;");
        ok.setPrefWidth(200);
       layout.add(lbl1, 0, 0);
        layout.add(ok, 0, 1);

        ok.setOnAction(e -> window.close());

        window.setScene(scene);
        window.showAndWait();
    }


}
