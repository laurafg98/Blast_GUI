package proyecto;

import java.awt.Color;
import javax.swing.*;
import blast.BlastController;

public class Principal{
	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");
	public static void  main (String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndShowGUI();
			}
		});
	}
	public static void createAndShowGUI(){
		JFrame frame = new JFrame("BlastGUI");
		Vista vista = new Vista();
		Control control= new Control(vista);
		vista.getBuscar().addActionListener(control);
		frame.setContentPane(vista);
		frame.pack();
		frame.setSize(600,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	
	
}
