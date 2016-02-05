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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import bucky.MultipleList;
public class Two extends JFrame {
			
			private JTextField entermoviename;
			private JList leftlist;
			private JList rightlist;
			private JButton movebutton;
			private String[] movie = {"Avatar", "Wanted", "Do or Die", "Superman", "Fast5"};
			

			private JTextArea log;
			
			private JButton addmovie;
			
			public Two() {
				
				super("Title");
				//setLayout(new FlowLayout());
				FlowLayout layout = new FlowLayout();
				setLayout(layout);
				entermoviename =new JTextField(10);
				addmovie = new JButton("addmovie");
				
				
				List<String> l1=new ArrayList<String>();
				
				addmovie.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						try{
						LinkedList<String> list1=new LinkedList<String>(Arrays.asList(movie));
						String storage4 = entermoviename.getText();
						list1.add(storage4);
						movie =list1.toArray(new String[list1.size()]);
						}catch(Exception e){
						System.out.println("Err"+e);
						/*for(String x:movie)
						{
							System.out.println(x);
						}*/
						}
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
				add(entermoviename);
				add(addmovie);
			    add( new JScrollPane(leftlist));
				add(movebutton);
				add( new JScrollPane(rightlist));
				add( new JScrollPane(log));
						
			}
		}

