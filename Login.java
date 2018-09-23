package hadoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class FrameLogin extends JFrame implements ActionListener
{
	boolean b=false;
	JTextField txtUsr,txtPwd;
	JLabel lblUsr,lblPwd,lblTitle;

	JPanel pane1,pane2,pane3;

	JButton cmdLogin,cmdCancel;
	public FrameLogin()
	{
		txtUsr=new JTextField(10);
		txtPwd=new JPasswordField(10);
		lblUsr=new JLabel("Username: ");
		lblPwd=new JLabel("Password: ");
		
		lblTitle=new JLabel("Login");
		lblTitle.setFont(new Font("Times new Roman",Font.BOLD,30));
		lblTitle.setForeground(Color.BLUE);

		cmdLogin=new JButton("Login");
		cmdCancel=new JButton("Cancel");
		cmdLogin.addActionListener(this);
		cmdCancel.addActionListener(this);

		pane1=new JPanel();
		pane1.add(lblTitle);
	
				
		pane2=new JPanel();
		pane2.add(lblUsr);
		pane2.add(txtUsr);
		pane2.add(lblPwd);
		pane2.add(txtPwd);


		pane3=new JPanel();
		pane3.add(cmdLogin);
		pane3.add(cmdCancel);

		Container pane=getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

	
		pane.add(pane1);
		pane.add(pane2);
		pane.add(pane3);
		
		setLocation(500,250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		setResizable(false);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String qry;
		
		if(ae.getSource()==cmdLogin)
		{

			if(!txtUsr.getText().equals("") && !txtPwd.getText().equals(""))
			{

			 
				if(txtUsr.getText().equals("admin") && txtPwd.getText().equals("admin")) 
				{
					JOptionPane.showMessageDialog(null, "Welcome "+txtUsr.getText(), "Stock", JOptionPane.INFORMATION_MESSAGE); 
					FrameMain mf=new FrameMain();
					mf.setSize(700,600);
					mf.setVisible(true);
					setVisible(false);
					b=true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Username or Password.", "Error", JOptionPane.ERROR_MESSAGE); 
				}
			 
			}
			 	
			
		}
		else if(ae.getSource()==cmdCancel)
		{
			System.exit(0);	
		}
	}

	
}
public class Login
{
	public static void main(String []arg)
	{
		FrameLogin fl=new FrameLogin();
		fl.setSize(250,250);
		fl.setVisible(true);
		fl.setTitle("Stock Management System");
	}
}
