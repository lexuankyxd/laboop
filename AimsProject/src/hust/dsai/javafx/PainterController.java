package hust.dsai.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
  @FXML
  private Pane drawingAreaPane;
  private Color color = Color.BLACK;
  @FXML
  void clearButtonPressed(ActionEvent event) {
    drawingAreaPane.getChildren().clear();
  }

  @FXML
  void drawingAreaMouseDragged(MouseEvent event) {
    Circle circle = new Circle(event.getX(), event.getY(), 4, color);
    drawingAreaPane.getChildren().add(circle);
  }

  @FXML
  void setColorBlack(ActionEvent event){
    color = Color.BLACK;
  }

  @FXML
  void setColorWhite(ActionEvent event){
    color = Color.WHITE;
  }
}
