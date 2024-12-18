package hust.dsai.aims.screen;

import hust.dsai.aims.store.Store;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class StoreScreen {
  private Store store;
  private static Scene scene;
  public StoreScreen(Store store) {
    super();

    this.store = store;
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/store.fxml"));

      StoreScreenController controller = new StoreScreenController(store);
      fxmlLoader.setController(controller);
      Parent root = fxmlLoader.load();
      scene = new Scene(root);
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public static Scene getScene(){return scene;}

}
