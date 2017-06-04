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

	public PasswordController(PassWordData controlledPw)
	{
		super();
		passWord = controlledPw;
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
					passWord.setPassWord(passWordLabel.getText());
	
				}
				catch(Exception exception)
				{
					JOptionPane.showMessageDialog(PasswordController.this,"Dont't set password again!","Error",JOptionPane.ERROR_MESSAGE);

				}
			}
		});
	}
	public static void main(String args[])
	{
		PassWordData pw = new PassWordData ();
		PasswordController pwc = new PasswordController(pw);

		JFrame f = new JFrame();
		f.getContentPane().setLayout( new FlowLayout());
		f.getContentPane().add(pwc);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
