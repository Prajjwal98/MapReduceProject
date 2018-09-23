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

class all_products extends JInternalFrame implements ActionListener
{
private	JPanel		topPanel;
	JTabbedPane jtp;
	JPanel pane0,pane1,pane2;
	JComboBox cmb1;
	JButton cmdVwPat,cmdSave,cmdCancel;
	JTextField txtId,txtProd,txtPno,txtPs,txtQty,txtTqty,txtAswork,txtDt,txtDdt;
	JLabel lbl1,lbl2,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10;
	String unit;
	public all_products(JFrame parent)
	{
		super("ALL Products",true,true);

		unit="Products";

		setSize(450,500);
		setVisible(true);

		pane0=new JPanel();
		pane1=new JPanel();
		pane2=new JPanel();



		cmb1=new JComboBox();
		cmb1.addItem("MS-40");
		cmb1.addItem("Ms-60");


 		pane0.add(cmb1);



		cmdVwPat=new JButton("Start MR1");
		cmdVwPat.addActionListener(this);
		cmdSave=new JButton("Save");
		cmdSave.addActionListener(this);
		cmdCancel=new JButton("Exit");
		cmdCancel.addActionListener(this);

		pane2.add(cmdVwPat);
		pane2.add(cmdSave);
		pane2.add(cmdCancel);

		getContentPane().setLayout(new FlowLayout());
		pane0.setLayout(new FlowLayout());
		pane1.setLayout(new GridLayout(12,12));
		pane2.setLayout(new FlowLayout());

		getContentPane().add(pane0);
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
                    System.out.println("DDDD");

                    String args[]={"input_dir","output_dir"};
                    //mr1 obj_mr1=new mr1();
                   try{ //mr1.startmr(args); 
					   showall(args[1]+"/part-m-00000");
					   
					   } catch(Exception e){}
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
 
    Object columnNames[] = { "EMPID", "EMP NAME", "SALARY" };
     String rowData[][] =new String[1000][3] ;//{ { "NA", "NA", "NA" },{ "NA", "NA", "NA" }};
 int i=0;
 int j=0;
 while(line!=null)
 {
	 System.out.println(line + "....");
	   j=0;
	  for (String val: line.split(";"))
	  {
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
