package hust.dsai.aims.screen;

import hust.dsai.aims.media.Media;
import hust.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OldStoreScreen extends JFrame {
  private Store store;
  public OldStoreScreen(Store store) {
    this.store = store;
    Container cp = getContentPane();
    cp.setLayout(new BorderLayout());

    cp.add(createNorth(), BorderLayout.NORTH);
    cp.add(createCenter(), BorderLayout.CENTER);

    setVisible(true);
    setTitle("Store");
    setSize(1024, 768);
  }

  JPanel createNorth(){
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(createMenuBar());
    panel.add(createHeader());
    return panel;
  }

  JMenuBar createMenuBar() {
    JMenu menu = new JMenu();

    JMenu smUpdateStore = new JMenu("Update Store");
    smUpdateStore.add(new JMenuItem("Add Book"));
    smUpdateStore.add(new JMenuItem("Add CD"));
    smUpdateStore.add(new JMenuItem("Add DVD"));

    menu.add(smUpdateStore);
    menu.add(new JMenuItem("View store"));
    menu.add(new JMenuItem("View cart"));

    JMenuBar menuBar = new JMenuBar();
    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
    menuBar.add(menu);

    return menuBar;
  }

  JPanel createHeader(){
    JPanel header = new JPanel();
    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

    JLabel title = new JLabel("AIMS");
    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
    title.setForeground(Color.CYAN);

    JButton cart = new JButton("View Cart");
    cart.setPreferredSize(new Dimension(100, 50));
    cart.setMaximumSize(new Dimension(100, 50));

    header.add(Box.createRigidArea(new Dimension(10, 10)));
    header.add(title);
    header.add(Box.createHorizontalGlue());
    header.add(cart);
    header.add(Box.createRigidArea(new Dimension(10, 10)));
    return header;
  }

  JPanel createCenter(){
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3,3,2,2));

    ArrayList<Media> mediaInStore = store.itemsInStore;
    for(int i = 0; i < Math.min(mediaInStore.size(), 9); i++){
      MediaScreen cell = new MediaScreen(mediaInStore.get(i));
      panel.add(cell);
    }
    return panel;
  }
}
