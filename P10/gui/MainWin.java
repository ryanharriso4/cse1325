package gui;

import store.*;
import javax.swing.JFrame; // for main window
import javax.swing.JOptionPane; // for standard dialogs
// import javax.swing.JDialog;          // for custom dialogs (for alternate About dialog)
import javax.swing.JMenuBar; // row of menu selections
import javax.swing.JMenu; // menu selection that offers another menu
import javax.swing.JMenuItem; // menu selection that does something
import javax.swing.JToolBar; // row of buttons under the menu
import javax.swing.JButton; // regular button
import javax.swing.JToggleButton; // 2-state button
import javax.swing.BorderFactory; // manufacturers Border objects around buttons
import javax.swing.Box; // to create toolbar spacer
import javax.swing.UIManager; // to access default icons
import javax.swing.JLabel;
import javax.swing.JPanel; // text or image holder
import javax.swing.ImageIcon; // holds a custom icon
import javax.swing.SwingConstants; // useful values for Swing method calls

import javax.imageio.ImageIO; // loads an image from a file

import java.io.File; // opens a file
import java.io.IOException; // reports an error reading from a file

import java.awt.BorderLayout; // layout manager for main window
import java.awt.FlowLayout; // layout manager for About dialog

import java.awt.Color; // the color of widgets, text, or borders
import java.awt.Font; // rich text in a JLabel or similar widget
import java.awt.image.BufferedImage; // holds an image loaded from a file

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SwingUtilities;
import javax.swing.JDialog;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;

public class MainWin extends JFrame {
  public MainWin(String title) {
    super(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 200);

    // /////// ////////////////////////////////////////////////////////////////
    // M E N U
    // Add a menu bar to the PAGE_START area of the Border Layout

    JMenuBar menubar = new JMenuBar();

    JMenu file = new JMenu("File");
    JMenuItem quit = new JMenuItem("Quit");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem saveAs = new JMenuItem("SaveAs");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem aNew = new JMenuItem("New");

    JMenu insert = new JMenu("Insert");
    JMenuItem customer = new JMenuItem("Customer");
    JMenuItem option = new JMenuItem("Option");
    JMenuItem computer = new JMenuItem("Computer");
    JMenuItem order = new JMenuItem("Order");

    JMenu view = new JMenu("View");
    JMenuItem customers = new JMenuItem("Customers");
    JMenuItem options = new JMenuItem("Options");
    JMenuItem computers = new JMenuItem("Computers");
    JMenuItem orders = new JMenuItem("Orders");

    JMenu help = new JMenu("Help");
    JMenuItem about = new JMenuItem("About");

    quit.addActionListener(event -> onQuitClick());
    save.addActionListener(event -> onSaveClick());
    saveAs.addActionListener(event -> onSaveAsClick());
    open.addActionListener(event -> onOpenClick());
    aNew.addActionListener(event -> onNewClick());

    customer.addActionListener(event -> onInsertCustomerClick());
    option.addActionListener(event -> onInsertOptionClick());
    computer.addActionListener(event -> onInsertComputerClick());
    order.addActionListener(event -> onInsertOrderClick());

    customers.addActionListener(event -> onViewClick(Record.CUSTOMER));
    options.addActionListener(event -> onViewClick(Record.OPTION));
    computers.addActionListener(event -> onViewClick(Record.COMPUTER));
    orders.addActionListener(event -> onViewOrderClick());

    about.addActionListener(event -> onAboutClick());

    file.add(quit);
    file.add(save);
    file.add(saveAs);
    file.add(open);
    file.add(aNew);
    insert.add(customer);
    insert.add(option);
    insert.add(computer);
    insert.add(order);
    view.add(customers);
    view.add(options);
    view.add(computers);
    help.add(about);

    menubar.add(file);
    menubar.add(insert);
    menubar.add(view);
    menubar.add(about);

    setJMenuBar(menubar);

    // ///////////// //////////////////////////////////////////////////////////
    // T O O L B A R
    // Add a toolbar to the PAGE_START region below the menu
    JToolBar toolbar = new JToolBar("ELSA Controls");

    // Create the 3 buttons using the icons provided

    JButton button1 = new JButton(new ImageIcon("gui/resources/InsertCustomer.png"));
    button1.setActionCommand("Add a customer");
    button1.setToolTipText("Add a customer");
    toolbar.add(button1);
    button1.addActionListener(event -> onInsertCustomerClick());

    JButton button2 = new JButton(new ImageIcon("gui/resources/InsertOption.png"));
    button2.setActionCommand("Add a Option");
    button2.setToolTipText("Add a option");
    toolbar.add(button2);
    button2.addActionListener(event -> onInsertOptionClick());

    JButton button3 = new JButton(new ImageIcon("gui/resources/InsertComputer.png"));
    button3.setActionCommand("Add a computer");
    button3.setToolTipText("Add a computer");
    toolbar.add(button3);
    button3.addActionListener(event -> onInsertComputerClick());

    toolbar.add(Box.createHorizontalStrut(25));

    JButton button4 = new JButton(new ImageIcon("gui/resources/ViewCustomers.png"));
    button4.setActionCommand("View Customer");
    button4.setToolTipText("View Customer");
    toolbar.add(button4);
    button4.addActionListener(event -> onViewClick(Record.CUSTOMER));

    JButton button5 = new JButton(new ImageIcon("gui/resources/ViewOptions.png"));
    button5.setActionCommand("View Option");
    button5.setToolTipText("View Option");
    toolbar.add(button5);
    button5.addActionListener(event -> onViewClick(Record.OPTION));

    JButton button6 = new JButton(new ImageIcon("gui/resources/ViewComputers.png"));
    button6.setActionCommand("Add Computer");
    button6.setToolTipText("Add Computer");
    toolbar.add(button6);
    button6.addActionListener(event -> onViewClick(Record.COMPUTER));

    getContentPane().add(toolbar, BorderLayout.PAGE_START);

    // /////////////////////////// ////////////////////////////////////////////
    // D I S P L A Y
    // Provide a text entry box to show the remaining sticks
    display = new JLabel();
    display.setFont(new Font("SansSerif", Font.BOLD, 18));
    display.setVerticalAlignment(JLabel.TOP);
    add(display, BorderLayout.CENTER);

    // S T A T U S B A R D I S P L A Y ////////////////////////////////////
    // Provide a status bar for game messages
    msg = new JLabel();
    add(msg, BorderLayout.PAGE_END);

    // Make everything in the JFrame visible
    setVisible(true);

  }

  // Listeners

  protected void onInsertCustomerClick() {

    JLabel nameLabel = new JLabel("<HTML><br/> Customer Name</HTML>");
    JTextField userName = new JTextField(20);
    JLabel emailLabel = new JLabel("<HTML><br/> Customer Email</HTML>");
    JTextField userEmail = new JTextField(20);

    Object[] objects = { nameLabel, userName, emailLabel, userEmail };

    int button = JOptionPane.showConfirmDialog(this,
        objects,
        "Customer Prompt",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);

    try {
      store.add(new Customer(userName.getText(), userEmail.getText()));
    } catch (IllegalArgumentException e) {
      if (!(button == JOptionPane.CANCEL_OPTION))
        JOptionPane.showMessageDialog(
            this,
            "The email that was entered is invalid.");
    }

  }

  protected void onInsertOptionClick() {
    JLabel name = new JLabel("<HTML><br/> Component </HTML>");
    JTextField componentName = new JTextField(20);
    JLabel price = new JLabel("<HTML><br/> Price </HTML>");
    JTextField inPrice = new JTextField(20);

    Object[] objects = { name, componentName, price, inPrice };

    int button = JOptionPane.showConfirmDialog(this,
        objects,
        "Customer Prompt",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);

    try {
      long fixedPrice = (long) (Double.parseDouble(inPrice.getText()) * 100);
      store.add(new Option(componentName.getText(), fixedPrice));
    } catch (IllegalArgumentException e) {
      if (!(button == JOptionPane.CANCEL_OPTION || button == JOptionPane.CLOSED_OPTION))
        JOptionPane.showMessageDialog(
            this,
            "The price that was entered is invalid.");
    }
  }

  protected void onInsertComputerClick() {
    try {
      Computer computer;
      JLabel name = new JLabel("<HTML><br/> Computer Name </HTML>");
      JTextField inName = new JTextField(20);
      JLabel model = new JLabel("<HTML><br/> Model </HTML>");
      JTextField inModel = new JTextField(20);

      Object[] objects = { name, inName, model, inModel };

      int button = JOptionPane.showConfirmDialog(this,
          objects,
          "Customer Prompt",
          JOptionPane.OK_CANCEL_OPTION,
          JOptionPane.PLAIN_MESSAGE);
      computer = new Computer(inName.getText(), inModel.getText());

      JComboBox<Object> cb = new JComboBox<>(store.options());
      int optionsAdded = 0;

      while (true) {
        int button2 = JOptionPane.showConfirmDialog(this, cb, "Another Option?", JOptionPane.YES_NO_OPTION);
        if (button2 != JOptionPane.YES_OPTION)
          break;
        computer.addOption((Option) cb.getSelectedItem());
        ++optionsAdded;
      }
      if (optionsAdded > 0)
        store.add(computer);
    } catch (NullPointerException e) {
    }

  }

  protected void onInsertOrderClick() {

  }

  protected void onViewOrderClick() {

  }

  protected void onViewClick(Record record) {
    Object[] values;

    if (record == Record.COMPUTER) {
      values = store.computers();
      StringBuilder s = new StringBuilder("<HTML><p><font size = +2> Computers </font</br></br><ol>");
      for (Object o : values)
        s.append("<li>" + o.toString().replaceAll("\n", "<br/>") + "</li>");
      s.append("</ol></HTML>");
      display.setText(s.toString());
    } else if (record == Record.CUSTOMER) {
      values = store.customers();
      StringBuilder s = new StringBuilder("<HTML><p><font size = +2> Customers </font</br></br><ol>");
      for (Object o : values)
        s.append("<li>" + o.toString().replaceAll("\n", "<br/>") + "</li>");
      s.append("</ol></HTML>");
      display.setText(s.toString());
    } else {
      values = store.options();
      StringBuilder s = new StringBuilder("<HTML><p><font size = +2> Options </font</br></br><ol>");
      for (Object o : values)
        s.append("<li>" + o.toString().replaceAll("\n", "<br/>") + "</li>");
      s.append("</ol></HTML>");
      display.setText(s.toString());
    }

  }

  protected void onAboutClick() { // Display About dialog

    JPanel logo = new Canvas();

    JLabel title = new JLabel("<html><br>"
        + "<p><font size=+4>Elsa</font></p><br>"
        + "<p><font size +=2>Exceptional Laptops and Supercomputers Always<br>"
        + "<p>Version 0.2</p><br>"
        + "</html>",
        SwingConstants.CENTER);

    JLabel artists = new JLabel("<html>"
        + "<br/><p>Copyright 2023 by Ryan T. Harris</p><br>"
        + "<p>Licensed under Gnu GPL 3.0</p><br/>");

    JLabel copyright = new JLabel("<html>"
        + "<br/><p><font size += 2> Logo based on work by IO-Images per the Pixabay License</p>"
        + "<br/><p><font size -= 2>https://pixabay.com/images/id-1077428/<p>");

    JOptionPane.showMessageDialog(this,
        new Object[] { logo, title, artists, copyright },
        "ELSA",
        JOptionPane.PLAIN_MESSAGE);
  }

  protected void onQuitClick() {
    System.exit(0);
  } // Exit the game

  protected void onSaveClick() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
      Object[] values;
      values = store.options();
      bw.write("" + values.length + '\n');
      for (int i = 0; i < values.length; i++) {
        ((Option) values[i]).save(bw);
      }

      values = store.customers();
      bw.write("" + values.length + '\n');
      for (int i = 0; i < values.length; i++)
        ((Customer) values[i]).save(bw);

      values = store.computers();
      bw.write("" + values.length + '\n');
      for (int i = 0; i < values.length; i++)
        ((Computer) values[i]).save(bw);
    } catch (Exception e) {
      System.err.println("Failed to write: " + e);
      System.exit(-1);
    }
    filename = new File("Elsa.txt");
  }

  protected void onSaveAsClick() {
    try {
      JFileChooser fc = new JFileChooser(filename);
      FileFilter txtFiles = new FileNameExtensionFilter("txt files", "txt");
      fc.addChoosableFileFilter(txtFiles);
      fc.setFileFilter(txtFiles);

      int result = fc.showSaveDialog(this);
      if (result == JFileChooser.APPROVE_OPTION)
        ;
      {
        filename = fc.getSelectedFile();
        if (!filename.getAbsolutePath().endsWith(".txt"))
          filename = new File(filename.getAbsolutePath() + ".txt");
        onSaveClick();
      }

    } catch (NullPointerException e) {
    }

  }

  protected void onOpenClick() {
    JFileChooser fc = new JFileChooser(filename);
    FileFilter txtFiles = new FileNameExtensionFilter("txt files", "txt");
    fc.addChoosableFileFilter(txtFiles);
    fc.setFileFilter(txtFiles);

    int result = fc.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      filename = fc.getSelectedFile();

      try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        int upperBound = Integer.parseInt(br.readLine());
        for (int i = 0; i < upperBound; i++) {
          store.add(new Option(br));
        }

        upperBound = Integer.parseInt(br.readLine());
        for (int i = 0; i < upperBound; i++) {
          store.add(new Customer(br));
        }

        upperBound = Integer.parseInt(br.readLine());
        for (int i = 0; i < upperBound; i++) {
          store.add(new Computer(br));
        }
      } catch (Exception e) {
      }
    }
  }

  protected void onNewClick() {
    try {

      JLabel question = new JLabel("<HTML><br/> Would you like to save before closing this instance? </HTML>");

      Object[] objects = { question };

      int button = JOptionPane.showConfirmDialog(this,
          objects,
          "Question Prompt",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.PLAIN_MESSAGE);

      if (button == JOptionPane.YES_OPTION)
        onSaveAsClick();
      store = new Store("Elsa Store");

    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Unable to save" + filename + " ");
      System.err.println(e);
    }
  }

  private Store store = new Store("ELSA Store");

  private JLabel display;
  private JLabel msg;
  private File filename = new File("Elsa.txt");
}
