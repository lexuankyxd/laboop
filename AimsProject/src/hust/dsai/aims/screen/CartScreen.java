package hust.dsai.aims.screen;

import hust.dsai.aims.customer.CustomerUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class CartScreen {
  private CustomerUser user;
  private static Scene scene;
  public CartScreen(CustomerUser user) {
    super();

    this.user = user;
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/cart.fxml"));

      CartScreenController controller = new CartScreenController(user);
      fxmlLoader.setController(controller);
      Parent root = fxmlLoader.load();
      scene = new Scene(root);
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public static Scene getScene(){return scene;}
}