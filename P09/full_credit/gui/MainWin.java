package gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JToolBar;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import store.Store;
import store.Product;
import store.Donut;
import store.Java;

import store.Person;
import store.Customer;

import store.Frosting;
import store.Filling;
import store.Darkness;
import store.Shot;

public class MainWin extends JFrame {

    /*********************************************************
                            Constructor
    *********************************************************/

    public MainWin(String title) {
        super(title);
        store = new Store("JADE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        fileName = new File("untitled.jade");
        
        /*****************************************************
                                M E N U
        *****************************************************/

        // Add a menu bar to the PAGE_START area of the Border Layout
        JMenuBar menubar = new JMenuBar();
        
        JMenu     mFile    = new JMenu("File");
                  mNew     = new JMenuItem("New");
                  mOpen    = new JMenuItem("Open");
                  mSave    = new JMenuItem("Save");
                  mSaveAs  = new JMenuItem("Save As");
                  mQuit    = new JMenuItem("Quit");
        JMenu     mCreate  = new JMenu("Create");
                  mCustomer = new JMenuItem("Customer");
                  mJava    = new JMenuItem("Java");
                  mDonut   = new JMenuItem("Donut");
        JMenu     mView    = new JMenu("View");
                  mProducts = new JMenuItem("Products");
                  mPeople  = new JMenuItem("People");
        JMenu     mHelp    = new JMenu("Help");
                  mAbout   = new JMenuItem("About");
        
        mNew  .addActionListener(event -> onNewClick());          // File
        mOpen .addActionListener(event -> onOpenClick());         // File
        mSave.addActionListener(event -> onSaveClick());          // File
        mSaveAs.addActionListener(event -> onSaveAsClick());      // File
        mQuit .addActionListener(event -> onQuitClick());         // File
        mJava .addActionListener(event -> onCreateJavaClick());
        mDonut.addActionListener(event -> onCreateDonutClick());
        mAbout.addActionListener(event -> onAboutClick());
        mCustomer.addActionListener(event -> onCreateCustomerClick());
        mProducts.addActionListener(event -> onProductsClick());
        mPeople.addActionListener(event -> onPeopleClick());

        mFile  .add(mQuit);
        mFile  .add(mNew);
        mFile  .add(mOpen);
        mFile  .add(mSave);
        mFile  .add(mSaveAs);
        mCreate.add(mJava);
        mCreate.add(mDonut);
        mCreate.add(mCustomer);
        mView  .add(mProducts);
        mView  .add(mPeople);
        mHelp  .add(mAbout);
        
        menubar.add(mFile);
        menubar.add(mCreate);
        menubar.add(mView);
        menubar.add(mHelp);
        
        setJMenuBar(menubar);
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("JADE Controls");

        // Create the 7 buttons using the icons provided
        bNew  = new JButton(new ImageIcon("gui/resources/new_store.png"));
          bNew.setActionCommand("Create a new Store");
          bNew.setToolTipText("Create a new Store");
          toolbar.add(bNew);
          bNew.addActionListener(event -> onNewClick());

        bOpen = new JButton(new ImageIcon("gui/resources/open.png"));
          bOpen.setActionCommand("Open a file");
          bOpen.setToolTipText("Open a previously saved file");
          toolbar.add(bOpen);
          bOpen.addActionListener(event -> onOpenClick());

         bSave = new JButton(new ImageIcon("gui/resources/save.png"));
          bSave.setActionCommand("About JADE Manager");
          bSave.setToolTipText("About JADE Manager");
          toolbar.add(bSave);
          bSave.addActionListener(event -> onSaveClick());

        bSaveAs = new JButton(new ImageIcon("gui/resources/save_as.png"));
          bSaveAs.setActionCommand("About JADE Manager");
          bSaveAs.setToolTipText("About JADE Manager");
          toolbar.add(bSaveAs);
          bSaveAs.addActionListener(event -> onSaveAsClick());

        // Put some distance between our buttons
        toolbar.add(Box.createHorizontalStrut(25));

        bJava  = new JButton(new ImageIcon("gui/resources/new_java.png"));
          bJava.setActionCommand("Create new Java");
          bJava.setToolTipText("Create a new coffee selection");
          toolbar.add(bJava);
          bJava.addActionListener(event -> onCreateJavaClick());

        bDonut = new JButton(new ImageIcon("gui/resources/new_donut.png"));
          bDonut.setActionCommand("Create new donut");
          bDonut.setToolTipText("Create a new donut selection");
          toolbar.add(bDonut);
          bDonut.addActionListener(event -> onCreateDonutClick());

        // Put some distance between our buttons
        toolbar.add(Box.createHorizontalStrut(25));

        bAbout = new JButton(new ImageIcon("gui/resources/about.png"));
          bAbout.setActionCommand("About JADE Manager");
          bAbout.setToolTipText("About JADE Manager");
          toolbar.add(bAbout);
          bAbout.addActionListener(event -> onAboutClick());

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        
        // /////////////////////////// ////////////////////////////////////////////
        // D A T A   D I S P L A Y
        // Provide a text entry box to show output
        data = new JLabel();
        data.setFont(new Font("SansSerif", Font.BOLD, 12));
        add(data, BorderLayout.CENTER);

        // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);
        
        // Initialize the dislay
        //updateDisplay();
      
        // Make everything in the JFrame visible
        setVisible(true);
    }
    
    // ///////////////////////////////////////////////////////////////////
    // Action Listeners
    protected void onNewClick(){
        store = new Store("JADE");
        updateDisplay(0);
        msg.setFont(new JLabel().getFont());
    }
    protected void onOpenClick(){
        final JFileChooser fc = new JFileChooser(fileName);
        FileFilter jadeFiles = new FileNameExtensionFilter("JADE files", "jade");
        fc.addChoosableFileFilter(jadeFiles);           // Add "Jade file" filter
        fc.setFileFilter(jadeFiles);                     // Show jade files only by defualt

        int result = fc.showOpenDialog(this);           // Run dialog, return button clicked (im not certain what this means)
        if(result == JFileChooser.APPROVE_OPTION){
            fileName = fc.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                store = new Store(br);
                String buffer;

                // Buffers is read and determines what constructor to call 
                buffer = br.readLine();
                while(!buffer.equals("end products")){
                    if(buffer.equals("donut")){
                        Donut d = new Donut(br);
                        store.addProduct(d);
                        
                    }
                    if(buffer.equals("java")){
                        Java j = new Java(br);
                        store.addProduct(j);
                    }

                    buffer = br.readLine();
                }

                /* 
                    Buffer == "end products"

                    we do not read again so the Custommer
                    construtor can the first name
                */ 

                while(buffer != null){
                    Customer c = new Customer(br);
                    store.addPerson(c);

                    buffer = br.readLine();
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(this,"Unable to open " + fileName + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    protected void onSaveClick(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            store.save(bw);
            Product product;
            
            for(int i = 0; i < store.numberOfProducts(); i++){
                product = store.getProduct(i);
                product.save(bw);
            }
            bw.write("" + "end products" + "\n");
            for(int i = 0; i < store.numberOfPeople(); i++){
                person = store.getPerson(i);
                person.save(bw);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Unable to open " 
                                + fileName 
                                + '\n' + e, "Failed", JOptionPane.ERROR_MESSAGE); 
        }
    }
    protected void onSaveAsClick(){
        final JFileChooser fc = new JFileChooser(fileName);
        FileFilter jadeFiles = new FileNameExtensionFilter("Jade files", "jade");
        fc.addChoosableFileFilter(jadeFiles);
        fc.setFileFilter(jadeFiles);

        int result = fc.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            fileName = fc.getSelectedFile();
            if(!fileName.getAbsolutePath().endsWith(".jade"))
                fileName = new File(fileName.getAbsolutePath());
            onSaveClick();
        }
    }
    protected void onCreateJavaClick() {  // Create a new Java product
        try{
            JLabel name = new JLabel("<html>Java Name</html>");
            textName = new JTextField(20);
    
            JLabel price = new JLabel("<html>Price</html>");
            textPrice = new JTextField(20);
    
            JLabel cost = new JLabel("<html>Cost</html>");
            textCost = new JTextField(20);
    
            JLabel darknessLabel = new JLabel("<html>Darkness</html>");
            textDark = new JComboBox<Darkness>(Darkness.values());
    
            Object[] objects = {
                name, textName,
                price, textPrice,
                cost, textCost,
                darknessLabel, textDark,
            };

            JOptionPane.showConfirmDialog(
                this,
                objects,
                "New Java",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            String strName = textName.getText();
            double dubPrice = Double.parseDouble(textPrice.getText()); 
            double dubCost = Double.parseDouble(textCost.getText());
            Darkness darkness = Darkness.valueOf(textDark.getSelectedItem().toString());

            if(strName == null || strName.length() == 0)
                throw new Exception("Name is empty");

            // Create our object
            Java java = new Java(strName, dubPrice, dubCost, darkness);
            while(true) {
                Shot shot = (Shot) selectFromArray("Shot?", Shot.values());
                if(shot.equals(Shot.None)) break;
                java.addShot(shot);
            }
            store.addProduct(java);
        }catch(Exception e){
            msg.setText("Failed to create new Customer: " + e);
        }
    }
    
    protected void onCreateDonutClick() {  // Create a new Java product
        try{
            // Name of Donut       
            JLabel name = new JLabel("<html>Donut Name</html>");       
            textName = new JTextField(20); 
            
            // Donut Price
            JLabel price = new JLabel("<html>Price</html>");
            textPrice = new JTextField(20);
    
            // Donut Cost
            JLabel cost = new JLabel("<html>Cost</html>");
            textCost = new JTextField(20);

            JLabel frostingLabel = new JLabel("<html>Frosting</html>");
            textFrost = new JComboBox<Frosting>(Frosting.values());

            JLabel fillingLabel = new JLabel("<html>Filling</html>");
            textFill = new JComboBox<Filling>(Filling.values());

            String[] options = {"No Sprinkles", "Sprinkles"};
            JLabel sprinklesLabel = new JLabel("<html>Sprinkles</html>");
            textSprinkles = new JComboBox<String>(options);

            Object[] objects = {
                name, textName,
                price, textPrice,
                cost, textCost,
                frostingLabel, textFrost,
                fillingLabel, textFill,
                sprinklesLabel, textSprinkles,
            };

            JOptionPane.showConfirmDialog(
                this,
                objects,
                "New Donut",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            String strName = textName.getText();
            double dubPrice = Double.parseDouble(textPrice.getText()); 
            double dubCost = Double.parseDouble(textCost.getText());

            Frosting frosting = Frosting.valueOf(textFrost.getSelectedItem().toString());
            Filling filling = Filling.valueOf(textFill.getSelectedItem().toString());
            boolean sprinkles;

            if(textSprinkles.getSelectedItem().toString().equals("No Sprinkles"))
                sprinkles = false;
            else
                sprinkles = true;

            if(strName == null || strName.length() == 0)
                throw new Exception("Name is empty");

            store.addProduct(new Donut(strName, dubPrice, dubCost, frosting, filling, sprinkles));
        } catch(Exception e){
            msg.setText("Failed to create new Donut: " + e);
        }
    }

    protected void onCreateCustomerClick(){
        try{
            // Name of Customer       
            JLabel name = new JLabel("<html>Name</html>");       
            textName = new JTextField(20); 
        
            // Customer Phone number
            JLabel phone = new JLabel("<html>Phone</html>");
            textPhone = new JTextField(20);

            Object[] objects = {
                name, textName,
                phone, textPhone
            };
        
            int button = JOptionPane.showConfirmDialog(
                this,
                objects,
                "New Customer",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            String strName = textName.getText();
            String strPhone = textPhone.getText(); 

            if(strName == null || strName.length() == 0) 
                throw new Exception("Name is empty");
            
            store.addPerson(new Customer(strName, strPhone));
        }catch(Exception e){
            msg.setText("Failed to create new Customer: " + e);
        }
    }
            
    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.getContentPane().setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
        about.setTitle("Java and Donut Express");
        about.setSize(640,600);
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("gui/resources/logo.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            logo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            about.add(logo);
        } catch(IOException e) {}
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+3>Java and Donut Express</font></p>"
          + "</html>");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(title);

        JLabel copyright = new JLabel("<html>"
          + "<p>Version 0.2</p>"
          + "<p>Copyright 2021 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<br/>"
          + "</html>");
        copyright.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(copyright);
                    
       JLabel artists = new JLabel("<html>"
          + "<p>JADE Logo by SaxDeux, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Logo_JADE.png</p>"
          + "<p>Flat Coffee Cup Icon by superawesomevectors, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>http://fav.me/dbf6otc</p>"
          + "<p><font size=-2>https://creativecommons.org/licenses/by-sa/3.0/us/</p>"
          + "<p>Donut Icon by Hazmat2 via Hyju, public domain</p>"
          + "<p><font size=-2>https://en.wikipedia.org/wiki/File:Simpsons_Donut.svg</p>"
          + "<p>Help Icon by Vector Stall via the Flat Icon license</p>"
          + "<p><font size=-2>https://www.flaticon.com/premium-icon/question-mark_3444393</p>"
          + "<p>Apps Folder Home Icon by alecive, licensed under CC Attribution-Share Alike 4.0</p>"
          +"<p><font size=-2>https://iconarchive.com/show/flatwoken-icons-by-alecive/Apps-Folder-Home-icon.html</p>"
          + "<p>Open File Icon by Custom Icon Design, licensed under Free for non-commercial use.</p>"
          +"<p><font size=-2>https://iconarchive.com/show/pretty-office-9-icons-by-custom-icon-design/open-file-icon.html</p>"
          + "<p>Save Icon by Custom Icon Design, licensed under Free for non-commercial use.</p>"
          +"<p><font size=-2>https://iconarchive.com/show/pretty-office-7-icons-by-custom-icon-design/Save-icon.html</p>"
          + "<p>Icon Quality Png File Png File Png File Png File transparent background by Ahkâm, licensed under Personal Use Only</p>"
          +"<p><font size=-2>https://www.freeiconspng.com/img/2488</p>"
          + "<br/>"
          + "</html>");
        artists.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.setAlignmentX(JButton.CENTER_ALIGNMENT);
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.pack();
        about.setVisible(true);
     }
    protected void onQuitClick() { dispose(); } 

    protected void onProductsClick(){ updateDisplay(0); }

    protected void onPeopleClick(){ updateDisplay(1); } 

    /********************************* 
                Utilities
    *********************************/

    // Called from onNew or onOpen
    private void updateDisplay(int i){
        if(i == 0){
            data.setText("<html>" + store.toString()
                         .replaceAll("<","&lt;")
                         .replaceAll(">", "&gt;")
                         .replaceAll("\n", "<br/>")
                         + "</html>");
        }
        else{
            data.setText("<html>" + store.peopleToString()
                         .replaceAll("<","&lt;")
                         .replaceAll(">", "&gt;")
                         .replaceAll("\n", "<br/>")
                         + "</html>");
        }
        
    }

    // ///////////////////////////////////////////////////////////////////
    // Main

    public static void main(String[] args) {
        MainWin myApp = new MainWin("JADE");
        myApp.setVisible(true);
    }
    
    /********************************************
                Attributes
    ********************************************/

    private Object obj;
    private Store store;
    private Person person;
    private File fileName;
    private JLabel data;                    // Display of output in main window
    private JLabel msg;                     // Status message display
    
    // buttons
    private JButton bAbout;
    private JButton bCustomer;
    private JButton bDonut;
    private JButton bJava;                  
    private JButton bNew;
    private JButton bOpen;
    private JButton bSave;
    private JButton bSaveAs;
    

    // Menu
    private JMenuItem mAbout;
    private JMenuItem mCustomer;
    private JMenuItem mDonut; 
    private JMenuItem mJava;                  
    private JMenuItem mNew;
    private JMenuItem mOpen;
    private JMenuItem mPeople;
    private JMenuItem mProducts;
    private JMenuItem mQuit;
    private JMenuItem mSave;
    private JMenuItem mSaveAs;

    private JComboBox textDark;
    private JComboBox textFill;
    private JComboBox textFrost;
    private JComboBox textSprinkles;

    private JTextField textName;
    private JTextField textPhone;
    private JTextField textPrice;
    private JTextField textCost;

}


/*
    Add toolbar buttons for Create > Customer, View > People, View > Products

    onCreateDonutClick(), onCreateJavaClick(), onCreateCustomer(lick) call updateDisplay()
    to display either products or customers

*/