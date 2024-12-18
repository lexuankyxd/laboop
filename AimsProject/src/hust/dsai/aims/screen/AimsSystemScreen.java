package hust.dsai.aims.screen;

import hust.dsai.aims.customer.CustomerUser;
import hust.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class AimsSystemScreen extends JFrame {
  private CustomerUser user;
  private Store store;
  private static Scene scene;
  private static final JFXPanel fxPanel = new JFXPanel();

  public AimsSystemScreen(Store store, CustomerUser user) {
    super();
    this.add(fxPanel);
    this.store = store;
    this.user = user;
    this.setSize(1024, 768);
    this.setTitle("Aims System");
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Platform.runLater(() -> {
      try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/aims.fxml"));
        AimsSystemScreenController controller = new AimsSystemScreenController(store, user);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        fxPanel.setScene(scene);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }

  public static void changeScene(Scene scene) {
    fxPanel.setScene(scene);
  }

  public static Scene getScene() {return scene;}
}