package hust.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingAccumulator extends JFrame {
  private JTextField tfInput;
  private JTextField tfOutput;
  private int sum = 0;

  public SwingAccumulator() {
    Container cp = getContentPane();
    cp.setLayout(new GridLayout());

    cp.add(new Label("Enter an Integer: "));

    tfInput = new JTextField(10);
    cp.add(tfInput);
    tfInput.addActionListener(new TFInputListener());

    cp.add(new JLabel("The Accumulated Sum is: "));

    tfOutput = new JTextField(10);
    tfOutput.setEditable(false);
    cp.add(tfOutput);

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
    new SwingAccumulator();
  }
}