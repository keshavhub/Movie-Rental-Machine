package mrm;

import javax.swing.JFrame;

import bucky.MultipleList;

public class MacineMain {
	
	public static void main(String[] args) {
	
		Macine m=new Macine();
		
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setSize(400,400);
		m.setVisible(true);
		m.setLocationRelativeTo(null);
	}
	
}