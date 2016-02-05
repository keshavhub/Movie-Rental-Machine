package mrm;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import bucky.MultipleList;

public class Macine extends JFrame {
	
		private JLabel message1,message2,message3,message4;
		private JTextField cardnumber;
		private JTextField zipnumber;
		private JTextField mobile;
		private JTextField entermoviename;
		private JButton submit;
		private JList leftlist;
		private JList rightlist;
		private JButton movebutton;
		private String[] movie = {"Aarya" , "Dhookudu","Rajarani","VIP","Julai"};
		private JButton poweroff;
		private JButton poweron;
		private boolean bcard;
		private boolean bzip;
		private boolean bmobile;
		private JButton addmovie;
		
		public Macine() {
			
			super("Title");
			//setLayout(new FlowLayout());
			FlowLayout layout = new FlowLayout();
			setLayout(layout);
			
			message1=new JLabel("Enter the card number:40-50");
			cardnumber =new JTextField(10);
			message2=new JLabel("Enter the zip number:40-50");
			zipnumber=new JTextField(10);
			message3=new JLabel("Enter the mobile number:40-50");
			mobile=new JTextField(10);
			submit=new JButton("submit");
			poweroff=new JButton("OFF");
		
			poweroff.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							setBackground(Color.BLACK);
							message1.setEnabled(false);
							cardnumber.setEnabled(false);
							message2.setEnabled(false);
							zipnumber.setEnabled(false);
							message3.setEnabled(false);
							mobile.setEnabled(false);
							submit.setEnabled(false);
							leftlist.setEnabled(false);
							movebutton.setEnabled(false);
							rightlist.setEnabled(false);
							poweroff.setEnabled(false);
							poweron.setEnabled(true);
							add(entermoviename).setEnabled(true);
							add(addmovie).setEnabled(true);
							cardnumber.setText(null);
							zipnumber.setText(null);
							mobile.setText(null);
							
							
						}
					}
			);
			poweron=new JButton("ON");
			poweron.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							//setBackground(Color.BLACK);
							message1.setEnabled(true);
							cardnumber.setEnabled(true);
							message2.setEnabled(true);
							zipnumber.setEnabled(true);
							message3.setEnabled(true);
							mobile.setEnabled(true);
							submit.setEnabled(true);
							leftlist.setEnabled(false);
							movebutton.setEnabled(false);
							rightlist.setEnabled(false);
							poweron.setEnabled(false);
							poweroff.setEnabled(true);
							add(entermoviename).setEnabled(false);
							add(addmovie).setEnabled(false);
						}
					}
			);
			submit.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e) {
						String storage1=cardnumber.getText();
						String storage2=zipnumber.getText();
						String storage3=mobile.getText();
						 //char c=storage1.charAt(0);
						int x=Integer.parseInt(storage1);
						int y=Integer.parseInt(storage2);
						int z=Integer.parseInt(storage3);
						
						
						
				try
				{		//int x=Integer.parseInt(storage1);
						 if(x<40 || x>50){
	
							 JOptionPane.showMessageDialog(null, "please enter a valid card num:"+x);
						 }
						 else {
							 JOptionPane.showMessageDialog(null, "U enterd a valid card num");
							 bcard=true;
						 }
						}
				catch(Exception e1){
							JOptionPane.showMessageDialog(null, "Please provide card number");
						}
				try
				{
						//int y=Integer.parseInt(storage2);
						 if(y<40 && y>50){
							 JOptionPane.showMessageDialog(null, "please enter a valid zip num:"+y);
						 }
						 else{
							 JOptionPane.showMessageDialog(null, "U enterd a valid zip num:");
							 bzip=true;
						 }
				}catch(Exception e2){
							JOptionPane.showMessageDialog(null, "Please enter the zip num");
						}
				try{
					//int z=Integer.parseInt(storage3);
						 if(z<40 && z>50){
							 JOptionPane.showMessageDialog(null, "please enter a valid mobile num:"+z);
						 }
						 else{
							 JOptionPane.showMessageDialog(null, "U enterd a valid mobile num:");
							 bmobile=true;
						 }
				}catch(Exception e3){
							JOptionPane.showMessageDialog(null, "Please enter a mobile num");
						}
				try{
					if(x>40 && x<50 && y>40 && y<50 && z>40 && z<50){
						leftlist.setEnabled(true);
						movebutton.setEnabled(true);
						rightlist.setEnabled(true);
						
					}
							}catch(Exception e4){
								System.out.println("oops");
							}                                        
						}
						}
					);
			
			/*List<String> l1=new ArrayList<String>();
			
			for(String y:movie)
				l1.add(y);
			String storage4 = null;
			l1.add(storage4);*/
			
			entermoviename =new JTextField(10);
			addmovie = new JButton("addmovie");
			final List<String> l1=new ArrayList<String>();
			addmovie.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
			
				for (String y : movie) {
					l1.add(y);
				}
				String storage4 = entermoviename.getText();
				l1.add(storage4);
				movie = l1.toArray(new String[l1.size()]);
					leftlist.updateUI();
				}	
			}
			);
			leftlist = new JList(movie);
			leftlist.setVisibleRowCount(3);
			leftlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			/*add( new JScrollPane(leftlist));*/
		
			movebutton=new JButton("Move ");
			movebutton.addActionListener(
					new ActionListener(){
						@SuppressWarnings({ "unchecked", "deprecation" })
						public void actionPerformed(ActionEvent e) {
						
							rightlist.setListData(leftlist.getSelectedValues());
							}
						}
					);
			/*add(movebutton);*/
			
			rightlist=new JList();
			rightlist.setVisibleRowCount(3);
			rightlist.setFixedCellHeight(20);
			rightlist.setFixedCellWidth(80);
			rightlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			/*add(new JScrollPane(rightlist)); */
	

			
			add(message1).setEnabled(false);
			add(cardnumber).setEnabled(false);
			add(message2).setEnabled(false);
			add(zipnumber).setEnabled(false);
			add(message3).setEnabled(false);
			add(mobile).setEnabled(false);
			add(submit).setEnabled(false);
			add(poweroff).setEnabled(false);
			add(poweron);
		    add( new JScrollPane(leftlist)).setEnabled(false);
		    leftlist.setEnabled(false);
			add(movebutton).setEnabled(false);
			add( new JScrollPane(rightlist)).setEnabled(false);
			add(entermoviename).setEnabled(false);
			add(addmovie).setEnabled(false);
			 	/*add(leftlist);
				add(movebutton);
				add(rightlist);*/
				
		}
	}

