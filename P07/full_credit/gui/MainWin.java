package gui;

import java.awt.*;
import javax.swing.*;
import java.store.*;

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
		file.add(quit);

		// Create
		JMenu create = new JMenu("Create");
		JMenuItem donut = new JMenuItem("Donut");
		JMenuItem java = new JMenuItem("Java");
		create.add(donut);
		create.add(java);

		// Help
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
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
		Store store = new Store("");
		getContentPane().add(data);

		setVisible(true);
	}
	protected void onCreateJavaClick(){}
	protected void onCreateDonutClick(){}
	protected void onAboutClick(){}
	protected void onQuitClick(){}

	//private Store store;
	private JLabel data;
	private JMenuItem mJava, mDonut;
	private JButton bJava, bDonut;

	public static void main(String[] args){
		MainWin app = new MainWin("JADE");
		app.setVisible(true);
	}
}