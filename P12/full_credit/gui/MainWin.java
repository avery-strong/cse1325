 package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import javax.imageio.ImageIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

import store.Store;                     // Class
import store.Product;                   // Class
import store.Donut;                     // Class
import store.Java;                      // Class
import store.Order;                     // Class

import store.Customer;                  // Class
import store.Person;                    // Class
import store.Server;                    // Class

import store.Frosting;                  // Enum class
import store.Filling;                   // Enum class
import store.Darkness;                  // Enum class
import store.Shot;                      // Enum class

public class MainWin extends JFrame {

    /************************************************
                            Constructor
    ************************************************/

    public MainWin(String title) {
        super(title);
        store = new Store("JADE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1120, 600);
        fileName = new File("untitled.jade");
        
        /************************************************
                                M E N U
        ************************************************/

        // Add a menu bar to the PAGE_START area of the Border Layout
        JMenuBar menubar = new JMenuBar();
        
        JMenu     mFile       = new JMenu("File");
                  mNew        = new JMenuItem("New");
                  mOpen       = new JMenuItem("Open");
                  mSave       = new JMenuItem("Save");
                  mSaveAs     = new JMenuItem("Save As");
                  mQuit       = new JMenuItem("Quit");

        JMenu     mCreate     = new JMenu("Create");
                  mJava       = new JMenuItem("Java");
                  mDonut      = new JMenuItem("Donut");
                  mCustomer   = new JMenuItem("Customer");
                  mOrder      = new JMenuItem("Order");
                  mServer     = new JMenuItem("Server");

        JMenu     mView       = new JMenu("View");
                  mProducts   = new JMenuItem("Products");
                  mPeople     = new JMenuItem("People");
                  mOrders     = new JMenuItem("Orders");

        JMenu     mEdit       = new JMenu("Edit");
                  mEditDonut  = new JMenuItem("Donut");
                  mEditJava   = new JMenuItem("Java");

        JMenu     mReports    = new JMenu("Reports");
                  mProfitLoss = new JMenuItem("Profits & Loss");
                  mServerReport     = new JMenuItem("Server");

        JMenu     mHelp       = new JMenu("Help");
                  mAbout      = new JMenuItem("About");
        
        mNew.addActionListener(event -> onNewClick());                  // File
        mOpen.addActionListener(event -> onOpenClick());                // File
        mSave.addActionListener(event -> onSaveClick());                // File
        mSaveAs.addActionListener(event -> onSaveAsClick());            // File
        mQuit.addActionListener(event -> onQuitClick());                // File

        mDonut.addActionListener(event -> onCreateDonutClick());        // Create
        mJava.addActionListener(event -> onCreateJavaClick());          // Create
        mCustomer.addActionListener(event -> onCreateCustomerClick());  // Create
        mServer.addActionListener(event -> onCreateServerClick());      // Create
        mOrder.addActionListener(event -> onCreateOrderClick());        // Create
        
        mProducts.addActionListener(event -> onProductsClick());        // View
        mPeople.addActionListener(event -> onPeopleClick());            // View
        mOrders.addActionListener(event -> onOrdersClick());            // View

        mEditDonut.addActionListener(event -> onEditDonutClick());      // Edit
        mEditJava.addActionListener(event -> onEditJavaClick());        // Edit

        mProfitLoss.addActionListener(event -> onProfitLossClick());    // Reports
        mServerReport.addActionListener(event -> onServerReportClick());// Reports
        mAbout.addActionListener(event -> onAboutClick());              // Help

        mFile.add(mNew);
        mFile.add(mOpen);
        mFile.add(mSave);
        mFile.add(mSaveAs);
        mFile.add(mQuit);

        mCreate.add(mDonut);
        mCreate.add(mJava);
        mCreate.add(mCustomer);
        mCreate.add(mServer);
        mCreate.add(mOrder);

        mView.add(mOrders);
        mView.add(mPeople);
        mView.add(mProducts);

        mEdit.add(mEditDonut);
        mEdit.add(mEditJava);

        mReports.add(mProfitLoss);
        mReports.add(mServerReport);

        mHelp.add(mAbout);
        
        menubar.add(mFile);
        menubar.add(mCreate);
        menubar.add(mView);
        menubar.add(mEdit);
        menubar.add(mReports);
        menubar.add(mHelp);
        
        setJMenuBar(menubar);
        
        /*************************************************************
                        T O O L B A R
            Add a toolbar to the PAGE_START region below the menu   
        *************************************************************/
    
        JToolBar toolbar = new JToolBar("JADE Controls");

        /***********************************************
                        File Buttons   
        ***********************************************/
        
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
        toolbar.add(Box.createHorizontalStrut(20));

        /***********************************************
                        Create Buttons   
        ***********************************************/

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

        bCustomer = new JButton(new ImageIcon("gui/resources/Users-icon.png"));
          bCustomer.setActionCommand("Create a new Customer");
          bCustomer.setToolTipText("Create a new customer Selection");
          toolbar.add(bCustomer);
          bCustomer.addActionListener(event -> onCreateCustomerClick());

        bServer = new JButton(new ImageIcon("gui/resources/barista.png"));
          bServer.setActionCommand("Create a new Server");
          bServer.setToolTipText("Create a new server");
          toolbar.add(bServer);
          bServer.addActionListener(event -> onCreateServerClick());

        bOrder = new JButton(new ImageIcon("gui/resources/noun_coffee_orders.png"));
          bOrder.setActionCommand("Create a new Order");
          bOrder.setToolTipText("Create a new Order");
          toolbar.add(bOrder);
          bOrder.addActionListener(event -> onCreateOrderClick());

          // Put some distance between our buttons
        toolbar.add(Box.createHorizontalStrut(20));

        /***********************************************
                        View Buttons   
        ***********************************************/

        bProduct = new JButton(new ImageIcon("gui/resources/product-icon.png"));
          bProduct.setActionCommand("View Products");
          bProduct.setToolTipText("View Products");
          toolbar.add(bProduct);
          bProduct.addActionListener(event -> onProductsClick());

        bPeople = new JButton(new ImageIcon("gui/resources/people-icon.png"));
          bPeople.setActionCommand("View People");
          bPeople.setToolTipText("View People");
          toolbar.add(bPeople);
          bPeople.addActionListener(event -> onPeopleClick());

        bOrders = new JButton(new ImageIcon("gui/resources/order-icon-17.jpg"));
          bOrders.setActionCommand("View Orders");
          bOrders.setToolTipText("View Orders");
          toolbar.add(bOrders);
          bOrders.addActionListener(event -> onOrdersClick());

        // Put some distance between our buttons
        toolbar.add(Box.createHorizontalStrut(20));

        /***********************************************
                        Edit Buttons   
        ***********************************************/

        bEditJava = new JButton(new ImageIcon("gui/resources/Food-Coffee-To-Go-icon.png"));
         bEditJava.setActionCommand("Edit Java");
         bEditJava.setToolTipText("Edit Java");
         toolbar.add(bEditJava);
         bEditJava.addActionListener(event -> onEditJavaClick());

        bEditDonut = new JButton(new ImageIcon("gui/resources/Food-Doughnut-icon.png"));
         bEditDonut.setActionCommand("Edit Donut");
         bEditDonut.setToolTipText("Edit Donut");
         toolbar.add(bEditDonut);
         bEditDonut.addActionListener(event -> onEditDonutClick());

        // Put some distance between our buttons
        toolbar.add(Box.createHorizontalStrut(20));

        /***********************************************
                        Report Buttons   
        ***********************************************/

        bProfitLoss = new JButton(new ImageIcon("gui/resources/Sales-report-icon.png"));
         bProfitLoss.setActionCommand("Profit & Loss Report");
         bProfitLoss.setToolTipText("Profit & Loss Report");
         toolbar.add(bProfitLoss);
         bProfitLoss.addActionListener(event -> onProfitLossClick());

        bServerReport = new JButton(new ImageIcon("gui/resources/Distributor-report-icon.png"));
         bServerReport.setActionCommand("Server Report");
         bServerReport.setToolTipText("Server Report");
         toolbar.add(bServerReport);
         bServerReport.addActionListener(event -> onServerReportClick());

        // Put some distance between our buttons
        toolbar.add(Box.createHorizontalStrut(20));

        /***********************************************
                        Help Buttons   
        ***********************************************/

        bAbout = new JButton(new ImageIcon("gui/resources/about.png"));
          bAbout.setActionCommand("About JADE Manager");
          bAbout.setToolTipText("About JADE Manager");
          toolbar.add(bAbout);
          bAbout.addActionListener(event -> onAboutClick());

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        /***********************************************
                        D A T A   D I S P L A Y
            Provide a text entry box to show output    
        ***********************************************/
        
        data = new JLabel();
        data.setFont(new Font("SansSerif", Font.BOLD, 12));
        add(data, BorderLayout.CENTER);

        /***********************************************
                S T A T U S   B A R   D I S P L A Y
            Provide a status bar for messages    
        ***********************************************/
        
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);
        
        // Initialize the dislay
        //updateDisplay();
      
        // Make everything in the JFrame visible
        setVisible(true);
    }
    
    /************************************************
                    File ActionListeners
    ************************************************/

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
                String buffer, token;
                buffer = br.readLine();     // Read for our Store Constructor

                store = new Store(buffer, br);

                buffer = br.readLine();     // Read for a Product Constructor
                
                 // Token determines which while loop or if statement is called
                StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
                token = multiTokenizer.nextToken();    

                while(token.equals("donut") || token.equals("java")){  // while for products
                    if(token.equals("donut")){
                        Donut d = new Donut(buffer, br);
                        store.addProduct(d);
                    }
                    if(token.equals("java")){
                        Java j = new Java(buffer, br);
                        store.addProduct(j);
                    }

                    buffer = br.readLine();
                    multiTokenizer = new StringTokenizer(buffer, "|");
                    token = multiTokenizer.nextToken();
                }

                while(token.equals("customer") || token.equals("server")){
                    if(token.equals("customer")){  // while for people
                        Customer c = new Customer(buffer, br);
                        store.addPerson(c);
                    }

                    if(token.equals("server")){
                        Server s = new Server(buffer, br);
                        store.addPerson(s);
                    }
                    
                    buffer = br.readLine();   
                    multiTokenizer = new StringTokenizer(buffer, "|");
                    token = multiTokenizer.nextToken();
                } 
                
                while(token.equals("order")){
                    Order o = new Order(buffer, store);
                    store.addOrders(o);

                    buffer = br.readLine();

                    multiTokenizer = new StringTokenizer(buffer, "|");
                    token = multiTokenizer.nextToken();
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
            
            for(int i = 0; i < store.numberOfPeople(); i++){
                person = store.getPerson(i);
                person.save(bw);
            }
            
            for(int i = 0; i < store.numberOfOrders(); i++){
                order = store.getOrder(i);
                order.save(bw);
            }
            bw.write('\n' +"" + "end file" + "|");
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
    protected void onQuitClick() { dispose(); } 

    /************************************************
                    Create ActionListeners
    ************************************************/

    protected void onCreateJavaClick() {  // Create a new Java product
        try{
            JPanel panel       = new JPanel(new BorderLayout());
            JPanel north       = new JPanel(new BorderLayout());
            JPanel northCombo  = new JPanel(new BorderLayout());
            JPanel center      = new JPanel(new BorderLayout());
            JPanel centerCombo = new JPanel(new BorderLayout());
            JPanel south       = new JPanel(new BorderLayout());
            bAdd = new JButton("Save");
            
            textName  = new JTextField(20);
            textPrice = new JTextField(20);
            textCost  = new JTextField(20);
            textDark  = new JComboBox<Darkness>(Darkness.values());

            String[] options = {"No", "Yes"};
            textShots = new JComboBox<String>(options);


            north.add(new JLabel("<html>Java Name</html>"), BorderLayout.NORTH);
            north.add(textName, BorderLayout.CENTER);
            north.add(new JLabel("<html>Price</html>"), BorderLayout.SOUTH);
            
            center.add(textPrice, BorderLayout.NORTH);
            center.add(new JLabel("<html>Cost</html>"), BorderLayout.CENTER);
            center.add(textCost, BorderLayout.SOUTH);

            northCombo.add(new JLabel("<html>Darkness</html>"), BorderLayout.NORTH);
            northCombo.add(textDark, BorderLayout.CENTER);

            centerCombo.add(new JLabel("<html>Would you like to add shots</html>"), BorderLayout.NORTH);
            centerCombo.add(textShots, BorderLayout.CENTER);

            south.add(northCombo, BorderLayout.NORTH);
            south.add(centerCombo, BorderLayout.CENTER);
            //bAdd.addActionListener(event -> store.addProduct(java));
            //south.add(bAdd, BorderLayout.SOUTH);
            
            panel.add(north, BorderLayout.NORTH);
            panel.add(center, BorderLayout.CENTER);
            panel.add(south, BorderLayout.SOUTH);

            int result = JOptionPane.showConfirmDialog(
                this,
                panel,
                "New Java",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            if(result != JOptionPane.OK_OPTION) return;

            boolean shots = false;

            // Create our object
            Java java = new Java(getString(textName), 
                                 getDouble(textPrice), 
                                 getDouble(textCost), 
                                 Darkness.valueOf(textDark.getSelectedItem().toString()));

            if(!textShots.getSelectedItem().toString().equals("No"))
                shots = true;

            while(shots) {
                Shot shot = (Shot) selectFromArray("Shot?", Shot.values());
                if(shot.equals(Shot.None)) break;
                java.addShot(shot);
            }

            store.addProduct(java);

            updateDisplay(0);
        }catch(Exception e){
            msg.setText("Failed to create new Java: " + e);
        }
    }
    
    protected void onCreateDonutClick() {  // Create a new Java product
        try{
            JPanel panel = new JPanel(new BorderLayout());
            JPanel north = new JPanel(new BorderLayout());
            JPanel northCombo = new JPanel(new BorderLayout());
            JPanel center = new JPanel(new BorderLayout());
            JPanel centerCombo = new JPanel(new BorderLayout());
            JPanel south = new JPanel(new BorderLayout());
            JPanel southCombo = new JPanel(new BorderLayout());

            textName = new JTextField(20);
            textPrice = new JTextField(20);
            textCost = new JTextField(20);

            textFrost = new JComboBox<Frosting>(Frosting.values());
            textFill = new JComboBox<Filling>(Filling.values());

            String[] options = {"No Sprinkles", "Sprinkles"};
            textSprinkles = new JComboBox<String>(options);

            north.add(new JLabel("<html>Donut Name</html>"), BorderLayout.NORTH);
            north.add(textName, BorderLayout.CENTER);
            north.add(new JLabel("<html>Price</html>"), BorderLayout.SOUTH);

            center.add(textPrice, BorderLayout.NORTH);
            center.add(new JLabel("<html>Cost</html>"), BorderLayout.CENTER);
            center.add(textCost, BorderLayout.SOUTH);

            northCombo.add(new JLabel("<html>Frosting</html>"), BorderLayout.NORTH);
            northCombo.add(textFrost, BorderLayout.CENTER);

            centerCombo.add(new JLabel("<html>Filling</html>"), BorderLayout.NORTH);
            centerCombo.add(textFill, BorderLayout.CENTER);

            southCombo.add(new JLabel("<html>Sprinkles</html>"), BorderLayout.NORTH);      
            southCombo.add(textSprinkles, BorderLayout.CENTER);

            south.add(northCombo, BorderLayout.NORTH);
            south.add(centerCombo, BorderLayout.CENTER);
            south.add(southCombo, BorderLayout.SOUTH);

            panel.add(north, BorderLayout.NORTH);
            panel.add(center, BorderLayout.CENTER);
            panel.add(south, BorderLayout.SOUTH);

            JOptionPane.showConfirmDialog(
                this,
                panel,
                "New Donut",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            boolean sprinkles = false;

            if(!textSprinkles.getSelectedItem().toString().equals("No Sprinkles"))
                sprinkles = true;

            store.addProduct(new Donut(getString(textName), 
                                       getDouble(textPrice), 
                                       getDouble(textCost), 
                                       Frosting.valueOf(textFrost.getSelectedItem().toString()), 
                                       Filling.valueOf(textFill.getSelectedItem().toString()), 
                                       sprinkles));
            
            updateDisplay(0);
        }catch(Exception e){
            msg.setText("Failed to create new Donut: " + e);
        }  
    }

    protected void onCreateCustomerClick(){
        try{

            JPanel panel = new JPanel(new BorderLayout());
            JPanel north = new JPanel(new BorderLayout());
            JPanel center = new JPanel(new BorderLayout());

            textName = new JTextField(20);              // Name of Customer   
            textPhone = new JTextField(20);             // Customer Phone number

            north.add(new JLabel("<html>Name</html>"), BorderLayout.NORTH);            
            north.add(textName, BorderLayout.CENTER);
            center.add(new JLabel("<html>Phone</html>"), BorderLayout.NORTH);
            center.add(textPhone, BorderLayout.CENTER);
            panel.add(north, BorderLayout.NORTH);
            panel.add(center, BorderLayout.CENTER);

            int button = JOptionPane.showConfirmDialog(
                this,
                panel,
                "New Customer",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            String strName = getString(textName);
            String strPhone = getString(textPhone); 
            
            store.addPerson(new Customer(strName, strPhone));

            updateDisplay(1);
        }catch(Exception e){
            msg.setText("Failed to create new Customer: " + e);
        }
    }

    protected void onCreateOrderClick(){
        /*******************
                People
        ********************/

        JPanel panel = new JPanel(new BorderLayout());
        JPanel north = new JPanel(new BorderLayout());
        JPanel center = new JPanel(new BorderLayout());

        ArrayList<Person> serverList = new ArrayList<>();
        ArrayList<Person> customerList = new ArrayList<>();

        for(int i = 0; i < store.numberOfPeople(); i++){
            if(store.getPerson(i) instanceof Customer)
                customerList.add(store.getPerson(i));
            else
                serverList.add(store.getPerson(i));
        }

        JComboBox textCustomer = new JComboBox<Object>(customerList.toArray());
        JComboBox textServer = new JComboBox<Object>(serverList.toArray());
        
        north.add(new JLabel("<html>Customers</html>"), BorderLayout.NORTH);
        north.add(textCustomer, BorderLayout.CENTER);
        center.add(new JLabel("<html>Servers</html>"), BorderLayout.NORTH);
        center.add(textServer, BorderLayout.CENTER);
        panel.add(north, BorderLayout.NORTH);
        panel.add(center, BorderLayout.CENTER);

        JOptionPane.showConfirmDialog(
            this,
            panel,
            "New Order",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        Customer c = (Customer)textCustomer.getSelectedItem();
        Server s = (Server)textServer.getSelectedItem();

        order = new Order(c, s);
        store.addOrders(order);
        

        /****************
            Products
        *****************/

        try{   
            // Display our order to the current JPanel
            JLabel products = new JLabel("<html>" + order.toString()
                         .replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .replaceAll("<","&lt;")
                         .replaceAll(">", "&gt;")
                         .replaceAll("\n", "<br/>")
                         + "</html>");

            Object[] productOptions = store.getProducts();  
            JComboBox textProducts = new JComboBox<Object>(productOptions);
            JSpinner spinner = new JSpinner();

            bAdd = new JButton("Add");
            bAdd.addActionListener(event -> {order.addProduct((Integer)spinner.getValue(),
                        (Product)textProducts.getSelectedItem());
                        products.setText("<html>" + order.toString()
                         .replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .replaceAll("<","&lt;")
                         .replaceAll(">", "&gt;")
                         .replaceAll("\n", "<br/>")
                         + "</html>");
            });

            panel = new JPanel(new BorderLayout());
            north = new JPanel(new BorderLayout());
            north.add(products, BorderLayout.NORTH);

            panel.add(textProducts, BorderLayout.EAST);
            panel.add(spinner, BorderLayout.CENTER);
            panel.add(bAdd, BorderLayout.WEST);

            Object[] objects = {
                north,
                panel,
            };

            int result = JOptionPane.showConfirmDialog(
                this,
                objects,
                "Product",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            // A quantity of 0 and a orders.numberOfProducts of 0 stops empty order form being added to orders ArrayList
            if(result != JOptionPane.OK_OPTION) return; 
        }catch(Exception e){
            msg.setText("Failed to create new Order: " + e);
        }

        updateDisplay(2);
    }

    protected void onCreateServerClick(){
        try{
            JPanel panel  = new JPanel(new BorderLayout());
            JPanel north  = new JPanel(new BorderLayout());
            JPanel center = new JPanel(new BorderLayout());
            JPanel south  = new JPanel(new BorderLayout());

            textName = new JTextField(20);
            textPhone = new JTextField(20);
            textSocial = new JTextField(20);

            north.add(new JLabel("<html>Name</html>"), BorderLayout.NORTH);
            north.add(textName, BorderLayout.CENTER);

            center.add(new JLabel("<html>Phone</html>"), BorderLayout.NORTH);
            center.add(textPhone, BorderLayout.CENTER);

            south.add(new JLabel("<html>SSN</html>"), BorderLayout.NORTH);
            south.add(textSocial, BorderLayout.CENTER);

            panel.add(north, BorderLayout.NORTH);
            panel.add(center, BorderLayout.CENTER);
            panel.add(south, BorderLayout.SOUTH);

            JOptionPane.showConfirmDialog(
                this,
                panel,
                "New Server",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            String strName = getString(textName);
            String strPhone = getString(textPhone); 
            String strSocial = getString(textSocial);

            store.addPerson(new Server(strName, strPhone, strSocial));

            updateDisplay(1);
        }catch(Exception e){
            msg.setText("Failed to create new Server: " + e);
        }

        updateDisplay(2);
    }

    /************************************************
                    Edit ActionListeners
    ************************************************/

    protected void onEditDonutClick(){
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel();
        bAdd = new JButton("Change");

        ArrayList<Donut> donutsList = new ArrayList<>();
        
        Object[] products = store.getProducts();

        for(int i = 0; i < store.numberOfProducts(); i++){
            if(products[i] instanceof Donut)
                donutsList.add((Donut)products[i]);
        }

        products = donutsList.toArray();
        JComboBox textDonuts = new JComboBox<Object>(products);

        panel.add(new JLabel("<html>Which donut product would you like to edit?</html>"), BorderLayout.NORTH);
        panel.add(textDonuts, BorderLayout.CENTER);
        bAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    JPanel panel = new JPanel(new BorderLayout());
                    JPanel north = new JPanel(new BorderLayout());
                    JPanel northCombo = new JPanel(new BorderLayout());
                    JPanel center = new JPanel(new BorderLayout());
                    JPanel centerCombo = new JPanel(new BorderLayout());
                    JPanel south = new JPanel(new BorderLayout());
                    JPanel southCombo = new JPanel(new BorderLayout());

                    Donut donut = (Donut)textDonuts.getSelectedItem();

                    textName = new JTextField(donut.getName());
                    textPrice = new JTextField(String.valueOf(donut.getPrice()));
                    textCost = new JTextField(String.valueOf(donut.getCost()));
        
                    textFrost = new JComboBox<Frosting>(Frosting.values());
                    textFrost.setSelectedItem(donut.getFrosting());
                    textFill = new JComboBox<Filling>(Filling.values());
                    textFill.setSelectedItem(donut.getFilling());
    
                    String[] options = {"No Sprinkles", "Sprinkles"};
                    textSprinkles = new JComboBox<String>(options);
                    textSprinkles.setSelectedItem(donut.getSprinkles());

                    boolean sprinkles = false;
        
                    if(!textSprinkles.getSelectedItem().toString().equals("No Sprinkles"))
                        sprinkles = true;
        
                    north.add(new JLabel("<html>Donut Name</html>"), BorderLayout.NORTH);
                    north.add(textName, BorderLayout.CENTER);
                    north.add(new JLabel("<html>Price</html>"), BorderLayout.SOUTH);
        
                    center.add(textPrice, BorderLayout.NORTH);
                    center.add(new JLabel("<html>Cost</html>"), BorderLayout.CENTER);
                    center.add(textCost, BorderLayout.SOUTH);
        
                    northCombo.add(new JLabel("<html>Frosting</html>"), BorderLayout.NORTH);
                    northCombo.add(textFrost, BorderLayout.CENTER);
        
                    centerCombo.add(new JLabel("<html>Filling</html>"), BorderLayout.NORTH);
                    centerCombo.add(textFill, BorderLayout.CENTER);
        
                    southCombo.add(new JLabel("<html>Sprinkles</html>"), BorderLayout.NORTH);      
                    southCombo.add(textSprinkles, BorderLayout.CENTER);
        
                    south.add(northCombo, BorderLayout.NORTH);
                    south.add(centerCombo, BorderLayout.CENTER);
                    south.add(southCombo, BorderLayout.SOUTH);
    
                    panel.add(north, BorderLayout.NORTH);
                    panel.add(center, BorderLayout.CENTER);
                    panel.add(south, BorderLayout.SOUTH);
        
                    int result = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "New Donut",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                    if(result != JOptionPane.OK_OPTION) return;
                    else{
                        store.removeProduct(donut);
                        
                        store.addProduct(new Donut(getString(textName), 
                                        getDouble(textPrice), 
                                        getDouble(textCost), 
                                        Frosting.valueOf(textFrost.getSelectedItem().toString()), 
                                        Filling.valueOf(textFill.getSelectedItem().toString()), 
                                        sprinkles));
                    }
        
                    updateDisplay(0);
                }catch(Exception exception){
                    msg.setText("Failed to create new Donut: " + e);
                }
            }
        });
        panel.add(bAdd, BorderLayout.SOUTH);

        int result = JOptionPane.showConfirmDialog(
            this,
            panel,
            "Edit Donut",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if(result != JOptionPane.OK_OPTION) return;
    }

    protected void onEditJavaClick(){
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel();
        bAdd = new JButton("Change");

        ArrayList<Java> javaList = new ArrayList<>();

        Object[] products = store.getProducts();

        for(int i = 0; i < store.numberOfProducts(); i++){
            if(products[i] instanceof Java)
                javaList.add((Java)products[i]);
        }

        products = javaList.toArray();
        JComboBox textJava = new JComboBox<Object>(products);

        panel.add(new JLabel("<html>Which java product would you like to edit?</html>"), BorderLayout.NORTH);
        panel.add(textJava, BorderLayout.CENTER);
        bAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    JPanel panel       = new JPanel(new BorderLayout());
                    JPanel north       = new JPanel(new BorderLayout());
                    JPanel northCombo  = new JPanel(new BorderLayout());
                    JPanel center      = new JPanel(new BorderLayout());
                    JPanel centerCombo = new JPanel(new BorderLayout());
                    JPanel south       = new JPanel(new BorderLayout());

                    Java java = (Java)textJava.getSelectedItem();

                    textName  = new JTextField(java.getName());
                    textPrice = new JTextField(String.valueOf(java.getPrice()));
                    textCost  = new JTextField(String.valueOf(java.getCost()));
                    textDark  = new JComboBox<Darkness>(Darkness.values());
                    textDark.setSelectedItem(java.getDarkness());

                    north.add(new JLabel("<html>Java Name</html>"), BorderLayout.NORTH);
                    north.add(textName, BorderLayout.CENTER);
                    north.add(new JLabel("<html>Price</html>"), BorderLayout.SOUTH);
                    
                    center.add(textPrice, BorderLayout.NORTH);
                    center.add(new JLabel("<html>Cost</html>"), BorderLayout.CENTER);
                    center.add(textCost, BorderLayout.SOUTH);
            
                    northCombo.add(new JLabel("<html>Darkness</html>"), BorderLayout.NORTH);
                    northCombo.add(textDark, BorderLayout.CENTER);

                    south.add(northCombo, BorderLayout.NORTH);
                    south.add(centerCombo, BorderLayout.CENTER);

                    panel.add(north, BorderLayout.NORTH);
                    panel.add(center, BorderLayout.CENTER);
                    panel.add(south, BorderLayout.SOUTH);
            
                    int result = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "New Java",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                    if(result != JOptionPane.OK_OPTION) return;
                    else{
                        store.removeProduct(java);

                        Java j = new Java(getString(textName), 
                                         getDouble(textPrice), 
                                         getDouble(textCost), 
                                         Darkness.valueOf(textDark.getSelectedItem().toString()));

                        store.addProduct(j);

                        while(true) {
                            Shot shot = (Shot) selectFromArray("Shot?", Shot.values());
                            if(shot.equals(Shot.None)) break;
                            j.addShot(shot);
                        }
                    }
    
                    updateDisplay(0);
                }catch(Exception exception){
                    msg.setText("Failed to create new Donut: " + e);
                }
            }
        });
        panel.add(bAdd, BorderLayout.SOUTH);

        int result = JOptionPane.showConfirmDialog(
            this,
            panel,
            "Edit Donut",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if(result != JOptionPane.OK_OPTION) return;
    }

    /************************************************
                    Reports ActionListeners
    ************************************************/

    protected void onProfitLossClick(){

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        int columnCount = 4;
        double totalCost = 0;
        double totalPrice = 0;
        double totalProfit = 0;
        String[][] columns = new String[store.numberOfProducts()+1][columnCount];
        String[] columnNames = {"Product", "Income", "Costs", "Profit",};
        double[] values = new double[columnCount-1];

        // Pass product and quantity from the order to a hashmap to ArrayLists
        for(int i=0; i<store.numberOfOrders(); i++){
            Order o = store.getOrder(i);
            HashMap<Product, Integer> tempMap = o.getMap();

            for(Product key : tempMap.keySet()){
               products.add(key);
               quantities.add(tempMap.get(key));
            }
        }  

        // Searches the arraylists for multiples of the same product an adds the together
        for(int i=0; i<products.size(); i++){
            for(int j=0; j<products.size(); j++){
                if(products.get(i).getName().equals(products.get(j).getName()) && i != j){
                    int tempInt = quantities.get(i) + quantities.get(j);
                    
                    quantities.set(i, tempInt);
                    quantities.remove(j);
                    products.remove(j);
                }
            }
        }

        for(int i=0; i<products.size(); i++){
            columns[i][0] = products.get(i).getName();                                                                  // Product name

            columns[i][1] = String.format("%.2f", products.get(i).getPrice() * quantities.get(i));                             // Product price or income
            totalPrice += Double.parseDouble(columns[i][1]);
            
            columns[i][2] = String.format("%.2f", products.get(i).getCost() * quantities.get(i));                              // Product cost
            totalCost += Double.parseDouble(columns[i][2]);
            
            columns[i][3] = String.format("%.2f", Double.parseDouble(columns[i][1]) - Double.parseDouble(columns[i][2]));      // Product profit
            totalProfit += Double.parseDouble(columns[i][3]);
        }
        
        columns[store.numberOfProducts()][0] = "Total";
        columns[store.numberOfProducts()][1] = String.format("%.2f", totalPrice);
        columns[store.numberOfProducts()][2] = String.format("%.2f", totalCost);
        columns[store.numberOfProducts()][3] = String.format("%.2f", totalProfit);

        JTable table = new JTable(columns, columnNames);
        JScrollPane pane = new JScrollPane(table);

        int result = JOptionPane.showConfirmDialog(
            this,
            pane,
            "Profits & Loss",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if(result != JOptionPane.OK_OPTION) return;
    }

    protected void onServerReportClick(){
        ArrayList<Server> servers = new ArrayList<>();
        int columnCount = 4;

        for(int i=0; i<store.numberOfPeople(); i++){
            if(store.getPerson(i) instanceof Server)
                servers.add((Server)store.getPerson(i));
        }

        String[] columnNames = {"Name", "Phone", "SSN", "Orders"};
        String[][] columns = new String[servers.size()][columnCount];

        for(int i=0; i<servers.size(); i++){
            int orderCount = 0;
            for(int j=0; j<store.numberOfOrders(); j++){
                // if server name == server name on the order
                if(servers.get(i).getName().equals(store.getOrder(j).getServer().getName()))
                    orderCount++;
            }
            columns[i][0] = servers.get(i).getName();
            columns[i][1] = servers.get(i).getPhone();
            columns[i][2] = servers.get(i).getSocial();
            columns[i][3] = String.valueOf(orderCount);
        }

        JTable table = new JTable(columns, columnNames);
        JScrollPane pane = new JScrollPane(table);

        int result = JOptionPane.showConfirmDialog(
            this,
            pane,
            "Server Report",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if(result != JOptionPane.OK_OPTION) return;
    }

    /************************************************
                    Help ActionListeners
    ************************************************/

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
          +"<p>Icon Quality Png File Png File Png File Png File transparent background by Ahkâm, licensed under Personal Use Only</p>"
          +"<p><font size=-2>https://www.freeiconspng.com/img/2488</p>"
          +"<p>Users Icon by iynque, licensed under CC Attribution-Noncommercial-No Derivate 4.0</p>"
          +"<p><font size=-2>https://iconarchive.com/show/ios7-style-icons-by-iynque/Users-icon.html</p>"
          +"<p>Product Icon by Custom Icon Design, licensed under Free for non-commercial use</p>"
          +"<p><font size=-2>https://iconarchive.com/show/flatastic-2-icons-by-custom-icon-design/product-icon.html</p>"
          +"<p>People Icon by GraphicLoads, licensed under Freeware</p>"
          +"<p><font size=-2>https://iconarchive.com/show/100-flat-2-icons-by-graphicloads/people-icon.html</font></p>"
          +"<p>Barista icon by Eucalyp, licensed under Free for personal and commercial purpose with attribution</p>"
          +"<p><font size=-2>https://www.flaticon.com/free-icon/barista_1461573</font></p>"
          +"<p>noun_coffee_orders Icon by Made, licensed under Creative Commons CCBY</p>"
          +"<p><font size=-2>https://thenounproject.com/term/coffee-orders/940871/</font></p>"
          +"<p>order-icon-17 Icon by icon-library.com, licensed under Free Icons Library</p>"
          +"<p><font size=-2>https://icon-library.com/icon/order-icon-17.html</font></p>"
          +"<p>Food-Coffee-To-Go-icon by Icons8, licensed under Linkware</p>"
          +"<p><font size=-2>https://iconarchive.com/show/ios7-icons-by-icons8/Food-Coffee-To-Go-icon.html</font></p>"
          +"<p><font size=-2>https://icons8.com/</font></p>"
          +"<p>Food-Doughnut-icon by Icons8, licensed under Linkware</p>"
          +"<p><font size=-2>https://iconarchive.com/show/ios7-icons-by-icons8/Food-Doughnut-icon.html</font></p>"
          +"<p><font size=-2>https://icons8.com/</font></p>"
          +"<p>Sales-report-icon by Custom Icon Design (Available for custom work), licensed under Free for non-commercial use.</p>"
          +"<p><font size=-2>https://iconarchive.com/show/flatastic-5-icons-by-custom-icon-design/Sales-report-icon.html</font></p>"
          +"<p>Distributor-report-icon by Custom Icon Design (Available for custom work), licensed under Free for non-commercial use.</p>"
          +"<p><font size=-2>https://iconarchive.com/show/flatastic-5-icons-by-custom-icon-design/Distributor-report-icon.html</font></p>"
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
    
   
    /************************************************
                    View ActionListeners
    ************************************************/

    protected void onProductsClick(){ updateDisplay(0); }

    protected void onPeopleClick(){ updateDisplay(1); } 

    protected void onOrdersClick(){ updateDisplay(2); }

    /************************************************ 
                    Utilities ActionListeners
    ************************************************/

    private void updateDisplay(int i){
        if(i == 0){
            data.setText("<html>" + store.toString()
                         .replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .replaceAll("<","&lt;")
                         .replaceAll(">", "&gt;")
                         .replaceAll("\n", "<br/>")
                         + "</html>");
        }
        if(i == 1){
            data.setText("<html>" + store.peopleToString()
                         .replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .replaceAll("<","&lt;")
                         .replaceAll(">", "&gt;")
                         .replaceAll("\n", "<br/>")
                         + "</html>");
        }
        if(i == 2){
            data.setText("<html>" + store.ordersToString()
                         .replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .replaceAll("<","&lt;")
                         .replaceAll(">", "&gt;")
                         .replaceAll("\n", "<br/>")
                         + "</html>");
        }  
    }

    private Object selectFromArray(String prompt, Object[] options){
        JComboBox<Object> comboEnum = new JComboBox<>();
        comboEnum.setModel(new DefaultComboBoxModel<Object>(options));
        int button = JOptionPane.showConfirmDialog(this, comboEnum, prompt, 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.CANCEL_OPTION);
        return comboEnum.getSelectedItem();
    } 

    protected String getString(JTextField prompt) throws Exception {
        String newPrompt;
        
        newPrompt = prompt.getText();

        if(newPrompt == null || newPrompt.length() == 0) 
            throw new Exception("Empty String");
            
        return newPrompt;
    } 

    protected double getDouble(JTextField prompt) throws Exception {
        String newPrompt = prompt.getText().toString();
        double result = 0.0;
       
        if(newPrompt == null) 
            throw new Exception("Invalid Double");

        result = Double.parseDouble(prompt.getText()); 
        
        return result;
    }

    /************************************************ 
                        Main
    ************************************************/

    public static void main(String[] args) {
        MainWin myApp = new MainWin("JADE");
        myApp.setVisible(true);
    }
    
    /************************************************
                Attributes
    ************************************************/

    private Object obj;
    private Store store;
    private Person person;
    private File fileName;
    private JLabel data;                    // Display of output in main window
    private JLabel msg;                     // Status message display
    private Order order;
    
    // buttons
    private JButton bAbout;
    private JButton bAdd;
    private JButton bCustomer;
    private JButton bDonut;
    private JButton bEditJava;
    private JButton bEditDonut;
    private JButton bJava;                  
    private JButton bNew;
    private JButton bOpen;
    private JButton bOrder;
    private JButton bOrders;
    private JButton bPeople;
    private JButton bProduct;
    private JButton bProfitLoss;
    private JButton bSave;
    private JButton bSaveAs;
    private JButton bServer;
    private JButton bServerReport;

    // Menu
    private JMenuItem mAbout;
    private JMenuItem mCustomer;
    private JMenuItem mDonut; 
    private JMenuItem mEditDonut;
    private JMenuItem mEditJava;
    private JMenuItem mJava;                  
    private JMenuItem mNew;
    private JMenuItem mOpen;
    private JMenuItem mOrder;
    private JMenuItem mOrders;
    private JMenuItem mPeople;
    private JMenuItem mProducts;
    private JMenuItem mProfitLoss;
    private JMenuItem mQuit;
    private JMenuItem mSave;
    private JMenuItem mSaveAs;
    private JMenuItem mServer;
    private JMenuItem mServerReport;

    private JComboBox textDark;
    private JComboBox textFill;
    private JComboBox textFrost;
    private JComboBox textShots;
    private JComboBox textSprinkles;

    private JTextField textName;
    private JTextField textCost;
    private JTextField textPhone;
    private JTextField textPrice;
    private JTextField textSocial;
}