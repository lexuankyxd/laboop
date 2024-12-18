package hust.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Painter extends Application {
  @Override
  public void start(Stage stage) throws Exception{
    Parent root = FXMLLoader.load(getClass().getResource("Painter.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("Painter");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
