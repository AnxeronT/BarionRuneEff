package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menu implements ActionListener,ItemListener{

	public void create(JMenuBar menuName)
	{
		JMenu menuFile = new JMenu("File");
		
		//Menu->File
		menuFile.setMnemonic(KeyEvent.VK_F);
		menuFile.getAccessibleContext().setAccessibleDescription("Import Export Exit");
		menuName.add(menuFile);
		
		//Open
		JMenuItem fileOpen = new JMenuItem("Open",KeyEvent.VK_O);
		fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		menuFile.add(fileOpen);
		fileOpen.addActionListener(this);
		
		menuFile.addSeparator();
		
		//Import
		JMenuItem fileImport = new JMenuItem("Import",KeyEvent.VK_T);
		fileImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		menuFile.add(fileImport);
		fileImport.addActionListener(this);
		
		//Export
		JMenuItem fileExport = new JMenuItem("Export",KeyEvent.VK_X);
		fileExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		menuFile.add(fileExport);
		fileExport.addActionListener(this);
		
		menuFile.addSeparator();
		
		//Exit
		JMenuItem fileExit = new JMenuItem("Exit",KeyEvent.VK_E);
		//fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		menuFile.add(fileExit);
		fileExit.addActionListener(this);
		
		//==============================//
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = e.getActionCommand();
		
		if (name.equals("Exit")){
			System.exit(0);
		}else if (name.equals("Export")){
			System.out.println("Export");
		}else if (name.equals("Import")){
			System.out.println("Import");
		}
	}
}
