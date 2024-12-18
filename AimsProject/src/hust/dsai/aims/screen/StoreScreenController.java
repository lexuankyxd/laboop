package hust.dsai.aims.screen;

import hust.dsai.aims.media.Media;
import hust.dsai.aims.store.Store;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class StoreScreenController {
  private Store store;

  @FXML
  private GridPane itemsGrid = new GridPane();

  @FXML
  private void initialize() {
    updateGrid();
  }

  public StoreScreenController(Store store) {
    this.store = store;
  }

  @FXML
  void addBookMenuPressed(ActionEvent event) {
    return;
  }

  @FXML
  void addCDMenuPressed(ActionEvent event) {
    return;
  }

  @FXML
  void addDVDMenuPressed(ActionEvent event) {
    return;
  }

  @FXML
  void viewStorePressed(ActionEvent event) {
    return;
  }

  @FXML
  void viewCartPressed(ActionEvent event) {
    AimsSystemScreen.changeScene(CartScreen.getScene());
    return;
  }

  public void updateGrid(){
    int i = 0;
    for(Media media: store.itemsInStore){
      MediaScreen cell = new MediaScreen(media);
      SwingNode t = new SwingNode();
      t.setContent(cell);
      itemsGrid.add(t, i, i);
    }
  }
}
