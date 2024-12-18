package hust.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
  private TextField tfInput;
  private TextField tfOutput;
  private int sum = 0;

  public AWTAccumulator() {
    setLayout(new GridLayout());

    add(new Label("Enter an Integer: "));

    tfInput = new TextField(10);
    add(tfInput);
    tfInput.addActionListener(new TFInputListener());

    add(new JLabel("The Accumulated Sum is: "));

    tfOutput = new TextField(10);
    tfOutput.setEditable(false);
    add(tfOutput);

    setTitle("AWTAccumulator");
    setSize(350, 350);
    setVisible(true);
  }

  private class TFInputListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent evt){
      int numberIn = Integer.parseInt(tfInput.getText());
      sum+=numberIn;
      tfInput.setText("");
      tfOutput.setText(sum + "");
    }
  }

  public static void main(String[] args) {
    new AWTAccumulator();
  }
}
