import javax.swing.JOptionPane;

public class ChosenOption {
  public void showDefaultConfirmationOptions(){
    int option = JOptionPane.showConfirmDialog(null, "Do you want first class ticket?");
    JOptionPane.showMessageDialog(null, "You've chosen: " + (option==JOptionPane.YES_OPTION?"Yes":"No"));
  }
  public void showCustomizedOptions(){
    String[] options = {"What", "Who", "Chika Chika", "Slim shady"};
    int input = JOptionPane.showOptionDialog(null, "My name is?", "My question",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
            options, options[0]);
    JOptionPane.showMessageDialog(null, "You've chosen: " + (input == JOptionPane.YES_OPTION ? "Yes" : "No"));
    System.exit(0);
  }
  public static void main(String[] args) {


  }
}
