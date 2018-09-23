import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

class unit1 extends JInternalFrame implements ActionListener
{
	Connection con;
	ResultSet rs;
	Statement st;
	String url="jdbc:odbc:stock",qry; 

	JTabbedPane jtp;
	JPanel pane0,pane1,pane2;
	JComboBox cmb1;
	JButton cmdVwPat,cmdSave,cmdCancel;
	JTextField txtId,txtProd,txtPno,txtPs,txtQty,txtTqty,txtAswork,txtDt,txtDdt;
	JLabel lbl1,lbl2,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10;
	String unit;
	public unit1(JFrame parent)
	{
		super("Unit-1",true,true);
	
		unit="Unit-1";
	
		setSize(450,500);
		setVisible(true);					

		pane0=new JPanel();
		pane1=new JPanel();
		pane2=new JPanel();


		lbl1=new JLabel("Product ID: ");
		lbl2=new JLabel("Product Name: ");
		lbl4=new JLabel("Pattern No: ");
		lbl5=new JLabel("No. of Pattern Selected: ");
		lbl6=new JLabel("Quantity: ");
		lbl7=new JLabel("Total Quantity: ");
		lbl8=new JLabel("Name of Assigned Work: ");
		lbl9=new JLabel("Date: ");
		lbl10=new JLabel("Due Date: ");

		cmb1=new JComboBox();
		cmb1.addItem("MS-40");
		cmb1.addItem("Ms-60");
		
		txtId=new JTextField(13);
		txtProd=new JTextField(8);
		txtPno=new JTextField(8);
		txtPs=new JTextField(8);
		txtQty=new JTextField(8);
		txtTqty=new JTextField(8);
		txtAswork=new JTextField(8);
		txtDt=new JTextField(8);
		txtDdt=new JTextField(8);


		pane0.add(lbl1);	
		pane0.add(cmb1);
		pane0.add(txtId);

		pane1.add(lbl2);
		pane1.add(txtProd);
		pane1.add(lbl4);
		pane1.add(txtPno);
		pane1.add(lbl5);
		pane1.add(txtPs);
		pane1.add(lbl6);
		pane1.add(txtQty);
		pane1.add(lbl7);		
		pane1.add(txtTqty);
		pane1.add(lbl8);
		pane1.add(txtAswork);
		pane1.add(lbl9);
		pane1.add(txtDt);
		pane1.add(lbl10);
		pane1.add(txtDdt);


		cmdVwPat=new JButton("View Pattern");
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

		try
		{			
			makeConn();
		}
		catch(Exception e){}

	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cmdVwPat)
		{
		
		}
		else if(ae.getSource()==cmdSave)
		{
			
			String str1="",str2="",str3="",str4="",str5="",str6="",str7="",str8="",str9="";
			
			str1=txtId.getText().trim();
			str2=txtProd.getText().trim();
			str3=txtPno.getText().trim();
			str4=txtPs.getText().trim();
			str5=txtQty.getText().trim();
			str6=txtTqty.getText().trim();	
			str7=txtAswork.getText().trim();
			str8=txtDt.getText().trim();
			str9=txtDdt.getText().trim();


			if(!str1.equals("") && !unit.equals("")&& !str2.equals("")&& !str3.equals("") && !str4.equals("") && !str5.equals("") && !str6.equals("") && !str7.equals("")&& !str8.equals("")&& !str9.equals(""))
			{

				qry="insert into product values("+txtId.getText()+",'"+unit+"','"+cmb1.getSelectedItem()+"','"+txtProd.getText()+"',"+txtPno.getText()+","+txtPs.getText()+","+txtQty.getText()+","+txtTqty.getText()+",'"+txtAswork.getText()+"','"+txtDt.getText()+"','"+txtDdt.getText()+"')";
				
				try
				{				
					st.executeUpdate(qry);
					JOptionPane.showMessageDialog(null, "Record saved sucessfully.","WARNING!!",JOptionPane.WARNING_MESSAGE);
				}
				catch(SQLException se)
				{ 
					System.out.print(se.toString());
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog((Component)null, "Fields should not be empty!","", JOptionPane.WARNING_MESSAGE);	
			}
		}
		else if(ae.getSource()==cmdCancel)
		{
			setVisible(false);
		}

	}
	public void makeConn()throws SQLException,ClassNotFoundException
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection(url);
		st=con.createStatement();
	}
}
