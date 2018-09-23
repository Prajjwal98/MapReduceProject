/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hadoop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

import java.util.*;
import org.apache.hadoop.util.*;
import org.apache.hadoop.conf.*;
import java.io.*;
import java.net.*;
 import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;

class worker_insurance extends JInternalFrame implements ActionListener
{
private	JPanel		topPanel;
	JTabbedPane jtp;
	JPanel pane0,pane1,pane2;
	JComboBox cmb1;
	JButton cmdVwPat,cmdSave,cmdCancel;
	JTextField txtId,txtProd,txtPno,txtPs,txtQty,txtTqty,txtAswork,txtDt,txtDdt;
	JLabel lbl1,lbl2,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10;
	String unit;
	public worker_insurance(JFrame parent)
	{
		super("Worker Insurance",true,true);

		unit="Products";

		setSize(450,500);
		setVisible(true);

		
		pane1=new JPanel();
		pane2=new JPanel();
		



		
		cmdVwPat=new JButton("Show Count Insured Workers");
		cmdVwPat.addActionListener(this);
		
		cmdCancel=new JButton("Exit");
		cmdCancel.addActionListener(this);

		pane2.add(cmdVwPat);
		//pane2.add(cmdSave);
		pane2.add(cmdCancel);

		getContentPane().setLayout(new FlowLayout());
		//pane0.setLayout(new FlowLayout());
		pane1.setLayout(new GridLayout(12,12));
		pane2.setLayout(new FlowLayout());

		//getContentPane().add(pane0);
		getContentPane().add(pane1);
		getContentPane().add(pane2);

		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cmdVwPat)
		{
                   
                    String args[]={"input_dir","output_dir"};
                   try{ mr5.startmr(args); 
					   showall(args[1]+"/part-r-00000");
					   
					   } catch(Exception e){}
		}
		else if(ae.getSource()==cmdCancel)
		{
		setVisible(false);
		}
		
 	}
   void showall(String args) throws Exception
  {
	  
	 	  
String uri = args;
Configuration conf = new Configuration();
FileSystem fs = FileSystem.get(conf);
 BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(new Path(args))));
 String line;
 line=br.readLine();
 
    Object columnNames[] = { "Worker", "Insurance" };
     String rowData[][] =new String[1000][2] ;
 int i=0;
 int j=0;
 while(line!=null)
 {
	 System.out.println(line + "....");
	   j=0;
	  for (String val: line.split("\t"))
	  {
		  if(j==0)
		  {
			  rowData[i][j++]=new definition().get_worker(Integer.parseInt(val));
		  }
		  else
		  rowData[i][j++]=val;
	
	}
	 
	 i++;
	 
	 line=br.readLine();
	 
	 if(i>=1000)break;
	 }
	 
	 
	
    JTable table = new JTable(rowData, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    topPanel.add( scrollPane, BorderLayout.CENTER );
	  topPanel.revalidate();


  }
  
}
