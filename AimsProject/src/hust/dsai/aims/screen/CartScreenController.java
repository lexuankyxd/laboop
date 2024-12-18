package hust.dsai.aims.screen;

import hust.dsai.aims.cart.Cart;
import hust.dsai.aims.customer.CustomerUser;
import hust.dsai.aims.media.*;
import hust.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CartScreenController {
  private Cart cart;
  private CustomerUser user;
  private ObservableList<Media> showingList = FXCollections.observableArrayList();

  public CartScreenController(CustomerUser user) {
    super();
    this.user = user;
    this.cart = user.cart;
  }

  @FXML
  private TableView<Media> tblMedia;

  @FXML
  private TableColumn<Media, String> colMediaTitle;

  @FXML
  private TableColumn<Media, String> colMediaCategory;

  @FXML
  private TableColumn<Media, Double> colMediaCost;

  @FXML
  private Button btnPlay, btnRemove;

  @FXML
  private TextField tfFilter;

  @FXML
  private RadioButton radioBtnFilterId, radioBtnFilterTitle;

  @FXML
  private Button fillOrderBtn;

  @FXML
  private Label totalCartCost, totalCheckoutCost;

  @FXML
  private VBox checkoutVBox;

  @FXML
  private HBox playingHBox;

  @FXML
  private Label titleLabel, lengthLabel;

  @FXML
  private MenuItem addBookItem, addCDItem, addDVDItem, viewStoreItem, viewCartItem;

  @FXML
  private void initialize() {
    colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Double>("cost"));
    tblMedia.setItems(this.cart.itemsOrdered);
    totalCartCost.textProperty().set("" + cart.totalCost());
    btnPlay.setVisible(false);
    btnRemove.setVisible(false);

    tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
      @Override
      public void changed(ObservableValue<? extends Media> observableValue, Media oldVal, Media newVal) {
        if (newVal != null) {
          updateButtonBar(newVal);
        }
      }

      void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
      }
    });
    tfFilter.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        showFilteredMedia(t1);
      }

      void showFilteredMedia(String filter) {
        if (filter == null || filter.isEmpty()) {
          showingList.addAll(cart.itemsOrdered);
          return;
        }
        showingList.clear();
        if (radioBtnFilterId.isSelected())
          try {
            for (Media media : cart.itemsOrdered) {
              if (media.getId() == Integer.parseInt(filter)) showingList.add(media);
            }
          } catch (NumberFormatException e) {
            return;
          }
        else
          for (Media media : cart.itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(filter.toLowerCase())) showingList.add(media);
          }
        tblMedia.setItems(showingList);
      }
    });
  }

  @FXML
  void removeButtonPressed(ActionEvent event) {
    Media media = tblMedia.getSelectionModel().getSelectedItem();
    cart.removeMedia(media);
    totalCartCost.textProperty().set("" + cart.totalCost());
  }

  @FXML
  void playButtonPressed(ActionEvent event) {
    Media media = tblMedia.getSelectionModel().getSelectedItem();
    titleLabel.textProperty().set(media.getTitle());
    lengthLabel.textProperty().set("" + ((Disc) media).getLength());
    // TODO not applied to CD, should reimplement to works with tracks
    playingHBox.setVisible(true);
  }

  @FXML
  void fillOrderButtonPressed(ActionEvent event) {
    user.placeOrder();
    checkoutVBox.setVisible(true);
    totalCheckoutCost.textProperty().set("" + cart.totalCost());
  }

  @FXML
  void addBookMenuPressed(ActionEvent event) {

  }

  @FXML
  void addDVDMenuPressed(ActionEvent event) {

  }

  @FXML
  void addCDMenuPressed(ActionEvent event) {

  }

  @FXML
  void viewStorePressed(ActionEvent event) {
    AimsSystemScreen.changeScene(StoreScreen.getScene());
  }

  @FXML
  void viewCartPressed(ActionEvent event) {
    return;
  }
}
