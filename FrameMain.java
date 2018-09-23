/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hadoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class FrameMain extends JFrame implements ActionListener
{

	
	boolean b=false;

	JMenuBar jb;
	JMenuItem ut1,ut2,ut3,ut4,ut5,ut6,ut7,ut8,ut9,ut10;
	JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10;
	JMenu file;
	JPanel pane1;
	JDesktopPane dsk;
	public FrameMain()
	{

		dsk=new JDesktopPane();

		jb=new JMenuBar();
		file=new JMenu("File");

		//ut1=new JMenuItem("ALL Records");
		//ut2=new JMenuItem("State Wise Records");
		ut3=new JMenuItem("Income of States");
		ut4=new JMenuItem("Avg Income of States");
		ut5=new JMenuItem("Total Insured workers");
		//ut6=new JMenuItem("Avg Insured workers");
		ut7=new JMenuItem("Income of Worker class");
		ut8=new JMenuItem("Avg Income of Worker class");
		ut9=new JMenuItem("Exit");

		//ut1.addActionListener(this);
		//ut2.addActionListener(this);
		ut3.addActionListener(this);
		ut4.addActionListener(this);
		ut5.addActionListener(this);
		//ut6.addActionListener(this);
		ut7.addActionListener(this);
		ut8.addActionListener(this);
		ut9.addActionListener(this);



		//file.add(ut1);
		//file.add(ut2);
		file.add(ut3);
		file.add(ut4);
		file.add(ut5);
		//file.add(ut6);
		file.add(ut7);
		file.add(ut8);
		file.add(ut9);
		
		


		jb.add(file);


		pane1=new JPanel();
		pane1.setLayout(new BorderLayout());

		pane1.add(jb);



		setJMenuBar(jb);
		dsk.setBackground(Color.GRAY);

	

		getContentPane().add(pane1,BorderLayout.PAGE_START);
		getContentPane().add(dsk,BorderLayout.CENTER);

		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ut1)
		{
			all_products u1=new all_products(this);
			dsk.add(u1);
		}
		if(ae.getSource()==ut2)
		{
			con_products u1=new con_products(this);
			dsk.add(u1);
		}
		if(ae.getSource()==ut3)
		{
			state_income u1=new state_income(this);
			dsk.add(u1);
		}
		 if(ae.getSource()==ut4)
		{
			state_income_avg u1=new state_income_avg(this);
			dsk.add(u1);
		}
		if(ae.getSource()==ut5)
		{
			worker_insurance u1=new worker_insurance(this);
			dsk.add(u1);
		}
		/*if(ae.getSource()==ut6)
		{
			worker_insurance_avg u1=new worker_insurance_avg(this);
			dsk.add(u1);
		}*/
		if(ae.getSource()==ut7)
		{
			worker_income  u1=new worker_income(this);
			dsk.add(u1);
		}
		if(ae.getSource()==ut8)
		{
			worker_income_avg u1=new worker_income_avg(this);
			dsk.add(u1);
		}
		if(ae.getSource()==ut9)
		{
			System.exit(0);
		}

	}
	
}
