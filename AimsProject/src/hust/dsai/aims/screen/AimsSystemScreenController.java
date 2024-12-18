package hust.dsai.aims.screen;

import hust.dsai.aims.customer.CustomerUser;
import hust.dsai.aims.store.Store;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AimsSystemScreenController {
  private CartScreen cartScreen;
  private StoreScreen storeScreen;
  public AimsSystemScreenController(Store store, CustomerUser user) {
    super();
    cartScreen = new CartScreen(user);
    storeScreen = new StoreScreen(store);
  }

  @FXML
  void loadCartScene(ActionEvent event) {
    AimsSystemScreen.changeScene(CartScreen.getScene());
  }

  @FXML
  void loadStoreScene(ActionEvent event) {
    AimsSystemScreen.changeScene(StoreScreen.getScene());
  }

  @FXML
  void initialize() {
  }
}
