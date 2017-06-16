package controller;

import model.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LoginController extends JPanel
{
	private PassWordData passWord;

	private JLabel passWordLabel;
	private JTextField passWordTextField;
	private SensorConfigureController scc;

	public LoginController(PassWordData controlledPassWord, SensorConfigureController controlledScc)
	{
		super();
		passWord = controlledPassWord;
		scc = controlledScc;
		passWordLabel = new JLabel("Enter Password: ");
		passWordTextField = new JTextField(20);

		

		JButton enterButton = new JButton("Enter");

		enterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				boolean correctPass = passWord.checkPassWord(passWordTextField.getText());
				if (correctPass)
				{
					scc.setVisible(true);
					passWordLabel.setVisible(false);
					passWordTextField.setVisible(false);
					enterButton.setVisible(false);

					updateUI();

				}	
				else
				{
					JOptionPane.showMessageDialog(LoginController.this,"Please enter correct password!","Error",JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		add(passWordLabel);
		add(passWordTextField);
		add(enterButton);
		add(scc);
		scc.setVisible(false);

	}
	/*public static void main(String args[])	
	{
		SensorBank sb = new SensorBank();
		SensorSchedule  ss = new SensorSchedule();
		PassWordData ps = new PassWordData();
		SensorConfigureController scc = new SensorConfigureController(sb,ss);
		LoginController lc = new LoginController(ps,scc);
		
		
		JFrame f = new JFrame();
		f.getContentPane().add(lc);
		f.setLayout(new FlowLayout());
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	*/

}
