package gui;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import store.*;

public class MainWin extends JFrame{
	public MainWin(String mainWindowTitle){
		super(mainWindowTitle); // Initialize JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Click X on close
		setSize(400, 200);

		/************************************
					Menu Bar
		************************************/

		// File
		JMenu file = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit");

		// Create
		JMenu create = new JMenu("Create");
		JMenuItem donut = new JMenuItem("Donut");
		JMenuItem java = new JMenuItem("Java");

		// Help
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");

		//quit.addActionListener(event -> onQuitClick());
		donut.addActionListener(event -> onCreateDonutClick());
		//java.addActionListener(event -> onCreateJavaClick());
		//about.addActionListener(event -> onButtonClick());

		file.add(quit);
		create.add(donut);
		create.add(java);
		help.add(about);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(file);
		menuBar.add(create);
		menuBar.add(help);

		setJMenuBar(menuBar);

		/************************************
					Tool Bar
		************************************/
		
		//ImageIcon imageIcon = new ImageIcon(""); // load the image to a imageIcon
		ImageIcon imgJava = new ImageIcon(new ImageIcon("gui/java.jpg").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imgDonut = new ImageIcon(new ImageIcon("gui/donut.jpg").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

		// Create a java icon for the toolbar
		bJava = new JButton(imgJava);
			bJava.setBorder(null);
			
		// Create a donut icon for the toolbar
		bDonut = new JButton(imgDonut);
			bDonut.setBorder(null);

		// Add a toolbar to the region below the menu
		JToolBar toolbar = new JToolBar();
		toolbar.add(Box.createHorizontalStrut(25));
		toolbar.add(bJava);
		toolbar.add(Box.createHorizontalStrut(10));
		toolbar.add(bDonut);

		getContentPane().add(toolbar, BorderLayout.NORTH);

		/************************************
					DATA Menu
		************************************/

		data = new JLabel("Welcome to Jade");
		getContentPane().add(data);

		setVisible(true);
	}
	protected void onCreateJavaClick(){}
	protected void onCreateDonutClick(){
		JFrame anew = new JFrame();
		Frosting[] frostings = Frosting.values();
		String[] strFrost = new String[frostings.length];
		for(int i = 0; i < strFrost.length; i++){
			strFrost[i] = frostings[i].name();
		}

		JOptionPane jPane = new JOptionPane();
		String name = jPane.showInputDialog("Name");
		String price = jPane.showInputDialog(this, "Price");
		String cost = jPane.showInputDialog(this, "Cost");
		JComboBox<String> frostBox = new JComboBox<>(strFrost);
		String frosting = jPane.add(frostBox);
		
		int sprinkles = jPane.showConfirmDialog(this, "Sprinkles?");
		// donut name, donut price, donut cost, donut frosting, donut filling, sprinkles
		//Donut d = new Donut(name, Double.valueOf(price), Double.valueOf(cost));
	}
	protected void onAboutClick(){}
	protected void onQuitClick(){}

	private Store store;
	private JLabel data;
	private JMenuItem mJava, mDonut;
	private JButton bJava, bDonut;

	public static void main(String[] args){
		MainWin app = new MainWin("JADE");
		app.setVisible(true);
	}
}