package gui;

import java.awt.*;
import javax.swing.*;

public class MainWin extends JFrame{
	public MainWin(String mainWindowTitle){
		super(mainWindowTitle); // Initialize JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Click X on close
		setSize(400, 200);

		JMenuBar menuBar = new JMenuBar();

		/************************************
					Menu Bar
		************************************/

		// File
		JMenu file = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit");
		menuBar.add(file);
		file.add(quit);

		// Create
		JMenu create = new JMenu("Create");
		JMenuItem donut = new JMenuItem("Donut");
		JMenuItem java = new JMenuItem("Java");
		menuBar.add(create);
		create.add(donut);
		create.add(java);

		// Help
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		menuBar.add(help);
		help.add(about);

		setJMenuBar(menuBar);

		/************************************
					Tool Bar
		************************************/
		// Add a toolbar to the region below the menu
		JToolBar toolbar = new JToolBar();

		// Add a java button the toolbar
		bJava = new JButton("java");
			//bJava.setSize(100,100);
			//bJava.setLayout(null);
			//bJava.setBorder(null);
			toolbar.add(bJava);

		bDonut = new JButton("donut");
			//bDonut.setSize(100,100);
			//bDonut.setLayout(null);
			//bDonut.setBorder(null);
			toolbar.add(bDonut);

		add(toolbar, BorderLayout.PAGE_START);
		
		// Welcome to Jade
		data = new JLabel("Welcome to Jade");
		add(data);

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