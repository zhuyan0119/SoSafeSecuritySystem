package controller;

import model.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PasswordController extends JPanel 
{
	private PassWordData passWord;
	private JTextField passWordTextField;
	private JLabel passWordLabel;
	private JButton passWordButton;
	 

	public PasswordController(SensorBank sensorBank)
	{
		super();
		passWord = sensorBank.getPassWordData();
		passWordLabel = new JLabel("Enter Password: ");
		passWordTextField = new JTextField(20);

		passWordButton = new JButton("Set ");

		setLayout(new FlowLayout());
		add(passWordLabel);
		add(passWordTextField);
		add(passWordButton);
		

		passWordButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					passWord.checkPwSetOrNot();
					passWord.setPassWord(passWordTextField.getText());
					passWordTextField.setText("password setted!" );
					passWordButton.setVisible(false);
	
				}
				catch(Exception exception)
				{
					JOptionPane.showMessageDialog(PasswordController.this,"Dont't set password again!","Error",JOptionPane.ERROR_MESSAGE);

				}
				
				
				/*
				if(!passWord.checkPwSetOrNot()){
					passWord.setPassWord(passWordLabel.getText());
					
				}
				else{
					JOptionPane.showMessageDialog(PasswordController.this,"Dont't set password again!","Error",JOptionPane.ERROR_MESSAGE);
				}
				*/
				
				
			}
		});
	}

}
